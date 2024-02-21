import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CA8MyProjectsPageTest {
    public static void main(String[] args){
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();;
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://qamyprojects.ccbp.tech/");

            // Test the first project page
            WebElement projectOneEle = driver.findElement(By.cssSelector("p[class='my-projects-description'] +div :first-child"));
            projectOneEle.click();

            WebElement projectOneTitle = driver.findElement(By.cssSelector("div[class='advanced-technologies-card'] :first-child"));
            System.out.println(projectOneTitle.getText());

            WebElement projectOneDes = driver.findElement(By.cssSelector("div[class='advanced-technologies-card'] :nth-child(2)"));
            System.out.println(projectOneDes.getText());

            WebElement backButton = driver.findElement(By.cssSelector("div[class='advanced-technologies-card'] :last-child"));
            backButton.click();

            // Test the second project page
            WebElement projectSecondEle = driver.findElement(By.cssSelector("p[class='my-projects-description'] +div :nth-child(2)"));
            projectSecondEle.click();

            List<WebElement> diwaliItems = driver.findElements(By.cssSelector("div[class='diwali-bottom-section'] div>h1"));
            ArrayList<String> arrayList = new ArrayList<String>();
            for (WebElement i :  diwaliItems){
                String items = i.getText();
                arrayList.add(items);
            }

            List<WebElement> diwaliItemsPrices = driver.findElements(By.cssSelector("div[class='diwali-bottom-section'] div>p"));
            ArrayList<String> arrayList2 = new ArrayList<String>();
            for (WebElement i :  diwaliItemsPrices){
                String itemsPrices = i.getText();
                arrayList2.add(itemsPrices);
            }
            for (int i=0; i<4;i++){
                System.out.println("The price of "+arrayList.get(i)+" id "+arrayList2.get(i));
            }

            backButton = driver.findElement(By.cssSelector("div[class='d-flex flex-row justify-content-center']:nth-child(3)"));
            backButton.click();

            // Test the third project page
            WebElement projectThirdEle = driver.findElement(By.xpath("//div[@class='d-flex flex-row justify-content-center'][2]/img[1]"));
            projectThirdEle.click();

            WebElement projectSecondTitle = driver.findElement(By.cssSelector("div[class='order-card'] h1"));
            System.out.println(projectSecondTitle.getText());

            WebElement projectSecondDes = driver.findElement(By.cssSelector("div[class='order-card'] p"));
            System.out.println(projectSecondDes.getText());

            backButton = driver.findElement(By.cssSelector("div[class='order-card'] :nth-child(4)"));
            backButton.click();

            // Test the fourth project page
            WebElement projectFourEle = driver.findElement(By.xpath("//div[@class='d-flex flex-row justify-content-center'][2]/img[2]"));
            projectFourEle.click();

            WebElement projectFourCategory = driver.findElement(By.cssSelector("div[class='news-card'] :first-child"));
            System.out.println(projectFourCategory.getText());

            WebElement projectFourTitle = driver.findElement(By.cssSelector("div[class='news-card'] :nth-child(2)"));
            System.out.println(projectFourTitle.getText());

            WebElement projectFourDes = driver.findElement(By.cssSelector("div[class='news-card'] :nth-child(3)"));
            System.out.println(projectFourDes.getText());

            backButton = driver.findElement(By.cssSelector("div[class='news-card'] :nth-child(5)"));
            backButton.click();

            Thread.sleep(3000);
            driver.quit();

            }catch (Exception e){
            System.out.println("The Exception is: "+e);
        }
    }
}
