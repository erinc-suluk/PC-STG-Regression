package com.pwc.productcentral;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationsReader {
	private String Platform;
	private String filename = "Configuration.properties";
	public String getPlatform()
	{
		return Platform;
	}

	public void setPlatform(String platform)
	{
		Platform = platform;
	}
	public String getFilename()
	{
		return filename;
	}

	public void setFilename(String filename)
	{
		this.filename = filename;
	}
	ConfigurationsReader()
	{
		platformName();
		
	}
	
	public void platformName()
	{

		Properties properties = new Properties();
		try
		{
			properties.load(new FileInputStream(filename));
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	  this.setPlatform(properties.getProperty("Platform"));
		

}
   

    private static Properties configFile;
    static {
        try {
            FileInputStream fileInputStream = new FileInputStream("Configuration.properties");
            configFile = new Properties();
            configFile.load(fileInputStream);
            fileInputStream.close();
        }catch (Exception e){
            System.out.println("Failed to load the properties");
            e.printStackTrace();
        }
    }
    public static String getProperties(String key){
        return configFile.getProperty(key);
    }
}

