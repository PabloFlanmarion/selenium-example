package br.example;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author Pablo
 *
 */
public class WaitUtil {

	/**
	 * 
	 * @param driver
	 * @param byElement
	 * @param timeWait
	 * @return
	 */
	public static WebElement explicitWait(WebDriver driver, By byElement, Long timeWait) {
		return new WebDriverWait(driver, timeWait).until(ExpectedConditions.elementToBeClickable(byElement));
	}

	/**
	 * 
	 * @param driver
	 * @param timeWait
	 */
	public static void implicitWait(WebDriver driver, int timeWait) {
		driver.manage().timeouts().implicitlyWait(timeWait, TimeUnit.SECONDS);
	}

	/**
	 * 
	 * @param driver
	 * @param byElement
	 * @return
	 */
	public static WebElement fluentWait(WebDriver driver, By byElement) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		return wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(byElement);
			}
		});
	}

}