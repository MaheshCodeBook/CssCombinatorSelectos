import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CA7AboutMePageTest {
    public static void main(String[] args){
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://qaaboutme.ccbp.tech/");

            WebElement factsTextEle = driver.findElement(By.cssSelector("h1[class *= 'about-me-section-sub-heading mb-3']"));
            String actualFactsText = factsTextEle.getText();
            String expectedFactText = "Facts";
            if (actualFactsText.equals(expectedFactText)){
                System.out.println("Sub-heading is as expected");
            }else {
                System.out.println("Mismatch found in sub-heading");
            }

            WebElement aboutMetEle = driver.findElement(By.cssSelector("h1[class *= 'about-me-section-sub-heading mb-3'] +h1"));
            String actualaboutMetText = aboutMetEle.getText();
            String expectedaboutMetText = "About me";
            if (actualaboutMetText.equals(expectedaboutMetText)){
                System.out.println("Main heading is as expected");
            }else {
                System.out.println("Mismatch found in main heading");
            }

            List<WebElement> fourSkils = driver.findElements(By.cssSelector("div[class ^= 'shadow skills-car'] h1"));
           for (WebElement i : fourSkils){
               System.out.println(i.getText());
           }

            Thread.sleep(3000);
            driver.quit();
        }catch (Exception e){
            System.out.println("The Exception is: "+e);
        }
    }
}
