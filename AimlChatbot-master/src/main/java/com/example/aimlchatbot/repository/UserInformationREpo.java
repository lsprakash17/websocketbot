package com.example.aimlchatbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.aimlchatbot.dto.Userinformation;

@Repository
public interface UserInformationREpo extends JpaRepository<Userinformation, Integer> 
{

}
