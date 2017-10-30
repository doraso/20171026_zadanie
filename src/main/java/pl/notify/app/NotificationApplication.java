package pl.notify.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.notify.logger.FileLogger;
import pl.notify.reader.FileNotificationReader;
import pl.notify.reader.InputNotificationReader;
import pl.notify.sender.EmailNotificationSender;
import pl.notify.sender.SmsNotificationSender;

import java.io.IOException;

/**
 * Konfiguracja beanów springa w pliku beans-config.xml
 */
public class NotificationApplication {
    public static void main(String[] args) {
        InputNotificationReader reader = new InputNotificationReader();
        SmsNotificationSender sender = new SmsNotificationSender();
        FileLogger logger = new FileLogger();
        NotificationFacade facade = new NotificationFacade(reader, sender, logger);
        try {
            facade.sendNotifications();
        } catch (IOException e) {
            System.err.println("Nie udało się wysłać powiadomień");
        }
    }
}
