import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class CA8GoaPageTest {
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://qagoapage.ccbp.tech/");

            WebElement firstHeading = driver.findElement(By.cssSelector("div[class='col-6 goa-card-container']>:first-child"));
            System.out.println(firstHeading.getText());

            WebElement description = driver.findElement(By.cssSelector("div[class='col-6 goa-card-container']>:nth-child(2)"));
            System.out.println(description.getText());

            WebElement secondHeading = driver.findElement(By.cssSelector("div[class='col-6 goa-card-container'] >:nth-of-type(2)"));
            System.out.println(secondHeading.getText());

            WebElement thirdHeading = driver.findElement(By.cssSelector("div[class='col-6 goa-card-container'] >:nth-of-type(3)"));
            System.out.println(thirdHeading.getText());


            Thread.sleep(3000);
            driver.quit();
        }catch (Exception e){
            System.out.println("The Exception is:  "+e);
        }
    }
}
