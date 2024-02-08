package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImageUrls {
    ChromeDriver driver;

    public ImageUrls(ChromeDriver driver) {
        this.driver = driver;
    }

    public int searchForImageUrls() throws InterruptedException {

        // Navigate to https://in.bookmyshow.com/explore/home/chennai
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        Thread.sleep(60000);//page is taking a long time to load the contents
        //Find the web elements list for recommended movies using the xpath //div[@class='commonStyles__VerticalFlexBox-sc-133848s-2 style__ImageWrapper-sc-1t5vwh0-1 dXHMBz']/img
        List<WebElement> list = driver.findElements(By.xpath(
                "//div[@class='commonStyles__VerticalFlexBox-sc-133848s-2 style__ImageWrapper-sc-1t5vwh0-1 dXHMBz']/img"));
        //traverse through the list and print Each Image Url using element.getAttribute("src")
        for (WebElement element : list) {
            System.out.println("image url is: " + element.getAttribute("src"));
        }
        //scroll down the page using java script executor by typecasting the driver instance
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        Thread.sleep(5000);
        //after 5 seconds waiting again scroll down the page using java script till webelement is found
        WebElement element = driver.findElement(By.xpath("//h2[@class='sc-7o7nez-0 sc-7o7nez-1 gMWGIh']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        Thread.sleep(5000);
        //find the name of the second element in the premier list and the language using the xpath (//div[@class='sc-133848s-3 cZuToi']/div/div[@class='sc-7o7nez-0 zDfcI'])[2]
        String name = driver.findElement(By.xpath("(//div[@class='sc-133848s-3 cZuToi']/div/div[@class='sc-7o7nez-0 zDfcI'])[2]")).getText();
        System.out.println("Name of the webelemet in the second place is: " + name);
        //find the language of the second item using the xpath (//div[@class='sc-133848s-3 cZuToi']/div/div[@class='sc-7o7nez-0 veMGd'])[2]" and retrieve the text using getText function
        System.out.println("Language of the webelement in the second place is"+driver.findElement(By.xpath("(//div[@class='sc-133848s-3 cZuToi']/div/div[@class='sc-7o7nez-0 veMGd'])[2]")).getText());
        return list.size();

    }

}
