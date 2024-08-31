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

public class BabyCare_Steps {
	
	WebDriver driver;
	SoftAssert sA = new SoftAssert();
	protected WebDriverWait wait;
	
	public static void capture(WebDriver driver, int n) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		//using getscreenshotAs() to take screenshot

		File image = ts.getScreenshotAs(OutputType.FILE);
		
		File img = new File("D:\\Naaptol_CW_Cucumber\\BabyCare"+n+".png");
		
		FileUtils.copyFile(image, img); 
	}


	
	@Given("Open browser , enter the URL of Naaptol and click on Shopping Categories \\(BabyCare)")
	public void open_browser_enter_the_url_of_naaptol_and_click_on_shopping_categories_baby_care() throws IOException {

	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://www.naaptol.com/");
	    
	    driver.findElement(By.xpath("//*[@class='cate_head']")).click();
	    capture(driver, 1);

		
	}

	@And("Click on the Kids and toys ,\\(BabyCare)")
	public void click_on_the_kids_and_toys_baby_care() throws IOException {

		driver.findElement(By.linkText("Kids & Toys")).click();
		capture(driver, 2);

	}

	@And("then click on BabyCare link then Click on KIds Footware")
	public void then_click_on_baby_care_link_then_click_on_k_ids_footware() throws IOException {

		driver.findElement(By.linkText("Baby Care & Maternity")).click();
		
		driver.findElement(By.linkText("Kids Footwear")).click();
		capture(driver, 3);

		
	}

	@When("User Click on the all the checkboxs is given on the left side\\(BabyCare)")
	public void user_click_on_the_all_the_checkboxs_is_given_on_the_left_side_baby_care() throws InterruptedException {

		Thread.sleep(1000);
		driver.findElement(By.id("isexoutStock")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.id("brandFilterBox38776")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.id("priceFilterBox1")).click();

		
	}

	@When("click on the given product and new tab will open\\(BabyCare)")
	public void click_on_the_given_product_and_new_tab_will_open_baby_care() throws InterruptedException, IOException {

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

	@When("Assert the given message\\(BabyCare)")
	public void assert_the_given_message_baby_care() throws IOException {

		String displayText = driver.findElement(By.xpath("//*[@class='button_head']")).getText();
		sA.assertEquals(displayText, "No offer for sale on Naaptol.", "Text did not match!");
		sA.assertAll();
		driver.close();
		driver.switchTo().window(driver.getWindowHandles().iterator().next());
		capture(driver, 5);

		driver.close();

		
	}


}
