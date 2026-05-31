package com.TechCoder.LawSetu.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TechCoder.LawSetu.model.Roles;

@Repository
public interface RoleDao extends CrudRepository<Roles, Integer>{
	// all the database code already written
}
