package Marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceProblem {
	
	//setup the path	
	//disable notifications
	//create instance
	//manage ur window
	//add wait
    // Login to https://login.salesforce.com
	//enter username
	//enter password
	//click login button
    //Click on toggle menu button from the left corner
    //Click view All and click Sales from App Launcher
    //Click on Opportunity tab 
	//Click on Accounts tab
	//Click on New button
	//Enter 'your name' as account name
	//Select Ownership as Public
	//click save
	//verify message
	
	public static void main(String[] args) throws InterruptedException {
		//Setup chrome driver
		WebDriverManager.chromedriver().setup();
				
		//Disable notifications code
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
			    
		//Launch chrome driver
		ChromeDriver driver = new ChromeDriver(options);
				
		//Load url
		driver.get("https://login.salesforce.com/?locale=in");
				
		//Maximize window
		driver.manage().window().maximize();
				
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// Login
		// Enter username
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("ramkumar.ramaiah@testleaf.com");
				
		// Enter password
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password#123");
		
		//Wait
		Thread.sleep(2000);
		
		//Click on Login
		driver.findElement(By.id("Login")).click();
		
		//Wait
		Thread.sleep(5000);
		
		//Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		Thread.sleep(5000);
		
	    //Click view All
		driver.findElement(By.xpath("//button[contains(text(),'View All')]")).click();
		Thread.sleep(5000);
		
		//Click Sales from App Launcher
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(5000);
		
	    //Click on Accounts tab
		WebElement accounts = driver.findElement(By.xpath("//a[@title='Accounts']/span[text()='Accounts']"));
		
		//For bypassing javascript error
		driver.executeScript("arguments[0].click()", accounts);
		Thread.sleep(5000);
		
		//Click on New button
		driver.findElement(By.xpath("//div[@title='New']")).click();
		Thread.sleep(5000);
		
		//Enter 'your name' as account name
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Sreevidya");
		Thread.sleep(2000);
		
		//Select Ownership as Public
		WebElement ownership = driver.findElement(By.xpath("(//label[text()='Ownership']/following::button)[1]"));
		driver.executeScript("arguments[0].click()", ownership);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//span[text()='Public']")).click();
		Thread.sleep(2000);
		
		//click save
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(2000);
		
		//verify message
		String verificationMsg = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
		System.out.println(verificationMsg);			

	}

}
