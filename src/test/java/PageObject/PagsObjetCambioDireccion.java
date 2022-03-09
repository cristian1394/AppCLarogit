package PageObject;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import MapObject.MapsObjectCambioDireccion;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilidadesExcel.ReadExcelFile;

public class PagsObjetCambioDireccion extends MapsObjectCambioDireccion

{

	public PagsObjetCambioDireccion(AppiumDriver<MobileElement> driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}
	
	
	
	public void SelecBarraWidged( ReadExcelFile leer, Properties propiedades,String numHoja, String nomTest, File rutaCarpeta) throws Exception {
		
		
		click(btnlogo, rutaCarpeta);
		tiempoEspera(2000);
		click(btncorreo, rutaCarpeta);
		tiempoEspera(2000);
		click(btnactualizar, rutaCarpeta);
		tiempoEspera(2000);
		click(btnnumcelular, rutaCarpeta);
		tiempoEspera(2000);
		
	}

}
