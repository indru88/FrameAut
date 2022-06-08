package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.GooglePage;

public class GoogleSteps {
    GooglePage google = new GooglePage();
    @Given("^Ingresar a la web de Google.com$")
    public void navigateToGoogle(){
        google.navigateToGoogle();
    }
    @When("^Ingresar la palabra 'Gatitos' en el campo de busqueda$")
    public void insertSearchCriteria(){
        google.searchCriteria("Gatitos");
    }
    @And("^Presionar el boton de busqueda$")
    public void clickSearchButton(){
        google.clickToSearch();
    }
    @Then("^Validar Resultados$")
    public void validate(){
        Assert.assertEquals("Texto que esperabamos", google.firstResult());
    }
}
