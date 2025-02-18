package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Courses;
import com.springrest.springrest.services.CourseService;

@RestController
public class MyController {
	
	@Autowired
	private CourseService courseService;
	
	//Get the courses
	@GetMapping("/courses")
	public List<Courses> getCourses()
	{
		return this.courseService.getCourses();
	}
	
	@GetMapping("/courses/{courseId}")
	public Courses getCourse(@PathVariable String courseId)
	{
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	@PostMapping(path  = "/courses", consumes = "application/json")
	public Courses addCourse(@RequestBody Courses course)
	{
		return this.courseService.addCourse(course);
	}
	
	//@PutMapping("/courses/{courseId}")
	//public Courses updateCourse(@PathVariable String courseId, @RequestBody Courses course)
	//{
	//	return this.courseService.updateCourse(Long.parseLong(courseId), course);
	//}
	
	//delete the course

	@DeleteMapping("/courses/{courseId}")

	public ResponseEntity<HttpStatus> deleteCourse (@PathVariable String courseId) {

		try {
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);

		} 
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
