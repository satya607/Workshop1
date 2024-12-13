package qapitol_workshop;

import java.io.FileInputStream;
import java.util.Properties;

public class fileutility {
	public String readfiledata(String key) throws Throwable {
		FileInputStream fis = new FileInputStream("C:\\Users\\Qapitol QA\\eclipse-workspace\\qapitol_workshop\\src\\test\\resources\\cricbbuzz.property");
		Properties p = new Properties();
		p.load(fis);
		String data = p.getProperty(key);
		return data;
}
	
}