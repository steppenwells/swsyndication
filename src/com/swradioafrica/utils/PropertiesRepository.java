package com.swradioafrica.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class PropertiesRepository {
	private Properties properties;

	//singleton pattern ruthlessly ripped off from here: http://en.wikipedia.org/wiki/Singleton_pattern#The_solution_of_Bill_Pugh
	private PropertiesRepository() {
		InputStream propertiesStream = this.getClass().getClassLoader().getResourceAsStream("swradioafrica.properties");
		this.properties = new Properties();
		try {
			this.properties.load(propertiesStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	private static class PropertiesRespositoryHolder {
		private static final PropertiesRepository INSTANCE = new PropertiesRepository();
	}
	
	private String getProperty(String key) {
		if (getProperties() != null && getProperties().getProperty(key) != null) {
			return getProperties().getProperty(key);
		} else {
			return null; 
		}
	}
	public Properties getProperties() {
		return properties;
	}
	
	public static PropertiesRepository getInstance() {
		return PropertiesRespositoryHolder.INSTANCE;
	}
		
	/* PROPERTIES */

	public String getTwitterUsername() {
		return getProperty("twitter.username");
	}
	
	public String getTwitterPassword() {
		return getProperty("twitter.password");
	}
	
	public String getJdotMPUsername() {
		return getProperty("j.mp.username");	
	}
	
	public String getJdotMPKey() {
		return getProperty("j.mp.key");	
	}

}
