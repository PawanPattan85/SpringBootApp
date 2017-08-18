package com.springBoot.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springBoot.domain.OsiEmployeeDetails;

@Repository
public interface EmployeeRepo extends MongoRepository<OsiEmployeeDetails, String> {

}
