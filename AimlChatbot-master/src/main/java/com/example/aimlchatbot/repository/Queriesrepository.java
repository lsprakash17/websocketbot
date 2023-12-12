package com.example.aimlchatbot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.aimlchatbot.dto.Adminquestions;

@Repository
public interface Queriesrepository extends JpaRepository<Adminquestions, Integer> {
	@Query("SELECT a.justification FROM Adminquestions a WHERE a.addabout = :addabout")
	String findJustificationByAddabout(@Param("addabout") String addabout);
	
	@Query("SELECT a.addabout FROM Adminquestions a")
	List<String> findAllAddAbout();

}
