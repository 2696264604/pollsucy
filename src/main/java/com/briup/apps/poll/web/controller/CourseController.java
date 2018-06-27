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

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/course")
public class CourseController {
	/**
	 * @return
	 */
	@Autowired
	private ICourseService courserService;

	// 批量删除
	@PostMapping("batchDelete")
	public MsgResponse batchDelete(long[] ids) {
		try {
			List<Long> idList = new ArrayList<>();
			for (long id : ids) {
				idList.add(id);
			}
			courserService.batchDelete(idList);
			return MsgResponse.success("批量删除成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	
	// 删除一个
	@GetMapping("DeleteCourseById")
	public MsgResponse DeleteCourseById(@RequestParam Long id) {
		try {
			courserService.deleteById(id);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

//	// 查询
//	@GetMapping("queryCourse")
//	public MsgResponse queryCourse() {
//		try {
//			List<Course> list = courserService.findAll();
//			return MsgResponse.success("success", list);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return MsgResponse.error(e.getMessage());
//		}
//	}
	
	
	// 关键字查询
		@ApiOperation("根据关键字查看课程信息")
		@GetMapping("/queryByKeyWords")
		public MsgResponse query(String keywords) {
			try {
				List<Course> list = courserService.query(keywords);
				return MsgResponse.success("成功", list);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
	
	@GetMapping("findAllCourse")
	public MsgResponse findAllCourse() {
		try {
			List<Course> list = courserService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}	
	
	

	// 添加
	@PostMapping("saveCourse")
	public MsgResponse saveCourse(Course course) {
		try {
			courserService.save(course);
			return MsgResponse.success("添加成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	// 更新
	@PostMapping("updateCourse")
	public MsgResponse updateCourse(Course course) {
		try {
			courserService.update(course);
			return MsgResponse.success("修改成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}
