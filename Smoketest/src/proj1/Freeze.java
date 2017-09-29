package proj1;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Freeze {
	

	@Test
	public class Url_check {
	public  WebDriver driver;
	@BeforeTest
	public  void setproperty(){

	System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chromedriver.exe");
	driver = new ChromeDriver();
	
	
	}
	public  void launch(){
		
	
	driver.navigate().to("https://www.mbusa.com/mercedes/index");
	driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	
	}
	 
	 
	@AfterClass
	public  void closedriver(){
	 
	driver.close();
	
	
	}
	public void model() throws Exception{
		
	ArrayList al = new ArrayList();
	ArrayList a2 = new ArrayList();
	ArrayList a3 = new ArrayList();
	int z=1,m=1,n=1,p=1,q=1,s=1;
	for (int r = 0; r<=30; r++){
	z = z+100;
	((JavascriptExecutor)driver).executeScript("scroll(0,"+z+")");
	Thread.sleep(1000);
	}
	
	List<WebElement>linkrl = driver.findElements(By.tagName("a"));//Collecting all URLs from MBUSA home page which includes model page of each of the model
	System.out.println("number of URL"+linkrl.size());
	System.out.println(linkrl);
	
	for(int t=0;t<linkrl.size();t++){
	WebElement el1 = linkrl.get(t);
	String Url = el1.getAttribute("href");//Collecting href attribute of the URL
	if(Url == "null"){
	System.out.println("Null element"+"--------------->"+el1.getText());//If href is null
	}
	al.add(Url);
	}
	
	
	for(int i=0;i<linkrl.size();i++){
	String str = (String) al.get(i);
	try{
	if(str.contains("https://www.mbusa.com/mercedes/vehicles/model/class")){//Checking for the URL which will navigate to model page
	WebDriverWait wait = new WebDriverWait(driver, 500);
	try{
	driver.get(str);
	Thread.sleep(3000); 
	
                   
	z = 0;
	for (int r = 0; r<=5; r++){
	z = z+100;
	((JavascriptExecutor)driver).executeScript("scroll(0,"+z+")");
	Thread.sleep(1000);
	}
	
	
	}
	catch(Exception e){
	System.out.println("Model is not loading properly"+e);
	System.out.println(str);
	}
	
	try{
		String dm = "//div[@id='model-features']/div/div[1]/div[1]/div/a[2]";
		WebElement elx = driver.findElement(By.xpath(dm));
		JavascriptExecutor  exc  =  (JavascriptExecutor)driver;
		exc.executeScript("arguments[0].click();", elx);//Trying to click "View All" button of "Performanace & handling"
		}catch(Exception e){
		System.out.println("View All button missed");	
		System.out.println("element not found Exception"+e);
		
		            
		}
	try{
	String nrl = str.replaceAll("/model/class", "/build/class");//Inserting Build to get build page of the model
	   driver.get(nrl);
	   Thread.sleep(3000);
	   z = 0;
	for (int r = 0; r<=3; r++){
	z = z+100;
	((JavascriptExecutor)driver).executeScript("scroll(0,"+z+")");
	Thread.sleep(1000);
	}
	   
	for (int r = 0; r<=3; r++){
	z = z-100;
	((JavascriptExecutor)driver).executeScript("scroll(0,"+z+")");
	Thread.sleep(1000);
	}
	   
	   try{
	   
		      
		   wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='byo-summary-widget-shop-tools-wrapper']/div/ul/li[4]/button/span"))));
	  
	       //Checking whether the "Save build" button is enabled at hero image section
	   
	   
	   }
	   
	   
	   
	   catch(Exception e){
	     
	     System.out.println("element missed_BYO"+"--------------->"+nrl);
	    
	     
	   }
	 
	
	}
	catch(Exception e){
	System.out.println( e);
	System.out.println("page is not loading_BYO"+"----------->"+str);
	}
	   //Thread.sleep(5000);
	}
	}catch(Exception e){
	System.out.println("element missed");
	System.out.println(al.get(i)+"   "+"is null");
	}
	}

	}


	
	}


	

}
