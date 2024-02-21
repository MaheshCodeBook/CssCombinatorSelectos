import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class CP13TopReadsPageTest {
    public static void main(String[] args){
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();;
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://qatopreads.ccbp.tech/");

            // sub-title of the first blog
            WebElement  subtitleFirstBlog = driver.findElement(By.cssSelector("img[src *= 'blogs-1'] +div>h1:first-of-type"));
            String actualSubtitleFirstBlog = subtitleFirstBlog.getText();
            String expectedSubtitleFirstBlog = "Fountain Pens";
            if (actualSubtitleFirstBlog.equals(expectedSubtitleFirstBlog)){
                System.out.println("Sub-title 1: Verified");
            }else {
                System.out.println("Sub-title 1: Verification Failed");
            }

            // sub-title of the second blog
            WebElement  subtitleSecondBlog = driver.findElement(By.cssSelector("img[src *= 'blogs-2'] +div >:first-child"));
            String actualSubtitleSecondBlog = subtitleSecondBlog.getText();
            String expectedSubtitleSecondBlog = "Productivity";
            if (actualSubtitleSecondBlog.equals(expectedSubtitleSecondBlog)){
                System.out.println("Sub-title 2: Verified");
            }else {
                System.out.println("Sub-title 2: Verification Failed");
            }

            // Test the title of the first blog
            WebElement  titleFirstBlog = driver.findElement(By.cssSelector("img[src *= 'blogs-1'] +div >h1:last-of-type"));
            String actualTitleFirstBlog = titleFirstBlog.getText();
            String expectedTitleFirstBlog = "Guide to Fountain Pen Nibs";
            if (actualTitleFirstBlog.equals(expectedTitleFirstBlog)){
                System.out.println("Title 1: Verified");
            }else {
                System.out.println("Title 1: Verification Failed");
            }

            // Test the title of the second blog
            WebElement  titleSecondBlog = driver.findElement(By.cssSelector("img[src *= 'blogs-2'] +div >h1:last-of-type"));
            String actualTitleSecondBlog = titleSecondBlog.getText();
            String expectedTitleSecondBlog = "How to Craft a Better Todo List";
            if (actualTitleSecondBlog.equals(expectedTitleSecondBlog)){
                System.out.println("Title 2: Verified");
            }else {
                System.out.println("Title 2: Verification Failed");
            }

            Thread.sleep(3000);
            driver.quit();
        }catch (Exception e){
            System.out.println("The Exception is: "+e);
        }
    }
}
