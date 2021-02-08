package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.Name;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MyCon {
	@Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
private ParentRepo Pr;
	@GetMapping(path="/")
	public String mrba() {
		return "Merhaba";
	}
	@GetMapping(path="/allParent")
	  public Iterable<ParentEntity> getAllUsers() {
	    // This returns a JSON or XML with the users
	    return Pr.findAll();
	  }
	@PostMapping(path = "/deleteParent", consumes = "application/json", produces = "application/json")
	public int deletef(@RequestBody ParentEntity Pobj)
	{
		int inx = Pobj.getId();
		Pr.deleteById(inx);
		return Pobj.getId();
	}
	
	@PostMapping("/insertParent")
	public ParentEntity insertf(@RequestBody ParentEntity u)
	{
Pr.save(u);		
	
	return u;
	}
	
	
}