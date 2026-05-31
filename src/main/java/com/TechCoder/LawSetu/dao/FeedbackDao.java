package com.TechCoder.LawSetu.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TechCoder.LawSetu.model.Feedback;

@Repository
public interface FeedbackDao extends CrudRepository<Feedback, Integer>{

}
