package webappli.utils.authentificators;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;

public class AwsSms {
    static String API_KEY = "";
    static String SECRET_KEY = "";

    public static void sendSms() {
        AmazonSNSClient snsClient = new AmazonSNSClient(new BasicAWSCredentials(API_KEY, SECRET_KEY));

        snsClient.setRegion(Region.getRegion(Regions.fromName("eu-west-1")));

        String message = "";
        String tel = "";
        sendSMSMessage(snsClient, message, tel);
    }

    public static void sendSMSMessage(AmazonSNSClient snsClient, String message, String tel) {
        PublishResult result = snsClient.publish(new PublishRequest()
                .withSubject("")
                .withMessage(message)
                .withPhoneNumber(tel));
        System.out.println(result);
    }
}
