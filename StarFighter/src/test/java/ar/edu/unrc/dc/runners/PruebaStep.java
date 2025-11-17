package ar.edu.unrc.dc.runners;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.*;

public class PruebaStep {
    
    @Given("Cucumber is setup")
    public void cucumber_is_setup() {
        System.out.println("Cucumber is working!");
    }
    
    @When("I run the tests")
    public void i_run_the_tests() {
        System.out.println("Running tests...");
    }
    
    @Then("everything should work")
    public void everything_should_work() {
        assertTrue(true, "Cucumber is working correctly!");
    }
}