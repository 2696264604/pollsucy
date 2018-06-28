package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.extend.QuestionnaireVM;

public interface IQuestionnaireService {
	QuestionnaireVM findById(long id) throws Exception;
	
	List<Questionnaire> findAll(long id) throws Exception;
	
	void deleteById(long id) throws Exception;
	
    void saveOrUpdate(Questionnaire questionnaire,long[] ids) throws Exception;
}
