package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.bean.Course;
import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.extend.ClazzVM;
import com.briup.apps.poll.bean.extend.SurveyVM;
import com.briup.apps.poll.service.ISurveyService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(description="课调相关接口")
@RestController
@RequestMapping("/Survey")
public class SurveyController {
	@Autowired
	private ISurveyService surveyService;	
	
	@ApiOperation(value="查询所有的课调信息",notes="")
	@GetMapping("findAllSurveyVM")
	public MsgResponse findAllSurveyVM(){
		try {
			List<SurveyVM> list = surveyService.findAllSurveyVM();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation("查询所有的课调信息")
	@GetMapping("findAllSurvey")
	public MsgResponse findAllSurvey(){
		try {
			List<Survey> list = surveyService.findAll();
			
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
}
