
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BlogHubPageTest {
    public static void main(String[] args){
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();;
            driver.get("https://qabloghub.ccbp.tech/");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul[class='blogs-list']")));

            //Test the Number of Blog Displayed
            List<WebElement> blogList = driver.findElements(By.cssSelector("ul[class='blogs-list'] > li"));
            int blogCount = blogList.size();
            if (blogCount == 10){
                System.out.println("All blogs are displayed");
            }else {
                System.out.println("ew blogs missing...");
            }

            //Test all the Blog Titles
            List<WebElement> titlesList = driver.findElements(By.cssSelector("img[class $= 'image'] +div >h1"));
            java.lang.String[] excpectedTitles = {"React v16.9.0 and the Roadmap Update", "React v16.7: No, This Is Not the One With Hooks", "Building Great User Experiences with Concurrent Mode and Suspense", "Introducing The Problem Solver React v17.0", "What about the React v16.13.0 That we Developed", "React v16.4.2: Server-side vulnerability fix", "Introducing Zero-Bundle-Size React Server Components", "Introducing the New JSX Transform", "Introducing the New React DevTools", "Sneak Peek: Beyond React 16"};
            int i;
            for (i = 0; i<10; i++){
                WebElement titles = titlesList.get(i);
                java.lang.String titleText =titles.getText();
                if (!excpectedTitles[i].equals(titleText)){
                    System.out.println("Mismatch found in blog titles");
                }
            }
            if (i == 10){
                System.out.println("All blog titles are as expected");
            }

            //Test the Routing Functionality
            List<WebElement> linkList = driver.findElements(By.cssSelector("li[class ^= 'link'] > a"));
            WebElement aboutLink = linkList.get(1);
            aboutLink.click();
            String expectedUrl = "https://qabloghub.ccbp.tech/about";
            String actualUrl = driver.getCurrentUrl();
            if (expectedUrl.equals(actualUrl)) {
                System.out.println("Navigation to About Page Successful");
            }

            WebElement contactLink = linkList.get(2);
            contactLink.click();
            expectedUrl = "https://qabloghub.ccbp.tech/contact";
            actualUrl = driver.getCurrentUrl();
            if (expectedUrl.equals(actualUrl)) {
                System.out.println("Navigation to contact Page Successful");
            }

            WebElement homeLink = linkList.get(0);
            homeLink.click();
            expectedUrl = "https://qabloghub.ccbp.tech/";
            actualUrl = driver.getCurrentUrl();
            if (expectedUrl.equals(actualUrl)) {
                System.out.println("Navigation to Home Page Successful");
            }

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul[class ^= 'blog'] > li")));


            //Test the Routing Functionality for Each Blog

            // Declare a web element for the heading element
            WebElement heading;

            for (i = 0; i < 10; i++) {
                // Click the blog link element
                WebElement blogLink = driver.findElement(By.cssSelector("a[href = '/blogs/" + (i + 1) + "']"));
                blogLink.click();

                // Wait until the blog image is loaded
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class = 'blog-image']")));

                // Verify the heading matches the title of the blog
                heading = driver.findElement(By.cssSelector("div[class = 'app-body'] h1"));
                if (!excpectedTitles[i].equals(heading.getText())) {
                    System.out.println("Blog " + (i + 1) + " is mismatched");
                    break;
                }

                // Click the "Home" link element
                homeLink.click();

                // Wait until all the blogs are displayed
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul[class ^= 'blog'] > li")));
            }
            if (i == 10) {
                System.out.println("Blog Hub Page working as expected");
            }

            Thread.sleep(3000);
            driver.quit();

        }catch (Exception e){
            System.out.println("The Exception is: "+e);
        }
    }
}
