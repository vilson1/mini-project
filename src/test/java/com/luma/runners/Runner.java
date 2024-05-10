package com.luma.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (
        plugin = {
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumberReport"
        },
        features = "src/test/resources/features",
        glue = "com/luma/step_definitions",
        dryRun = false,
        tags = "@wip"
)
public class Runner {
}
