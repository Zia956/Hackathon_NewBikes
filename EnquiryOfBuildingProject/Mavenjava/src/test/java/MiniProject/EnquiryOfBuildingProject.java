package MiniProject;

import java.io.File; 
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
public class EnquiryOfBuildingProject
{

		public static WebDriver driver;
		
		
		public void createChromeDriver() 
		{
		 driver = Driver.getChromeWebDriver();
		}
		public void createEdgeDriver()
		{
			driver = Driver.getEdgeWebDriver();
		}
		
		public void complete() 
		{
		 driver.findElement(By.xpath("//li[@id='menu-item-25810']//a[contains(@class,'nav-link')][normalize-space()='Completed Projects']")).click();
		}
		
		 public void livepop() 
		 {
		  try 
		  {
		   driver.switchTo().frame("livservMiddleFrame");
		   driver.findElement(By.xpath("//*[@id=\'td2\']/div")).click();
		  }catch (Exception e) 
		  {
		  }
		  try 
		  {
		   driver.findElement(By.id("livchat_close")).click();
		  }
		  catch (Exception e) 
		  {
		  }
		  driver.switchTo().defaultContent();
		  try 
		  {
		  driver.findElement(By.xpath("//*[@id=\"elementor-popup-modal-33100\"]/div/a")).click();
		  }catch(Exception e) {
		   driver.switchTo().defaultContent();
		  }
		 }
		
		 public void scroll() 
		 {
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,5000)");
		 }
		 
		 public void count() throws IOException  
		 {
		  List<WebElement>projects = driver.findElements(By.xpath("//*[@id=\"boosted-tab-0\"]//*[@id=\"module_properties\"]/div"));
		  System.out.println("Number of projects "+projects.size());
		  
		  FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\Excel\\Output.xlsx");
		  XSSFWorkbook workbook = new XSSFWorkbook();
		  XSSFSheet sheet = workbook.createSheet("Output");
		
		  XSSFRow row = sheet.createRow(0);
		  XSSFCell cell = row.createCell(0);
		  cell.setCellValue("Number of projects "+projects.size());
		  
		  workbook.write(file);
		  workbook.close();
		  file.close();
		 }
		
		 public void first5() throws IOException 
		 {
		  List<WebElement>projectnames = driver.findElements(By.xpath("//*[@id=\"boosted-tab-0\"]//*[@id=\"properties_module_section\"]//div[@class= 'item-listing-wrap hz-item-gallery-js item-listing-wrap-v6 card amadadalda']//*[@class = 'item-title']"));
		  int i = 0;
		  
		  FileOutputStream file1 = new FileOutputStream(System.getProperty("user.dir")+"\\Excel\\Data.xlsx");
		  XSSFWorkbook workbook1 = new XSSFWorkbook();
		  XSSFSheet sheet1 = workbook1.createSheet("Data");
		  
		   for(int i1 = 0; i1<projectnames.size(); i1++)
		   {
			   WebElement e = projectnames.get(i1);
			   System.out.println((i1+1)+" "+e.getText());
			   
			   if(i1==5)
			   {
				   break;
			   }
		   XSSFRow row1 = sheet1.createRow(i);
		   XSSFCell cell1 = row1.createCell(0);
		   cell1.setCellValue(i+" "+e.getText());
		   i++;
		   }
		   workbook1.write(file1);
		   workbook1.close();
		   file1.close();
		   
		   
		 }
		
		 public void contactusvalidation() 
		 {
		  boolean contactus = driver.findElement(By.xpath("//*[span ='Contact Us']")).isDisplayed();
		  if(contactus){
		   System.out.println("Contact Us Element is present");
		  }else {
		   System.out.println("Contact Us Element is not present");
		  }
		  driver.findElement(By.xpath("//*[span ='Contact Us']")).click();
		 }
		
		 public void scrolltocontact() throws IOException 
		 {
		  JavascriptExecutor details = (JavascriptExecutor) driver;
		  details.executeScript("window.scrollBy(0,500)");
		 }
		
		
		 public void maximize() throws IOException {
		 driver.manage().window().maximize();
		
		 }
		
		 public void printemail() throws IOException, InterruptedException 
		 {
		  WebElement eid = driver.findElement(By.xpath("//*[text()='marketing@ishahomes.com']"));
		  System.out.println(eid.getText());
		  
		  FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\Excel\\Email.xlsx");
		  XSSFWorkbook workbook = new XSSFWorkbook();
		  XSSFSheet sheet = workbook.createSheet("Email");
		
		  XSSFRow row = sheet.createRow(0);
		  XSSFCell cell = row.createCell(0);
		  cell.setCellValue(eid.getText());
		  
		  workbook.write(file);
		  workbook.close();
		  file.close();
		  try 
		  {
		  driver.findElement(By.xpath("//*[@id=\"elementor-popup-modal-33100\"]/div/a/i")).click();
		  }
		  catch (Exception e)
		  {
		  System.out.println("Ad is not displayed");
		  }
		  
		  
		  TakesScreenshot ts = (TakesScreenshot)driver;
		  File src = ts.getScreenshotAs(OutputType.FILE);
		  File trg = new File("C:\\Users\\2318310\\Mavenjava\\screenshots\\shot1.png");
		  FileUtils.copyFile(src, trg);
		  driver.quit();  
		 }
		 
		  

 

 }
