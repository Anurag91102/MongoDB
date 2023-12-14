package com.mongo.controller;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.model.Student;
import com.mongo.payloads.Response;
import com.mongo.repo.StudentRepo;
import com.mongo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentRepo repo;
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/add")
	public ResponseEntity<Response> addStudent(@RequestBody Student student)
	{
		repo.save(student);
		Response response = new Response(1, "Added Successfully", student);
		return new ResponseEntity<Response>(response, HttpStatus.OK);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Response> getStudent(@PathVariable("id") int id)
	{
		Student student= studentService.findById(id);
		Response response = new Response();
		if(student==null)
		{
			response.setSuccess(0);
			response.setMessage("No Such Record");
			response.setData(new ArrayList<>());
			return new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);
		}
		else
		{
			response.setSuccess(1);
			response.setMessage("Record Successfully");
			response.setData(student);
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		}	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Response> deleteById(@PathVariable("id") int id)
	{		
		Response response = studentService.deleteById(id);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@PutMapping(path="/update/{id}")
	public ResponseEntity<Response> updateById(@RequestBody Student student,@PathVariable("id") int id)
	{
		Student existing = studentService.findById(id);
		Response response = new Response();
		if(existing!=null)
		{
			if(student.getFname()!=null)
			{
				existing.setFname(student.getFname());
			}
			if(student.getLname()!=null)
			{
				existing.setLname(student.getLname());
			}
			if(student.getPhone()!=null)
			{
				existing.setPhone(student.getPhone());
			}
			if(student.getCity()!=null)
			{
				existing.setCity(student.getCity());
			}
			repo.save(existing);
			response.setSuccess(1);
			response.setMessage("Record Updated Successfully");
			response.setData(existing);
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		}
		else
		{
			response.setSuccess(0);
			response.setMessage("No Such Record");
			response.setData(new ArrayList<>());
			return new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);
		}
		
	}
}
