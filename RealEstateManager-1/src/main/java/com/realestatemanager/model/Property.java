package com.realestatemanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Entity
@ToString
public class Property {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Getter @Setter int propertyId;
	@Column(name = "PROPERTYNAME")
	private @Getter @Setter String propertyName;
	@Column(name = "NUMOFBEDROOMS")
	private @Getter @Setter int numOfBedrooms;
	@Column(name = "NUMOFBATHROOMS")
	private @Getter @Setter int numOfBathrooms;
	//area is in sq meter
	@Column(name = "AREAOFPROPERTY")
	private @Getter @Setter int areaOfProperty;
	@Column(name = "AREAOFBEDROOM")
	private @Getter @Setter int areaOfBedroom;
	@Column(name = "AREAOFBATHROOMS")
	private @Getter @Setter int areaOfBathroom;
	//price is in rupees
	@Column(name = "PRICE")
	private @Getter @Setter int price;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + areaOfBathroom;
		result = prime * result + areaOfBedroom;
		result = prime * result + areaOfProperty;
		result = prime * result + numOfBathrooms;
		result = prime * result + numOfBedrooms;
		result = prime * result + price;
		result = prime * result + propertyId;
		result = prime * result + ((propertyName == null) ? 0 : propertyName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Property other = (Property) obj;
		if (areaOfBathroom != other.areaOfBathroom)
			return false;
		if (areaOfBedroom != other.areaOfBedroom)
			return false;
		if (areaOfProperty != other.areaOfProperty)
			return false;
		if (numOfBathrooms != other.numOfBathrooms)
			return false;
		if (numOfBedrooms != other.numOfBedrooms)
			return false;
		if (price != other.price)
			return false;
		if (propertyId != other.propertyId)
			return false;
		if (propertyName == null) {
			if (other.propertyName != null)
				return false;
		} else if (!propertyName.equals(other.propertyName))
			return false;
		return true;
	}	
}
