package PageObject;

import java.io.File;
import java.util.Properties;

import MapObject.MapsObjetCerrarSesion;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilidadesExcel.ReadExcelFile;

public class PagsObjetCerrarSesion extends MapsObjetCerrarSesion {

	public PagsObjetCerrarSesion(AppiumDriver<MobileElement> driver) {
		super(driver);
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}
	
	public void findAlerts ( ReadExcelFile leer, Properties propiedades,String numHoja, String nomTest, File rutaCarpeta) throws Exception {
		
		tiempoEspera(5000);
		click(esfero, rutaCarpeta);
		tiempoEspera(7000);
		click(departamento, rutaCarpeta);
		tiempoEspera(2000);
		click(bogota, rutaCarpeta);
		tiempoEspera(5000);
		click(cuidad, rutaCarpeta);
		tiempoEspera(3000);
		click(bogota2, rutaCarpeta);
		tiempoEspera(2000);
		sendkey(leer.getCellValue(propiedades.getProperty("PathExcel"),"datos",1,4),barrio,rutaCarpeta);
		tiempoEspera(2000);
		click(tipo, rutaCarpeta);
		tiempoEspera(2000);
		click(tipo2, rutaCarpeta);
		tiempoEspera(2000);
		scrollVertical(rutaCarpeta, 330, 930, 430, 2);
		tiempoEspera(2000);
		sendkey(leer.getCellValue(propiedades.getProperty("PathExcel"),"datos",1,5),principal,rutaCarpeta);
		tiempoEspera(2000);
		click(sufijo, rutaCarpeta);
		tiempoEspera(2000);
		click(sufijo2, rutaCarpeta);
		tiempoEspera(2000);
		sendkey(leer.getCellValue(propiedades.getProperty("PathExcel"),"datos",1,6),secundario,rutaCarpeta);
		tiempoEspera(2000);
		click(sufijo3, rutaCarpeta);
		tiempoEspera(2000);
		click(sufijo4, rutaCarpeta);
		tiempoEspera(2000);
		sendkey(leer.getCellValue(propiedades.getProperty("PathExcel"),"datos",1,7),compu,rutaCarpeta);
		tiempoEspera(2000);
		click(complemento, rutaCarpeta);
		tiempoEspera(2000);
		click(complemento2, rutaCarpeta);
		tiempoEspera(2000);
		sendkey(leer.getCellValue(propiedades.getProperty("PathExcel"),"datos",1,8),numero,rutaCarpeta);
		scrollVertical(rutaCarpeta, 330, 930, 430, 1);
		click(validar, rutaCarpeta);
		tiempoEspera(5000);
		click(guardar, rutaCarpeta);
		tiempoEspera(10000);
		click(cerrar, rutaCarpeta);
		tiempoEspera(2000);
		click(btnclickdevolver, rutaCarpeta);
		tiempoEspera(1000);
		click(btnclickdevolver, rutaCarpeta);
		tiempoEspera(1000);
		click(btnclickdevolver, rutaCarpeta);
		tiempoEspera(1000);
		click(btnclickdevolver, rutaCarpeta);
		tiempoEspera(1000);
		click(btnpersona, rutaCarpeta);
		tiempoEspera(2000);
		click(btncerrarsesion, rutaCarpeta);
		tiempoEspera(2000);
		click(btnsalir, rutaCarpeta);
		tiempoEspera(5000);
	
	}

}
