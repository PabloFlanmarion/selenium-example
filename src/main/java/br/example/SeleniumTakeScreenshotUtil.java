package br.example;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 
 * @author Pablo
 *
 */
public class SeleniumTakeScreenshotUtil {

	/**
	 * Recupera uma imagem da página.
	 * 
	 * @param driver
	 * @param nomePrint
	 * @throws IOException
	 */
	public static void getScreenshotPage(WebDriver driver, String nomePrint) throws IOException {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("C:\\PRINT_SELENIUM\\" + nomePrint + ".jpg"));
	}

	/**
	 * Recupera uma imagem do elemento em evidência.
	 * 
	 * 
	 * @param webElement
	 * @param nomePrint
	 * @throws IOException
	 */
	public static void getScreenshotElement(WebElement webElement, String nomePrint) throws IOException {
		File file = webElement.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("C:\\PRINT_SELENIUM\\" + nomePrint + ".jpg"));
	}
}
