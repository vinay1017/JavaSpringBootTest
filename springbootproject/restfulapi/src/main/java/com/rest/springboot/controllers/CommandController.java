package com.rest.springboot.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.io.File;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class CommandController {
	
	@RequestMapping("/mkdir")
	public String mkdir() {
		String query = "C:\\projects/java/testDirectory";
        File f = new File(query);


        if (f.mkdir()) { 
            System.out.println("Directory was created at " + query); 
        } 
        else { 
            System.out.println("Directory cannot be created at " + query); 
        }
            
		return "Directory Has Been Created at " + query;
	}
	
	
	@GetMapping("/mkdir/{query}")
	public @ResponseBody String mkdirQuery(@PathVariable String query) {
        File f = new File("C:\\projects/" + query); 
        if (f.mkdir()) { 
            return "Directory was created at C:\\projects/" + query;
        } 
        else { 
            System.out.println("Directory cannot be created at " + query); 
        }
	return "There might have been an issue, maybe your directory was already created?";
	}

}
