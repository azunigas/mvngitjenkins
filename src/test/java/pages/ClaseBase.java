package pages;

import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClaseBase {
	private WebDriver driver;

	public ClaseBase(WebDriver driver) {
		super(); // llama de forma explicita a la clase padre "Object"
		this.driver = driver;
	}

	public WebDriver conexionChromeDriver() {
		// Preparamos la ruta del webdriver
		String rutaDriver = Paths.get(System.getProperty("user.dir"), "/src/test/resources/Drivers/chromedriver.exe")
				.toString();

		// Configuramos la property con la ruta del driver
		System.setProperty("webdriver.chrome.driver", rutaDriver);

		// Asignamos al atributo driver una instancia de ChromeDriver
		driver = new ChromeDriver();
		
		return driver;
	}

	public WebElement buscarElementoWeb(By localizador) {
		return driver.findElement(localizador);
	}

	public List<WebElement> buscarElementosWeb(By localizador) {
		return driver.findElements(localizador);
	}

	public String obtenerTexto(By localizador) {
		return driver.findElement(localizador).getText();
	}

	public void agregarTexto(String imput, By localizador) {
		driver.findElement(localizador).sendKeys(imput);
	}

	public void click(By localizador) {
		driver.findElement(localizador).click();
	}
	
	public void visitarSitio(String url){
		driver.get(url);
	}
	
	//Espera implicita de 10 segundos, consultado por el elemento cada .5 segundos.
	public void esperarElementoWeb(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	//Espera implicita de 3 segundos a travez de una pausa. esto lanza una interrupted Exception
	//que es controlada a travez del throws.
	public void esperar3segundos() throws InterruptedException{
		Thread.sleep(3000);
	}

	public void cerrarBrowser() {
		driver.close();
	}

}
