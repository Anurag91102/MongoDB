package com.mongo.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongo.model.Student;
import com.mongo.payloads.Response;
import com.mongo.repo.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;
	
	public Student findById(int id)
	{
		Optional<Student> student = studentRepo.findById(id);
		if(student.isPresent())
		{	
			return student.get();
		}
		else
		{
			return null;
		}	
	}
	
	public Response deleteById(int id)
	{
		Optional<Student> student = studentRepo.findById(id);
		
		if(student.isPresent())
		{
			studentRepo.deleteById(id);
			Response response = new Response();
			response.setSuccess(1);
			response.setMessage("Deleted Successfully");
			response.setData(student);
			return response;
			
		}
		else
		{
			Response response = new Response();
			response.setSuccess(0);
			response.setMessage("No Such Record Found.");
			response.setData(null);
			return response;
		}
	}
	
	
}
