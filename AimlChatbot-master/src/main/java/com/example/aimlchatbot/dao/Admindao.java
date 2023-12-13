package com.example.aimlchatbot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.aimlchatbot.AimlChatbot.HelloMessage;
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

	public String SaveData(HelloMessage message, int num) {
		// TODO Auto-generated method stub
		Userinformation user=new Userinformation();
		user.setUname(message.getMessage());
		user.setRefid(num);
		epo.save(user);
		return "please provide phoneNumber";
	}

}
