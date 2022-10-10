package MapsObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import ClasesBase.ClaseBase;

public class MapObjectTOOLSQAwidgets extends ClaseBase
{
	
  public MapObjectTOOLSQAwidgets(WebDriver driver) 
    {
		super(driver);
	}
	
  
	// ELEMENTOS DE PAGINA ALERTS FRAME Y WINDOWS

	protected By btnDatePicker=By.xpath("//*[@id='item-2']/span[text()='Date Picker']"); // BOTON DATEPICKER DE LA LISTA WIDGETS
	protected By boxDate=By.id("datePickerMonthYearInput"); // CAJA DE SELECCIONAR FECHA
	protected By selectMes=By.xpath("//*[@id='datePickerMonthYear']/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select/option"); // SELECCIONADOR DEL MES
	protected By selectAño=By.xpath("//*/select[@class='react-datepicker__year-select']/option"); // SELECCIONADOR DEL AÑO
	protected By selectAño3=By.xpath("//*/select[@class='react-datepicker__year-select']"); // SELECCIONADOR DEL AÑO
	protected By selectDia=By.xpath("//*[@class='react-datepicker__day react-datepicker__day--008']"); // SELECCIONADOR DEL AÑO
	protected By boxDateAndTime=By.id("dateAndTimePickerInput"); // CAJA DE FECHA Y HORA
	protected By volverAtrasMes=By.xpath("//*[@class='react-datepicker__navigation react-datepicker__navigation--previous']");
	protected By selectDia2=By.xpath("//*[@class='react-datepicker__day react-datepicker__day--008']"); // SELECCIONAR EL DIA 8 DEL MES DE AGOSTO 2022
	protected By selectHora=By.xpath("//*[@class='react-datepicker__time-list-item '][text()='10:00']"); // SELECCIONAR LA HORA
	protected By listHora=By.xpath("//*[@class='react-datepicker__time-list']"); // LISTA DE HORAS
	
}
