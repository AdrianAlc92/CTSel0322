package methods;

import java.net.SocketException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import objects.ProjectConfigObj;

public class Methods {

	WebDriver driver;
	public String caseID;

	public WebDriver launchBrowser(String browser, String url, boolean mode) {
		if (browser.equalsIgnoreCase("ch")) {
			String exePath = "./driver/chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", exePath);
			if (mode == true) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				driver = new ChromeDriver(options);
			} else {
				driver = new ChromeDriver();
			}
		} else if (browser.equalsIgnoreCase("ff")) {
			String exePath = "./driver/geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", exePath);
			driver = new FirefoxDriver();

		}
		driver.manage().window().maximize();
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;
	}

	public void quit() {
		driver.quit();
	}

	public void close() {
		driver.close();
	}

	public void refresh() {
		driver.navigate().refresh();
	}

	public void clear(String locator) {
		driver.findElement(By.xpath(locator)).clear();
	}

	public void input(String kind, String locator, String data) {
		if (kind.equalsIgnoreCase("cssselector")) {
			driver.findElement(By.cssSelector(locator)).sendKeys(data);
		} else if (kind.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(locator)).sendKeys(data);
		} else if (kind.equalsIgnoreCase("id")) {
			driver.findElement(By.id(locator)).sendKeys(data);
		} else if (kind.equalsIgnoreCase("name")) {
			driver.findElement(By.name(locator)).sendKeys(data);
		}

	}

	public void click(String kind, String locator) {
		if (kind.equalsIgnoreCase("cssselector")) {
			driver.findElement(By.cssSelector(locator)).click();
		} else if (kind.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(locator)).click();
		} else if (kind.equalsIgnoreCase("id")) {
			driver.findElement(By.id(locator)).click();
		} else if (kind.equalsIgnoreCase("linkText"))
			driver.findElement(By.xpath(locator)).click();
	}

	public void submit(String kind, String locator) {
		if (kind.equalsIgnoreCase("cssselector")) {
			driver.findElement(By.cssSelector(locator)).submit();
		} else if (kind.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(locator)).submit();
		} else if (kind.equalsIgnoreCase("id")) {
			driver.findElement(By.id(locator)).submit();
		} else if (kind.equalsIgnoreCase("linkText")) {
			driver.findElement(By.linkText(locator)).submit();
		} else if (kind.equalsIgnoreCase("classname"))
			driver.findElement(By.className(locator)).submit();

	}

	public void selectOptDropdown(String kind, String locator, String data) {
		if (kind.equalsIgnoreCase("xpath")) {
			Select objectSelect = new Select(driver.findElement(By.xpath(locator)));
			objectSelect.selectByValue(data);
		} else if (kind.equalsIgnoreCase("id")) {
			Select objectSelect = new Select(driver.findElement(By.id(locator)));
			objectSelect.selectByValue(data);
		}

	}

	public void validationVisible(String kind, String locator) {
		boolean present;

		if (kind.equalsIgnoreCase("xpath")) {
			try {
				driver.findElement(By.xpath(locator)).isDisplayed();
				driver.findElement(By.xpath(locator)).getText();

				present = true;
				System.out.println("Element is visible");
			}

			catch (NoSuchElementException e) {
				present = false;
				System.out.println("Element not visible");
			}

			if (kind.equalsIgnoreCase("id")) {
				try {
					driver.findElement(By.xpath(locator)).isDisplayed();
					driver.findElement(By.xpath(locator)).getText();
					present = true;
					System.out.println("Element is visible");
				}

				catch (NoSuchElementException e) {
					present = false;
					System.out.println("Element not visible");
				}
			}
		}
	}

	public void printElement(String locator) {
		String NameLocate = driver.findElement(By.xpath(locator)).getText();
		System.out.println(NameLocate);

	}

	public void explicitWait(String kind, String locator) {
		if (kind.equalsIgnoreCase("xpath")) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		} else if (kind.equalsIgnoreCase("id")) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ProjectConfigObj.WAITING_TIME));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
		}
	}

	public void listCreate(String kind, String locator) {
		if (kind.equalsIgnoreCase("cssselector")) {
			List<WebElement> allsites = driver.findElements(By.cssSelector(locator));
			System.out.println("The size of the page is = " + allsites.size());
			for (WebElement item : allsites) {
				System.out.println("Name of the product is : " + item.getText());
				// System.out.println("Title of the Next Page is : " + driver.getTitle());
			}
		} else if (kind.equalsIgnoreCase("xpath")) {
			List<WebElement> allSites = driver.findElements(By.xpath(locator));
			System.out.println("The size of the page is = " + allSites.size());

			for (WebElement item : allSites) {
				System.out.println("Name of the product is : " + item.getText());
			}

		} else if (kind.equalsIgnoreCase("id")) {
			List<WebElement> allsites = driver.findElements(By.id(locator));
			System.out.println("The size of the page is = " + allsites.size());
			for (WebElement item : allsites) {
				System.out.println("Name of the product is : " + item.getText());
				// System.out.println("Title of the Next Page is : " + driver.getTitle());
			}
		} else if (kind.equalsIgnoreCase("linkText")) {
			List<WebElement> allsites = driver.findElements(By.linkText(locator));
			System.out.println("The size of the page is = " + allsites.size());
			for (WebElement item : allsites) {
				System.out.println("Name of the product is : " + item.getText());
				// System.out.println("Title of the Next Page is : " + driver.getTitle());
			}
		}
	}

	public void listTest(String kind, String locator) {
		if (kind.equalsIgnoreCase("xpath")) {
			List<WebElement> allSites = driver.findElements(By.xpath(locator));
			System.out.println("The size of the page is = " + allSites.size());

			for (WebElement item : allSites) {
				System.out.println("Name of the product is : " + item.getText());
			}

			List<String> expectedMenuItems = Arrays.asList("Microsoft 365", "Windows", "Surface", "Xbox", "Deals",
					"Small Business", "Support");

			for (String menuItem : expectedMenuItems) {
				boolean isMenuItemPresent = false;

				for (WebElement item : allSites) {
					if (item.getText().equalsIgnoreCase(menuItem)) {
						isMenuItemPresent = true;
						break;
					}
				}

				Assert.assertTrue(isMenuItemPresent, "Elemento del menú no encontrado: " + menuItem);
			}
		} else if (kind.equalsIgnoreCase("id")) {
			List<WebElement> allSites = driver.findElements(By.xpath(locator));
			System.out.println("The size of the page is = " + allSites.size());

			for (WebElement item : allSites) {
				System.out.println("Name of the product is : " + item.getText());
			}

			List<String> expectedMenuItems = Arrays.asList("Microsoft 365", "Windows", "Surface", "Xbox", "Deals",
					"Small Business", "Support");

			for (String menuItem : expectedMenuItems) {
				boolean isMenuItemPresent = false;

				for (WebElement item : allSites) {
					if (item.getText().equalsIgnoreCase(menuItem)) {
						isMenuItemPresent = true;
						break;
					}
				}

				Assert.assertTrue(isMenuItemPresent, "Elemento del menú no encontrado: " + menuItem);
			}
		}

	}

	public boolean isElementPresent(String locator) {
		try {
			// Intenta encontrar el elemento
			driver.findElement(By.xpath(locator));
			return true; // Si no se lanza una excepción, el elemento está presente
		} catch (NoSuchElementException e) {
			return false; // Si se lanza una excepción, el elemento no está presente
		}
	}

	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
	}

	public void printElementSave(String locator) {
		String NameLocate = driver.findElement(By.xpath(locator)).getText();
		System.out.println(NameLocate);
		storedPrice = NameLocate;

	}

	private String storedPrice;

	public void validatePricesNotSame(String locator) {
		// Obtener el nuevo precio de la página de detalles
		WebElement priceOnDetailsPageElement = driver.findElement(By.xpath(locator));
		String priceOnDetailsPage = priceOnDetailsPageElement.getText();
		System.out.println(priceOnDetailsPage);

		// Comparar con el precio almacenado
		Assert.assertNotEquals(storedPrice, priceOnDetailsPage, "Los precios son iguales en la página de detalles");
	}

	public void selectRadio(String value) {
		String radioButtonLocator = "//input[@type='radio' and @value='" + value + "']";
		WebElement radioButton = driver.findElement(By.xpath(radioButtonLocator));

		if (!radioButton.isSelected()) {
			radioButton.click();
		}
	}

	public void verifyPricesAreEqual(String individualPriceLocator, String itemsPriceLocator,
			String totalPriceLocator) {
		String individualPrice = driver.findElement(By.xpath(individualPriceLocator)).getText();
		String itemsPrice = driver.findElement(By.xpath(itemsPriceLocator)).getText();
		String totalPrice = driver.findElement(By.xpath(totalPriceLocator)).getText();

		Assert.assertEquals(individualPrice, itemsPrice, "Los precios individuales e items no son iguales.");
		Assert.assertEquals(individualPrice, totalPrice, "Los precios individuales y totales no son iguales.");
	}

	public void validateTotalAmount(String unitPriceLocator, String totalAmountLocator, int quantity) {
		// Obtener el precio unitario
		String unitPriceText = driver.findElement(By.xpath(unitPriceLocator)).getText();
		double unitPriceValue = extractNumericValue(unitPriceText);

		// Obtener el monto total
		String totalAmountText = driver.findElement(By.xpath(totalAmountLocator)).getText();
		double totalAmountValue = extractNumericValue(totalAmountText);

		// Calcular el monto total esperado
		double expectedTotalAmount = unitPriceValue * quantity;
		System.out.println("El resultado del calculo es: " + expectedTotalAmount + " y el total en la pagina es: "
				+ totalAmountValue);

		// Realizar la validación
		Assert.assertEquals(totalAmountValue, expectedTotalAmount,
				"El monto total no es igual al precio unitario multiplicado por la cantidad.");
	}

	// Método para extraer el valor numérico de una cadena
	private double extractNumericValue(String text) {
		// Eliminar caracteres no numéricos y convertir a double
		return Double.parseDouble(text.replaceAll("[^0-9.]", ""));
	}
}
