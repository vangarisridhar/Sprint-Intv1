package demo;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFramesText {
ChromeDriver driver;

    public NestedFramesText(ChromeDriver driver){
        this.driver = driver;
    }

    public void searchForNestedFramesText() throws InterruptedException{
        //Navigate to Url

        driver.get("https://the-internet.herokuapp.com/nested_frames");
        
        //switch to the left frame;
        WebElement frameelement = driver.findElement(By.xpath("//frame[@name='frame-left']"));
        driver.switchTo().frame(frameelement);
        String s1= driver.findElement(By.xpath("//body")).getText();
        System.out.println("retrtieved text from left frame is: "+s1);

        


      
    }
    
}
