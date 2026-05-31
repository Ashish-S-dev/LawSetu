package com.TechCoder.LawSetu.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TechCoder.LawSetu.model.BarCouncilId;

@Repository
public interface BarCouncilIdDao extends CrudRepository<BarCouncilId, Integer>{

	public Optional<BarCouncilId> findByLawyerEmail(String userEmail);
	
}
