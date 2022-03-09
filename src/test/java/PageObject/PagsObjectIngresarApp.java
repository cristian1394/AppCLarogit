package PageObject;

import java.io.File;
import java.util.Properties;

import MapObject.MapsObjetIngresarApp;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilidadesExcel.ReadExcelFile;

public class PagsObjectIngresarApp extends MapsObjetIngresarApp
{
		public PagsObjectIngresarApp(AppiumDriver<MobileElement> driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	
	public void urlAcceso(String url) 
	{
		driver.get(url);
	}
	
	
	public void seleccionElements( ReadExcelFile leer, Properties propiedades,String numHoja, String nomTest, File rutaCarpeta) throws Exception
		{
		
		tiempoEspera(10000);
		click(btnusucon, rutaCarpeta);
		tiempoEspera(2000);
		click(btncorreo, rutaCarpeta);
		sendkey(leer.getCellValue(propiedades.getProperty("PathExcel"),"datos",1,2),correo,rutaCarpeta);
		sendkey(leer.getCellValue(propiedades.getProperty("PathExcel"),"datos",1,3),contraseña,rutaCarpeta);
		click(btniniciar, rutaCarpeta);
		tiempoEspera(4000);	
		click(cancelar, rutaCarpeta);
		//click(btnSelecEquipo, rutaCarpeta);
		//click(continuar, rutaCarpeta);
		//click(btnConfirmar, rutaCarpeta);

		}

	
	
}
