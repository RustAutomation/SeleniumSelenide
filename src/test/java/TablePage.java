import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TablePage {

    public static WebElement table() {
        return SeleniumTest.driver.findElement(By.xpath("//table[@id = 'customers']"));
    }

    public static WebElement cellText(String text) {
        return SeleniumTest.driver.findElement(By.xpath("//table[@id = 'customers']//td[contains(text(), '" + text +"')]"));
    }

    public static List<WebElement> tableLine() {
        List<WebElement> tableLineElements = SeleniumTest.driver.findElements(By.xpath("//table[@id = 'customers']//tr"));
        return tableLineElements;
    }

    public static List<WebElement> searchColumnCell(int columnIndex) {
        List<WebElement> searchColumn = SeleniumTest.driver.findElements(By.xpath("//table[@id = 'customers']//tr/td[" + columnIndex + "]"));
        return searchColumn;
    }

    public static List<WebElement> searchLineCell(int lineIndex) {
        List<WebElement> searchColumn = SeleniumTest.driver.findElements(By.xpath("//table[@id = 'customers']//tr[" + lineIndex + "]/td"));
        return searchColumn;
    }

    public static WebElement searchCellWithParameters(int lineIndex, int columnIndex) {
        WebElement searchCell = SeleniumTest.driver.findElement(By.xpath("//table[@id = 'customers']//tr[" + lineIndex + "]/td[" + columnIndex + "]"));
        return searchCell;
    }

}
