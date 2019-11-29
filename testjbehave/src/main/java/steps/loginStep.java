package steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;


public class loginStep extends Steps {

	private static WebDriver driver = null;
	//String bacseURl =  "https://nbttest.yr.com" ;

	@Given("I open a browser")
	public void openingBrowser() {

		String projectpath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectpath+"\\Drivers\\Chrome\\chromedriver.exe");
		driver =  new ChromeDriver();
		ChromeOptions option =  new ChromeOptions();
		option.addArguments("--disable-extensions");
		//driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();	
		

	} 

	@When("I enter the $bacseURl")
	public void enterURL(String bacseURl) {
		driver.get(bacseURl);
		
	}
	
	@When("select the User ID checkbox")
	public void selectcheckbox() {
		
		driver.findElement(By.id("usernameType")).click();
	}
	
	@When("ender the <username> and <password>")
	public void enterUsernamePassword(@Named("username") String username, @Named("password") String password ) {
		
		driver.findElement(By.name("usernameVisible")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
	}
	
	@When("select the ap from dropdown")
	public void selectDropDown() {
		
		Select dropdown_value =  new Select(driver.findElement(By.name("domain")));
		dropdown_value.selectByVisibleText("AP");
	}
	
	@When("click on the login button")
	public void clickLoginButton() {
		
		driver.findElement(By.name("submit")).click();
	}



	@Then("nbttest page title is displayed")
	public void nbttestTitle() {

		String title = driver.getTitle();
		title.equalsIgnoreCase("NBT");
		System.out.println("This is Third method");

	}
}




