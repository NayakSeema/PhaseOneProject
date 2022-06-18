package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class logintest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		
		WebElement search = driver.findElement(By.xpath("//input[@id = 'twotabsearchtextbox']"));
		search.sendKeys("iphone 12");
		
		WebElement clicksearch = driver.findElement(By.xpath("//input[@id = 'nav-search-submit-button']"));
		clicksearch.click();
		
    	List<WebElement> text = driver.findElements(By.xpath("//span[@class = 'a-size-medium a-color-base a-text-normal']"));
		List<WebElement> price = driver.findElements(By.xpath("//span[@class = 'a-price-whole']"));
		
		HashMap<String,String> values = new HashMap<String,String>();
		
		System.out.println(text.size());
		for (int i = 0;i<=price.size()-1;i++)
		{
			if (text.get(i).getText().contains("Apple iPhone 12")) {
				values.put(text.get(i).getText(),price.get(i).getText());				
			}
		}
		
		for(Map.Entry<String, String> entity1 :values.entrySet())		
		{
			System.out.println(entity1.getKey() + " "+entity1.getValue());
		}
		
	driver.close();
		
	}

}
