package demo;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {
    ChromeDriver driver;

    public WindowHandle(ChromeDriver driver){
        this.driver=driver;

    }

    public void searchForWindowHandle() throws IOException{
        //navigate to the url https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        //get the parent window handle using driver.getwindowhandle();
        String parentwindowhandle= driver.getWindowHandle();
        //find the iframe element using the xpath "//iframe[@name='iframeResult']"
         WebElement iframe = driver.findElement(By.xpath("//iframe[@name='iframeResult']"));
         //switch to the frame using the iframe element 
        driver.switchTo().frame(iframe);
        //find the button element try it using the xpath "//button[contains(text(),'Try')]" and click using the click function
        driver.findElement(By.xpath("//button[contains(text(),'Try')]")).click();
        //Find the total number of window handles and store them in a set variable
        Set<String> setofWindowHandles = driver.getWindowHandles();
        //Iterate through the set until current window handle is not equal to the parent window handle and switch the drivert that window handle
        for(String currentwindowhandle: setofWindowHandles){
            if(!(currentwindowhandle.equals(parentwindowhandle)))
            driver.switchTo().window(currentwindowhandle);
        }
        //print the new window url using driver.getcurrenturl function
        System.out.println("New window Url is :"+ driver.getCurrentUrl());
        //print the new window title using the driver.getTitle function
        System.out.println("New window Title is :"+ driver.getTitle());
        //using TakeScreenshot interface  cast the driver 
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        //Capture the screenshot using getScreenshotAs function my mentioning the output file type as File
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        //Assign the path and filename to the destfile variable
        File DestFile=new File("src\\main\\java\\demo\\Screenshot.png");
        //using fileutils copy the source file to the destination file
         FileUtils.copyFile(SrcFile, DestFile);
         //switch the driver to parent window
         driver.switchTo().window(parentwindowhandle);

        
    }
    
}
