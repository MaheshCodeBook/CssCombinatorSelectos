import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CP13OurCompanyPageTest {
    public static void main(String[] args){
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();;
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://qacompany.ccbp.tech/");

            WebElement firstHeding = driver.findElement(By.cssSelector("div.services-container >h3:first-child"));
            System.out.println(firstHeding.getText());

            WebElement secondHeading = driver.findElement(By.cssSelector("div.services-container >h3:nth-of-type(2)"));
            System.out.println(secondHeading.getText());

            WebElement thirdHeading = driver.findElement(By.cssSelector("div.services-container >h3:last-of-type"));
            System.out.println(thirdHeading.getText());

            WebElement firstDescription = driver.findElement(By.cssSelector("div.services-container >p:first-of-type"));
            System.out.println(firstDescription.getText());

            WebElement secondDescription = driver.findElement(By.cssSelector("div.services-container >p:nth-of-type(2)"));
            System.out.println(secondDescription.getText());

            WebElement thirdDescription = driver.findElement(By.cssSelector("div.services-container >p:last-of-type"));
            System.out.println(thirdDescription.getText());

            Thread.sleep(3000);
            driver.quit();
        }catch (Exception e){
            System.out.println("The Exception is: "+e);
        }
    }
}
