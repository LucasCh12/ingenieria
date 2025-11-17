package ar.edu.unrc.dc.runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("runners") // ← Cambiado a "runners" (sin la ruta completa)
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "ar.edu.unrc.dc.runners")
public class CucumberTestRunner {
}