package MapsObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import ClasesBase.ClaseBase;

public class MapObjectMERhome extends ClaseBase
{
	
  public MapObjectMERhome(WebDriver driver) 
    {
		super(driver);
	}
	
	// ELEMENTOS DE PAGINA HOME
	
	protected By txtCajaBusqueda=By.xpath("//*[@class='nav-search-input']"); //CAJA DE BUSQUEDA MERCADO LIBRE
	protected By clickAceptarCookies=By.xpath("//*[@class='cookie-consent-banner-opt-out__action cookie-consent-banner-opt-out__action--primary cookie-consent-banner-opt-out__action--key-accept']"); //COOKIES       
	protected By clickCerrarUbicacion=By.xpath("//*[@class='andes-tooltip-button-close']"); //VENTANA EMERGENTE UBICACION
	protected By clickProducto=By.xpath("//img[@src='https://http2.mlstatic.com/D_NQ_NP_950383-MCO50188050642_062022-V.webp']"); // PRODCUTO MERCADO LIBRE
	protected By clickAgregarCarrito=By.xpath("//*[@class='andes-button andes-spinner__icon-base andes-button--quiet']"); // BOTON AGREGAR AL CARRITO
//	protected By clickCrearCuenta=By.xpath("//*[@class='andes-button andes-button--large andes-button--loud andes-button--full-width']"); // BOTON CREAR CUENTA
	protected By clickCreaTuCuenta=By.xpath("//*[@data-link-id='registration']");
	protected By clickPrimerProducto=By.xpath("//img[@class='ui-search-result-image__element shops__image-element']"); // PRIMER PRODCUTO DEL RESULTADO DE BUSQUEDA - MERCADO LIBRE

	protected By clickCrearCuenta=By.xpath("//*[@id='registration-link']"); // BOTON CREAR CUENTA
}
