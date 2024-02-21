import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CP13FeedbackAppTest {
    public static void main(String[] args){
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();;
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://qafeedback.ccbp.tech/");

            WebElement sadElement = driver.findElement(By.cssSelector("ul[class='emojis-list'] >:first-child button"));
            sadElement.click();

            WebElement editFeedbackElement = driver.findElement(By.cssSelector("div[class='thank-you-container'] >:last-child"));
            editFeedbackElement.click();

            WebElement noneElement = driver.findElement(By.cssSelector("ul[class = 'emojis-list'] >:nth-child(2) button"));
            noneElement.click();

            editFeedbackElement = driver.findElement(By.cssSelector("div[class='thank-you-container'] >:last-child"));
            editFeedbackElement.click();

            WebElement happyElement = driver.findElement(By.cssSelector("ul[class = 'emojis-list'] >:last-child"));
            happyElement.click();

            // Verify the Thank You text,
            WebElement thanqTextElement = driver.findElement(By.cssSelector("div.thank-you-container >:nth-child(2)"));
            String actualThanqText = thanqTextElement.getText();
            String expectedThanqText = "Thank You!";
            if (actualThanqText.equals(expectedThanqText)){
                System.out.println("Thank You text: Verified");
            }else {
                System.out.println("Thank You text: Verification Failed");
            }
            // Verify the Thank You text description,
            WebElement thanqTextDesEle = driver.findElement(By.cssSelector("div.thank-you-container >:nth-child(3)"));
            String actualThanqTextDes = thanqTextDesEle.getText();
            String expectedThanqTextDes = "We will use your feedback to improve our customer support performance.";
            if (actualThanqTextDes.equals(expectedThanqTextDes)){
                System.out.println("Description: Verified");
            }else {
                System.out.println("Description: Verification Failed");
            }

            Thread.sleep(3000);
            driver.quit();
        }catch (Exception e){
            System.out.println("The Exception is: "+e);
        }
    }
}
