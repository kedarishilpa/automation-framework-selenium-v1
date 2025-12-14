//package com.ui.tests;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import com.utility.BrowserUtility;
//
//public class LoginTest {
//
//	public static void main(String[] args) {
//		WebDriver driver= new ChromeDriver();//launch browser , create browser sessiobn
//		
//		
//		BrowserUtility browserUtility=new BrowserUtility(driver);
//		
//		browserUtility.maximizeWindow();
//		browserUtility.goToWebsite("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
//		
//		
//		By signInLink=By.xpath("//a[@class='login']");
//		browserUtility.clickOn(signInLink);
//		
//		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("mibot40899@nyfhk.com");
//		
//		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("password");
//		
//		driver.findElement(By.id("SubmitLogin")).click();
//
//	}
//
//}



