import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FeaturesPageTest2 {
    public static void main(String[] args){
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();;
            driver.get("https://qafeaturesect.ccbp.tech/");

            List<WebElement> titlesList = driver.findElements(By.cssSelector("div[class *='feature-card'] >h1"));

            String expectedArrayList[] = {"Easy to connect", "VR Capability", "Video games", "Interaction", "Easy to play", "Awesome Experience"};
            int i;
            for (i=0; i < 6; i++){
                WebElement title = titlesList.get(i);
                if (!expectedArrayList[i].equals(title.getText())){
                    System.out.println("Mismatch found in titles");
                    break;
                }
            }
            if (i == 6){
                System.out.println("All titles are as expected");
            }

            List<WebElement> description = driver.findElements(By.cssSelector("div[class *='feature-card'] > p"));

            String[] excpectedDesc = {"Instead of viewing a screen in front of them, users are immersed and able to interact with 3D worlds.", "Virtual reality (VR) can create an environment similar to or completely different from the real world.", "Ability to recognize hand motion, evolving interactions and gameplay in VR.", "Interaction refers to the natural interaction between the user and the virtual scene.", "In 360-degree video, the locations of viewers are fixed, viewers are limited to the angles captured by the cameras.", "Virtual reality (VR) is a simulated experience that can be similar to or completely different from the real world."};

            for (i=0; i<6; i++){
                WebElement descrip = description.get(i);
                if (!excpectedDesc[i].equals(descrip.getText())){
                    System.out.println("Mismatch found in descriptions");
                    break;
                }
            }
            if (i == 6){
                System.out.println("All descriptions are as expected");
            }

            WebElement spanEle = driver.findElement(By.cssSelector("img[src *= 'interaction'] ~ p > span"));
            // Verify that the highlighted text is as expected
            String expectedSpanText = "natural interaction";
            if (expectedSpanText.equals(spanEle.getText())) {
                System.out.println("Highlighted text found");
            } else {
                System.out.println("Mismatch in highlighted text");
            }

            Thread.sleep(4000);
            driver.quit();

        }catch (Exception e){
            System.out.println("The Exception is: "+e);
        }
    }
}
