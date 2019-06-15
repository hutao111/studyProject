package org.hutao.projectservice.application.mail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MailTest {
    @Autowired
    JavaMailSender mailSender;

    @Test
    public void sendMail() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setSubject("通知今晚七点开会");
        mailMessage.setText("不见不散！");
        mailMessage.setTo("hutao@fulan.com.cn");
        mailMessage.setFrom("15079158693@qq.com");
        mailSender.send(mailMessage);

    }

    @Test
    public void test() throws MessagingException {
        MimeMessage mimeMailMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMailMessage,true);

        helper.addAttachment("1.jfif", new File("C:\\Users\\hutao\\Desktop\\照片\\1.jfif"));
        helper.setSubject("通知今晚七点开会");
        helper.setText("不见不散！");
        helper.setTo("hutao@fulan.com.cn");
        helper.setFrom("15079158693@qq.com");
        mailSender.send(mimeMailMessage);

    }
}
