package pl.notify.reader;

import org.springframework.stereotype.Component;
import pl.notify.model.Notification;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class InputNotificationReader {
    public static final String EXIT = "exit";
    public static final String NEXT = "next";

    public List<Notification> getNotifications() {
        List<Notification> notifications = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        String option;
        boolean temp = true;
        while (temp) {
            System.out.println("Wpisz next, aby dodać kolejne powiadomienie lub exit, aby zakończyć");
            option = sc.nextLine();
            if (option.equals(InputNotificationReader.EXIT)) {
                temp = false;
            } else {
                System.out.println("Podaj nazwę użytkownika: ");
                String username = sc.nextLine();
                System.out.println("Podaj email: ");
                String mail = sc.nextLine();
                System.out.println("Podaj nr telefonu: ");
                String phone = sc.nextLine();
                System.out.println("Podaj treść do wysłania: ");
                String message = sc.nextLine();
                Notification notification = new Notification(username, mail, phone, message);
                notifications.add(notification);

            }

        }
        return notifications;
        }
    }






