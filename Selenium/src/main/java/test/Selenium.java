package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {

	public static void main(String[] args) {
		String exePath = "./driver/chromedriver.exe"; //especificar la ruta del chrome driver
		System.setProperty("webdriver-chrome.driver", exePath); //agregando la ruta del chrome
		WebDriver driver = new ChromeDriver(); //objeto de webdriver
		driver.get("https://www.google.com"); 
		
	}

}
