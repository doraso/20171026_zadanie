package pl.notify.sender;

import org.springframework.stereotype.Component;
import pl.notify.model.Notification;

@Component
public class SmsNotificationSender {
    public void send(Notification notification){
        System.out.println("Sending SMS to " + notification.getTelephone());
    }
}
