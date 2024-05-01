package com.luma.step_definitions;
import com.luma.utilities.ConfigurationReader;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.luma.utilities.Driver;

public class Hooks {
    @Before
    public void setUp(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }
    @After
    public void teardownScenario(Scenario scenario){

        //scenario.isFailed() --> if scenario fails this method will return TRUE boolean value


        if (scenario.isFailed()){

            byte [] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

        }

        //Driver.closeDriver();

    }
}
