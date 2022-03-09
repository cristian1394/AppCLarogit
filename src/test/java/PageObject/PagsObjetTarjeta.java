package PageObject;

import java.io.File;
import java.util.Properties;

import MapObject.MapObjectTarjeta;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilidadesExcel.ReadExcelFile;

public class PagsObjetTarjeta extends MapObjectTarjeta {
	
	public PagsObjetTarjeta(AppiumDriver<MobileElement> driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	public void seleccionpagos( ReadExcelFile leer, Properties propiedades,String numHoja, String nomTest, File rutaCarpeta) throws Exception
	{
		
		tiempoEspera(2000);
		click(btnpagos, rutaCarpeta);
		tiempoEspera(6000);
		scrollVertical(rutaCarpeta, 330, 930, 430, 1);
		click(btnfactura, rutaCarpeta);
		tiempoEspera(2000);
		click(btndeseofactura, rutaCarpeta);
		tiempoEspera(6000);
		click(btnbarra, rutaCarpeta);
		tiempoEspera(2000);
		click(btntarjeta, rutaCarpeta);
		tiempoEspera(2000);
		click(btncontinuar, rutaCarpeta);
		tiempoEspera(8000);
		scrollVertical(rutaCarpeta, 330, 930, 430, 4);
		tiempoEspera(2000);
		sendkey(leer.getCellValue(propiedades.getProperty("PathExcel"),"datos",1,9),btnnumtarjeta,rutaCarpeta);
		tiempoEspera(2000);
		click(btnmm, rutaCarpeta);
		tiempoEspera(2000);
		click(btnmm2, rutaCarpeta);
		tiempoEspera(2000);
		click(btnaaaa, rutaCarpeta);
		tiempoEspera(2000);
		click(btnaaaa2, rutaCarpeta);
		tiempoEspera(2000);
		sendkey(leer.getCellValue(propiedades.getProperty("PathExcel"),"datos",1,10),btncodigoseg,rutaCarpeta);
		tiempoEspera(2000);
		scrollVertical(rutaCarpeta, 330, 930, 430, 1);
		click(btncoutas, rutaCarpeta);
		tiempoEspera(2000);
		click(btncoutas2, rutaCarpeta);
		tiempoEspera(2000);
		sendkey(leer.getCellValue(propiedades.getProperty("PathExcel"),"datos",1,11),btnnombreape,rutaCarpeta);
		tiempoEspera(2000);
		click(btndocumentacion, rutaCarpeta);
		tiempoEspera(2000);
		click(btncc, rutaCarpeta);
		tiempoEspera(2000);
		scrollVertical(rutaCarpeta, 330, 930, 430, 1);
		tiempoEspera(2000);
		sendkey(leer.getCellValue(propiedades.getProperty("PathExcel"),"datos",1,12),btncc2,rutaCarpeta);
		tiempoEspera(2000);
		sendkey(leer.getCellValue(propiedades.getProperty("PathExcel"),"datos",1,13),btntelefono,rutaCarpeta);
		tiempoEspera(2000);
		sendkey(leer.getCellValue(propiedades.getProperty("PathExcel"),"datos",1,14),btncorreo,rutaCarpeta);
		tiempoEspera(2000);
		scrollVertical(rutaCarpeta, 330, 930, 430, 2);
		tiempoEspera(2000);
		click(btncancelar, rutaCarpeta);
		tiempoEspera(2000);
		click(btnclickdevolver, rutaCarpeta);
		tiempoEspera(2000);
		click(btnpersona, rutaCarpeta);
		tiempoEspera(2000);
		click(btncerrarsesion, rutaCarpeta);
		tiempoEspera(2000);
		click(btnsalir, rutaCarpeta);
		tiempoEspera(5000);
		
     }
	
}
