package com.swradioafrica.utils;

import com.google.inject.Singleton;
import com.swradioafrica.model.SWRadioProperties;

@Singleton
public class PropertiesRepository {

	public SWRadioProperties loadProperties() {		
		SWRadioProperties properties = SWRadioProperties.all().get();
		if (properties == null) {
			return new SWRadioProperties();
		} else {
			return properties;
		}
		
	}
	
	public void saveProperties(SWRadioProperties properties) {
		if (properties.id == null) {
			properties.insert();
		} else {
			properties.update();
		}
	}

	

}
