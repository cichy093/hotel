package com.pz;

import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotelApplication extends AbstractJavaFxApplicationSupport {

	public static void main(String[] args) {
		launchApp(HotelApplication.class, HelloView.class, args);
	}
}
