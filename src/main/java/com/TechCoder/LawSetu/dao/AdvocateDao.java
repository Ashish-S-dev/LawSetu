package com.TechCoder.LawSetu.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TechCoder.LawSetu.model.Advocate;

@Repository
public interface AdvocateDao extends CrudRepository<Advocate, Long> {

	public Optional<Advocate> findByBarCouncilNumber(String barCouncilNumber);
	
}
