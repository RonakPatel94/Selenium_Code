package DataRead_PropertyFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Login_WithPropertifile {
    public WebDriver driver;


    public static void main(String[] args) throws IOException {
        //Properties prop = new Properties();

        System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //load properties file
        BufferedReader reader = new BufferedReader(new FileReader("resources\\Data.properties"));
        Properties properties = new Properties();
        properties.load(reader);

        try {
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.get(properties.getProperty("appurl"));
        driver.findElement(By.xpath(properties.getProperty("clicklogin"))).click();
        driver.findElement(By.xpath(properties.getProperty("txtusername"))).sendKeys(properties.getProperty("username"));
        driver.findElement(By.xpath(properties.getProperty("txtpassword"))).sendKeys(properties.getProperty("password"));
        driver.findElement(By.xpath(properties.getProperty("btnsubmit"))).click();

    }
}