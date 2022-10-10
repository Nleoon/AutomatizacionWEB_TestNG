package RunPruebas;

import org.testng.annotations.Test;

import ClasesBase.ClaseBase;
import PageObjects.PageObjectMERCURYhome;
import PageObjects.PageObjectMERcrearCuenta;
import PageObjects.PageObjectMERhome;
import PageObjects.PageObjectTOOLSQAalerts;
import PageObjects.PageObjectTOOLSQAhome;
import PageObjects.PageObjectTOOLSQAwidgets;
import Utilidades.ExcelUtilidades;
import Utilidades.GenerarReportePdf;
import Utilidades.MyScreenRecorder;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class RunPrueba {

	// INSTANCIAS
	WebDriver driver;
	ClaseBase clasebase;
	
	// MERCADOLIBRE -->
	PageObjectMERhome MercadolibreHome;
	PageObjectMERcrearCuenta MercadolibreCrearCuenta;
	
	// TOOLS QA -->
	PageObjectTOOLSQAhome toolsQAhome;
	PageObjectTOOLSQAalerts toolsQAalerts;
	PageObjectTOOLSQAwidgets toolsQAwidgets;
	
	// MERCURY TOURS -->
	PageObjectMERCURYhome mercuryHome;
	
	// PDF -->
	GenerarReportePdf generarPDF;
	String rutaImagenTools;
	String rutaImagenMercury;
	
	
	

  @BeforeClass
  @Parameters({"rutaImagenReporteMER","logoToolsQA","logoMercury"})
  public void beforeClass(@Optional("default") String rutaImagenReporteMER,
		  				  @Optional("default") String logoToolsQA,
		  				  @Optional("default") String logoMercury) throws IOException
  {	  
	  // INSTANCIAR LAS CLASES -->
	  
	  // MERCADOLIBRE -->
	  // CLASE BASE - (ScreenShots)
	  clasebase = new ClaseBase(driver);
	  // INSTANCIAR LA CLASE PAGEOBJECT-MER HOME
	  MercadolibreHome = new PageObjectMERhome(driver);
	  // INSTANCIAR LA CLASE PAGEOBJECT-MER CREAR CUENTA
	  MercadolibreCrearCuenta = new PageObjectMERcrearCuenta(driver);
	  	  
	  // TOOLSQA -->
	  toolsQAhome = new PageObjectTOOLSQAhome(driver);
	  toolsQAalerts = new PageObjectTOOLSQAalerts(driver);
	  toolsQAwidgets = new PageObjectTOOLSQAwidgets(driver);
	  
	  // MERCURY TOURS -->
	  mercuryHome = new  PageObjectMERCURYhome(driver);
	  	  
	  // INSTANCIAR LA CLASE DE GENERAR PDF
	  generarPDF = new GenerarReportePdf();	  
	  //SETIAR LA IMAGEN DEL ENCABEZADO PARA REPORTE PDF
	  generarPDF.setRutaImagen(rutaImagenReporteMER);
	  rutaImagenTools = logoToolsQA;
	  rutaImagenMercury = logoMercury;
  }
  
  

  // PRIMER TEST ->>
  @DataProvider(name = "busqueda")
  public Object[][] datos() throws Exception
  {
	  Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/mercadolibreExcel.xlsx", "mercadolibre");
	  return arreglo;
  }
  
 
  @Test(priority = 1, dataProvider = "busqueda", description="Buscar producto, añadir el primer resultado y crear cuenta")
  public void agregarAlCarrito(String url, String producto, String email, String ejecutarCaso, String generarEvidencia) throws Exception 
  {
	  if(ejecutarCaso.equals("SI")) {
		  
		  // ASIGNAMOS LAS OPCIONES Y LA CONFIGURACION DEL NAVEGADOR A LA VARIABLE DRIVER
		  driver = ClaseBase.chromeDriverConnetion();
		  	
		  	// CONFIRMACION
		    System.out.println("COMIENZA EL PROCESO DE AUTOMATIZACION");
		  
			// OBTENER EL NOMBRE DEL TEST - (ScreenShot's)
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			// CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
			File rutaCarpeta = clasebase.crearCarpeta(nomTest);
			
			if(generarEvidencia.equals("SI")) {
				
				
				  // INICIAR LA CREACION DE LA PLANTILLA PDF
				  generarPDF.crearPlantilla(nomTest, rutaCarpeta);
				  
				  
				  // INICIAR LA GRABACION DE VIDEO
				  MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
				  				  
				  
				  // LLAMADO DE METODOS ->>
				  MercadolibreHome.urlAcceso(url);
				  MercadolibreHome.busquedaProducto(producto, rutaCarpeta, generarEvidencia);
				  MercadolibreCrearCuenta.crearCuenta(email, rutaCarpeta, generarEvidencia);
				  
				  
				  // FINALIZAR LA GRABACION DE VIDEO
				  MyScreenRecorder.stopRecording();
				  
				  // TERMINAR LA CREACION DE LA PLANTILLA
				  generarPDF.cerrarPlantilla();
				  
				  // TERMINAR
				  driver.close();
				
				} else {
				
					// CONFIRMACION
					System.out.println("LA AUTOMATIZACION SE EJECUTARA SIN GENERAR EVIDENCIA");
					// LLAMADO DE METODOS ->>
					MercadolibreHome.urlAcceso(url);
					MercadolibreHome.busquedaProducto(producto, rutaCarpeta, generarEvidencia);
					MercadolibreCrearCuenta.crearCuenta(email, rutaCarpeta, generarEvidencia);	
					
					// TERMINAR
					driver.close();
				}
			  			
	  } else {
		  System.out.println("LA AUTOMATIZACION NO SE EJECUTARA, VALIDAR EL CAMPO 'EJECUTAR CASO' EN EL EXCEL");
	  }	
  }
 
  
 
  // SEGUNDO TEST ->>
  @DataProvider(name = "busquedaExcelCrearCuentaHome")
  public Object[][] datosCrearCuentaHome() throws Exception
  {
	  Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/mercadolibreExcel.xlsx", "creaTuCuentaHome");
	  return arreglo;
  }
  
  @Test(priority = 2, dataProvider = "busquedaExcelCrearCuentaHome", description="Crear cuenta desde Home")
  public void crearCuentaHome(String ejecutarCaso, String generarEvidencia, String url, String email) throws Exception 
  {
	  if(ejecutarCaso.equals("SI")) {
		  	
		  // ASIGNAMOS LAS OPCIONES Y LA CONFIGURACION DEL NAVEGADOR A LA VARIABLE DRIVER
		  driver = ClaseBase.chromeDriverConnetion();
		  
		  	// CONFIRMACION
		    System.out.println("COMIENZA EL PROCESO DE AUTOMATIZACION CREAR CUENTA HOME");
		  
			// OBTENER EL NOMBRE DEL TEST - (ScreenShot's)
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			// CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
			File rutaCarpeta = clasebase.crearCarpeta(nomTest);
			
			if(generarEvidencia.equals("SI")) {
				
				
				  // INICIAR LA CREACION DE LA PLANTILLA PDF
				  generarPDF.crearPlantilla(nomTest, rutaCarpeta);
				  
				  
				  // INICIAR LA GRABACION DE VIDEO
				  MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
				  				  
				  
				  // LLAMADO DE METODOS ->>
				  MercadolibreHome.urlAcceso(url);
				  MercadolibreHome.creaTuCuenta(rutaCarpeta, generarEvidencia);
				  MercadolibreCrearCuenta.crearCuenta(email, rutaCarpeta, generarEvidencia);
				   
				  
				  // FINALIZAR LA GRABACION DE VIDEO
				  MyScreenRecorder.stopRecording();
				  
				  // TERMINAR LA CREACION DE LA PLANTILLA
				  generarPDF.cerrarPlantilla();
				  
				  // TERMINAR
				  driver.close();
				
				} else {
				
					// CONFIRMACION
					System.out.println("LA AUTOMATIZACION SE EJECUTARA SIN GENERAR EVIDENCIA");
					// LLAMADO DE METODOS ->>
					MercadolibreHome.urlAcceso(url);
					MercadolibreHome.creaTuCuenta(rutaCarpeta, generarEvidencia);
					MercadolibreCrearCuenta.crearCuenta(email, rutaCarpeta, generarEvidencia);	
					
					// TERMINAR
					 driver.close();
				}
			  			
	  } else {
		  System.out.println("LA AUTOMATIZACION NO SE EJECUTARA, VALIDAR EL CAMPO 'EJECUTAR CASO' EN EL EXCEL");
	  }	
  }

  
  // TERCER TEST - TOOLS QA ->>
  @DataProvider(name = "busquedaExcelAlerts")
  public Object[][] datosAlerts() throws Exception
  {
	  Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/mercadolibreExcel.xlsx", "toolsQAalerts");
	  return arreglo;
  }
  
  @Test(priority = 3, dataProvider = "busquedaExcelAlerts", description="Prueba de Alertas en ToolsQA")
  public void pruebaAlerts(String ejecutarCaso, String generarEvidencia, String url, String textPromptBox) throws Exception 
  {
	  if(ejecutarCaso.equals("SI")) {
		  	  		  			  
		  // ENVIAMOS LA IMAGEN DE ENCABEZADO DEL PDF
		  generarPDF.setRutaImagen(rutaImagenTools);
		  
		  // ASIGNAMOS LAS OPCIONES Y LA CONFIGURACION DEL NAVEGADOR A LA VARIABLE DRIVER
		  driver = ClaseBase.chromeDriverConnetion();
		  
		  	// CONFIRMACION
		    System.out.println("COMIENZA EL PROCESO DE AUTOMATIZACION PRUEBA ALERTS");
		  
			// OBTENER EL NOMBRE DEL TEST - (ScreenShot's)
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			// CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
			File rutaCarpeta = clasebase.crearCarpeta(nomTest);
			
			if(generarEvidencia.equals("SI")) {
				
				
				  // INICIAR LA CREACION DE LA PLANTILLA PDF
				  generarPDF.crearPlantilla(nomTest, rutaCarpeta);
				  
				  
				  // INICIAR LA GRABACION DE VIDEO
				  MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
				  				  
				  
				  // LLAMADO DE METODOS ->>
				  toolsQAhome.urlAcceso(url);
				  toolsQAhome.alertsFrameWindows(rutaCarpeta, generarEvidencia);
				  toolsQAalerts.pruebaAlerts(textPromptBox, rutaCarpeta, generarEvidencia);

				   				  
				  // FINALIZAR LA GRABACION DE VIDEO
				  MyScreenRecorder.stopRecording();
				  
				  // TERMINAR LA CREACION DE LA PLANTILLA
				  generarPDF.cerrarPlantilla();
				  
				  // TERMINAR
				  driver.close();
				
				} else {
				
					// CONFIRMACION
					System.out.println("LA AUTOMATIZACION SE EJECUTARA SIN GENERAR EVIDENCIA");
					
					  // LLAMADO DE METODOS ->>
					  toolsQAhome.urlAcceso(url);
					  toolsQAhome.alertsFrameWindows(rutaCarpeta, generarEvidencia);
					  toolsQAalerts.pruebaAlerts(textPromptBox, rutaCarpeta, generarEvidencia);
					
					// TERMINAR
					 driver.close();
				}
			  			
	  } else {
		  System.out.println("LA AUTOMATIZACION NO SE EJECUTARA, VALIDAR EL CAMPO 'EJECUTAR CASO' EN EL EXCEL");
	  }	
  }
  
 
  // CUARTO TEST - TOOLS QA ->>
  @DataProvider(name = "busquedaExcelWidgets")
  public Object[][] datosWidgets() throws Exception
  {
	  Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/mercadolibreExcel.xlsx", "toolsQAwidgets");
	  return arreglo;
  }
  
  @Test(priority = 4, dataProvider = "busquedaExcelWidgets", description="Prueba de Widgets en ToolsQA")
  public void pruebaWidgets(String ejecutarCaso, String generarEvidencia, String url) throws Exception 
  {
	  if(ejecutarCaso.equals("SI")) {
		  
		  // ENVIAMOS LA IMAGEN DE ENCABEZADO DEL PDF
		  generarPDF.setRutaImagen(rutaImagenTools);
		  	  		  			  
		  // ASIGNAMOS LAS OPCIONES Y LA CONFIGURACION DEL NAVEGADOR A LA VARIABLE DRIVER
		  driver = ClaseBase.chromeDriverConnetion();
		  
		  	// CONFIRMACION
		    System.out.println("COMIENZA EL PROCESO DE AUTOMATIZACION PRUEBA WIDGETS");
		  
			// OBTENER EL NOMBRE DEL TEST - (ScreenShot's)
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			// CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
			File rutaCarpeta = clasebase.crearCarpeta(nomTest);
			
			if(generarEvidencia.equals("SI")) {
				
				
				  // INICIAR LA CREACION DE LA PLANTILLA PDF
				  generarPDF.crearPlantilla(nomTest, rutaCarpeta);
				  
				  
				  // INICIAR LA GRABACION DE VIDEO
				  MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
				  				  
				  
				  // LLAMADO DE METODOS ->>
				  toolsQAhome.urlAcceso(url);
				  toolsQAhome.widgets(rutaCarpeta, generarEvidencia);
				  toolsQAwidgets.pruebaWidgets(rutaCarpeta, generarEvidencia);

				   				  
				  // FINALIZAR LA GRABACION DE VIDEO
				  MyScreenRecorder.stopRecording();
				  
				  // TERMINAR LA CREACION DE LA PLANTILLA
				  generarPDF.cerrarPlantilla();
				  
				  // TERMINAR
				  driver.close();
				
				} else {
				
					// CONFIRMACION
					System.out.println("LA AUTOMATIZACION SE EJECUTARA SIN GENERAR EVIDENCIA");
					
					  // LLAMADO DE METODOS ->>
					  toolsQAhome.urlAcceso(url);
					  toolsQAhome.widgets(rutaCarpeta, generarEvidencia);
					  toolsQAwidgets.pruebaWidgets(rutaCarpeta, generarEvidencia);
					
					// TERMINAR
					 driver.close();
				}
			  			
	  } else {
		  System.out.println("LA AUTOMATIZACION NO SE EJECUTARA, VALIDAR EL CAMPO 'EJECUTAR CASO' EN EL EXCEL");
	  }	
  }
  
 
  
//QUINTO TEST - TOOLS QA ->>
 @DataProvider(name = "busquedaExcelMercury")
 public Object[][] datosMercury() throws Exception
 {
	  Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/mercadolibreExcel.xlsx", "mercuryTours");
	  return arreglo;
 }
 
 @Test(priority = 5, dataProvider = "busquedaExcelMercury", description="Prueba de formulario MercuryTours")
 public void pruebaMercury(String ejecutarCaso, String generarEvidencia, String url, String firtsname, String lastname, String phone,
	String email, String address, String city, String state, String postalcode, String country, String username, String password, String confrimpass) throws Exception 
 {
	  if(ejecutarCaso.equals("SI")) {
		  
		  // ENVIAMOS LA IMAGEN DE ENCABEZADO DEL PDF
		  generarPDF.setRutaImagen(rutaImagenMercury);
		  	  		  			  
		  // ASIGNAMOS LAS OPCIONES Y LA CONFIGURACION DEL NAVEGADOR A LA VARIABLE DRIVER
		  driver = ClaseBase.chromeDriverConnetion();
		  
		  	// CONFIRMACION
		    System.out.println("COMIENZA EL PROCESO DE AUTOMATIZACION PARA MERCURYTOURS");
		  
			// OBTENER EL NOMBRE DEL TEST - (ScreenShot's)
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			// CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
			File rutaCarpeta = clasebase.crearCarpeta(nomTest);
			
			if(generarEvidencia.equals("SI")) {
				
				
				  // INICIAR LA CREACION DE LA PLANTILLA PDF
				  generarPDF.crearPlantilla(nomTest, rutaCarpeta);
				  
				  
				  // INICIAR LA GRABACION DE VIDEO
				  MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
				  				  
				  
				  // LLAMADO DE METODOS ->>
				  mercuryHome.urlAcceso(url);
				  mercuryHome.registrarUsuario(rutaCarpeta, generarEvidencia, firtsname, lastname, phone, email, 
						  					address, city, state, postalcode, country, username, password, confrimpass);

				   				  
				  // FINALIZAR LA GRABACION DE VIDEO
				  MyScreenRecorder.stopRecording();
				  
				  // TERMINAR LA CREACION DE LA PLANTILLA
				  generarPDF.cerrarPlantilla();
				  
				  // TERMINAR
				  driver.close();
				
				} else {
				
					// CONFIRMACION
					System.out.println("LA AUTOMATIZACION SE EJECUTARA SIN GENERAR EVIDENCIA");
					
					  // LLAMADO DE METODOS ->>
					  mercuryHome.urlAcceso(url);
					  mercuryHome.registrarUsuario(rutaCarpeta, generarEvidencia, firtsname, lastname, phone, email, 
							  					address, city, state, postalcode, country, username, password, confrimpass);
					
					// TERMINAR
					 driver.close();
				}
			  			
	  } else {
		  System.out.println("LA AUTOMATIZACION NO SE EJECUTARA, VALIDAR EL CAMPO 'EJECUTAR CASO' EN EL EXCEL");
	  }	
 }

  
  @AfterClass
  public void afterClass() 
  {
	  driver.quit();
  }

}
