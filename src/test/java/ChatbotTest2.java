import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ChatbotTest2 {
    public static void main(String[] args){
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();;
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://qachatbot.ccbp.tech/");

            WebElement inputFiled = driver.findElement(By.cssSelector("input.user-input"));
            inputFiled.sendKeys("Hi");

            WebElement clickBtn = driver.findElement(By.cssSelector("button.send-msg-btn"));
            clickBtn.click();

            inputFiled.sendKeys("Good Morning");
            clickBtn.click();

            inputFiled.sendKeys("Help!!!");
            clickBtn.click();

            List<WebElement> msgList = driver.findElements(By.cssSelector("div[id='chatContainer'] span"));
            for (WebElement i : msgList){
                System.out.println(i.getText());
            }

            Thread.sleep(4000);
            driver.quit();

        }catch (Exception e){
            System.out.println("The Exception is: "+e);
        }
    }
}
