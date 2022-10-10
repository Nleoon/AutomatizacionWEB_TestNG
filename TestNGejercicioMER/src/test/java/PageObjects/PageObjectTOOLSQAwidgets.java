package PageObjects;

import java.io.File;
import java.time.LocalDate;
import java.time.Month;

import org.openqa.selenium.WebDriver;
import MapsObjects.MapObjectTOOLSQAwidgets;


public class PageObjectTOOLSQAwidgets extends MapObjectTOOLSQAwidgets
{

	public PageObjectTOOLSQAwidgets(WebDriver driver) 
	{
		super(driver);
	}
		
		// 1.METODO PARA INICIAR PRUEBA DE ALERTS
		public void pruebaWidgets(File rutaCarpeta, String generarEvidencia) throws Exception
		{
			// CLICK PARA ACCEDER AL APARTADO DE ALERTS
			scrollWeb(300, 1);
			ScreenShot(rutaCarpeta, btnDatePicker, generarEvidencia);
			click(btnDatePicker, rutaCarpeta, generarEvidencia);
			
			// SE ALMACENA LA NUEVAFECHA
			String fechaFinal = widgetsPruebaFecha(1, 1, 1, rutaCarpeta);
			tiempoEspera(1);
		System.out.println(fechaFinal);
			
			// SE BORRA LA FECHA PREDETERMINADA
			reemplazar(boxDate, rutaCarpeta, generarEvidencia);
			// SE ENVIA LA NUEVA FECHA 
			sendkey(fechaFinal, boxDate, rutaCarpeta, generarEvidencia);
			// SE DA ENTER PARA GUARDAR LA FECHA ENVIADA
			enter(boxDate, rutaCarpeta, generarEvidencia);
			
			
			// SEGUNDA FECHA A MANDAR
			// CLICK EN EL BOX DE LA FECHA
			click(boxDateAndTime, rutaCarpeta, generarEvidencia);
			// SE BORRA LA FECHA PREDETERMINADA
			reemplazar(boxDateAndTime, rutaCarpeta, generarEvidencia);
			// SE ALMACENA EL MES EN LETRA
			Month mesLetra= LocalDate.now().minusMonths(1).getMonth();
		System.out.println(mesLetra);
		
			// SE ALMACENA EL DIA Y EL AÑO DE LA HORA LOCAL 
			String fechaDiaAño = widgetsPruebaFechaSinMes(1, 1, rutaCarpeta);
			// SE ALAMACENA LA HORA ACTUAL
			String horaActual = HoraSistema();
			// SE CONCADENA EL MES DE LETRA MAS EL DIA Y EL AÑO
			String fechaFinal2 = mesLetra + fechaDiaAño + " " + horaActual;
			tiempoEspera(1);
			
			// SE ENVIA LA FECHA CONCADENADA AL BOX DE LA SEGUNDA FECHA
			sendkey(fechaFinal2, boxDateAndTime, rutaCarpeta, generarEvidencia);
			tiempoEspera(2);
			// LISTA DE HORA
						
			enter(boxDateAndTime, rutaCarpeta, generarEvidencia);
			tiempoEspera(2);

		}
		
}
