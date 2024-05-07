package selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class a {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		
		WebElement txtemailbox = driver.findElement(By.id("Email"));
		txtemailbox.clear();
		txtemailbox.sendKeys("admin@yourstore.com");
		
		WebElement empassword = driver.findElement(By.id("Password"));
		empassword.clear();
		empassword.sendKeys("admi");
		
		driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")).click();
		
		String act_title = driver.getTitle();
		String exp_title = "Dashboard / nopCommerce administration";
		
		if(act_title.equals(exp_title)) {
			System.out.println("Test passed");
			
		}
		else {
			System.out.println("Test Failed");
		}
		driver.quit();

	}

}
