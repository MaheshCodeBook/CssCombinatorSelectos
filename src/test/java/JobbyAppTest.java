import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class JobbyAppTest {
    public static void main(String args[]){
        try {
            // Set the path to the ChromeDriver executable
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");

            // Launch the Chrome browser
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Open the Jobby App login page
            driver.get("https://qajobbyapp.ccbp.tech/login");

            // Locate username field
            WebElement usernameEl = driver.findElement(By.cssSelector("input[id='userNameInput']"));
            usernameEl.sendKeys("rahul");

            // Locate password field
            WebElement passwordEl = driver.findElement(By.cssSelector("input#passwordInput"));
            passwordEl.sendKeys("rahul@2021");


            // Locate submit button
            WebElement buttonEl = driver.findElement(By.cssSelector("button[class='login-button']"));
            buttonEl.submit();

            // Define the expected URL of the home page
            String expectedUrl = "https://qajobbyapp.ccbp.tech/";

            // Wait for the expected URL to be loaded
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlToBe(expectedUrl));

            // Get the current URL after login
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.equals(expectedUrl)) {
                System.out.println("Navigation to home page is successful!");
            }

            // Find and click on the "Find Jobs" button
            WebElement findJobsButtonEl = driver.findElement(By.cssSelector("button[class*='find-jobs']"));
            findJobsButtonEl.click();
            String jobsPageUrl = "https://qajobbyapp.ccbp.tech/jobs";
            wait.until(ExpectedConditions.urlToBe(jobsPageUrl));
            currentUrl = driver.getCurrentUrl();
            if (currentUrl.equals(jobsPageUrl)) {
                System.out.println("Navigation to jobs page is successful!");
            }


            //Wait until elements are displayed
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.jobs-list")));

            // Verify the display of jobs on the jobs page
            List<WebElement> jobs = driver.findElements(By.cssSelector("li[class$='job-item']"));

            //Verify if more than one job is displayed
            if (jobs.size() > 0) {
                System.out.println("Jobs are displayed successfully on the Jobs page:" + jobs.size());

                String expectedRATING = "4";
                WebElement ratingEle = driver.findElement(By.cssSelector("a[href = '/jobs/bb95e51b-b1b2-4d97-bee4-1d5ec2b96751'] >li p.rating\n"));
                // xpath    a[@href='/jobs/bb95e51b-b1b2-4d97-bee4-1d5ec2b96751']/descendant::p[@class='rating']
                // css selectpr descendant a[href='/jobs/bb95e51b-b1b2-4d97-bee4-1d5ec2b96751'] * p[class ='rating']
                String actualRating = ratingEle.getText();
                if (actualRating.equals(expectedRATING)){
                    System.out.println("Rating is 4");
                }else {
                    System.out.println("Rating is not expected");

                }

            } else {
                System.out.println("No jobs found on the jobs page.");
            }


            // Close the browser
            driver.quit();
        }
        catch (Exception e){
            System.out.println("An exception occurred: " + e.getMessage());
        }
    }
}

