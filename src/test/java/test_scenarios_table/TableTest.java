package test_scenarios_table;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TableTest {

    @Test
    void testGetTableCellText() {
        Table table = new Table();
        WebElement webTable = // get web table element from http://www.w3schools.com/html/html_tables.asp
        String expectedText = "Germany";
        String actualText = table.getTableCellText(webTable, 1, "Alfreds Futterkiste", 2);
        assertEquals(expectedText, actualText);
    }

    @Test
    void testVerifyTableCellText() {
        Table table = new Table();
        WebElement webTable = // get web table element from http://www.w3schools.com/html/html_tables.asp
        String expectedText = "Germany";
        boolean result = table.verifyTableCellText(webTable, 1, "Alfreds Futterkiste", 2, expectedText);
        assertTrue(result);
    }

    @Test
    void testGetTableCellTextByXpath() {
        Table table = new Table();
        WebElement webTable = // get web table element from http://www.w3schools.com/html/html_tables.asp
        String expectedText = "Germany";
        String actualText = table.getTableCellTextByXpath(webTable, 1, "Alfreds Futterkiste", 2);
        assertEquals(expectedText, actualText);
    }

}
