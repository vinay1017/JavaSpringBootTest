package com.rest.springboot.repositories;

import org.springframework.data.repository.CrudRepository;

import com.rest.springboot.entities.tests;

public interface TestRepository extends CrudRepository<tests, Integer> {

}