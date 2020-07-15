package com.yjs3508.framework;

import com.yjs3508.framework.data.DAOTemplate;
import com.yjs3508.framework.data.Datasource;
import com.yjs3508.framework.data.DefaultDatasourceImpl;
import com.yjs3508.framework.exceptions.DAOTemplateNotInitializedException;

import java.util.Properties;

public class ApplicationContext {

    private static DAOTemplate daoTemplate;
    private static DefaultDatasourceImpl defaultDatasource;


    public static DAOTemplate getDAOTemplate() {
        if (daoTemplate == null) throw new DAOTemplateNotInitializedException();
        return daoTemplate;
    }

    private static void initializeDataAccessTemplate(Datasource datasource) {
        if (daoTemplate != null) return;
        daoTemplate = new DAOTemplate(datasource);
    }

    private static Datasource initializeDatasource(Properties applicationConfig) {
        if(defaultDatasource == null){
            defaultDatasource = new DefaultDatasourceImpl()
                    .withDatasourceUrl(applicationConfig.getProperty(ApplicationConstants.LEGAL_CONFIGURATION_KEYS.DATASOURCE_URL))
                    .withDatasourceUsername(applicationConfig.getProperty(ApplicationConstants.LEGAL_CONFIGURATION_KEYS.DATASOURCE_USERNAME))
                    .withDatasourcePassword(applicationConfig.getProperty(ApplicationConstants.LEGAL_CONFIGURATION_KEYS.DATASOURCE_PASSWORD));
        }
        return defaultDatasource;
    }

    public static void initialize(Properties applicationConfig){
        printApplicationInfo(applicationConfig);
        initializeDataAccessTemplate(initializeDatasource(applicationConfig));
    }

    private static void printApplicationInfo(Properties applicationConfig) {
        System.out.println(applicationConfig.getProperty(ApplicationConstants.LEGAL_CONFIGURATION_KEYS.APPLICATION_NAME) + " is starting...");
        System.out.println("Version : " + applicationConfig.getProperty(ApplicationConstants.LEGAL_CONFIGURATION_KEYS.APPLICATION_VERSION));
    }
}
