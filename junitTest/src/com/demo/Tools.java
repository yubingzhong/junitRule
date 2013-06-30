package com.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Tools {
	public static Properties getPropertyFile(String path) {
		Properties p = new Properties();
		FileInputStream inputFile = null;
		try {
			inputFile = new FileInputStream(path);
			p.load(inputFile);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return p;
	}

}
