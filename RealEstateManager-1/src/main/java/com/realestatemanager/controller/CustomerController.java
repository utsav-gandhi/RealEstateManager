package com.realestatemanager.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.realestatemanager.exception.CustomExceprion;
import com.realestatemanager.exception.NoDataFoundException;
import com.realestatemanager.model.Property;
import com.realestatemanager.service.PropertyService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	PropertyService propService;
	
	@GetMapping("/getproperties")
	public ResponseEntity<List<Property>> getProperties(@RequestBody Property property) 
		    throws URISyntaxException, NoDataFoundException {
		List<Property> result= propService.getProperty(property);
		    if (result ==  null) {
		        return ResponseEntity.notFound().build();
		    } else {
		        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
		          .path("/properties")
		          .buildAndExpand(result)
		          .toUri();

		        return ResponseEntity.created(uri).body(result);
		    }
		}
}
