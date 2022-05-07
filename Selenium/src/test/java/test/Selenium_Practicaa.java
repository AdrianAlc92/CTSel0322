package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_Practicaa {

	public static void main(String[] args) {
		String exePath = "./driver2.0/chromedriver1.exe"; //especificar la ruta del chrome driver
		System.setProperty("webdriver-chrome.driver", exePath); 
	//
		System.setProperty("webdriver-chrome.driver", "C:\\Users\\adria\\Downloads\\chromedriver\\chromedriver.exe"); //agregando la ruta del chrome
		WebDriver driver = new ChromeDriver(); //objeto de webdriver
		driver.get("https://opensource-demo.orangehrmlive.com");
		
		WebElement userName = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		WebElement btnlogin = driver.findElement(By.id("btnLogin"));
		
		userName.sendKeys("Admin");
		password.sendKeys("admin123");
		btnlogin.click();
	}

}
