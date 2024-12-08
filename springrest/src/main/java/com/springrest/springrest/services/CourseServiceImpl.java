package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.controller.PathVariable;
import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Courses;

@Service // this is written to let know the spring framework that this is providing implementations 
public class CourseServiceImpl implements CourseService {
	
	//List<Courses> list;
	@Autowired
	private CourseDao courseDao;
	
	public CourseServiceImpl()
	{
//		list = new ArrayList<>();
//		list.add(new Courses(1, "Java Core Course", "Java Backed Project"));
//		list.add(new Courses(2, "Spring Boot", "API"));
	}
	@Override
	public List<Courses> getCourses() {
		// TODO Auto-generated method stub
		//return list;
		
		return courseDao.findAll();
	}
	
	public Courses getCourse(Long courseId)
	{
//		Courses c=null;
//		
//		for(Courses course:list)
//		{
//			if(course.getId()==courseId)
//			{
//				c=course;
//				break;
//			}
//		}
		return courseDao.getOne(courseId);
	}
	
	public Courses addCourse(Courses course)
	{
		//list.add(course);
		courseDao.save(course);
		return course;
	}
	
	//public Courses updateCourse(Long courseId, Courses updateCourse)
	//{
//		Courses c=null;
//		
//		for(Courses course:list)
//		{
//			if(course.getId()==courseId)
//			{
//				course.setId(updateCourse.getId());
//				course.setTitle(updateCourse.getTitle());
//				course.setDescription(updateCourse.getDescription());
//				c=course;
//				break;
//			}
//		}
		//return c;
	//}
	
	@Override
	public void deleteCourse(Long parseLong) {
		//list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		Courses entity = courseDao.getOne(parseLong);
		courseDao.delete(entity);
	}

}
