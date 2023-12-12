package com.example.aimlchatbot.AimlChatbot;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.util.HtmlUtils;

import com.example.aimlchatbot.dao.Admindao;

@Controller
public class GreetingController implements ServletContextAware {

	private ServletContext servletContext;

	
	Admindao admindao=new Admindao();

	@MessageMapping("/talktorobot")
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws Exception {
		String response = "";
		try {
			String textLine = message.getMessage();
			response = executeDefault(textLine);
		
			System.out.println("Robot : " + response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		Thread.sleep(1000); // simulated delay
		return new Greeting(HtmlUtils.htmlEscape(response));
	}

	private String executeDefault(String textLine) {
		List<String> li=admindao.GetAllquerries();
		
		String ans="welcome"+textLine+"We provide services like";
		for(String a:li)
		{
			ans=ans+a;
		}
		return ans;


	}

	private String executeDefault(String response, String textLine) {
		return "Welcome" + textLine;
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

}
