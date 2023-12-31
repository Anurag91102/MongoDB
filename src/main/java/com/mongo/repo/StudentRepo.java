package com.mongo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongo.model.Student;

@Repository
public interface StudentRepo extends MongoRepository<Student, Integer> {

}
