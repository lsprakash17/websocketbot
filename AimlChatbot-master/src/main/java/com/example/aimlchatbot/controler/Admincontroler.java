package com.example.aimlchatbot.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.aimlchatbot.dao.Admindao;
import com.example.aimlchatbot.helperclass.Querries;
import com.example.aimlchatbot.helperclass.ResponseStructure;

@RestController
public class Admincontroler {
	
	@Autowired
	Admindao admindao;
	
	@GetMapping("admin")
	public ResponseStructure<String> AddQuerries(@RequestBody Querries quer)
	{
		return	admindao.Savedata(quer);
		 
	}

}
