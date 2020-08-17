package com.rest.springboot.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.io.File;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class CommandController {
	
//	@RequestMapping("/mkdir")
	public String mkdir() {
		// create an abstract pathname (File object) 
		String query = "C:\\projects/java/testDirectory";
        File f = new File(query);

        // check if the directory can be created 
        // using the abstract path name 
        if (f.mkdir()) { 
  
            // display that the directory is created 
            // as the function returned true 
            System.out.println("Directory was created at " + query); 
        } 
        else { 
            // display that the directory cannot be created 
            // as the function returned false
            System.out.println("Directory cannot be created at " + query); 
        }
            
		return "Directory Has Been Created at " + query;
	}
	
	
	@GetMapping("/mkdir/{param}")
	public @ResponseBody String mkdirParam(@PathVariable String param) {
        File f = new File("C:\\projects/" + param); 
        if (f.mkdir()) { 
            return "Directory was created at C:\\projects/" + param;
        } 
        else { 
            System.out.println("Directory cannot be created at " + param);
        }
	return "There might have been an issue; maybe your directory was already created?";
	}
	
	@GetMapping("/api/foos")
	@ResponseBody
	public String getFoos(@RequestParam String id) {
	    return "ID: " + id;
	}
	
	
	@GetMapping("/mkdir")
	@ResponseBody
	public String mkdirQuery(@RequestParam String query) {
        File f = new File("C:\\projects/" + query); 
        if (f.mkdir()) { 
            return "Directory was created at C:\\projects/" + query;
        }
        else { 
            System.out.println("Directory cannot be created at " + query);
            mkdir();
            System.out.println("Directory created at C:\\projects/java/testDirectory instead.");
        }
	return "There might have been an issue; maybe your directory was already created?";
	}
	
	
	
}
