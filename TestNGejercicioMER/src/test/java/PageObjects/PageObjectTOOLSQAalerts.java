package PageObjects;

import java.io.File;
import org.openqa.selenium.WebDriver;
import MapsObjects.MapObjectTOOLSQAalerts;



public class PageObjectTOOLSQAalerts extends MapObjectTOOLSQAalerts
{

	public PageObjectTOOLSQAalerts(WebDriver driver) 
	{
		super(driver);
	}


		// METODO INICIAL - URL 
		public void urlAcceso(String url)
		{
			driver.get(url);
		}
		
		
		// 1.METODO PARA INICIAR PRUEBA DE ALERTS
		public void pruebaAlerts(String textPromptBox, File rutaCarpeta, String generarEvidencia) throws Exception
		{
			// SCROLL DE PAGINA
		    scrollWeb(200, 1);
		    ScreenShot(rutaCarpeta, btnAlerts, generarEvidencia);
		    
			// CLICK PARA ACCEDER AL APARTADO DE ALERTS
			click2(btnAlerts, rutaCarpeta, generarEvidencia);
			
			// CLICK EN EL PRIMER BOTON DE ALERTA
			click2(btnAlertButton1, rutaCarpeta, generarEvidencia);	
			tiempoEspera(2);
			// ACEPTAR LA ALERTA
			driver.switchTo().alert().accept();		
			tiempoEspera(1);
						
			// CLICK EN EL SEGUNDO BOTON DE ALERTA
			click2(btnAlertButton2, rutaCarpeta, generarEvidencia);
			tiempoEspera(6);
			driver.switchTo().alert().accept();	
						
			// CLICK EN EL TERCER BOTON DE ALERTA - ACEPTAR
			click2(btnAlertButton3, rutaCarpeta, generarEvidencia);
			driver.switchTo().alert().accept();	
			tiempoEspera(2);
					
			// SCROLL DE PAGINA
		    scrollWeb(120, 1);
			
			// CLICK EN EL TERCER BOTON DE ALERTA - CANCELAR
			click2(btnAlertButton3, rutaCarpeta, generarEvidencia);
			driver.switchTo().alert().dismiss();
			tiempoEspera(2);
						
			// CLICK EN EL CUARTO BOTON DE ALERTA Y ENVIO DE INFORMACION
			click2(btnAlertButton4, rutaCarpeta, generarEvidencia);
			driver.switchTo().alert().sendKeys(textPromptBox);
			tiempoEspera(2);
			driver.switchTo().alert().accept();	
			tiempoEspera(2);
						
			// SCREENSHOT
			ScreenShot(rutaCarpeta, btnAlertButton4, generarEvidencia);

		}
		
}
