package com.realestatemanager.repsitory;

import java.util.List;

import javax.persistence.Column;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.realestatemanager.exception.NoDataFoundException;
import com.realestatemanager.model.Property;

import lombok.Getter;
import lombok.Setter;

public interface PropertyRepo extends JpaRepository<Property, Integer> {

	 @Query(value = "SELECT * FROM Property t WHERE " +
	            "t.PRICE >=:price "
	            + "and "
	            + "t.NUMOFBEDROOMS >=:minBedrooms and "
	            + "t.NUMOFBATHROOMS >=:minBathrooms and "
	            + "t.AREAOFBEDROOM >=:minAreaOfBedroom and "
	            + "t.AREAOFBATHROOMS >=:minAreaOfBathroom and " +
	            "t.AREAOFPROPERTY >=:minAreaOfProperty",
	            nativeQuery = true
	    )
	    List<Property> findBySearchTermNative(@Param("price") int price,@Param("minBedrooms") int minBathrooms,@Param("minBathrooms") int numOfBathr
	    								,@Param("minAreaOfBedroom") int minAreaOfBedroom,@Param("minAreaOfBathroom") int minAreaOfBathroom,@Param("minAreaOfProperty") int minAreaOfProperty);
	
	 @Query(value = "SELECT * FROM Property t WHERE " +
	            "t.price >=:price ",
	            /*+ "and "
	            + "t.numOfBedrooms >=:minBedrooms and "
	            + "t.numOfBathrooms >=:minBathrooms and "
	            + "t.areaOfBedroom >=:minAreaOfBedroom and "
	            + "t.areaOfBathroom >=:minAreaOfBathroom and " +
	            "t.areaOfProperty >=:minAreaOfProperty",
	            */nativeQuery = true
	    )
	    List<Property> findBySearchPrice(@Param("price") int price) throws NoDataFoundException;
	
}
