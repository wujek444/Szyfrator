/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szyfrator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author jrwoj_000
 */
public class Okienko extends JFrame implements ActionListener{
    JTextField inputTxt, outputTxt, stateTxt;
    JLabel inputLabel, outputLabel, shiftLabel;
    JButton cipherBtn, decipherBtn, reset, setShiftBtn;
    JPanel shiftPanel, lowerBtnPanel, menuPanel;
    JSpinner shiftSpinner;
    SpinnerNumberModel shiftSpinnerModel;
    JMenu fileMenu;
    JMenuBar menuBar;
    JMenuItem open, save;
    
    Okienko(){
        super("Maszyna Szyfrująca");
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS ));
        
        menuPanel = new JPanel(new FlowLayout());
        menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout());
        menuPanel.setBackground(Color.orange);
        menuPanel.add(menuBar);
        fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        open = new JMenuItem("Open");
        save = new JMenuItem("Save");
        fileMenu.add(open);
        fileMenu.add(save);
        add(menuPanel);
        
        
        shiftPanel = new JPanel(new FlowLayout());
        shiftLabel = new JLabel("Set shift:");
        shiftPanel.add(shiftLabel);
        shiftSpinnerModel = new SpinnerNumberModel(1,1,26,1);
        shiftSpinner = new JSpinner(shiftSpinnerModel);
        shiftPanel.add(shiftSpinner);
        setShiftBtn = new JButton(new AbstractAction("Set"){
            @Override
            public void actionPerformed(ActionEvent e) {
                KodCezara.przesuniecie = (int)shiftSpinner.getValue();
                stateTxt.setText("Przesunięcie: " + KodCezara.przesuniecie);
            }
            
        });
        shiftPanel.add(setShiftBtn);
        add(shiftPanel);
        inputLabel = new JLabel("Input:");
        add(inputLabel);
        inputTxt = new JTextField(20);
        inputTxt.setBorder(BorderFactory.createBevelBorder(1, Color.gray, Color.black));
        add(inputTxt);
        outputLabel = new JLabel("Output:");
        add(outputLabel);
        outputTxt = new JTextField(20);
        outputTxt.setEditable(false);
        outputTxt.setBorder(BorderFactory.createBevelBorder(1, Color.gray, Color.black));
        add(outputTxt);
        
        lowerBtnPanel = new JPanel(new FlowLayout());
        cipherBtn = new JButton("Cipher");
        cipherBtn.addActionListener((ActionListener)this);
        lowerBtnPanel.add(cipherBtn);
        decipherBtn = new JButton(new AbstractAction("Decipher"){
            @Override
            public void actionPerformed(ActionEvent e) {
                String tmpInput = inputTxt.getText();
                KodCezara.napis = tmpInput;
                KodCezara.odszyfruj();
                outputTxt.setText(KodCezara.napis);
            }
            
        });
        lowerBtnPanel.add(decipherBtn);
        reset = new JButton(new AbstractAction("Reset"){
            @Override
            public void actionPerformed(ActionEvent e){
                inputTxt.setText(null);
                outputTxt.setText(null);
                stateTxt.setText("Ustaw przesunięcie!");
                shiftSpinner.setValue(1);
            }
        });
        lowerBtnPanel.add(reset);
        stateTxt = new JTextField("Ustaw przesunięcie!");
        stateTxt.setEditable(false);
        lowerBtnPanel.add(stateTxt);
        add(lowerBtnPanel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String tmpInput = inputTxt.getText();
        KodCezara.napis = tmpInput;
        KodCezara.szyfruj();
        outputTxt.setText(KodCezara.napis);
    }
}
