package MapsObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import ClasesBase.ClaseBase;

public class MapObjectMERCURYhome extends ClaseBase
{
	
  public MapObjectMERCURYhome(WebDriver driver) 
    {
		super(driver);
	}
	
  
	// ELEMENTOS DE PAGINA HOME
  
  	protected By register=By.xpath("//td/a[@href='register.php']"); // LINK DE REGISTER
  
	protected By textBoxFirstName=By.xpath("//*[@name='firstName']"); // CAJA DE TEXTO FIRST NAME
	protected By textBoxLastName=By.xpath("//*[@name='lastName']"); // CAJA DE TEXTO LAST NAME
	protected By textBoxPhone=By.xpath("//*[@name='phone']"); // CAJA DE TEXTO PHONE
	protected By textBoxEmail=By.id("userName"); // CAJA DE TEXTO EMAIL
	protected By textBoxAddress=By.xpath("//*[@name='address1']"); // CAJA DE TEXTO ADDRES
	protected By textBoxCity=By.xpath("//*[@name='city']"); // CAJA DE TEXTO CITY
	protected By textBoxState=By.xpath("//*[@name='state']"); // CAJA DE TEXTO STATE
	protected By textBoxPostalCode=By.xpath("//*[@name='postalCode']"); // CAJA DE TEXTO POSTAL CODE
//	protected By textBoxCountry=By.xpath("//select/option[@value='COLOMBIA']"); // CAJA DE TEXTO COUNTRY
	protected By textBoxCountry=By.xpath("//*[@name='country']"); // CAJA DE TEXTO COUNTRY
	protected By textBoxUserName=By.id("email"); // CAJA DE TEXTO USER NAME
	protected By textBoxPassword=By.xpath("//*[@name='password']"); // CAJA DE TEXTO PASSWORD
	protected By textBoxConfirmPassword=By.xpath("//*[@name='confirmPassword']"); // CAJA DE TEXTO CONFIRM PASSWORD
	protected By btnEnviar=By.xpath("//*[@name='submit']"); // BOTON DE ENVIAR
}
