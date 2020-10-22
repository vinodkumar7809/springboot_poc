package com.vensai.rest.webservices.restfulwebservices.resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vensai.rest.webservices.restfulwebservices.user.User;

@Repository
public interface ResourceRepository extends JpaRepository<User, Integer> {

}
