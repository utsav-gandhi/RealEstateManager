package com.realestatemanager.repsitory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import com.realestatemanager.ResourceLoader;
import com.realestatemanager.exception.CustomExceprion;
import com.realestatemanager.model.Property;
@Repository
public class PropertyRepoImpl {

	  /*@Autowired JdbcTemplate jdbcTempate;
	  
	  @Autowired ResourceLoader resLoader;
	  
	  
	  public String saveProperty(Property property) throws CustomExceprion { int
	  result=0; try { String insertSql=resLoader.getSql("saveProperty");
	  
	  
	  result = jdbcTempate.update(new PreparedStatementCreator() {
	  
	  @Override public PreparedStatement createPreparedStatement(Connection con)
	  throws SQLException { PreparedStatement ps=con.prepareStatement(insertSql);
	  ps.setString(1, property.getPropertyName());
	 * ps.setInt(2,property.getNumOfBedrooms());
	 * ps.setInt(3,property.getNumOfBathrooms());
	 * ps.setInt(4,property.getAreaOfProperty());
	 * ps.setInt(5,property.getAreaOfBedroom());
	 * ps.setInt(6,property.getAreaOfBathroom()); ps.setInt(7,property.getPrice());
	 * return ps; } }); }catch(Exception e) { throw new
	 * CustomExceprion(e.getMessage()); }
	 * 
	 * if(result==1) { return "1"; } return result+"";
	 * 
	 * }
	 */	
}
