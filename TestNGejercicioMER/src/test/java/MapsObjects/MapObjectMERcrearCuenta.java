package MapsObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import ClasesBase.ClaseBase;

public class MapObjectMERcrearCuenta extends ClaseBase
{
	
  public MapObjectMERcrearCuenta(WebDriver driver) 
    {
		super(driver);
	}
	
	// ELEMENTOS DE PAGINA HOME
	
	protected By clickCrearCuenta=By.xpath("//*[@id='registration-link']"); // BOTON CREAR CUENTA
	protected By clickTerminosCondiciones=By.xpath("//*[@id='terms-and-conds']"); // TERMINOS Y CONDICIONES
	protected By clickContinuar=By.xpath("//*[@class='andes-button__content']"); // BOTON CONTINUAR
	protected By clickValidarEmail=By.xpath("//*[@class='andes-button__content']"); // BOTON VALIDAR EMAIL
	protected By txtCajaEmail=By.xpath("//*[@class='andes-form-control__field']"); // CAJA DE TEXTO EMAIL


}
