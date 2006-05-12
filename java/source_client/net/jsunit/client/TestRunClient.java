package net.jsunit.client;

import net.jsunit.model.Result;
import net.jsunit.model.TestPage;
import net.jsunit.services.TestRunService;
import net.jsunit.services.TestRunServiceServiceLocator;
import net.jsunit.utility.JsUnitURL;

import java.io.File;

public class TestRunClient {
    private JsUnitURL serviceURL;
    private String username;
    private String password;

    public TestRunClient(String serviceURL) {
        this.serviceURL = new JsUnitURL(serviceURL);
    }

    public Result send(File testPageFile) throws Exception {
        TestPage testPage = new TestPage(testPageFile);
        TestRunServiceServiceLocator locator = new TestRunServiceServiceLocator();
        TestRunService service = locator.getTestRunService(serviceURL.asJavaURL());
        return service.runTests(testPage);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
