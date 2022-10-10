package PageObjects;

import java.io.File;
import org.openqa.selenium.WebDriver;

import MapsObjects.MapObjectMERcrearCuenta;


public class PageObjectMERcrearCuenta extends MapObjectMERcrearCuenta
{

	public PageObjectMERcrearCuenta(WebDriver driver) 
	{
		super(driver);
	}


		// METODO INICIAL - URL 
		public void urlAcceso(String url)
		{
			driver.get(url);
		}
		
		
		// 1.METODO PARA LA BUSQUEDA Y SELECCION DE PRODUCTO
		public void crearCuenta(String email, File rutaCarpeta, String generarEvidencia) throws Exception
		{
			
			//ACEPTAR TERMINOS Y CONDICIONES
			tiempoEspera(2);
			click(clickTerminosCondiciones, rutaCarpeta, generarEvidencia);
			
			// BOTON CONTINUAR
			tiempoEspera(2);
			click(clickContinuar, rutaCarpeta, generarEvidencia);
			
			// BOTON VALIDAR
			tiempoEspera(2);
			click(clickValidarEmail, rutaCarpeta, generarEvidencia);
			
			// ENVIAR EMAIL
			tiempoEspera(2);
			sendkey(email,txtCajaEmail, rutaCarpeta, generarEvidencia);
			tiempoEspera(2);
			
			
			// CONFIRMACIÓN
			System.out.println("EL METODO DE CREAR CUENTA HA CULMINADO CORRECTAMENTE");
		}
}
