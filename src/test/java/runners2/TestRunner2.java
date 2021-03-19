package runners2;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin= {"json:target/cucumber.json"},features = "src/test/resources/weather",glue = {"stepDefinition2"},tags= {"@tag2"})
public class TestRunner2 {

}
