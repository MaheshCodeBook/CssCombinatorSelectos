import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CA8VRBlogospherePageTest {
    public static void main(String[] args){
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();;
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://qavrblog.ccbp.tech/");

            //Test the title of the first blog
            WebElement firstHeadingEle = driver.findElement(By.xpath("//h1[text()='Amazon']"));
            String actualFirstHeading = firstHeadingEle.getText();
            String expectedFirstHeading = "Amazon";
            if (actualFirstHeading.equals(expectedFirstHeading)){
                System.out.println("Title 1: Verified");
            }else {
                System.out.println("Title 1: Verification failed");
            }

            //Test the title of the second blog
            WebElement secondHeadingEle = driver.findElement(By.xpath("//h1[text()='Advertising']"));
            String actualSecondHeading = secondHeadingEle.getText();
            String expectedSecondHeading = "Advertising";
            if (actualSecondHeading.equals(expectedSecondHeading)){
                System.out.println("Title 2: Verified");
            }else {
                System.out.println("Title 2: Verification failed");
            }

            // Test the description of the first blog
            WebElement firstDescription = driver.findElement(By.xpath("//p[contains(text(),'New Way to See the World. It is a simulated experienc')]"));
            String actualFirstDescription = firstDescription.getText();
            String expectedSFirstDescription = "New Way to See the World. It is a simulated experience that can be completely different from the real world.";
            if (actualFirstDescription.equals(expectedSFirstDescription)){
                System.out.println("Description 1: Verified");
            }else {
                System.out.println("Description 1: Verification failed");
            }


            // Test the description of the second blog
            WebElement secondDescription = driver.findElement(By.xpath("//p[contains(text(),'The best one for you. Come experience the wonder')]"));
            String actualSecondtDescription = secondDescription.getText();
            String expectedSecondDescription = "The best one for you. Come experience the wonder of Google Earth in virtual reality.";
            if (actualSecondtDescription.equals(expectedSecondDescription)){
                System.out.println("Description 2: Verified");
            }else {
                System.out.println("Description 2: Verification failed");
            }

            Thread.sleep(3000);
            driver.quit();

            } catch (Exception e){
            System.out.println("The Exception is: "+e);
        }
    }
}

