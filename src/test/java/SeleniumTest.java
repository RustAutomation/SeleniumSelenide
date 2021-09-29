import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest {

    public static WebDriver driver;
    private String searchValue;
    private String searchCountry;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-infobars");
        driver = new ChromeDriver(options);
        driver.get("http://www.w3schools.com/html/html_tables.asp");
    }

    @Test
    public void test() throws Exception {
        ConfigGetPropertyValues properties = new ConfigGetPropertyValues();
        searchValue = properties.getProperty("config.properties", "searchValue");
        searchCountry = properties.getProperty("config.properties", "country");

        verifyTableCellText(TablePage.table(),5,"",1,searchValue);
        String country = getTableCellTextByXpath(TablePage.table(), 3,searchValue ,5);
        Assert.assertTrue(country.equals(searchCountry));
        driver.close();
        driver.quit();
    }

    public String getTableCellText (WebElement table, int searchColumn, String searchText, int returnColumnText) {
         /* The functions should get the table element, index or column name to search for a value, the value to search, index or the name of the column from which a value
will be returned. For example: the function will get a company name and return the country name*/
// Take the search value (s) from an external source of your choice: File Properties, XML, Excel, CSV*/

        searchText = TablePage.searchCellWithParameters(returnColumnText, searchColumn).getText();

        return searchText;
    }

    public boolean verifyTableCellText (WebElement table, int searchColumn, String searchText, int returnColumnText, String expectedText) {
//         The verifyTableCellText function should use getTableCellText and report success or failure
        boolean result = false;

        String actual = getTableCellText(TablePage.table(), returnColumnText, searchText, searchColumn);
        if(actual.equals(expectedText)) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public String getTableCellTextByXpath (WebElement table, int searchColumn, String searchText, int returnColumnText) throws Exception {
//        The getTableCellTextByXpath function should retrieve the value by using xpath and without running a loop on the table records
        searchText = TablePage.searchCellWithParameters(returnColumnText, searchColumn).getText();
        return searchText;
    }




}