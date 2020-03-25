package maven_jenkins_demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class test4 {
	@Test
	public void method4() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\rkreddy\\rkrworkspace\\drivers\\src\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://apps.qaplanet.in/hrm/login.php");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		//verify homepage
		if(driver.getTitle().equals("OrangeHRM - New Level of HR Management")){
		System.out.println("correct title displayed");
		}else
		{
		System.out.println("Incorrect title displayed");
		}
		//verify UN,PWD,Login & clear
		//create webelement
		WebElement objUN = driver.findElement(By.name("txtUserName"));
		WebElement objPWD = driver.findElement(By.name("txtPassword"));
		WebElement objLogin = driver.findElement(By.name("Submit"));
		WebElement objClr = driver.findElement(By.name("clear"));
		if(objUN.isDisplayed()){
		System.out.println("Username present");
		}
		if(objPWD.isDisplayed()){
		System.out.println("Password present");
		}
		if(objLogin.isDisplayed() && objClr.isDisplayed()){
		System.out.println("Login and Clear are present");
		}
		//Enter valid UN,PWD & click on login
		String UN = "qaplanet1";
		String PWD = "lab1";
		objUN.sendKeys(UN);
		objPWD.sendKeys(PWD);
		objLogin.click();
		//verify Orhrm displayed
		if(driver.getTitle().equals("OrangeHRM")){
		System.out.println("Orhrm page displayed correctly");
		}else
		{
		System.out.println("Orhrm page not displayed correctly");
		}
		       //verify Welcome UN,change password and Logout
		String wel = driver.findElement(By.xpath("//ul[@id='option-menu']/li[1]")).getText();
		if(wel.equals("Welcome "+UN)){
		System.out.println("Welcome qaplanet1 displayed");
		}else{
		System.out.println("Welcome UN doesn't displayed");
		}



		WebElement objCP = driver.findElement((By.linkText("Change Password")));
		WebElement objLogout =driver.findElement(By.linkText("Logout"));
		if(objCP.isDisplayed() && objLogout.isDisplayed()){
		System.out.println("CP & Logout are present");
		}
		 //click on logout
		objLogout.click();
		Thread.sleep(2000);
		driver.close();
		driver.quit();

	}

}
