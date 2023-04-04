package test_scenarios_table;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

class TableTest {
    private final WebDriver driver = new ChromeDriver();

    @Test
    void testGetTableCellText() {
        driver.get("http://www.w3schools.com/html/html_tables.asp");
        Table table = new Table();
        WebElement webTable = driver.findElement(By.id("customers"));
        String expectedText = "Germany";
        String actualText = table.getTableCellText(webTable, 1, "Alfreds Futterkiste", 2);
        assertEquals(expectedText, actualText);
    }

    @Test
    void testVerifyTableCellText() {
        driver.get("http://www.w3schools.com/html/html_tables.asp");
        Table table = new Table();
        WebElement webTable = driver.findElement(By.id("customers"));
        String expectedText = "Germany";
        boolean result = table.verifyTableCellText(webTable, 1, "Alfreds Futterkiste", 2, expectedText);
        assertTrue(result);
    }

    @Test
    void testGetTableCellTextByXpath() {
        driver.get("http://www.w3schools.com/html/html_tables.asp");
        Table table = new Table();
        WebElement webTable = driver.findElement(By.id("customers"));
        String expectedText = "Germany";
        String actualText = table.getTableCellTextByXpath(webTable, 1, "Alfreds Futterkiste", 2);
        assertEquals(expectedText, actualText);
    }

    public void tearDown() {
        driver.quit();
    }
}
