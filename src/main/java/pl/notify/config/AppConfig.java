package pl.notify.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.notify.app.NotificationFacade;
import pl.notify.logger.FileLogger;
import pl.notify.logger.NotifyLogger;
import pl.notify.reader.FileNotificationReader;
import pl.notify.reader.InputNotificationReader;
import pl.notify.sender.EmailNotificationSender;
import pl.notify.sender.SmsNotificationSender;

//@Configuration
public class AppConfig {

    @Bean
    public NotifyLogger logger() {
        FileLogger fileLogger = new FileLogger();
        return fileLogger;
    }


    @Bean
    public InputNotificationReader reader(){
        InputNotificationReader inputNotificationReader = new InputNotificationReader();
        return inputNotificationReader;
    }

    @Bean
    public SmsNotificationSender sender() {
        SmsNotificationSender smsNotificationSender = new SmsNotificationSender();
        return new SmsNotificationSender();
    }

@Bean
public NotificationFacade facade(NotifyLogger logger, InputNotificationReader reader, SmsNotificationSender sender) {
    NotificationFacade notificationFacade = new NotificationFacade(reader, sender, logger);
    return notificationFacade;
}
}
