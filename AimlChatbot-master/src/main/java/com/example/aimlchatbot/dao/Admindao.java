package com.example.aimlchatbot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.aimlchatbot.dto.Adminquestions;
import com.example.aimlchatbot.helperclass.Querries;
import com.example.aimlchatbot.helperclass.ResponseStructure;
import com.example.aimlchatbot.repository.Queriesrepository;

@Service
public class Admindao {

	@Autowired
	Queriesrepository repo;

	public ResponseStructure<String> Savedata(Querries quer) {
		Adminquestions adminquestions = new Adminquestions();
		adminquestions.setAddabout(quer.getAns());
		adminquestions.setJustification(quer.getAns());
		adminquestions.setShow(quer.isFlag());
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

}
