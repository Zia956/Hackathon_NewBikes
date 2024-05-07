package MiniProject;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Driver 
{
	public static WebDriver driver;

	 public static WebDriver getChromeWebDriver()
	 {
		 driver = new ChromeDriver();
		 driver.get("https://ishahomes.com/");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		 driver.manage().window().maximize();
		 return driver;
	 }
	 public static WebDriver getEdgeWebDriver()
	 {
		 driver = new EdgeDriver();
		 driver.get("https://ishahomes.com/");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		 driver.manage().window().maximize();
		 return driver;
	 }
//	  WebDriver driver = new ChromeDriver();
//	  driver.get("https://ishahomes.com/");
	  
	 
	 }

