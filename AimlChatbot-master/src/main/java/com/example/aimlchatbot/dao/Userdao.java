package com.example.aimlchatbot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aimlchatbot.dto.Userinformation;
import com.example.aimlchatbot.helperclass.UserData;
import com.example.aimlchatbot.repository.UserInformationREpo;

@Service
public class Userdao {
	@Autowired
	UserInformationREpo epo;
	
	public void saveName(UserData data)
	{
		Userinformation information=new Userinformation();
		information.setUname(data.getName());
		information.setEmail(data.getEmail());
		information.setMobnum(data.getPhNum());
		epo.save(information);
	}

	
}
