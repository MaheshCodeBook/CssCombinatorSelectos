import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CA8MusicPageTest {
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://qamusicpage.ccbp.tech/");

            WebElement headingOfHeaderSection = driver.findElement(By.cssSelector("div[class *= 'header-bg-container'] >:first-child"));
            System.out.println(headingOfHeaderSection.getText());


            WebElement firstDesOfHeaderSection = driver.findElement(By.cssSelector("div[class *= 'header-bg-container'] >p:first-of-type"));
            System.out.println(firstDesOfHeaderSection.getText());

            WebElement lastDesOfHeaderSection = driver.findElement(By.cssSelector("div[class *= 'header-bg-container'] >p:last-of-type"));
            System.out.println(lastDesOfHeaderSection.getText());

            WebElement headingOfNightIceland = driver.findElement(By.cssSelector("div[class *= 'night-island-bg-container'] >:first-child"));
            System.out.println(headingOfNightIceland.getText());

            WebElement firstDesOfNightIceland = driver.findElement(By.cssSelector("div[class='night-island-card text-center'] :nth-child(2)"));
            System.out.println(firstDesOfNightIceland.getText());

            WebElement lastDesOfNightIceland = driver.findElement(By.cssSelector("div[class='night-island-card text-center'] :nth-child(3)"));
            System.out.println(lastDesOfNightIceland.getText());

            WebElement getStartedButton = driver.findElement(By.cssSelector("div[class='night-island-card text-center'] button"));
            getStartedButton.click();

            WebElement afterClickHeading = driver.findElement(By.cssSelector("div.music-details-container :first-child"));
            System.out.println(afterClickHeading.getText());

            WebElement afterClickHeadingDes1 = driver.findElement(By.cssSelector("div.music-details-container :nth-child(2)"));
            System.out.println(afterClickHeadingDes1.getText());

            WebElement afterClickHeadingDes2 = driver.findElement(By.cssSelector("div.music-details-container :nth-child(3)"));
            System.out.println(afterClickHeadingDes2.getText());

            WebElement afterClickHeadingDes3 = driver.findElement(By.cssSelector("div.music-details-container :nth-child(4)"));
            System.out.println(afterClickHeadingDes3.getText());

            WebElement afterClickHeadingDes4 = driver.findElement(By.cssSelector("div.music-details-container :nth-child(5)"));
            System.out.println(afterClickHeadingDes4.getText());

            Thread.sleep(3000);
            driver.quit();
        }catch (Exception e){
            System.out.println("The Exception is:  "+e);
        }
    }
}
