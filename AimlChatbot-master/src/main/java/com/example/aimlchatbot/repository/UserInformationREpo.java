package com.example.aimlchatbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.aimlchatbot.dto.Userinformation;

@Repository
public interface UserInformationREpo extends JpaRepository<Userinformation, Integer> 
{
	@Query("SELECT u FROM Userinformation u WHERE u.refid = :refid")
    Userinformation findByRefid(@Param("refid") String refid);
}
