package PageObjects;

import java.io.File;
import org.openqa.selenium.WebDriver;

import MapsObjects.MapObjectMERCURYhome;


public class PageObjectMERCURYhome extends MapObjectMERCURYhome
{

	public PageObjectMERCURYhome(WebDriver driver) 
	{
		super(driver);
	}


		// METODO INICIAL - URL 
		public void urlAcceso(String url)
		{
			driver.get(url);
		}
		
		
		// 1.METODO PARA ACCEDER A REGISTRAR USUARIO
		public void registrarUsuario(File rutaCarpeta, String generarEvidencia, String firtsname, String lastname, String phone,
				String email, String address, String city, String state, String postalcode, String country, String username, String password, String confrimpass) throws Exception
		{
			tiempoEspera(2);
			ScreenShot(rutaCarpeta, register, generarEvidencia);
			click(register, rutaCarpeta, generarEvidencia);
			
			// RELLENAR LA CAJA DE TEXTO DE FIRTS NAME
			sendkey(firtsname, textBoxFirstName, rutaCarpeta, generarEvidencia); 
			// RELLENAR LA CAJA DE TEXTO DE LAST NAME
			sendkey(lastname, textBoxLastName, rutaCarpeta, generarEvidencia);
			// RELLENAR LA CAJA DE TEXTO DE PHONE
			sendkey(phone, textBoxPhone, rutaCarpeta, generarEvidencia);
			// RELLENAR LA CAJA DE TEXTO DE EMAIL
			sendkey(email, textBoxEmail, rutaCarpeta, generarEvidencia);
			// RELLENAR LA CAJA DE TEXTO DE ADDRESS
			sendkey(address, textBoxAddress, rutaCarpeta, generarEvidencia);
			// RELLENAR LA CAJA DE TEXTO DE CITY
			sendkey(city, textBoxCity, rutaCarpeta, generarEvidencia);
			// RELLENAR LA CAJA DE TEXTO DE STATE
			sendkey(state, textBoxState, rutaCarpeta, generarEvidencia);
			// RELLENAR LA CAJA DE TEXTO DE POSTAL CODE
			sendkey(postalcode, textBoxPostalCode, rutaCarpeta, generarEvidencia);
			// SELECCIONAR PAIS
			click(textBoxCountry, rutaCarpeta, generarEvidencia);
			sendkey(country, textBoxCountry, rutaCarpeta, generarEvidencia);
			// RELLENAR LA CAJA DE TEXTO DE USER NAME
			sendkey(username, textBoxUserName, rutaCarpeta, generarEvidencia);
			// RELLENAR LA CAJA DE TEXTO DE PASSWORD
			sendkey(password, textBoxPassword, rutaCarpeta, generarEvidencia);
			// RELLENAR LA CAJA DE TEXTO DE CONFIRM PASSWORD
			sendkey(confrimpass, textBoxConfirmPassword, rutaCarpeta, generarEvidencia);
			// ENVIAR EL FORMULARIO
			click(btnEnviar, rutaCarpeta, generarEvidencia);
		}
		
}
