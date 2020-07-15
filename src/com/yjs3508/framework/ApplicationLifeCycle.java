package com.yjs3508.framework;

import java.util.Properties;

interface ApplicationLifeCycle {
    void initializeApplication(Properties applicationConfigurations);
    void beforeApplicationStart();
    void startApplication();
    void beforeApplicationStop();
    void stopApplication();
}
