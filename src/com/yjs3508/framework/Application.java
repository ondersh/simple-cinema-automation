package com.yjs3508.framework;


import java.util.Properties;

public abstract class Application implements Runnable, ApplicationLifeCycle {

    private boolean isRunning;


    @Override
    public final void initializeApplication(Properties applicationConfigurations) {
        initializeApplicationContext(applicationConfigurations);
    }

    @Override
    public final void startApplication() {
        setRunning(true);
//        new Thread(application).start();
        start();
    }

    @Override
    public final void stopApplication() {
        setRunning(false);
        beforeApplicationStop();
        System.out.println("Application is stopped");
        System.exit(0);
    }

    @Override
    public void beforeApplicationStart() {

    }

    @Override
    public void beforeApplicationStop() {
        // Overrideable methods
    }

    public abstract void start();

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public boolean isRunning() {
        return isRunning;
    }
    private void initializeApplicationContext(Properties applicationConfig) {
        ApplicationContext.initialize(applicationConfig);
    }

}
