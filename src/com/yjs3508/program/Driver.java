package com.yjs3508.program;

import com.yjs3508.controller.CinemaAutomationApplication;
import com.yjs3508.framework.ApplicationDriver;

public class Driver {

    public static void main(String[] args) {
       new ApplicationDriver(CinemaAutomationApplication.class).run();
    }
}
