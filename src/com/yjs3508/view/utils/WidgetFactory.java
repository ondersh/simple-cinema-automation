package com.yjs3508.view.utils;

import javax.swing.*;

public final class WidgetFactory {

    private WidgetFactory(){}

    public static JTextField createTextField(){
        return new JTextField(20);
    }

    public static JLabel  createLabel(String labelText){
        return new JLabel(labelText,SwingConstants.CENTER);
    }

    public static JButton createButton(String text){
        return new JButton(text);
    }

}
