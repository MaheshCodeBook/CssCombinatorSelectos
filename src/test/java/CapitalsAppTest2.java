import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CapitalsAppTest2 {
    public static void main(String[] args){
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();;
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://qacapitalsapp.ccbp.tech/");
            // Find all the options of the dropdown element
            List<WebElement> optionList = driver.findElements(By.cssSelector("select.capital-select > option"));

            // Find the dropdown element
            WebElement dropdownEl = driver.findElement(By.cssSelector("select[class ^= 'capital']"));

            // Find the resultant country name
            WebElement countryName = driver.findElement(By.cssSelector("div[class = 'question-container'] + p"));

            // Verify the country text with expected country name order
            String[] expectedArray = {"India", "United Kingdom", "France", "Nepal", "Finland"};

            int i;
            for (i=0; i<5; i++){
                WebElement option = optionList.get(i);
                String text = option.getText();

                Select dropDown = new Select(dropdownEl);
                dropDown.selectByVisibleText(text);

                if (!expectedArray[i].equals(countryName.getText())){
                    System.out.println("Mismatch found in country name");
                }
            }
            if (i == 5){
                System.out.println("Capitals App working as expected");
            }

            Thread.sleep(4000);
            driver.quit();

        }catch (Exception e){
            System.out.println("The Exception is: "+e);
        }
    }
}
