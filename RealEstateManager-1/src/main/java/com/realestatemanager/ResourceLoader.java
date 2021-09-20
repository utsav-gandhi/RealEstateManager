package com.realestatemanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:properties/sqlquery.properties")
public class ResourceLoader {
	
	@Autowired
	Environment env;

	public String getSql(String key)
	{
		return env.getProperty(key);
	}
}
