package automationframework.config;

public class Driver {
	
	private static Driver driver = null;
	
	
	private Driver()
	{
		
	}
	public static Driver getInstance()
	{
		if (driver == null)
		{
			System.out.println("first time");
			driver = new Driver();
		}
		return driver;
	}
	
}
