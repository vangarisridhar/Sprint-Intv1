package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ImageUrls {
    ChromeDriver driver;

    public ImageUrls(ChromeDriver driver){
        this.driver= driver;
    }

    public int searchForImageUrls() throws InterruptedException{

        
        // Navigate to https://in.bookmyshow.com/explore/home/chennai
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        
        List<WebElement> list = driver.findElements(By.xpath(
                "//div[@class='commonStyles__VerticalFlexBox-sc-133848s-2 style__ImageWrapper-sc-1t5vwh0-1 dXHMBz']/img"));


        for (WebElement element : list) {
            System.out.println("image url is: " + element.getAttribute("src"));
        }
       
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        Thread.sleep(5000);
        WebElement element = driver.findElement(By.xpath("//h2[@class='sc-7o7nez-0 sc-7o7nez-1 gMWGIh']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
  
    Thread.sleep(5000);

        
        String name= driver.findElement(By.xpath("(//div[@class='sc-133848s-3 cZuToi'])[2]")).getText();
        System.out.println("contents of the webelemet in the second item are: "+name);
        
        
            
                return list.size();
                
    }
    
}
