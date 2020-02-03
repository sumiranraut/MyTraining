package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTest {
	public static WebDriver driver;
	PageObjects po;

	@Given("Navigate to Home Page")
	public void navigate_to_Home_Page() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://10.232.237.143:443/TestMeApp/");
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		po = new PageObjects(driver);

	}

	@When("user enters username and password")
	public void user_enters_username_and_password() {
		po.signin.click();
		po.username.sendKeys("lalitha");
		po.password.sendKeys("Password123");
		po.Login.click();

	}

	@Then("user logged in sucessfully")
	public void user_logged_in_sucessfully() {
		System.out.println("User login Sucessfully");

	}

	@When("Larry searches below products in the search box:")
	public void larry_searches_below_products_in_the_search_box(DataTable DT) {
		List<String> product = DT.asList(String.class);
		for (String s : product) {
			driver.findElement(By.name("products")).sendKeys(s);
			driver.findElement(By.xpath("//input[@value='FIND DETAILS']")).click();
			driver.findElement(By.xpath("//a[@href='fetchcat.htm']")).click();
		}
		

		throw new cucumber.api.PendingException();
	}
	@When("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void enterusernamepassword(String username,String password)
	{
		po.signin.click();

		po.username.sendKeys(username);

		po.password.sendKeys(password);

		po.Login.click();
		driver.findElement(By.xpath("//a[@href='logout.htm']")).click();
	}

	@Then("product should be added in the cart if available")
	public void product_should_be_displayed_if_available_in_TestMeApp() {
		throw new cucumber.api.PendingException();
	}
}
