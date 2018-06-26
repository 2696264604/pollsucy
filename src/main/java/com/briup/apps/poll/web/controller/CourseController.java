package com.briup.apps.poll.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Course;
import com.briup.apps.poll.service.ICourseService;
import com.briup.apps.poll.util.MsgResponse;

@RestController
@RequestMapping("/Course")
public class CourseController {
	@Autowired
	private ICourseService courseService;
	//涉及多个值用postMapping
	@PostMapping
	public MsgResponse batchDelete(Long[] ids){
		try {	
			List<Long> idList=new ArrayList<>();
			for(long id : ids){
				idList.add(id);
			}			
			courseService.batchDelete(idList);
			return MsgResponse.success("批量删除成功", null);
		} catch (Exception e) {
			e.printStackTrace(); 
			return MsgResponse.error(e.getMessage());
		}
		
	}
	
	@GetMapping("findAllCourse")
	public MsgResponse findAllCourse(){
		try {
			List<Course> list=courseService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	
//	@GetMapping("deleteById")//删除一个
//	public MsgResponse deleteById(){
//		try {
//			List<Course> list=courseService.findAll();
//			return MsgResponse.success("success", list);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return MsgResponse.error(e.getMessage());
//		}
//		
//	}
	
	@PostMapping("updateCourse")//更新
	public MsgResponse updateCourse(Course course){
		try {
			courseService.update(course);
			return MsgResponse.success("修改成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}		
	}
	
	@PostMapping("saveCourse")//添加
	public MsgResponse saveCourse(Course course){
		try {
			courseService.save(course);
			return MsgResponse.success("添加成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}		
	}
	@GetMapping("deleteByIdCourse")//删除
	public MsgResponse deleteByIdCourse(@RequestParam Long id){
		try {
			courseService.deleteById(id);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}		
	}
	

	

}
