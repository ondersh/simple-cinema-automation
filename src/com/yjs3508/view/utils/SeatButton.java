package com.yjs3508.view.utils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SeatButton extends JToggleButton implements ActionListener {

    private static List<SeatButton> seatList;
    private int seatNumber;
    private String message;


    public SeatButton(String message){
        super(message);
        seatList = new ArrayList<SeatButton>();
        this.message = message;
        this.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        setSeatNumber(Integer.parseInt(message));
        seatList.add(this);
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public static List<SeatButton> getSeatList() {
        return seatList;
    }

    public static void setSeatList(List<SeatButton> seatList) {
        SeatButton.seatList = seatList;
    }

    public static void disableSeatList(){
        for(SeatButton button : seatList){
            button.setEnabled(false);

        }
    }

    public static void clearSeatList(){
        seatList.clear();
    }


}
