package Marathon;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RedbusSample {
	
			// Launch Firefox / Chrome
			// Load https://www.redbus.in/
			// Type "Chennai" in the FROM text box
			// Type "Bangalore" in the TO text box
			// Select tomorrow's date in the Date field
			// Click Search Buses
			// Print the number of buses shown as results (104 Buses found)
			// Close the redbus primo notification
			// Choose SLEEPER in the left menu
			//click on view seats
			//print the starting price
			//Print the available seats

	public static void main(String[] args) throws InterruptedException {

		//Setup chrome driver
		WebDriverManager.chromedriver().setup();
		
		//Disable notifications code
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("disable-notifications");
	    
		//Launch chrome driver
		ChromeDriver driver = new ChromeDriver(options);
		
		//Load url
		driver.get("https://www.redbus.in/");
		
		//Maximize window
		driver.manage().window().maximize();
		
		//Filling the FROM text box 
		driver.findElement(By.xpath("//input[@id='src']")).sendKeys("Chennai");
		//driver.findElement(By.className("class=selected")).click();
		Thread.sleep(5000);
		
		//Filling the TO textbox
		driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Bangalore");
		Thread.sleep(5000);
	
		//Selecting the date
		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
		driver.findElement(By.xpath("//td[text()='16']")).click();
		
		//Click on search
		driver.findElement(By.id("search_btn")).click();	
		
		Thread.sleep(5000);
		
		//Print the number of buses shown as results (104 Buses found)
		String buses = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		System.out.println("The Number of buses displayed in results: " + buses);
		
		// Close the redbus primo notification
		driver.findElement(By.xpath("//div[@class='close-primo']//i")).click();
		
		// Choose SLEEPER in the left menu
		driver.findElement(By.xpath("//label[text()='SLEEPER']/preceding-sibling::label")).click();
		
		//click on view seats
		driver.findElement(By.xpath("//div[@class='clearfix m-top-16']//div[text() ='View Seats']")).click();
		
		//print the starting price
		String startingPrice = driver.findElement(By.xpath("(//div[@class='seat-fare ']//span[@class='f-19 f-bold'])[1]")).getText();
		System.out.println("The starting price is: " + startingPrice);
		
		//Print the available seats
		String availableSeats = driver.findElement(By.xpath("//div[@class='column-eight w-15 fl']//div")).getText();
		System.out.println("The available seats : " + availableSeats);
	
		
	}
}
