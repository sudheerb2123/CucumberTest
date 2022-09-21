package Stepdefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BrookSource {
	WebDriver driver = null;
	
	
	

@Given("^browser is open$")
public void browser_is_open() {
	
	System.setProperty("webdriver.chrome.driver","E:\\Cucumber_By_Bala\\Cucumber\\src\\test\\resources\\Drivers\\chromedriver.exe");
    
	driver = new ChromeDriver();
	driver.manage().window().maximize();
}

	
	
   @And("^user launch Brooksource url$")
public void user_launch_Brooksource_URL() {
	driver.navigate().to("https://www.brooksource.com/"); 
}

@When("^user clicks on Search IT Openings$")
public void user_Clicks_On_Search_IT_Openings() {
	driver.findElement(By.xpath("//div[contains(text(),'Search')]")).click();
}

@And("^user should see careers page$")
public void user_Should_See_Careers_Page() {
	ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
    driver.switchTo().window(newTb.get(1));
    System.out.println("Page title of new tab: " + driver.getTitle());
	if(driver.findElement(By.xpath("//h1[text()='Careers']")).isDisplayed())
	{
		System.out.println("Careers page displayed successfully");
	} 
	else
	{
		Assert.fail("Careers page is not displayed");
	}
}

@When("^user enters the keyword \'(.*?)\' and click on Search button$")
public void user_enters_the_search_keyword(String searchKeyword) {
	driver.findElement(By.xpath("//input[@class='facetwp-search']")).sendKeys(searchKeyword);
	driver.findElement(By.xpath("//span//i[@class='facetwp-icon']")).click();
}

@Then("^user should see the matching openings$")
public void user_Should_See_Matching_Results() throws InterruptedException
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,350)", "");
	
	Thread.sleep(2000);
	
	ArrayList<String> JobNames = new ArrayList<String>();
	
	List<WebElement> ElejobNames = driver.findElements(By.xpath("//h3"));
	for(int i=1; i<ElejobNames.size();i++)
	{
		JobNames.add(ElejobNames.get(i).getText());
		System.out.println(JobNames);
		break;
	}
	if(JobNames.contains("Test"))
	{
		System.out.println("Search keyword resulting expected job openings");
	}
	else
	{
		Assert.fail("Search keyword is not resulting expected job openings");
	}
	
}

}
    

