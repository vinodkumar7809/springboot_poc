package com.vensai.springdemo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevRepository extends CrudRepository<Employee, Integer> {
	
	
	//jparepo extends pagingAndSortingrepo extends CrudRepo

}
