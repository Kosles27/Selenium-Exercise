	package com.example;

	import java.io.IOException;
	import java.util.Properties;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class table_exercise {

	  public static void main(String[] args) throws IOException {
	    // Load properties file with search values
	    Properties props = new Properties();
	    props.load(table_exercise.class.getClassLoader().getResourceAsStream("search_values.properties"));

	    // Set up WebDriver
	    System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
	    WebDriver driver = new ChromeDriver();

	    try {
	      // Navigate to webpage with table
	      driver.get("http://www.w3schools.com/html/html_tables.asp");

	      // Find table element
	      WebElement table = driver.findElement(By.xpath("//table[@id='customers']"));

	      // Get cell text using search value from properties file
	      String companyName = props.getProperty("company_name");
	      String countryName = getTableCellText(table, 1, companyName, 2);
	      System.out.println("Country for company " + companyName + ": " + countryName);

	      // Verify cell text using search value from properties file
	      String expectedCountry = props.getProperty("expected_country");
	      boolean result = verifyTableCellText(table, 1, companyName, 2, expectedCountry);
	      System.out.println("Verification result: " + result);

	      // Get cell text using XPath and search value from properties file
	      String productId = props.getProperty("product_id");
	      String price = getTableCellTextByXpath(table, 0, productId, 1);
	      System.out.println("Price for product " + productId + ": " + price);
	    } finally {
	      // Clean up WebDriver
	      driver.quit();
	    }
	  }

	  public static String getTableCellText(WebElement table, int searchColumn, String searchText,
	      int returnColumnText) {
	    int searchRowIndex = -1;
	    int returnColumnIndex = -1;

	    // Find search and return column indices
	    WebElement headersRow = table.findElement(By.tagName("thead")).findElement(By.tagName("tr"));
		  for (WebElement header : headersRow.findElements(By.tagName("th"))) {
			  String headerText = header.getText().trim();
			  if (headerText.equals(Integer.toString(searchColumn + 1))) {
				  searchColumn = headersRow.findElements(By.tagName("th")).indexOf(header);
			  } else if (headerText.equals(Integer.toString(returnColumn + 1))) {
				  returnColumnIndex = headersRow.findElements(By.tagName("th")).indexOf(header);
	      }
	    }

		  // Find search value in table using XPath and return text from return column
		  String cellText = table.findElement(By.xpath("//td[" + (searchColumn + 1) + "][contains(text(), '" + searchText + "')]"))
				  .findElement(By.xpath("../td[" + (returnColumnIndex + 1) + "]")).getText().trim();

		  return cellText;
	  }

	  public static boolean verifyTableCellText(WebElement table, int searchColumn, String searchText,
	      int returnColumnText, String expectedText) {
	    String actualText = getTableCellText(table, searchColumn, searchText, returnColumnText);
	    return expectedText.equals(actualText);
	   }
	
	  public static String getTableCellTextByXpath(WebElement table, int searchColumn, String searchText,
	      int returnColumn
	}
