package objects;

public class CartPage {

	static String label = "Visual Studio Enterprise Subscription Quantity selection";
	public static final String QTY_DRPDWN = "//*[@aria-label='" + label + "']";
	public static final String QTY_DRPDWN2 = "//select[@aria-label='Visual Studio Enterprise Subscription Quantity selection']";

	public static final String IND_PRICE = "//*[@class='totalListPrice--xsXwCqf0']//*[contains(text(),'51,380.00')]";
	public static final String ITEM_PRICE = "(//span[text()='$51,380.00'])[4]";
	public static final String TOTAL_PRICE = "(//span[text()='$51,380.00'])[5]";
	public static final String UNIT_PRICE = "//*[contains(text(),'$2,569.00')]";

	// *[@class='group--veHwR+72']//*[@class='textAlign--jsUpELxB']//*[contains(text(),'51,380.00')]

}
