# Summary
This plugin uses [Probely](https://probely.com) to scan your web application for 
security vulnerabilities.

Probely is a Web Vulnerability Scanning suite for Agile Teams. It provides 
continuous scanning of your Web Applications and lets you efficiently manage 
the lifecycle of the vulnerabilities found, in a sleek and intuitive web 
interface. Probely also provides tailored instructions on how to fix the 
vulnerabilities (including snippets of code). By using its API, it can be 
integrated into the development processes and the continuous integration tools 
in order to automatize security testing. Probely runs in the cloud as a SaaS 
and is targeted at companies that build online services.

# Installing the plugin
1. Open Jenkins and click on **Manage Jenkins**

![Manage Jenkins](/images/install_plugin_1.png)

2. Click on **Manage Plugins**

![Manage Plugins](/images/install_plugin_2.png)

3. Click on the **Available** tab

![Available](/images/install_plugin_3.png)

5. On the **Filter** search box, enter **probely**
6. Select the **Probely Security Scanner** plugin
7. Click on **Download now and install after restart**
8. After Jenkins restarts, the plugin will be ready to use

# Generating an API key
Before using the plugin, you first need to create an API key.

1. Go to https://app.probely.com and log in
1. Select a target from the drop-down list
1. Go to the **Settings** page
1. Click on the **Integrations** tab
1. Write a name for the API Key. Since we want this API Key for Jenkins, we name it **Jenkins**
1. Click on **Generate New Key**

![Creating an API key](/images/new_api_key.png)

After the API is created, please take note of the `Target id` and API key values. They will be required to configure the Plugin credentials later on.

# Configuring the plugin

The plugin can be used both in a Freestyle or a in a Pipeline project. 
We will describe how to use the plugin in both project types.

## Configuring credentials

1. Click on **Credentials**

![Credentials](/images/credentials_0.png)

2. Click on the down arrow near "(global)" to enable the dropdown menu and choose 
**Add credentials**

![Add Credentials](/images/credentials_1.png)

1. On the credentials kind dropdown menu, choose **Secret text**
1. Enter the API key on **Secret** textbox
1. Enter a value for the credentials in the **ID** textbox, for example **probely-test-site**
1. Enter an optional Description and click **OK**

![Add Secret](/images/credentials_2.png)

## Using the plugin in a Freestyle project

Freestyle Jenkins projects have been traditionally used to create pipeline-like setups by chaining build steps together. To enable Probely in a Freestyle project, the following steps may be used.

1. Click on **New Item**

![New Item](/images/new_item.png)

2. Enter your project name, choose **Freestyle Project** and click **OK**

![Freestyle Project](/images/freestyle_0.png)

3. Add Probely scan step

We assume that all required steps have been properly configured, such as checking out from your SCM, testing, among others.

1. Add the `Target Id`. As defined in the **Generating an API key** step.
1. Select the right credentials, which were configured in **Configuring credentials**. If the connection to Probely's API is working correctly, and the credentials are valid, you should see the message "Credentials verified sucessfully".
1. When all steps are properly configured, click on **Save**

![Probely step](/images/freestyle_1.png)

## Using the plugin in a Pipeline project

Pipeline projects are the new way to create build/test/deploy (among others) pipelines in Jenkins. Pipelines are defined in a `Jenkinfile`, which can be configured in an older imperative syntax, or in a more modern declarative syntax. We describe how to use Probely using a declarative `Jenkinsfile` to build a simple build/test/scan Pipeline.

1. Click on **New Item**

![New Item](/images/new_item.png)

2. Enter your project name, choose **Pipeline Project** and click **OK**

![Pipeline](/images/pipeline_0.png)

3. Create a Jenkinsfile

We assume that the step to check out source code from your SCM is properly configured.
The following `Jenkinsfile` may be used as an example to add Probely to your pipeline.
It should be placed in the root of your source code repository.
This pipeline consists of an hypothetical Java project, built with Gradle, with two stages: 
one running units tests and the other launching a scan with Probely. 
Note that the `targetId` and `credentialsId` value refer to the credentials obtained and configured previosuly.

```
pipeline {
    agent {
        docker {
            image 'maven:3-alpine' 
        }
    }
    stages {
        stage('Unit tests') { 
            steps {
                sh './gradlew check'
            }
        }
        stage('Scan with Probely') {
            steps {
                probelyScan targetId: '9nl6yy0TWWKv', credentialsId: 'probely-test-site'	
            }
         }
    }
}
```

4. Configure Jenkins to use the Jenkins file on your repository

![Pipeline using Jenkinsfile](/images/pipeline_1.png)


# Building and Contributing

Contributions are very welcome. To build the plugin, be sure to install the Java Development Kit (JDK) 1.8 and Maven.

A minimal example on how to build and run the plugin on Ubuntu Linux follows. It will also build on macOS and Windows, provided you have the required packages installed. After running the commands below, you will have a test Jenkins instance running with the plugin.

```bash

$ sudo apt install openjdk-8-jdk maven
$ git clone https://github.com/jenkinsci/probely-security-plugin.git
$ cd probely-security-plugin
$ mvn hpi:run
```
