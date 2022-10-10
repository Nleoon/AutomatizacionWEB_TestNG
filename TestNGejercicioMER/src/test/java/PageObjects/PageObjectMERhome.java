package PageObjects;

import java.io.File;
import org.openqa.selenium.WebDriver;
import MapsObjects.MapObjectMERhome;


public class PageObjectMERhome extends MapObjectMERhome
{

	public PageObjectMERhome(WebDriver driver) 
	{
		super(driver);
	}


		// METODO INICIAL - URL 
		public void urlAcceso(String url)
		{
			driver.get(url);
		}
		
		
		// 1.METODO PARA LA BUSQUEDA Y SELECCION DE PRODUCTO
		public void busquedaProducto(String producto, File rutaCarpeta, String generarEvidencia) throws Exception
		{
			// LIMPIAR LA CAJA DE BUSQUEDA
			borrar(txtCajaBusqueda, rutaCarpeta, generarEvidencia);
			
			// ENVIAR EL VALOR A BUSCAR
			sendkey(producto,txtCajaBusqueda, rutaCarpeta, generarEvidencia);
			submit(txtCajaBusqueda, rutaCarpeta, generarEvidencia);
			tiempoEspera(2);
			
			// ACEPTAR LAS COOKIES
			click(clickAceptarCookies, rutaCarpeta, generarEvidencia);
			
			// CERRAR VENTANA DE UBICACION
			click(clickCerrarUbicacion, rutaCarpeta, generarEvidencia);
			
			// SELECCIONAR PRODUCTO
			click(clickPrimerProducto, rutaCarpeta, generarEvidencia);
			tiempoEspera(1);
			
			// AGREGAR AL CARRITO
			click(clickAgregarCarrito, rutaCarpeta, generarEvidencia);	
			
			//BOTON DE CREAR CUENTA
			tiempoEspera(2);
			click(clickCrearCuenta, rutaCarpeta, generarEvidencia);
						
			// CONFIRMACIÓN
			System.out.println("EL METODO DE BUSQUEDA PRODUCTO HA CULMINADO CORRECTAMENTE");
		}
		
		// 2.METODO CREAR CUENTA DESDE HOME
		public void creaTuCuenta(File rutaCarpeta, String generarEvidencia) throws Exception
		{
			// CAPTURA DE PANTALLA INICIO
//			ScreenShot(rutaCarpeta, clickCreaTuCuenta, generarEvidencia);
			
			// CLICK EN EL BOTON DEL NAVBAR - CREA TU CUENTA
			tiempoEspera(2);
			click(clickCreaTuCuenta, rutaCarpeta, generarEvidencia);
			
			// ACEPTAR LAS COOKIES
			tiempoEspera(1);
			click(clickAceptarCookies, rutaCarpeta, generarEvidencia);
									
			// CONFIRMACIÓN
			System.out.println("EL METODO DE CREA TU CUENTA HA CULMINADO CORRECTAMENTE");
		}
}
