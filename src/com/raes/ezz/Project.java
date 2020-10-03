package com.raes.ezz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import java.util.List;
import javax.swing.JColorChooser;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Project extends JFrame{
    private JPanel frame;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JTextField p1;
    private JTextField p2;
    private JTextField p3;
    private JTextField p4;
    private JTextField p5;
    private JTextField q1;
    private JTextField q2;
    private JTextField q3;
    private JTextField q4;
    private JTextField q5;
    private JButton calculateButton;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItem;

    public Project(){
        JTextField[] inputs = new JTextField[]{q1,q2,q3,q4,q5,p1,p2,p3,p4,p5};
        menuBar = new JMenuBar();
        menu = new JMenu("Settings");
        menuBar.add(menu);
        menuItem = new JMenuItem(new ChangeColor(this.frame));
        menu.add(menuItem);
        menuItem = new JMenuItem(new ChangeTitle(this));
        menu.add(menuItem);
        menuBar.add(menu);
        setBounds(0,0,600,300);
        this.setJMenuBar(menuBar);
        this.setTitle("Products");
        add(frame);
        calculateButton.setEnabled(false);
        for (int i = 0; i < inputs.length; i++) {
            inputs[i].getDocument().addDocumentListener(new DocumentListener() {
                public void changedUpdate(DocumentEvent e) {
                    changed();
                }
                public void removeUpdate(DocumentEvent e) {
                    changed();
                }
                public void insertUpdate(DocumentEvent e) {
                    changed();
                }
                public void changed() {
                    for (int k = 0; k < inputs.length; k++) {
                        if (inputs[k].getText().equals("")){
                            calculateButton.setEnabled(false);
                        } else {
                            calculateButton.setEnabled(true);
                        }
                    }
                }
            });
        }
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double d = Double.parseDouble(JOptionPane.showInputDialog("Set discount ?%"));
                Double t1 = Double.parseDouble(q1.getText()) * Double.parseDouble(p1.getText());
                Double t2 = Double.parseDouble(q2.getText()) * Double.parseDouble(p2.getText());
                Double t3 = Double.parseDouble(q3.getText()) * Double.parseDouble(p3.getText());
                Double t4 = Double.parseDouble(q4.getText()) * Double.parseDouble(p4.getText());
                Double t5 = Double.parseDouble(q5.getText()) * Double.parseDouble(p5.getText());
                Double subtotal = t1+t2+t3+t4+t5;
                Double iva = subtotal * 0.12;
                subtotal = iva + subtotal;
                Double total = subtotal - (subtotal * (d/100));
                JOptionPane.showMessageDialog(null, "Result:"
                        + "\n" + q1.getText() + " " + comboBox1.getSelectedItem().toString() + " without iva: " + t1
                        + "\n" + q2.getText() + " " + comboBox2.getSelectedItem().toString() + " without iva: " + t2
                        + "\n" + q3.getText() + " " + comboBox3.getSelectedItem().toString() + " without iva: " + t3
                        + "\n" + q4.getText() + " " + comboBox4.getSelectedItem().toString() + " without iva: " + t4
                        + "\n" + q5.getText() + " " + comboBox5.getSelectedItem().toString() + " without iva: " + t5
                        + "\nSubtotal with iva: " + subtotal
                        + "\nDiscount " + d + "%: " + subtotal * (d/100)
                        + "\nTotal: " + total);
            }
        });
    }
}

class ChangeColor extends AbstractAction {
    Component parentComponent;
    private Color current;
    public ChangeColor(Component parentComponent) {
        super("Change color background");
        this.parentComponent = parentComponent;
    }
    public void actionPerformed(ActionEvent actionEvent) {
        addColorChangedListener(newColor -> parentComponent.setBackground(current));
        Color newColor = JColorChooser.showDialog(null, "Choose a color", current);
        setSelectedColor(newColor);
    }
    public void setSelectedColor(Color newColor) {
        setSelectedColor(newColor, true);
    }
    public void setSelectedColor(Color newColor, boolean notify) {
        if (newColor == null) return;
        current = newColor;
        if (notify) {
            for (ColorChangedListener l : listeners) {
                l.colorChanged(newColor);
            }
        }
    }
    public interface ColorChangedListener {
        void colorChanged(Color newColor);
    }
    private final List<ColorChangedListener> listeners = new ArrayList<>();
    public void addColorChangedListener(ColorChangedListener toAdd) {
        listeners.add(toAdd);
    }
}

class ChangeTitle extends AbstractAction {
    JFrame parentComponent;
    public ChangeTitle(JFrame parentComponent) {
        super("Change title");
        this.parentComponent = parentComponent;
    }
    public void actionPerformed(ActionEvent actionEvent) {
        String title = JOptionPane.showInputDialog("Please input your custom title");
        parentComponent.setTitle(title);
    }
}
