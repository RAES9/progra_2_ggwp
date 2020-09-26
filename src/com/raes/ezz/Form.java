package com.raes.ezz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form extends JFrame {
    private JPanel frame;
    private JButton setValueButton;
    private JFormattedTextField inputText;
    private JLabel labelName;
    private Boolean isFirst;
    private JLabel labelC;
    private JLabel labelTitle;
    private JButton exitButton;

    public Form(){
        isFirst = true;
        setBounds(0,0,300,200);
        add(frame);

        setValueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isFirst) {
                    labelTitle.setText("Set your card number");
                    labelName.setText(inputText.getText());
                }else{
                    labelTitle.setText("Set your name");
                    labelC.setText(inputText.getText());
                }
                isFirst = !isFirst;
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
