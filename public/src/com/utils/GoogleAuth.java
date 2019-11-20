package com.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import com.models.Admins;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.*;
import java.util.Base64.Encoder;
import java.util.concurrent.TimeUnit;


public class GoogleAuth {
    final GoogleAuthenticator gAuth = new GoogleAuthenticator();
    final GoogleAuthenticatorKey googleAuthkey = gAuth.createCredentials();

    String qrCodeLocation = "./";
    String key = googleAuthkey.getKey();
    Integer windowSize = 3;
    Long KEY_VALIDATION_INTERVAL_MS = TimeUnit.SECONDS.toMillis(30);


    public String generateKeyUri(String account, String secret) {
        String _return = null;

        try {
            URI uri = new URI(
                    "otpauth",
                    "totp",
                    "/" + account,
                    "secret=" + secret,
                    null);
            _return = uri.toASCIIString();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return _return;
    }

    public Map<String, String> qrCodeGeneration(Admins admins) throws URISyntaxException, WriterException, IOException {
        String key = admins.getTwoFactorKey();//getTwoFactorKey(user);
        String filePath = qrCodeLocation + File.separator + admins.getId() + ".png";
        String charset = "UTF-8"; // or "ISO-8859-1"
        Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new EnumMap<>(EncodeHintType.class);
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        String keyUri = generateKeyUri(admins.getMail(), key);
        String qrCodeData = keyUri;
        String base64Image = createQRCode(qrCodeData, filePath, charset, hintMap, 500, 500);
        Map<String, String> map = new HashMap<>();
        map.put("fileName", admins.getId() + ".png");
        map.put("key", key);
        map.put("base64Image", base64Image);
        map.put("verificationToken", "blob");//verificationToken.getToken());
        return map;
    }


    //Configure the Google Authenticator App by scanning the following QR code image
    private static String createQRCode(
            String qrCodeData,
            String filePath,
            String charset,
            @SuppressWarnings("rawtypes") Map hintMap,
            int qrCodeheight,
            int qrCodewidth
    )
            throws WriterException, IOException {

        @SuppressWarnings("unchecked")
        BitMatrix matrix = new MultiFormatWriter().encode(
                new String(qrCodeData.getBytes(charset), charset),
                BarcodeFormat.QR_CODE,
                qrCodewidth,
                qrCodeheight,
                hintMap
        );

        Encoder encoder = Base64.getEncoder();
        File targetFile = new File(filePath);

        MatrixToImageWriter.writeToPath(
                matrix,
                filePath.substring(filePath.lastIndexOf('.') + 1),
                targetFile.toPath()
        );


        String base64Image = encoder.encodeToString(Files.readAllBytes(targetFile.toPath()));


        Files.setPosixFilePermissions(Paths.get(targetFile.toString()), getFullAccessPermissions());

        return "data:image/png;base64," + base64Image;
    }


    private static Set getFullAccessPermissions() {
        Set<PosixFilePermission> perms = new HashSet<>();
        // add owners permission
        perms.add(PosixFilePermission.OWNER_READ);
        perms.add(PosixFilePermission.OWNER_WRITE);
        // add group permissions
        perms.add(PosixFilePermission.GROUP_READ);
        perms.add(PosixFilePermission.GROUP_WRITE);
        // add others permissions
        perms.add(PosixFilePermission.OTHERS_READ);

        return perms;
    }

    public boolean performAuthentication(
            Admins admins,
            String value
    ) {
        Integer totp = Integer.valueOf((value.equals("") ? "-1" : value));

        Boolean matches = gAuth.authorize(admins.getTwoFactorKey(), totp);

        return matches;
    }

}