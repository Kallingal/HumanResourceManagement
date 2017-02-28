package generics;

import java.io.FileInputStream;
import java.util.Properties;

public class Property {
	
	public static String getPropertyValue(String path, String key)
	{
		String props ="";
		Properties ppt = new Properties();
		try
		{
			ppt.load(new FileInputStream(path));
			props=ppt.getProperty(key);			
		}catch(Exception e)
		{
			e.printStackTrace();
		}		
		return props;
	}
}
