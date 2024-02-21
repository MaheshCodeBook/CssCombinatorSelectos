import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CA7CashWithdrawalPageTest {
    public static void main(String[] args){
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://qawithdrawal.ccbp.tech/\n");

            WebElement nameEle = driver.findElement(By.cssSelector("div[class *= 'details'] >p"));
            String actualName = nameEle.getText();
            String expectedName = "Sarah Williams";

            if (actualName.equals(expectedName)){
                System.out.println("Username is correct");
            }else {
                System.out.println("Incorrect username");
            }


            WebElement balanceEle = driver.findElement(By.cssSelector("div[class *= 'balance-card'] >p"));
            int actualBal = Integer.parseInt(balanceEle.getText());
            int expectedBal = 2000;

            if (actualBal == expectedBal){
                System.out.println("Initial balance is correct");
            }else {
                System.out.println("Incorrect initial balance");
            }

            List<WebElement> denominationsList = driver.findElements(By.cssSelector("ul[class *= 'denominations-list'] button"));

            for (WebElement denominationButton : denominationsList) {
                    denominationButton.click();
                    denominationButton.click();

                    //verify updated balance
                    int updatedBalance = Integer.parseInt(driver.findElement(By.cssSelector("p[class='balance']")).getText());
                    int expectedupdatedBalance = actualBal - 2 * Integer.parseInt(denominationButton.getText());

                    if (updatedBalance != expectedupdatedBalance) {
                        System.out.println("Mismatch found in balance");
                    } else {
                        System.out.println("Withdrawal App working as expected");
                    }
                }

            Thread.sleep(3000);
            driver.quit();
        }catch (Exception e){
            System.out.println("The Exception is: "+e);
        }
    }
}
