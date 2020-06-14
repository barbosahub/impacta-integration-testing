package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import definition.ProcessImpacta;
import org.junit.Assert;
import support.RESTSupport;

public class CrudNewProcessSteps {
    private String url = "";
    @When("^user clicks on find Rui button$")
    public void userClicksOnFindRuiButton() {
        RESTSupport.executeGet(url);
    }

    @Given("^user is on the Rui Process Page$")
    public void userIsOnTheRuiProcessPage() {
        url = ProcessImpacta.getUrl();
    }


    @And("^user would like to see process with id \"([^\"]*)\"$")
    public void userWouldLikeToSeeProcessWithId(String id) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        url = url + "/" + id;
    }

    @Dado("^que o processo esteja no site do agapito$")
    public void queOProcessoEstejaNoSiteDoAgapito() {
        ProcessImpacta.clearFields();
    }

    @E("^que preencha o campo \"([^\"]*)\" com o valor \"([^\"]*)\"$")
    public void quePreenchaOCampoComOValor(String field, String value) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        ProcessImpacta.addFields(field,value);
    }

    @Quando("^o usuario clicar no botao salvar processo$")
    public void oUsuarioClicarNoBotaoSalvarProcesso() {
        RESTSupport.executePost(ProcessImpacta.getUrl(),ProcessImpacta.getFields());
        ProcessImpacta.setLastId(RESTSupport.key("id").toString());
    }
    @Quando("^o usuario clicar no botao salvar processo sem id$")
    public void oUsuarioClicarNoBotaoSalvarProcessoSemId() {
        RESTSupport.executePost(ProcessImpacta.getUrl(),ProcessImpacta.getFields());
    }


    @Quando("^o usuario buscar o ultimo processo salvo$")
    public void oUsuarioBuscarOUltimoProcessoSalvo() {
        RESTSupport.executeGet(ProcessImpacta.getUrl() + "/" + ProcessImpacta.getLastId());
    }

    @Entao("^o usuario deveria ver no campo \"([^\"]*)\" o valor \"([^\"]*)\"$")
    public void oUsuarioDeveriaVerNoCampoOValor(String field, String value) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(value,RESTSupport.key(field).toString());
    }


    @When("^the user clicks on delete button$")
    public void theUserClicksOnDeleteButton() {
        String url = ProcessImpacta.getUrl() + "/" + ProcessImpacta.getLastId();
        RESTSupport.executeDelete(url);
    }

    @When("^the user clicks on delete button with invalid id$")
    public void theUserClicksOnDeleteButtonWithInvalidId() {
        RESTSupport.executeDelete(ProcessImpacta.getUrl() + "/12584869875");
    }

    @When("^the user clicks on read button$")
    public void theUserClicksOnReadButton() {
        String url = ProcessImpacta.getUrl() + "/" + ProcessImpacta.getLastId();
        RESTSupport.executeGet(url);
    }
}
