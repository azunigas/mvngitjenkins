package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageInicioBCI extends ClaseBase {

	public PageInicioBCI(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Agregaremos los localizadores
	
	//Localizador Bóton banco en linea
	By btonBcoEnLinea = By.partialLinkText("Banco en Lín");
	
	//Localizador imput Rut
	By textBoxRut = By.id("rut_aux");
	
	//Localizador imput password
	By textBoxPassword = By.id("clave");
	
	//Localizador boton ingresar
	By btonIngresar = By.xpath("//input[@class='submit btn btn-primary btn-block']");
	
	//Localizador Mensaje Cta BLoqueada
	By mensajeCtaBloqueada = By.xpath("//h6[@class='headline grey-text']");
	
	//Función para realizar login
	public void Login() throws InterruptedException{
		click(btonBcoEnLinea);
		esperarElementoWeb();
		agregarTexto("158998025", textBoxRut);
		esperarElementoWeb();
		agregarTexto("Azuniga1", textBoxPassword);
		esperarElementoWeb();
		click(btonIngresar);
		esperar3segundos();
	}
	
	//Metodos para mas acciones en el sitio
	
	//Metodo para mensaje de inicio de sesión correcto
	
	//Función para validar mensaje de bloqueo Cta
	public String obtenerMensajeCtaBloqueada(){
		return obtenerTexto(mensajeCtaBloqueada);
	}
	
}
