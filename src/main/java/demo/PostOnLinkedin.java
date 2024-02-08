
package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PostOnLinkedin {
    ChromeDriver driver;

    public PostOnLinkedin(ChromeDriver driver) {

        this.driver = driver;
    }

    public void linkedinpost() {

        try {

            // navigate to the url https://in.linkedin.com/
            driver.get(" https://in.linkedin.com/");
            // find the element input field for email  using the id "session_key" and enter the email
            driver.findElement(By.id(("session_key"))).sendKeys("vangarisridhar@gmail.com");
            // find the element password field using id "session_password" and enter the password
            driver.findElement(By.id("session_password")).sendKeys("SRI!&)dhar123");
            // find the Button element sign in using the xpath//button[@data-id='sign-in-form__submit-btn'] and click on it
            driver.findElement(By.xpath("//button[@data-id='sign-in-form__submit-btn']")).click();
            Thread.sleep(90000);//delay due to security check to solve the puzzle manually


            //  Now post image in linkedin
            //find the media button using xpath  //button[@class='artdeco-button artdeco-button--muted artdeco-button--4 artdeco-button--tertiary share-box-feed-entry-toolbar__item'] and clickon it
            driver.findElement(By.xpath(
                    " //button[@class='artdeco-button artdeco-button--muted artdeco-button--4 artdeco-button--tertiary share-box-feed-entry-toolbar__item']"))
                    .click();
            Thread.sleep(3000);
            //using autoit executable to handle the windows explorer to upload the imagefile execute the autoit script
            Runtime.getRuntime().exec("D:\\Sprint-intv-1\\linkedinimagepost.exe");
            Thread.sleep(5000);
            //find the elememt Next button using the xpath //button[@class='share-box-footer__primary-btn artdeco-button artdeco-button--2 artdeco-button--primary ember-view'] and click on it
            driver.findElement(By.xpath(
                    "//button[@class='share-box-footer__primary-btn artdeco-button artdeco-button--2 artdeco-button--primary ember-view']"))
                    .click();
                    Thread.sleep(2000);
             //find the element post button using the xpath   //button[@class='share-actions__primary-action artdeco-button artdeco-button--2 artdeco-button--primary ember-view'] and click on it     
                    driver.findElement(By.xpath("//button[@class='share-actions__primary-action artdeco-button artdeco-button--2 artdeco-button--primary ember-view']")).click();
                    Thread.sleep(5000);
             // Post image part ends here




            
            // find the element "me"  by xpath //img[@class='global-nav__me-photo evi-image ember-view'] and click on it
             driver.findElement(By.xpath("//img[@class='global-nav__me-photo evi-image ember-view']")).click();
             Thread.sleep(1000);
             //find the view Profile element by xpath //a[text()='View Profile'] and click on it
            driver.findElement(By.xpath("//a[text()='View Profile']")).click();
             Thread.sleep(5000);
             //find the number of profile views in Analytics using the xpath and print it
            
             System.out.println("views count is:"+driver.findElement(By.xpath("//div[@class='display-flex flex-wrap align-items-center full-height']//span")).getText());
            //find the number of post impressions in Analytics using the xpath //div[@class='display-flex flex-wrap align-items-center full-height']/div/div/div/span)[3]
             System.out.println("Numer of post impressions are:"+driver.findElement(By.xpath("(//div[@class='display-flex flex-wrap align-items-center full-height']/div/div/div/span)[3]")).getText());

        } catch (Exception e) {
            System.out.println("exception occured in testcase07  " + e);

        }

    }

}
