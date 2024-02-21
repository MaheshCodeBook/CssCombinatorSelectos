import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class JobbyAppTest2 {

    public static void main(String[] args) {

        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");

        // Open Chrome Browser
        WebDriver driver = new ChromeDriver();

        // Navigate to the login page
        driver.get("https://qajobbyapp.ccbp.tech/login");

        // Find and fill in the form fields
        WebElement usernameEl = driver.findElement(By.cssSelector("input#userNameInput"));
        usernameEl.sendKeys("rahul");

        WebElement passwordEl = driver.findElement(By.cssSelector("input#passwordInput"));
        passwordEl.sendKeys("rahul@2021");

        WebElement buttonEl = driver.findElement(By.cssSelector("button[type='submit']"));
        buttonEl.submit();

        // Define the expected URL of the home page
        String homePageUrl = "https://qajobbyapp.ccbp.tech/";

        // Wait for the expected URL to be loaded
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(homePageUrl));

        // Get the current URL and verify redirection to home page
        String currentUrl = driver.getCurrentUrl();

        if (currentUrl.equals(homePageUrl)) {
            System.out.println("Navigation to home page is successful!");
        }

        // Find and click on the "Find Jobs" button
        WebElement findJobsButtonEl = driver.findElement(By.cssSelector("button.find-jobs-button"));
        findJobsButtonEl.click();

        // Define the expected URL of the home page
        String jobsPageUrl = "https://qajobbyapp.ccbp.tech/jobs";

        // Wait for the expected URL to be loaded
        wait.until(ExpectedConditions.urlToBe(jobsPageUrl));

        // Get the current URL and verify redirection to jobs page
        currentUrl = driver.getCurrentUrl();

        if (currentUrl.equals(jobsPageUrl)) {
            System.out.println("Navigation to jobs page is successful!");
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.jobs-list")));

        // Verify the display of jobs on the jobs page
        List<WebElement> jobs = driver.findElements(By.cssSelector("li[class='job-item']"));

        if (jobs.size() > 0) {
            System.out.println("Jobs are displayed successfully on the jobs page: " + jobs.size());
            // locating first-child element
            //WebElement childEle = driver.findElement(By.cssSelector("ul[class='jobs-list'] >:last-child"));
            // nth-child
            //WebElement childEle = driver.findElement(By.cssSelector("ul[class='jobs-list'] >:nth-child(60)"));
            // first-of-type
            WebElement childEle = driver.findElement(By.cssSelector("ul.jobs-list >a:first-of-type"));
            childEle.click();
            String excpectedURL = "https://qajobbyapp.ccbp.tech/jobs/bb95e51b-b1b2-4d97-bee4-1d5ec2b96751";
            wait.until(ExpectedConditions.urlToBe(excpectedURL));
            currentUrl = driver.getCurrentUrl();
            if (excpectedURL.equals(currentUrl)){
                System.out.println("Navigation to jobs details page is successful!");
            }


        } else {
            System.out.println("No Jobs found on the jobs page.");
        }
















        // Close the browser
        driver.quit();

    }
}
