import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CP13HelpDeskPageTest {
    public static void main(String[] args){
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();;
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://qafbhelpdesk.ccbp.tech/");

            // Test the address text
            WebElement addresEle = driver.findElement(By.cssSelector("div[class='row']>:first-child p"));
            String actualAddress = addresEle.getText();
            String expectedAddres = "37, Ayur Vigyan Nagar, New Delhi, India.";
            if (actualAddress.equals(expectedAddres)){
                System.out.println("Address: Verified");
            }else {
                System.out.println("Address: Verification Failed");
            }

            //Test the heading of the first section
            WebElement headingFirstSection = driver.findElement(By.cssSelector("div[class=row] >:nth-child(2) h1"));
            String actualHeadingFirstSection = headingFirstSection.getText();
            String expectedHeadingFirstSection = "Get to know us";
            if (actualHeadingFirstSection.equals(expectedHeadingFirstSection)){
                System.out.println("Heading 1: Verified");
            }else {
                System.out.println("Heading 1: Verification Failed");
            }

            //Test the heading of the second section
            WebElement headingSecondSection = driver.findElement(By.cssSelector("div[class=row] >:nth-child(3) h1"));
            String actualHeadingSecondSection = headingSecondSection.getText();
            String expectedHeadingSecondSection = "Contact with Us";
            if (actualHeadingSecondSection.equals(expectedHeadingSecondSection)){
                System.out.println("Heading 2: Verified");
            }else {
                System.out.println("Heading 2: Verification Failed");
            }

            //Test the heading of the Third section
            WebElement headingThirdSection = driver.findElement(By.cssSelector("div[class=row] >:nth-child(4) h1"));
            String actualHeadingThirdSection = headingThirdSection.getText();
            String expectedHeadingThirdSection = "Let Us Help You";
            if (actualHeadingThirdSection.equals(expectedHeadingThirdSection)){
                System.out.println("Heading 3: Verified");
            }else {
                System.out.println("Heading 3: Verification Failed");
            }

            // Test the copyright text
            WebElement copyRightText = driver.findElement(By.cssSelector("div[class=text-center] :last-child"));
            String actualCopyrightText = copyRightText.getText();
            String expectedCopyrightText = "2020 by Rahul. Created with Bootstrap.";
            if (actualCopyrightText.equals(expectedCopyrightText)){
                System.out.println("Copyright : Verified");
            }else {
                System.out.println("Copyright : Verification Failed");
            }

            Thread.sleep(3000);
            driver.quit();
        }catch (Exception e){
            System.out.println("The Exceptions is: "+e);
        }
    }
}
