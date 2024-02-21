import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CA7ConferencePageTest {
    public static void main(String[] args){
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();;
            driver.get("https://qaconference.ccbp.tech/");

            WebElement description = driver.findElement(By.cssSelector("h1[class='conference-title'] + p"));
            String excpecredDes = description.getText();
            String actualDes = "Redefining the future of IoT with LoRaWAN";
            if (excpecredDes.equals(actualDes)){
                System.out.println("Description is as expected");
            }else {
                System.out.println("Mismatch found in description");
            }

            WebElement knowmoreBtn = driver.findElement(By.cssSelector("p[class='conference-description'] +button"));
            knowmoreBtn.click();

            WebElement descriptionDetails = driver.findElement(By.cssSelector("h1[class='conference-details-title'] + p"));
            excpecredDes = "Join Asia’s Largest Conference on LoRaWAN";
            actualDes = descriptionDetails.getText();
            if (excpecredDes.equals(actualDes)){
                System.out.println("Description is as expected");
            }else {
                System.out.println("Mismatch found in description");
            }

            List<WebElement> labels = driver.findElements(By.cssSelector("h1[class='conference-stats-count'] +p"));
            for (WebElement i : labels){
                System.out.println(i.getText());
            }



            Thread.sleep(3000);
            driver.quit();
        }catch (Exception e){
            System.out.println("The Exception is: "+e);
        }
    }
}
