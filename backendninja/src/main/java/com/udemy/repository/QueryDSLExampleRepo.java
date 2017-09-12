package com.udemy.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.hql.internal.ast.tree.BooleanLiteralNode;
import org.springframework.stereotype.Repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.udemy.entity.Course;
import com.udemy.entity.QCourse;

@Repository("queryDSLExampleRepo")
public class QueryDSLExampleRepo {
	
	private QCourse qCourse = QCourse.course;
	
	@PersistenceContext
	private EntityManager em;
	
	public Course find(boolean exit) {
		
		JPAQuery<Course> query = new JPAQuery<Course>(em);
		
		BooleanBuilder booleanBuilder = new BooleanBuilder(qCourse.description.endsWith("OP"));
		
		if(exit) {
			Predicate predicate2 = qCourse.id.eq(23);
			booleanBuilder.and(predicate2);
		} else {
			Predicate predicate3 = qCourse.name.endsWith("OP");
			booleanBuilder.or(predicate3);
		}
		
		Course course1 = query.select(qCourse).from(qCourse).where(booleanBuilder).fetchOne();
		
		List<Course> listCurso = query.select(qCourse).from(qCourse).where(qCourse.hours.between(20, 50)).fetch();
		
		return course1;
	}

}
