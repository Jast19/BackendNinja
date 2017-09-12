package com.udemy.service.imp;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.controller.CourseController;
import com.udemy.entity.Course;
import com.udemy.repository.CourseJpaRespository;
import com.udemy.service.CourseService;


@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService{
	
	private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);

	@Autowired
	@Qualifier("courseJpaRespository")
	private CourseJpaRespository courseJpaRespository;

	@Override
	public List<Course> listAllCourse() {
		LOG.info("call:: listAllCourse()");
		return courseJpaRespository.findAll();
	}

	@Override
	public Course addCourse(Course course) {
		LOG.info("call:: addCourse()");
		return courseJpaRespository.save(course);
	}

	@Override
	public int removeCourse(int id) {
		courseJpaRespository.delete(id);
		return 0;
	}

	@Override
	public Course updateCourse(Course course) {
		return courseJpaRespository.save(course);
	}

}
