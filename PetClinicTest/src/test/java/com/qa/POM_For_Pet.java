package com.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class POM_For_Pet 
{
	public void firstName(WebDriver driver)
	{
		WebElement firstName = driver.findElement(By.id("firstName"));
		firstName.click();
		firstName.clear();
		firstName.sendKeys("test_front_end");
	}
	public void lastName(WebDriver driver)
	{
		WebElement firstName = driver.findElement(By.id("lastName"));
		firstName.click();
		firstName.clear();
		firstName.sendKeys("test_front_end");
	}
	public void address(WebDriver driver)
	{
		WebElement firstName = driver.findElement(By.id("address"));
		firstName.click();
		firstName.clear();
		firstName.sendKeys("test_front_end");
	}
	public void city(WebDriver driver)
	{
		WebElement firstName = driver.findElement(By.id("city"));
		firstName.click();
		firstName.clear();
		firstName.sendKeys("test_front_end");
	}
	public void telephone(WebDriver driver)
	{
		WebElement firstName = driver.findElement(By.id("telephone"));
		firstName.click();
		firstName.clear();
		firstName.sendKeys("0");
	}
	public void submit(WebDriver driver)
	{
		WebElement firstName = driver.findElement(By.xpath("/html/body/app-root/app-owner-add/div/div/form/div[7]/div/button[2]"));
		firstName.click();
		
	}
	public void ownersButton(WebDriver driver)
	{
		WebElement firstName = driver.findElement(By.xpath("/html/body/app-root/div[1]/nav/div/ul/li[2]/a"));
		firstName.click();
		
	}
	public void seeAllButton(WebDriver driver)
	{
		WebElement firstName = driver.findElement(By.xpath("/html/body/app-root/div[1]/nav/div/ul/li[2]/ul/li[1]/a"));
		firstName.click();
		
	}
}
