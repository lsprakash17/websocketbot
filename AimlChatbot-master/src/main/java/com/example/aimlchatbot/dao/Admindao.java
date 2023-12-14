package com.example.aimlchatbot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.aimlchatbot.AimlChatbot.HelloMessage;
import com.example.aimlchatbot.AimlChatbot.SendmailHelper;
import com.example.aimlchatbot.dto.Adminquestions;
import com.example.aimlchatbot.dto.Userinformation;
import com.example.aimlchatbot.helperclass.Querries;
import com.example.aimlchatbot.helperclass.ResponseStructure;
import com.example.aimlchatbot.helperclass.UserData;
import com.example.aimlchatbot.repository.Queriesrepository;
import com.example.aimlchatbot.repository.UserInformationREpo;

@Service
public class Admindao {

	@Autowired
	Queriesrepository repo;
	
	@Autowired
	UserInformationREpo epo;
	
	@Autowired
	SendmailHelper helper;

	public ResponseStructure<String> Savedata(Querries quer) {
		Adminquestions adminquestions = new Adminquestions();
		adminquestions.setAddabout(quer.getAns());
		adminquestions.setJustification(quer.getAns());
		repo.save(adminquestions);

		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.ACCEPTED.value());
		responseStructure.setMessage("Saved Success");
		responseStructure.setData(null);

		return responseStructure;
	}
	
	public List<String>GetAllquerries()
	{
		
	 return repo.findAllAddAbout();
	}

	public String findserviceeByname(String textLine) {
		// TODO Auto-generated method stub
		return repo.findJustificationByAddabout(textLine);
	}

	public String SaveData(String message, String num) {
		Userinformation user=new Userinformation();
		user.setUname(message);
		user.setRefid(num);
		epo.save(user);
		return "Please provide your phone number:";
	
	}

	public String FindandSaveData(String textLine, String number) {
		Userinformation user=epo.findByRefid(number);
		if(user==null)
		{
			return "something went wrong";
		}
		else
		{
			user.setMobnum(textLine);
			epo.save(user);
			return "Please provide your Email ID:";
		}
	}

	public String FindandSaveDataEmail(String textLine, String number) {
		Userinformation user=epo.findByRefid(number);
		if(user==null)
		{
			return "something went wrong";
		}
		else
		{
			user.setEmail(textLine);
			epo.save(user);
			if(helper.sendLink(user))
				return "We will contact you soon happy to help";
			else
				return "We will contact you soon happy to help";
				
		}
	}

}
