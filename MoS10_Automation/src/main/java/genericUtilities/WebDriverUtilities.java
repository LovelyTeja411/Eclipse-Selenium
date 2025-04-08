package genericUtilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class WebDriverUtilities {
	public void impliciteWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
}
