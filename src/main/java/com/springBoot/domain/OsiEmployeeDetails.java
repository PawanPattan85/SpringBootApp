package com.springBoot.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "osiEmployeeDetails")
public class OsiEmployeeDetails {

	private String empId;
	private String empName;
	private String empEmailId;
	private String empCompanyName;
	private String empRole;

}