package stepdefinitions.first_stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FirstStepDef {


    @Given("Cucumber is setup in my project")
    public void cucumber_is_setup_in_my_project() {
        System.out.println("My first Given step");

    }
    @When("I try to execute")
    public void i_try_to_execute() {
        System.out.println("My first When step");

    }
    @Then("I executed successfully")
    public void i_executed_successfully() {
        System.out.println("My first Then step");

    }

    @When("I try to execute my second scenario")
    public void iTryToExecuteMySecondScenario() {
        System.out.println("My second When step");

    }

    @And("I try to execute my third step")
    public void iTryToExecuteMyThirdStep() {
        System.out.println("My third step");
    }
}
