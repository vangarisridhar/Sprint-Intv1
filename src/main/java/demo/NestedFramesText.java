package demo;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFramesText {
    ChromeDriver driver;

    public NestedFramesText(ChromeDriver driver) {
        this.driver = driver;
    }

    public void searchForNestedFramesText() throws InterruptedException {
        // Navigate to Url https://the-internet.herokuapp.com/nested_frames

        driver.get("https://the-internet.herokuapp.com/nested_frames");
        Thread.sleep(5000);
        //find the frame element by name "frame-top"
        WebElement topframe = driver.findElement(By.name("frame-top"));
        //switch the driver to the frame using frame by name "frame-top"
        driver.switchTo().frame(topframe);
         //find the frame element by name "frame-left"
        WebElement leftframe = driver.findElement(By.name("frame-left"));
        //switch the driver to the frame using frame by name "frame-left"
        driver.switchTo().frame(leftframe);
        //print the text contents of left frame using xpath "//body" and getText function
        System.out.println("text in the left frame is: " + driver.findElement(By.xpath("//body")).getText());
        //switch the driver to parent frame
        driver.switchTo().parentFrame();
        //find the frame element by name "frame-middle"
        WebElement middleframe = driver.findElement(By.name("frame-middle"));
         //switch the driver to the frame using frame by name "frame-middle"
        driver.switchTo().frame(middleframe);
         //print the text contents of middle frame using xpath "//body" and getText function
        System.out.println("text in the middle frame is: " + driver.findElement(By.xpath("//body")).getText());
        //switch the driver to parent frame
        driver.switchTo().parentFrame();
        //find the frame element by name "frame-right"
        WebElement rightframe = driver.findElement(By.name("frame-right"));
         //switch the driver to the frame using frame by name "frame-right"
        driver.switchTo().frame(rightframe);
        //print the text contents of right frame using xpath "//body" and getText function
        System.out.println("text in the right frame is: " + driver.findElement(By.xpath("//body")).getText());
        // //switch the driver to the default content
        driver.switchTo().defaultContent();
         //find the frame element by name "frame-bottom"
        WebElement bottomframe = driver.findElement(By.name("frame-bottom"));
        //switch the driver to the frame using frame by name "frame-bottom"
        driver.switchTo().frame(bottomframe);
         //print the text contents of bottom frame using xpath "//body" and getText function
        System.out.println("text in the bottom frame is: " + driver.findElement(By.xpath("//body")).getText());


    }

}
