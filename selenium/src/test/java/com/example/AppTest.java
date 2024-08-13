package com.example;

// import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;
import org.testng.TestNG;

import com.example.scenario_tests.login;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void TestNG() throws IOException {
        TestNG testNG = new TestNG();
        testNG.setTestClasses(new Class[]{
            login.class,
        });
        testNG.run(); // Make sure to call run() to execute the tests
    }

}
