package Launch123;

import java.util.concurrent.TimeUnit;

//import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



import graphql.Assert;

public class LaunchChrome {
	//@SuppressWarnings("deprecation")
	public static void main(String args[])
	{
		//part1();
		//emptyMsg();

		System.setProperty(
				"webdriver.chrome.driver",
				"C:\\Users\\DELL\\Downloads\\selenium\\chromedriver.exe");
		// Instantiate a ChromeDriver class.
		WebDriver driver = new ChromeDriver();


		// Maximize the browser
		driver.manage().window().maximize();
		//Actions actions = new Actions(driver);

		// Launch Website
		driver.get("https://live.guru99.com/");
		//public static void part1() {
		//Actual Title of the page
		String PageTitle = driver.getTitle();
		System.out.println("Page Title is:" + PageTitle);
		String my_title=driver.getTitle();
		System.out.println("Title is"  +my_title);
		Assert.assertTrue(my_title.contains("Home page"));
		System.out.println("Test Completed. Page Title Verified");

		//driver.findElement(By.cssSelector("a[title=\"Home page\"]")).click();		
		//FindElement(By.Id( "my-id" )). Click();
		//Xpath=//a[@attribute='http://live.techpanda.org/index.php/mobile.html']
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		System.out.println("Test Completed. Page Title Verified1111111");
		//ClickOnMobile Option
		WebElement selectMobile= driver.findElement(By.xpath("/html/body/div/div/header/div/div[3]/nav/ol/li[1]/a"));
		selectMobile.click();
		//SelectNameFrom DropDown
		Select selectDropdown = new Select (driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select")));
		selectDropdown.selectByVisibleText("Name");
		//}
		WebElement sonyCost = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/div[1]/span/span"));

		String sonyFirstCost=sonyCost.getText();

		System.out.println("Sony cost " +sonyCost.getText());
		System.out.println("Test Completed. Page Title Verified 222222222");


		WebElement clickSonyName = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/h2/a"));
		clickSonyName.click();
		WebElement sonyDetails = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div[2]/div[1]/form/div[3]/div[2]/div/span/span"));
		String sonySecondCost=sonyDetails.getText();

		if(sonySecondCost.equalsIgnoreCase(sonyFirstCost)) {
			System.out.println("Cost Matched;Test Case Passed");
		}else{
			System.out.println("Cost NotMatched;Test Case Failed");
		}

		WebElement clickAddToCart = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div[2]/div[1]/form/div[4]/div/div/div[2]/button/span/span"));
		clickAddToCart.click();

		WebElement edit = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/table/tbody/tr/td[4]/ul/li/a"));
		edit.click();
		WebElement value = driver.findElement(By.id("qty"));
		value.sendKeys("1000");

		//Update Cart click		
		WebElement updateCart = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div[2]/div[1]/form/div[4]/div/div/div[2]/button/span/span"));
		updateCart.click();

		//ErrorMsg Verification
		// This will capture error message

		String actual_errorMsg=driver.getTitle();

		// Store message in variable
		String expected="The maximum quantity allowed for purchase is 500.";

		// Verify error message
		Assert.assertEquals(actual_errorMsg,expected);

		//EmptyCart click
		WebElement emptyCart = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/table/tfoot/tr/td/button[2]/span/span"));
		emptyCart.click();

		//CartEmptyMsg Verification
		//public void emptyMsg()
		{
			// This will capture error message
			String actual_Msg=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div[1]/h1")).getText();

			// Store message in variable
			String expectedMsg="Shopping Cart is Empty";

			// Verify error message
			Assert.assertEquals(actual_Msg,expectedMsg);
		}
		//clickMobileOption
		WebElement Mobile= driver.findElement(By.xpath("/html/body/div/div/header/div/div[3]/nav/ol/li[1]/a"));
		Mobile.click();

		//AddComparison
		WebElement AddCompareMobile= driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/ul/li[2]/a"));
		AddCompareMobile.click();

		//Compare
		WebElement CompareMobile= driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/div[3]/div[2]/div/button/span/span"));
		CompareMobile.click();











		driver.manage().timeouts().implicitlyWait(10000000,TimeUnit.SECONDS);
		//driver.close();
	}






}
