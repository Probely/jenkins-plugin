package com.probely.plugin;

import hudson.model.FreeStyleBuild;
import hudson.model.FreeStyleProject;
import org.junit.Rule;
import org.junit.Test;
import org.jvnet.hudson.test.JenkinsRule;

public class ProbelyScanBuilderTest {

    private final static String targetId = "test-target";
    private final static String authToken = "test-token";

    @Rule
    public JenkinsRule jenkins = new JenkinsRule();

    @Test
    public void testConfigRoundtrip() throws Exception {
        FreeStyleProject project = jenkins.createFreeStyleProject();
        project.getBuildersList().add(new ProbelyScanBuilder(targetId, authToken));
        project = jenkins.configRoundtrip(project);
        jenkins.assertEqualDataBoundBeans(
                new ProbelyScanBuilder(targetId, authToken),
                project.getBuildersList().get(0));
    }

    @Test
    public void testBuild() throws Exception {
        FreeStyleProject project = jenkins.createFreeStyleProject();
        ProbelyScanBuilder builder = new ProbelyScanBuilder(targetId, authToken);
        project.getBuildersList().add(builder);

        FreeStyleBuild build = jenkins.buildAndAssertSuccess(project);
        jenkins.assertLogContains("Started scan on target", build);
    }
}