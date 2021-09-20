package com.realestatemanager.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.realestatemanager.exception.CustomExceprion;
import com.realestatemanager.model.Property;
import com.realestatemanager.service.PropertyService;

@RestController
@RequestMapping("/mananger")
public class ManagerController {

	@Autowired
	PropertyService propService;
	
	@PostMapping("/createproperty")
	public ResponseEntity<Property> create(@RequestBody Property property) 
		    throws URISyntaxException, CustomExceprion {
		Property result= propService.addProperty(property);
		    if (result ==  null) {
		        return ResponseEntity.notFound().build();
		    } else {
		        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
		          .path("/"+result.getPropertyId())
		          .buildAndExpand(result)
		          .toUri();

		        return ResponseEntity.created(uri).body(result);
		    }
		}
	
}
