package com.briup.apps.poll.service.Impl;

import java.util.List;


import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.extend.QuestionnaireVM;
import com.briup.apps.poll.dao.QuestionnaireMapper;
import com.briup.apps.poll.service.IQuestionnaireService;

@Service
public class QuestionnaireServiceImpl implements IQuestionnaireService{

	@Override
	public QuestionnaireVM findById(long id) throws Exception {
		
		return null;
	}

	@Override
	public List<Questionnaire> findAll(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(long id) throws Exception {
		
		
	}

	@Override
	public void saveOrUpdate(Questionnaire questionnaire, long[] ids) throws Exception {
		//保存
		if(questionnaire.getId()==null){
			//QuestionnaireMapper.insert(questionnaire);
			for(long id:ids){
				//QuestionnaireQuestionServiceImpl qq=new QuestionnaireQuestionServiceImpl();
			}
		}else{
			
		}
		
	}

}
