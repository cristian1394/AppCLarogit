package DemoNav;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import javax.imageio.ImageIO;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import utilidadesExcel.ReadExcelFile;

//DemoBase
public class ClaseBaseFinalMobil

{
	protected AppiumDriver<MobileElement> driver;

	public ClaseBaseFinalMobil(WebDriver driver) {
		super();

	}

	// METODO DE NAVEGADOR
	@SuppressWarnings("rawtypes")
	public static AppiumDriver AppiumDriverConnection() {

		AppiumDriver _driver = null;
		Properties propiedades;
		InputStream entrada = null;
		propiedades = new Properties();
		try {
			entrada = new FileInputStream("./properties/datos.properties");
			propiedades.load(entrada);
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("platformName", propiedades.getProperty("platformName"));
			caps.setCapability("deviceName", propiedades.getProperty("deviceName"));
			caps.setCapability("platfotmVersion", propiedades.getProperty("platfotmVersion"));
			caps.setCapability("appPackage", propiedades.getProperty("appPackage"));
			caps.setCapability("appActivity", propiedades.getProperty("appActivity"));
			caps.setCapability("noReset", propiedades.getProperty("noReset"));
			caps.setCapability("autoGrantPermissior", propiedades.getProperty("autoGrantPermissior"));

			try {
				// SETEAR LAS PROPIEDADES DEL NAVEGADOR
				printConsola("Cargando capacibility de appium, favor esperar.....");
				_driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

			} catch (MalformedURLException e) {
				printConsola(e.getMessage());
			}

			// MAXIMIZAR NAVEGADOR

			return _driver;
		} catch (Exception e) {
			System.out.println(e);
		}
		return _driver;
	}

	private static void printConsola(String consola) {

		System.out.println(consola);
	}

	public String fechaHora() {
		// TOMAMOS LA FECHA DEL SISTEMA
		LocalDateTime fechaSistema = LocalDateTime.now();

		// DEFINIR FORMATO FECHA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyymmdd-HHmmss");

		// DAR FORMATO A LA FECHA DEL SISTEMA
		String formatFecha = fecha.format(fechaSistema);
		return formatFecha;
	}

	public String HoraSistema() {
		// TOMAMOS LA FECHA DEL SISTEMA
		LocalTime horaSistema = LocalTime.now();

		// DEFINIR FORMATO FECHA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("HHmmss");

		// DAR FORMATO A LA FECHA DEL SISTEMA
		String hora = fecha.format(horaSistema);
		return hora;
	}

	public void captureScreen(File rutaCarpeta) throws Exception {
		// HORA DEL SISTEMA
		String hora = HoraSistema();
		// HERRAMIENTAS DE TAMAÑO DE IMAGEN(HERRAMIENTA DEL SISTEMA)
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle screenRectangle = new Rectangle(screenSize);
		Robot robot = new Robot();
		BufferedImage image = robot.createScreenCapture(screenRectangle);
		ImageIO.write(image, "png", new File(rutaCarpeta + "/" + hora + ".png"));

	}

	public File crearCarpeta(Properties propiedades, String nomTest) {
		// FECHA DEL SISTEMA
		String fecha = fechaHora();

		// NOMBRE CARPETA
		String nomCarpeta = nomTest + "-" + fecha;

		// RUTA DE ALOJAMIENTO DE SALIDA Y NOMBRE DE TEST A EJECUTAR
		File directorio = new File("./output/" + nomCarpeta);

		// CREAMOS LA CARPETA
		directorio.mkdir();
		return directorio;

	}

	// METODO CLICK
	public void click(By locator, File rutaCarpeta) throws Exception {
		driver.findElement(locator).click();
		tiempoEspera(2000);
		captureScreen(rutaCarpeta);
	}

	// METODO BORRAR
	public void borrar(By locator, File rutaCarpeta) throws Exception {
		driver.findElement(locator).clear();
		captureScreen(rutaCarpeta);
	}

	// METODO ENVIAR TEXTO

