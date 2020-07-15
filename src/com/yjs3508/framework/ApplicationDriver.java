package com.yjs3508.framework;

import java.io.IOException;
import java.util.Properties;

public final class ApplicationDriver {

    private static ApplicationLifeCycle application;

    public ApplicationDriver(Class<? extends ApplicationLifeCycle> applicationClass) {
        try{
            application = applicationClass.newInstance();
        }catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    Properties loadConfiguration() {
        Properties applicationConfig = null;
        try {
            applicationConfig = ConfigurationLoader.loadConfiguration();
        } catch (IOException exception) {
            exception.printStackTrace();
            // TODO
        }
        return applicationConfig;
    }

    public void run() {
        application.initializeApplication(loadConfiguration());
        application.beforeApplicationStart();
        application.startApplication();
    }


}
