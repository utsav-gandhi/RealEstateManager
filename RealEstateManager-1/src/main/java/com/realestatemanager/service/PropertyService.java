package com.realestatemanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestatemanager.exception.CustomExceprion;
import com.realestatemanager.exception.NoDataFoundException;
import com.realestatemanager.model.Property;
import com.realestatemanager.repsitory.PropertyRepo;

@Service
public class PropertyService {

	@Autowired
	PropertyRepo propertyRepoImpl;
	
	public Property addProperty(Property property) throws CustomExceprion
	{
		
		
		return propertyRepoImpl.saveAndFlush(property);
			
	}
	
	public List<Property> getProperty(Property property) throws NoDataFoundException
	{
		List<Property> propertyList =propertyRepoImpl.findBySearchTermNative(property.getPrice(),
				  property.getNumOfBedrooms(), property.getNumOfBathrooms(),
				  property.getAreaOfBedroom(), property.getAreaOfBathroom(),
				  property.getAreaOfProperty());
		
		if(propertyList==null)
		{
			throw new NoDataFoundException("No data found for the request");
		}else {
			return propertyList;
		}
		
	}
	
}
