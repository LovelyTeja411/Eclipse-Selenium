package mos_PathCheck;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Locate_Element {

//Add_Delete_Room 
 
	public static void main(String[] args) throws Exception{
		
		String roomNumber = "2001";
		WebDriver driver = new ChromeDriver();
		driver.get("http://192.168.0.108:4321/MoS10/#/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
//		Login Page
		
		driver.findElement(By.id("mat-input-0")).sendKeys("techsupport");
		driver.findElement(By.id("mat-input-1")).sendKeys("Ironm@n2023");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
//		Home Page
		
		WebElement miniBar_Logo = driver.findElement(By.tagName("img"));
			String logoUrl = miniBar_Logo.getDomAttribute("src");
            System.out.println("Logo URL: " + logoUrl);
            Thread.sleep(2000);	
        WebElement rooms = driver.findElement(By.xpath("//span[text()='Rooms']"));
        rooms.click();
        Thread.sleep(2000);	
        driver.findElement(By.linkText("Rooms")).click();
        
        
        WebElement roomsHeading = driver.findElement(By.xpath("//div[text()='Rooms']"));
        System.out.println("Room Component Heading" + roomsHeading.getText());
        Thread.sleep(2000);	
        driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
        
//      Add Rooms Screen 
        
        WebElement rangeField = driver.findElement(By.xpath("//label[contains(text(),'Range')]"));
		if (rangeField.isDisplayed()) {
			driver.findElement(By.xpath("//label[contains(text(),'Range')]/following-sibling::div[1]/child::input[@class='form-control search ng-untouched ng-pristine ng-valid']")).sendKeys(Keys.chord(roomNumber));
		}
		else {
			System.out.println("Range field path  is Not Correct");
		}
		WebElement toField = driver.findElement(By.xpath("//label[contains(text(),'To')]"));
		if (toField.isDisplayed()) {
			driver.findElement(By.xpath("//label[contains(text(),'To')]/following-sibling::div[1]/child::input[@class='form-control search ng-untouched ng-pristine ng-valid']")).sendKeys(Keys.chord(roomNumber));
		}
		else {
			System.out.println("To field path  is Not Correct");
		}
		WebElement noOfBarsPerRoom = driver.findElement(By.xpath("//label[contains(text(),'Number of Bar(s) per Room(s)')]"));
		if (noOfBarsPerRoom.isDisplayed()) {
			Select barsDropdown = new Select(driver.findElement(By.xpath("//label[contains(text(),'Number of Bar(s) per Room(s)')]/following-sibling::select[@class='dropdown_select ng-untouched ng-pristine ng-valid']")));
			barsDropdown.selectByValue("1");
			Thread.sleep(2000);	
		}
		else {
			System.out.println("The Number of Bar(s) per Room(s) dropdown field path  is Not Correct");
		}
		driver.findElement(By.xpath("//button[text()='Go']")).click();
		
		WebElement addRoomsTableEle = driver.findElement(By.xpath("//div[@class='table-box']/child::table"));
		if (addRoomsTableEle.isDisplayed()) {
			WebElement barModelSelect = driver.findElement(By.xpath("//div[@class='table1']/descendant::tbody/descendant::td[2]/descendant::select[@class='select_drop ng-untouched ng-pristine ng-valid']"));
			Select modelDropdown = new Select(barModelSelect);
			modelDropdown.selectByContainsVisibleText("SC111-AW-EU");
			WebElement barMenuSelect = driver.findElement(By.xpath("//div[@class='table1']/descendant::tbody/descendant::td[4]/descendant::select[@class='select_drop ng-untouched ng-pristine ng-valid']"));
			Select menuDropdown = new Select(barMenuSelect);
			menuDropdown.selectByValue("1");
		}
		else {
			System.out.println("The user is not able to select the Bar model & Bar Menu please check the entered path is correct or not");
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		WebElement submitButton = driver.findElement(By.xpath("/html/body/app-root/div/app-landing/div/div[2]/app-add-rooms/div/div[5]/button[1]"));
		String submitText = submitButton.getText();
		System.out.println("The clicked button is - "+submitText);
		Thread.sleep(2000);	
		submitButton.click();
		driver.findElement(By.xpath("//input[@formcontrolname='roomSearchRange']")).sendKeys(Keys.chord(roomNumber));
		driver.findElement(By.xpath("//input[@formcontrolname='roomSearchRange']/following-sibling::button[@class='goBtn']")).click();
		WebElement cell = driver.findElement(By.xpath("//table/tbody/tr/td[contains(text(),"+roomNumber+")]"));
		System.out.println("The newly created room number is"+ cell.getText());
		System.out.println("The newly created room "+roomNumber+" successfully recorded under rooms screen");
		Thread.sleep(2000);	
		driver.findElement(By.xpath("//table/tbody/tr/td[11]/descendant::mat-icon[2]")).click();
		WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-dialog-container/descendant::button[@class='okBtn']")));
		confirmButton.click();
		System.out.println("Successfully delete"+ roomNumber +"newly added room");
		Thread.sleep(2000);	
		driver.navigate().refresh();
		Thread.sleep(2000);	

//		Navigation to sub modules
		WebElement rooms1 = driver.findElement(By.xpath("//span[text()='Rooms']"));
        rooms1.click();
        Thread.sleep(2000);	
        driver.findElement(By.xpath("//a[@ng-reflect-router-link='rooms/room_set']")).click();
        Thread.sleep(2000);	
        driver.findElement(By.xpath("//a[contains(text(),' Bar Commands ')][1]")).click();
        Thread.sleep(2000);	
//        Navigation to Front Desk
        driver.findElement(By.xpath("//span[text()='Front Desk']")).click();
        Thread.sleep(2000);	
        driver.findElement(By.xpath("//a[@ng-reflect-router-link='front-desk/bar_command']")).click();
 
 
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p-button[@icon='pi pi-cog']/following-sibling::button[contains(text(),'Logout')]")));
//		                                 (OR)
//		driver.findElement(By.xpath("//p-button[@icon='pi pi-cog']/following-sibling::button[contains(text(),'Logout')]")).click();
		driver.manage().window().minimize();
		Thread.sleep(2000);
		driver.quit();
		System.out.println("Execution is done THANK YOU");
 
	}
 
}