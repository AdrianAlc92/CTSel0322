package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestSel {
  @Test
  public void selenium_test01() {
	  String exePath = "./driver/chromedriver.exe"; //especificar la ruta del chrome driver
		System.setProperty("webdriver-chrome.driver", exePath); //agregando la ruta del chrome
		WebDriver driver = new ChromeDriver(); //objeto de webdriver
		driver.get("https://www.google.com");
		
  }
}
