package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class DashController {
	@Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
private DashRepo dr;
	//Show All Messages

	@GetMapping(path="/allDashMessages")
	  public Iterable<DashBoard> getAllUsers() {
	    // This returns a JSON or XML with the users
	    return dr.findAll();
	  }
	//Delete A Messsage
	
	@PostMapping(path = "/deleteDash", consumes = "application/json", produces = "application/json")
	public int deletef(@RequestBody DashBoard Dobj)
	{
		int inx = Dobj.getId();
		dr.deleteById(inx);
		return Dobj.getId();
	}
	@PostMapping("/insertDash") // Send A message
	public DashBoard insertf(@RequestBody DashBoard u)
	{
dr.save(u);		
	
	return u;
	}
	

}