	public void sendkey(String inputText, By locator, File rutaCarpeta) throws Exception {
		driver.findElement(locator).sendKeys(inputText);
		captureScreen(rutaCarpeta);

	}

	// METODO INTRO
	public void intro(By locator, File rutaCarpeta) throws Exception {
		driver.findElement(locator).sendKeys(Keys.ENTER);
		captureScreen(rutaCarpeta);
	}

	// METODO UNIVERSAL PARA TODOS LOS CASOS
	public void urlAcceso(String url) {
		driver.get(url);
		// busquedaInicial();
	}

	// METODO ENTER SUBMIN

	public void submit(By locator, File rutaCarpeta) throws Exception {
		driver.findElement(locator).submit();
		captureScreen(rutaCarpeta);
	}

	// METODO DE TIEMPO DE ESPERA
	public void tiempoEspera(long tiempo) throws InterruptedException {
		Thread.sleep(tiempo);
	}

	// METODO DE SCROLL
	public void scrollpage(int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(x,y)");
	}

	public void alert() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.accept();
			tiempoEspera(3000);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void teclaborrar(By locator, File rutaCarpeta) throws Exception {

		driver.findElement(locator).sendKeys(Keys.BACK_SPACE);
		captureScreen(rutaCarpeta);
	}

	public void controla(By locator, File rutaCarpeta) throws Exception {
		driver.findElement(locator).sendKeys(Keys.CONTROL, "a");
		captureScreen(rutaCarpeta);
	}

	@SuppressWarnings("rawtypes")
	private TouchAction TouchAction(AppiumDriver<MobileElement> driver2) {
		// TODO Auto-generated method stub
		return null;
	}

	// METODO SCROLLVERTICAL
	public void scrollVertical(File rutaCarpeta, int xini, int yini, int yfinal, int iteraciones) throws Exception {

		for (int i = 1; i <= iteraciones; i++) {
			@SuppressWarnings("rawtypes")
			TouchAction touch = new TouchAction(driver);
			touch.press(PointOption.point(xini, yini)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
					.moveTo(PointOption.point(xini, yfinal)).release().perform();
			captureScreen(rutaCarpeta);
		}
		
		
	}
	//METODO TOCAR PANTALLA
	public void tocarPantalla(int a, int b)
	{
	@SuppressWarnings("rawtypes")
	TouchAction touch = new TouchAction(driver);
	touch.press(PointOption.point(a,b)).release().perform();

	}
	
	//INGRESAR DATOS
	public void escribir(String palabra) throws Exception{

	char[] c = palabra.toCharArray();

	for(int i =0; i<palabra.length();i++)
	{
	String C = String.valueOf(c[i]);
	((AndroidDriver<MobileElement>)driver).pressKey(new KeyEvent(AndroidKey.valueOf(C)));
	}

	driver.hideKeyboard();
	}
	// TOUCH EN LA PANTALLA HORIZONTAL



	public void scrollHorizontal(File rutaFile, int X, int Y, int XFin, int YFin, int iteraciones) throws Exception {



	for (int i = 1; i <= iteraciones; i++) {
	@SuppressWarnings("rawtypes")
	TouchAction touch = new TouchAction(driver);
	touch.press(PointOption.point(X, Y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
	.moveTo(PointOption.point(XFin, YFin)).release().perform();
	captureScreen(rutaFile);
	}
	}
	// android
	@SuppressWarnings("deprecation")
	public void sendkeyandroid(ReadExcelFile leer,Properties propiedades,String numHoja,int fil,int col) throws Exception
	{
		driver.getKeyboard().sendKeys(leer.getCellValue(propiedades.getProperty("PathExcel"),"datos",fil,col));
	}
	//METODO TAB
	
	@SuppressWarnings("deprecation")
	public void Tab() 
	{

		driver.getKeyboard().sendKeys(Keys.TAB);
		
	}
	// boolean
	public boolean elementoPresente(By Locator) 
	{
		boolean estado = driver.findElement(Locator).isDisplayed();
		return estado;
	}
}
