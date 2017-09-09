package com.udemy.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.udemy.entity.Course;
import com.udemy.repository.CourseJpaRespository;
import com.udemy.service.CourseService;

public class CourseServiceImpl implements CourseService{

	@Autowired
	@Qualifier("courseJpaRespository")
	private CourseJpaRespository courseJpaRespository;

	@Override
	public List<Course> listAllCourse() {
		return courseJpaRespository.findAll();
	}

	@Override
	public Course addCourse(Course course) {
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
