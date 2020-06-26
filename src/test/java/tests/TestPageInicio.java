package tests;

import org.testng.annotations.Test;

import pages.PageInicioBCI;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestPageInicio {
	private WebDriver driver;
	PageInicioBCI pageInicioSitio;
	
	

	@BeforeTest
	public void beforeTest() {
		pageInicioSitio = new PageInicioBCI(driver);
		driver = pageInicioSitio.conexionChromeDriver();
		pageInicioSitio.visitarSitio("https://www.bci.cl/personas");
	}

	@Test
	public void testCtaBloqueada() throws InterruptedException {
		pageInicioSitio.Login(); //Resultado de login depende de los datos de prueba
		Assert.assertEquals(pageInicioSitio.obtenerMensajeCtaBloqueada(), "Clave de Internet bloqueada");
	}

	@AfterTest
	public void afterTest() {
		pageInicioSitio.cerrarBrowser();
	}

}
