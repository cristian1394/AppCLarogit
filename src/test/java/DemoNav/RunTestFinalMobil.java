package DemoNav;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import PageObject.PagsObjectIngresarApp;
import PageObject.PagsObjetCerrarSesion;
import PageObject.PagsObjetTarjeta;
import PageObject.PagsObjetCambioDireccion;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilidadesExcel.ReadExcelFile;
import utilidadesExcel.WriteExcelFile;

public class RunTestFinalMobil<PagsObjectTarjeta> {

	private AppiumDriver<MobileElement> driver;
	Properties propiedades;
	ReadExcelFile leer;
	WriteExcelFile escribir;
	PagsObjectIngresarApp selecObject;
	PagsObjetTarjeta  tarjeta;
	PagsObjetCambioDireccion selectObjetWidged;
	PagsObjetCerrarSesion alerts;
	String url = null;
	//PagsObjetWebTablel paginas;
	PagsObjetCerrarSesion paginasPp;
	ClaseBaseFinalMobil claseBase;

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws InterruptedException, IOException {

		driver = ClaseBaseFinalMobil.AppiumDriverConnection();

		// ACCESOS PORTABLES DEL NAVEGADOR
		
		//selectObjetWidged = new PagsObjetWid(driver);
		
		
		// mprueba github
		

		// INSTANCIAR LA CLASE PROPIEDADES DE JAVA UNIT
		propiedades = new Properties();
		
		paginasPp = new PagsObjetCerrarSesion(driver);
		selectObjetWidged = new PagsObjetCambioDireccion(driver);
		alerts = new PagsObjetCerrarSesion(driver);
		tarjeta = new PagsObjetTarjeta(driver);
		

		// INSTANCIAR CLASES DE EXCEL
		leer = new ReadExcelFile();
		escribir = new WriteExcelFile();

		// CREAR LA VARIABLE TIPO INPUTSTRING
		InputStream entrada = null;

		// VALIDAR SI GENERA ERROR AL NO ENCONTRAR EL ARCHIVO
		try {
			entrada = new FileInputStream("./Properties/datos.properties");
			propiedades.load(entrada);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e);
			// TODO: handle exception
		}

	}
	
   /*
	@Test
	public void TestToolsQA() throws Exception {
		//if (leer.getCellValue(propiedades.getProperty("PathExcel"), "datos", 0, 0).equals("Si")) {		
			
			claseBase = new ClaseBaseFinalMobil(driver);
			// OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();

			// CREAR CARPETA PARA EL ALMACENAMIENTO DE IMAGENES
			File rutaCarpeta = claseBase.crearCarpeta(propiedades, nomTest); 
			
			selecObject = new PagsObjectIngresarApp(driver);  

			selecObject.seleccionElements(leer, propiedades, "datos", nomTest, rutaCarpeta); 
			selectObjetWidged.SelecBarraWidged(leer, propiedades, "datos", nomTest, rutaCarpeta);
			alerts.findAlerts(leer, propiedades, "datos", nomTest, rutaCarpeta);
			
	   }
		
	*/
	
	
	
	@Test
	
	public void TestToolsQA2() throws Exception {
		//if (leer.getCellValue(propiedades.getProperty("PathExcel"), "datos", 1, 0).equals("Si")) {		
			
			claseBase = new ClaseBaseFinalMobil(driver);
			// OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();

			// CREAR CARPETA PARA EL ALMACENAMIENTO DE IMAGENES
			File rutaCarpeta = claseBase.crearCarpeta(propiedades, nomTest); 
			
			selecObject = new PagsObjectIngresarApp(driver);
			//tarjeta = new PagsObjetTarjeta(driver);
			selecObject.seleccionElements(leer, propiedades, "datos", nomTest, rutaCarpeta); 
			//tarjeta = new PagsObjetTarjeta(driver); 
			tarjeta.seleccionpagos(leer, propiedades, "datos", nomTest, rutaCarpeta);		
	    }
	
	

	@After
	public void cerrar() {
		//driver.quit();
	}

}

	

