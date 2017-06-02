package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import db.RedisResource;
import model.Address;
import model.Person;

@Controller
@RequestMapping
public class PersonController {

	@Autowired
	RedisResource redisCache;
	
	 @PostMapping("/addName")
	    public  @ResponseBody String addName(@RequestParam(value="firstname", required=false, defaultValue="Jason") String firstName,
	    					   @RequestParam(value="lastname", required=false, defaultValue="Bourne") String lastName ) {
		
		 redisCache.addType(firstName, lastName);
		 return "Added Key "+ firstName + " Value "+lastName;
	    }
		
	 
	 @GetMapping("/getName")
	    public  @ResponseBody String getName(@RequestParam(value="firstname", required=false, defaultValue="Jason") String firstName,
	    					   @RequestParam(value="lastname", required=false, defaultValue="Bourne") String lastName) {
	       
		 
		 return  redisCache.getType(firstName);
	    }
	 
	 @GetMapping("/getAllName")
	    public  @ResponseBody List<String> getAllName(@RequestParam(value="firstname", required=false, defaultValue="Jason") String firstName,
	    					   @RequestParam(value="lastname", required=false, defaultValue="Bourne") String lastName) {
	       
		 
		 return  redisCache.getAll(firstName);
	    }
	
	
	
	 @GetMapping("/person")
    public  @ResponseBody Person getPerson(@RequestParam(value="firstname", required=false, defaultValue="Jason") String firstName,
    					   @RequestParam(value="lastname", required=false, defaultValue="Bourne") String lastName,
    					   @RequestParam(value="phone", required=false, defaultValue="000-000-000") String phone,
    					   @RequestParam(value="email", required=false, defaultValue="secret@gmail.com") String email ) {
        return new Person(firstName,lastName,phone,email);
    }
	 @GetMapping("/personaddress")
	    public  @ResponseBody Person getPerson(@RequestParam(value="firstname", required=false, defaultValue="Jason") String firstName,
	    					   @RequestParam(value="lastname", required=false, defaultValue="Bourne") String lastName,
	    					   @RequestParam(value="phone", required=false, defaultValue="000-000-000") String phone,
	    					   @RequestParam(value="email", required=false, defaultValue="secret@gmail.com") String email ,
	    					   @RequestParam(value="housenum", required=false, defaultValue="1600") String housenum,
	    					   @RequestParam(value="street", required=false, defaultValue="Pennsylvania Ave NW") String street,
	    					   @RequestParam(value="city", required=false, defaultValue="Washington") String city,
	    					   @RequestParam(value="state", required=false, defaultValue="DC") String state,
	    					   @RequestParam(value="zipcode", required=false, defaultValue="20500") String zipcode) {
		 	Address personAddress = new Address(housenum,street,city,state,zipcode);
	        return new Person(firstName,lastName,phone,email,personAddress);
	    }
	   @PostMapping("/person")
	    public  @ResponseBody Person insertPerson(@RequestBody( required=true) Person person) {
	        return person;
	    }
    
    

}
