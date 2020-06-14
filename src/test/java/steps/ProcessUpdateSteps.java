package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import definition.Process;
import definition.ProcessImpacta;
import org.junit.Assert;
import support.RESTSupport;

public class ProcessUpdateSteps {
    @And("^the user fills \"([^\"]*)\" with value \"([^\"]*)\"$")
    public void theUserFillsWithValue(String field, String value) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        ProcessImpacta.addFields(field, value);
    }

    @Given("^the user is on the Agapito webpage$")
    public void theUserIsOnTheAgapitoWebpage() {
        ProcessImpacta.clearFields();
    }

    @And("^the user update \"([^\"]*)\" with value \"([^\"]*)\"$")
    public void theUserUpdateWithValue(String field, String value) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        ProcessImpacta.addFields(field, value);
    }

    @And("^the user clicks on save button$")
    public void theUserClicksOnSaveButton() {
        RESTSupport.executePost(ProcessImpacta.getUrl(), ProcessImpacta.getFields());
        ProcessImpacta.setLastId(RESTSupport.key("id").toString());
    }

    @When("^the user clicks on update button$")
    public void theUserClicksOnUpdateButton() {
        String url = ProcessImpacta.getUrl();
        RESTSupport.executePut(url + "/" + ProcessImpacta.getLastId(),ProcessImpacta.getFields());
    }

    @When("^the user reads the last update$")
    public void theUserReadsTheLastUpdate() {
        String url = ProcessImpacta.getUrl() + "/" + ProcessImpacta.getLastId();
        RESTSupport.executeGet(url);
    }

    @Then("^the user should be \"([^\"]*)\" with value \"([^\"]*)\"$")
    public void theUserShouldBeWithValue(String field, String value) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(value,RESTSupport.key(field).toString());
    }

    @When("^the user clicks on update button with invalid id$")
    public void theUserClicksOnUpdateButtonWithInvalidId() {
        RESTSupport.executePut(ProcessImpacta.getUrl() + "/12584869875", ProcessImpacta.getFields());
    }
}
