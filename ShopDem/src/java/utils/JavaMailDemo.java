/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 *
 * @author anhdt
 */
public class JavaMailDemo {
    
    private final String MAIL = "khaitran30062000@gmail.com";
    private final String PASSWORD = "khai123098";
    
    public void sentEmail(String toEmail, String subject, String text) {
        
        // Config
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        
        // Authenticator
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(MAIL, PASSWORD);
            }
        });

        // Mail info
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(MAIL));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(text);

            Transport.send(message);           
            System.out.println("Message sent successfully...");
            
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }    
    
    public static void main(String[] args) {
        JavaMailDemo j = new JavaMailDemo();
        String mail = "khaitqhe141672@fpt.edu.vn";
        String a = "ds";
        String b = "sds";
        j.sentEmail(mail, a, b);
    }
}