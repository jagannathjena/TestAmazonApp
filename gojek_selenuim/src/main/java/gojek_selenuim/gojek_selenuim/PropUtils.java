package gojek_selenuim.gojek_selenuim;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropUtils {
	public static String getLocator(String key) throws IOException {
		Properties obj = new Properties();
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//resources//Locators.properties");
		obj.load(objfile);
		return obj.getProperty(key);
	}
	
	public static String getLabels(String key) throws IOException {
		Properties obj = new Properties();
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + "//src//test//java//resources//Labels.properties");
		obj.load(objfile);
		return obj.getProperty(key);
	}

}
