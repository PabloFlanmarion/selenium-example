package br.example.base;

import java.io.IOException;
import java.util.Set;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;

import br.example.util.takescreenshot.SeleniumTakeScreenshotUtil;

public class SeleniumMain {

	private static Logger log = Logger.getLogger(SeleniumMain.class.getName());

	public static void main(String[] args) {
		try {
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
			WebDriver driver = new ChromeDriver(chromeOptions);

			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();

			driver.get("https://selenium.dev");

			SeleniumTakeScreenshotUtil.getScreenshotPage(driver, "teste");
			SeleniumTakeScreenshotUtil.getScreenshotElement(driver.findElement(By.linkText("Downloads")), "download");
			
		} catch (IOException e) {
			log.info(e.getCause().toString());
			log.info(e.getMessage());
		}
	}
}
