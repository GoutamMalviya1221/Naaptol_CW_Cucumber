package Definations;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class BodyCare {
	
	WebDriver driver;
	SoftAssert sA = new SoftAssert();
	protected WebDriverWait wait;
	
	public static void capture(WebDriver driver, int n) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		//using getscreenshotAs() to take screenshot

		File image = ts.getScreenshotAs(OutputType.FILE);
		
		File img = new File("D:\\Naaptol_CW_Cucumber\\BobyCare"+n+".png");
		
		FileUtils.copyFile(image, img); 
	}

	
	@Given("Open browser , enter the URL of Naaptol and click on Shopping Categories \\(Body Care)")
	public void open_browser_enter_the_url_of_naaptol_and_click_on_shopping_categories_body_care() throws IOException {

	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://www.naaptol.com/");
	    
	    driver.findElement(By.xpath("//*[@class='cate_head']")).click();
	    capture(driver, 1);


		
	}

	@And("Click on the Kids and toys ,\\(Body Care)")
	public void click_on_the_kids_and_toys_body_care() throws IOException {

		driver.findElement(By.linkText("Kids & Toys")).click();
		capture(driver, 2);

		
	}

	@And("then click on BabyCare link then Click on Body Care")
	public void then_click_on_baby_care_link_then_click_on_body_care() throws IOException {
		
		driver.findElement(By.linkText("Baby Care & Maternity")).click();
		
		driver.findElement(By.linkText("Body Care")).click();
		capture(driver, 3);

	
	}

	@When("User Click on the all the checkboxs is given on the left side\\(Body Care)")
	public void user_click_on_the_all_the_checkboxs_is_given_on_the_left_side_body_care() throws InterruptedException {
		
		Thread.sleep(1000);
		driver.findElement(By.id("isfreeship")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.id("brandFilterBox8313")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.id("priceFilterBox1")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.id("discountFilterBox1")).click();


		
	}

	@When("click on the given product and new tab will open\\(Body Care)")
	public void click_on_the_given_product_and_new_tab_will_open_body_care() throws IOException, InterruptedException {
		
		String parent = driver.getWindowHandle();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@class='square']")).click();
		
		
		Set<String> allwindows = driver.getWindowHandles(); 
		
		for (String window : allwindows) {
			
			if (!window.equals(parent)) {
				
				driver.switchTo().window(window);
				
				break;
			}
		}
		capture(driver, 4);


		
	}

	@When("Assert the given message\\(Body Care)")
	public void assert_the_given_message_body_care() throws IOException {
		
		String displayText = driver.findElement(By.xpath("//*[@id='cart-panel-button-0']")).getText();
		sA.assertEquals(displayText, "Click here to Buy", "Text did not match!");
		sA.assertAll();
		driver.close();
		driver.switchTo().window(driver.getWindowHandles().iterator().next());
		capture(driver, 5);

		driver.close();

		
	}


}
