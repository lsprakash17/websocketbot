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
			response = admindao.findserviceeByname(textLine)+"  "+" "+".To know more about our products, please enter your name.";
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
	public Greeting ab(HelloMessage message,Numberread num) throws Exception {
		String response = "";
		try {
			String textLine = message.getMessage().toLowerCase();
			String number=num.getNum();
			
			response = admindao.SaveData(textLine,number);
			if(response.isEmpty()||response==null)
				response="Invalid service please Provide the name";
			System.out.println("Robot : " + response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		Thread.sleep(1000); // simulated delay
		return new Greeting(HtmlUtils.htmlEscape(response));
	}
	@MessageMapping("/talktorobot3")
	@SendTo("/topic/greetings")
	public Greeting abc(HelloMessage message,Numberread num) throws Exception {
		String response = "";
		try {
			String textLine = message.getMessage().toLowerCase();
			String number=num.getNum();
			
			response = admindao.FindandSaveData(textLine,number);
			if(response.isEmpty()||response==null)
				response="Invalid service please Provide the name";
			System.out.println("Robot : " + response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		Thread.sleep(1000); // simulated delay
		return new Greeting(HtmlUtils.htmlEscape(response));
	}
	
	@MessageMapping("/talktorobot4")
	@SendTo("/topic/greetings")
	public Greeting useremail(HelloMessage message,Numberread num) throws Exception {
		String response = "";
		try {
			String textLine = message.getMessage().toLowerCase();
			String number=num.getNum();
			
			response = admindao.FindandSaveDataEmail(textLine,number);
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
	
		String ans = "";
		int f=1;
		for(String a:li)
		{
			ans=ans+"\n"+a;
			f++;
		}
		return ans;


	}



	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

}
