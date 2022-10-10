package PageObjects;

import java.io.File;
import org.openqa.selenium.WebDriver;
import MapsObjects.MapObjectTOOLSQAhome;


public class PageObjectTOOLSQAhome extends MapObjectTOOLSQAhome
{

	public PageObjectTOOLSQAhome(WebDriver driver) 
	{
		super(driver);
	}


		// METODO INICIAL - URL 
		public void urlAcceso(String url)
		{
			driver.get(url);
		}
		
		
		// 1.METODO PARA INGRESAR A ALERTS, FRAME Y WINDOWS - ALERTS
		public void alertsFrameWindows(File rutaCarpeta, String generarEvidencia) throws Exception
		{
			// SCROLL DE PAGINA
		    scrollWeb(200, 1);
		    // TIEMPO DE ESPERA PARA VISUALIZAR
		    tiempoEspera(2);	    
			// CLICK PARA ACCEDER AL FORMULARIO DE REGISTRAR USUARIO
			click(cardAlertsFrameWindows, rutaCarpeta, generarEvidencia);
						
			// CONFIRMACIÓN
			System.out.println("EL METODO PARA INGRESAR A ALERTS, FRAME Y WINDOWS - ALERTS");
		}
		
		
		
		// 2.METODO PARA INGRESAR A WIDGETS - DATE PICKER
		public void widgets(File rutaCarpeta, String generarEvidencia) throws Exception
		{
			// SCROLL DE PAGINA
		    scrollWeb(200, 1);
		    // TIEMPO DE ESPERA PARA VISUALIZAR
		    tiempoEspera(2);	    
			// CLICK PARA ACCEDER AL FORMULARIO DE REGISTRAR USUARIO
			click(cardWidgets, rutaCarpeta, generarEvidencia);
			
			// CONFIRMACIÓN
			System.out.println("EL METODO PARA INGRESAR A WIDGETS - DATE PICKER");
		}
}
