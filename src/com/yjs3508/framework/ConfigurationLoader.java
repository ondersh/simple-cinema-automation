package com.yjs3508.framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

class ConfigurationLoader {


    static Properties loadConfiguration() throws IOException {
        Path configurationAbsoluteRootPath = Paths.get(ApplicationConstants.CONFIGURATION_ROOT_PATH).toAbsolutePath();
        Path applicationConfigurationPath = configurationAbsoluteRootPath.resolve(ApplicationConstants.APPLICATION_CONFIGURATION_FILE);
        Properties applicationConfigurationProperties = new Properties();
        applicationConfigurationProperties.load(new FileInputStream(applicationConfigurationPath.toString()));
        return applicationConfigurationProperties;
    }

    public static void main(String[] args) throws IOException {
        // TEST
    }

}
