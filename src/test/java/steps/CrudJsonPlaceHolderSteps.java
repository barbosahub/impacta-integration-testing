/**
 * Created by robson on 22/01/2018.
 */
package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import support.RESTSupport;

public class CrudJsonPlaceHolderSteps {
    private String url = "";

    @When("^user clicks on find button$")
    public void userClicksOnFindButton() throws Throwable {
        RESTSupport.executeGet(url);
    }

    @Given("^user would like to see all json placeholder$")
    public void userWouldLikeToSeeAllPlaceholder() throws Throwable {
        url = "https://jsonplaceholder.typicode.com/posts";
    }

    @Given("^user fills the follwind id equal \"([^\"]*)\"$")
    public void userFillsTheFollwindIdEqual(String id) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        url = url + id;
    }

    @Given("^user goes to main menu$")
    public void userGoesToMainMenu() {
        System.out.println("Entrou aqui!");
    }
}
