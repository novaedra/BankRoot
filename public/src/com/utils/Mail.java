package com.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class Mail {
    public static void sendMail(String Mail) {

        //Le compte google par lequel les messages sont envoyés :
        final String mail = "bankroot.contact@gmail.com";
        final String password = "mNb*n1roakFo$t&ls41Kza!";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentification() {
                        return new PasswordAuthentication(mail, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("contact@bankroot.fr"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("test@gmail.com, test@hotmail.fr")
            );
            String send_at = new SimpleDateFormat("ddmmyyyy_hh-mm-ss").format(new Date());
            message.setSubject("Nouvelle offre");
            message.setSentDate(new Date());
            message.setText("Salut Michel," + "\n\n Une nouvelle offre pour toi !");

            Transport.send(message);

            System.out.println("Message sent.");

        } catch (MessagingException e) {
            System.out.println("Message not sent" + e);
        }
    }
}
