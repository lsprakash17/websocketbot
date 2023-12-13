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

	@Autowired
	Admindao admindao;

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
	
	@MessageMapping("/talktorobot1")
	@SendTo("/topic/greetings")
	public Greeting about(HelloMessage message) throws Exception {
		String response = "";
		try {
			String textLine = message.getMessage().toLowerCase();
			response = admindao.findserviceeByname(textLine)+"  "+" "+"Want to know about service Please enter you name";
			if(response.isEmpty()||response==null)
				response="Invalid service please Provide the name";
			System.out.println("Robot : " + response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		Thread.sleep(1000); // simulated delay
		return new Greeting(HtmlUtils.htmlEscape(response));
	}
	
	@MessageMapping("/talktorobot2")
	@SendTo("/topic/greetings")
	public Greeting ab(HelloMessage message,String num) throws Exception {
		String response = "";
		try {
			String textLine = message.getMessage().toLowerCase();
			int number=Integer.parseInt(num);
			response = admindao.SaveData(message,number);
			if(response.isEmpty()||response==null)
				response="Invalid service please Provide the name";
			System.out.println("Robot : " + response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		Thread.sleep(1000); // simulated delay
		return new Greeting(HtmlUtils.htmlEscape(response));
	}

	private String executeDefault(String textLine) {
		List<String> li=admindao.GetAllquerries();
		
		String ans="welcome We provide services like";
		int f=1;
		for(String a:li)
		{
			ans=ans+f+". "+a+" ";
			f++;
		}
		return ans+" "+"please type the service name you want to know about";


	}



	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

}
