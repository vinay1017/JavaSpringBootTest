package com.rest.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rest.springboot.entities.tests;
import com.rest.springboot.repositories.TestRepository;

@Controller
@RequestMapping(path="/test")
public class TestController {
  @Autowired

  private TestRepository testRepo;

  @GetMapping(path="/add")
//  @PostMapping(path="/add") // Swap to posts later
  public @ResponseBody String addNewTest (@RequestParam String number, @RequestParam String name) {
	  
//	 ex: http://localhost:8080/test/add?number=1&name=test
	
	// Create an instance of tests, grab the values from the params
	// and set the values to then pass to the repo to save the values in the database.
	tests test = new tests();
    test.setName(name);
    Integer num = Integer.parseInt(number);
    test.setNumber(num);
    testRepo.save(test);
    return "Saved";
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<tests> getAllTests() {
    return testRepo.findAll();
  }
}