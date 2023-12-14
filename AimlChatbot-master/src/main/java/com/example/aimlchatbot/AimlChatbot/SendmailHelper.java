package com.example.aimlchatbot.AimlChatbot;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.aimlchatbot.dto.Userinformation;
import com.example.aimlchatbot.helperclass.UserData;

@Service
public class SendmailHelper {

	@Autowired
	JavaMailSender MailSender;
	
	public boolean sendLink(Userinformation datacollect) {
		MimeMessage mimeMessage = MailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
		try {
			helper.setFrom("chatbotMaster");
			helper.setTo("lspraksh17@gmail.com");
			helper.setSubject("User Wants More Information");

			

			String content = "<h1>Here the details are <h1>"
					+ "<h1> Name:   "+datacollect.getUname()+"   contactNumber:    "+datacollect.getMobnum()+"    EmailId:   "+datacollect.getEmail()+
					 "</h1>";
			helper.setText(content, true);

			MailSender.send(mimeMessage);
			return true;
		} catch (MessagingException e) {
			return false;
		}

	}
}
