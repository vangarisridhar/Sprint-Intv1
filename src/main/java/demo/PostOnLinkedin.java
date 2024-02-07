
package demo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class PostOnLinkedin {
    ChromeDriver driver;

    public PostOnLinkedin(ChromeDriver driver){

        this.driver= driver;
    }



    public void linkedinpost() {
    
                try {

                    //navigate to the url  https://in.linkedin.com/
                    driver.get(" https://in.linkedin.com/");

                    // find the element input field for email or mobilenumber using the id By.id("session_key")) and enter the email or number
                    driver.findElement(By.id(("session_key"))).sendKeys("vangarisridhar@gmail.com");
                    //find the element password field using id (By.id("session_password")) and enter the password
                    driver.findElement(By.id("session_password")).sendKeys("confidential");
                    //find the Button element sign in using the xpath//button[@data-id='sign-in-form__submit-btn'] and click on it
                    driver.findElement(By.xpath("//button[@data-id='sign-in-form__submit-btn']")).click();
                    // find the element "me" button by id //button[@id='ember14'] and click on it
                    driver.findElement(By.id("ember14")).click();
                    Thread.sleep(1000);
                    //find the view Profile element by xpath //a[text()='View Profile'] and click on it
              
                    driver.findElement(By.xpath("//a[text()='View Profile']")).click();
                    Thread.sleep(5000);
                    //find the number of profile views in Analytics using the xpath //*[@id="profile-content"]/div/div[2]/div/div/main/section[3]/div[3]/ul/li[1]/div/div[2]/div/a/div/div/div/div/span[1]/text()
                    System.out.println("views count is:"+driver.findElement(By.xpath("//div[@class='display-flex flex-wrap align-items-center full-height']//span")).getText());
                    //find the number of post impressions in Analytics using the xpath (//div[@class='display-flex flex-wrap align-items-center full-height']/div/div/div/span)[3]
                     System.out.println("Numer of post impressions are:"+driver.findElement(By.xpath("(//div[@class='display-flex flex-wrap align-items-center full-height']/div/div/div/span)[3]")).getText());
                    
                } catch (Exception e) {
                    System.out.println("exception occured in testcase07  "+e);
        
                }
        
            }
    
}
