package Marathon;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceTask {

	//	1) Launch the app
	//	2) Click Login
	//	3) Login with the credentials
	//	4) Click on Global Actions SVG icon
	//	5) Click view all
	//	6) Type task and select task
	//	7) Click New Task under dropdown icon
	//	6) Enter subject as "Bootcamp "                                               
	//	8) Select status as 'Waiting on someone else'
	//	9) Save and verify the 'Task created' message
	
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
		
		// Click on Global Actions SVG icon
		driver.findElement(By.xpath("(//div[@class='uiMenu']//a[@role='button'])[1]")).click();
		Thread.sleep(5000);
		
		//Click New Task under dropdown icon
		driver.findElement(By.xpath("//a[@title='New Task']//span[text()='New Task']")).click();
		Thread.sleep(3000);
		
		
		//Enter subject as "Bootcamp "
		driver.findElement(By.xpath("//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click']//input[@role='combobox']")).sendKeys("Bootcamp");
		Thread.sleep(2000);
		
		//Select status as 'Waiting on someone else'
		driver.findElement(By.xpath("(//span[text()='Status']/following::a[text()='Not Started'])[1]")).click();
		driver.findElement(By.xpath("//a[text()='Waiting on someone else']")).click();
		Thread.sleep(5000);
				
		//Save 
		driver.findElement(By.xpath("//div[@class='visibilitySwitcher hide']/following::span[text()='Save']")).click();
		Thread.sleep(5000);
				
		//verify message
		String verificationMsg = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
		System.out.println(verificationMsg);	

	}

}
