package testCase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import methods.Methods;
import objects.CartPage;
import objects.HomePageMicrosoft;
import objects.ProjectConfigObj;
import objects.VisualStudioPage;
import objects.WindowPageMicrosoft;

public class TestCase_01 {
	Methods m = new Methods();

	@BeforeTest
	public void BeforeTest() {
		System.out.println("Inicio de ejecucion para pruebas en Microsoft");
		m.launchBrowser(ProjectConfigObj.BROWSER_CHROME, ProjectConfigObj.URL, ProjectConfigObj.RUN_HEADLES);

	}

	@Test(priority = 0)
	public void ValidateMenu() throws Exception {
		m.listTest("xpath", HomePageMicrosoft.HOME_MENU_BAR);
		m.click("xpath", HomePageMicrosoft.WINDOW_BTN);

	}

	@Test(priority = 1)
	public void WindowTab() throws Exception {
		m.click("xpath", WindowPageMicrosoft.ABOUT_WINDOW_BTN);
		/*
		 * tengo un error en esta parte me detecta 79 elementos y de otra manera reduje
		 * la lista a 29 pero no logre hacer que los imprima, necesito realizar mas
		 * investigacion sobre este menu
		 */
		m.listCreate("xpath", WindowPageMicrosoft.ABOUT_WINDOW_DRPDWN);
	}

	@Test(priority = 2)
	public void SearchVS() throws Exception {

		m.click("id", HomePageMicrosoft.SEARCH_BTN);
		m.input("xpath", HomePageMicrosoft.SEARCH_TXBOX, HomePageMicrosoft.VISUAL_STUDIO);
		m.click("xpath", HomePageMicrosoft.VISUAL_PRO);

	}

	@Test(priority = 3)
	public void PricesValidation() throws Exception {
		m.printElementSave(VisualStudioPage.PRICE_1);
		m.click("xpath", VisualStudioPage.RENEWAL);
		m.validatePricesNotSame(VisualStudioPage.PRICE_2);
		m.click("xpath", VisualStudioPage.ADD_CART_BTN);

	}

	@Test(priority = 4)
	public void CartValidation() throws Exception {
		m.explicitWait("xpath", CartPage.QTY_DRPDWN2);
		m.selectOptDropdown("xpath", CartPage.QTY_DRPDWN2, "20");
		m.verifyPricesAreEqual(CartPage.IND_PRICE, CartPage.ITEM_PRICE, CartPage.TOTAL_PRICE);
		m.validateTotalAmount(CartPage.UNIT_PRICE, CartPage.TOTAL_PRICE, 20);

	}

	@AfterClass
	public void close() throws Exception {

		m.quit();
	}

}
