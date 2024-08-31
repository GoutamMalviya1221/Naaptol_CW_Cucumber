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

	public class BabyCare_KidsWare_Steps {
	
		WebDriver driver;
		SoftAssert sA = new SoftAssert();
		protected WebDriverWait wait;
		
		public static void capture(WebDriver driver, int n) throws IOException {
			TakesScreenshot ts = (TakesScreenshot)driver;
			
			//using getscreenshotAs() to take screenshot

			File image = ts.getScreenshotAs(OutputType.FILE);
			
			File img = new File("D:\\Naaptol_CW_Cucumber\\KidsWare"+n+".png");
			
			FileUtils.copyFile(image, img); 
		}

	
	@Given("Open browser , enter the URL of Naaptol and click on Shopping Categories \\(Kids Ware)")
	public void open_browser_enter_the_url_of_naaptol_and_click_on_shopping_categories_kids_ware() throws IOException {


	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://www.naaptol.com/");
	    
	    driver.findElement(By.xpath("//*[@class='cate_head']")).click();
	    capture(driver, 1);
		
	}

	@And("Click on the Kids and toys , then click on Kids Ware link \\(Kids Ware)")
	public void click_on_the_kids_and_toys_then_click_on_kids_ware_link_kids_ware() throws IOException {

		driver.findElement(By.linkText("Kids & Toys")).click();
		capture(driver, 2);
	}

	@When("User Click on the all the checkboxs is given on the left side\\(\\(Kids Ware))")
	public void user_click_on_the_all_the_checkboxs_is_given_on_the_left_side_kids_ware() throws IOException {

		driver.findElement(By.linkText("Baby Care & Maternity")).click();
		
		driver.findElement(By.linkText("Kids Wear")).click();
		capture(driver, 3);
		
	}

	@When("click on the given product and new tab will open\\(\\(Kids Ware))")
	public void click_on_the_given_product_and_new_tab_will_open_kids_ware() throws InterruptedException, IOException {
		
		Thread.sleep(1000);
		driver.findElement(By.id("isfreeship")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.id("brandFilterBox38398")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.id("priceFilterBox1")).click();

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

	@When("Assert the given message\\(\\(Kids Ware)	)")
	public void assert_the_given_message_kids_ware() throws IOException {

		String displayText = driver.findElement(By.xpath("(//*[@class='font-bold'])[2]")).getText();
		sA.assertEquals(displayText, "Currently Not Available", "Text did not match!");
		sA.assertAll();
		driver.close();
		driver.switchTo().window(driver.getWindowHandles().iterator().next());
		capture(driver, 5);
		driver.close();

		
	}

}
