package com.api.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/** @author Oshay Jackson **/

public class AppFrame extends JFrame implements KeyListener, MouseListener {
    public AppFrame(){
        initComponents();
        setVisible(true);
    }
    private void initComponents() {
        
        requestContainer = new javax.swing.JPanel();
        textField = new javax.swing.JTextField();
        button = new javax.swing.JButton();
        responseContainer = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        responseArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 500));
        setTitle("Macro API");

        requestContainer.setBackground(Color.decode("#82AAFF"));

        textField.setBackground(Color.decode("#ecefff"));
        textField.setFont(new java.awt.Font("Ayuthaya", 0, 12));
        textField.setForeground(Color.decode("#1a1b26"));
        textField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textField.addKeyListener(this);

        button.setFont(new java.awt.Font("Ayuthaya", 0, 12));
        button.setForeground(Color.decode("#1a1b26"));
        button.setBorderPainted(true);
        button.setOpaque(false);
        button.setText("Submit");
        button.addMouseListener(this);
        
        javax.swing.GroupLayout requestContainerLayout = new javax.swing.GroupLayout(requestContainer);
        requestContainer.setLayout(requestContainerLayout);
        requestContainerLayout.setHorizontalGroup(
                requestContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(requestContainerLayout.createSequentialGroup()
                                          .addGap(20, 20, 20)
                                          .addComponent(textField, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addGap(20, 20, 20)
                                          .addComponent(button)
                                          .addGap(20, 20, 20))
                                                 );
        requestContainerLayout.setVerticalGroup(
                requestContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, requestContainerLayout.createSequentialGroup()
                                                                                      .addGap(10, 10, 10)
                                                                                      .addGroup(requestContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                        .addComponent(textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addComponent(button))
                                                                                      .addGap(15, 15, 15))
                                               );
        
        getContentPane().add(requestContainer, java.awt.BorderLayout.PAGE_END);
        
        responseContainer.setBackground(Color.decode("#FFCB8B"));
        
        responseArea.setEditable(false);
        responseArea.setBackground(Color.decode("#ecefff"));
        responseArea.setColumns(50);
        responseArea.setFont(new java.awt.Font("Ayuthaya", 0, 14));
        responseArea.setForeground(Color.decode("#1a1b26"));
        responseArea.setRows(15);
        responseArea.setBorder(null);
        responseArea.setCaretColor(Color.decode("#ecefff"));
        scrollPane.setViewportView(responseArea);
        
        javax.swing.GroupLayout responseContainerLayout = new javax.swing.GroupLayout(responseContainer);
        responseContainer.setLayout(responseContainerLayout);
        responseContainerLayout.setHorizontalGroup(
                responseContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(responseContainerLayout.createSequentialGroup()
                                          .addGap(20, 20, 20)
                                          .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addGap(20, 20, 20))
                                                  );
        responseContainerLayout.setVerticalGroup(
                responseContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(responseContainerLayout.createSequentialGroup()
                                          .addGap(15, 15, 15)
                                          .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                                          .addContainerGap())
                                                );
        
        getContentPane().add(responseContainer, java.awt.BorderLayout.CENTER);
        
        pack();
    }
    
    private void textFieldAPI() {
        String query = textField.getText(); // Get the user's input from the text field
        if (!query.isEmpty()) {
            NutritionAPI nutritionAPI = new NutritionAPI();
            NutritionInfo nutritionInfo = nutritionAPI.fetchNutritionInfo(query);
            if (nutritionInfo != null) {
                // Display the nutrition information in the response area
                responseArea.setText("Calories: " + nutritionInfo.getCalories() + "\n"
                                             + "Serving Size: " + nutritionInfo.getServingSize() + "g\n"
                                             + "Fat (Total): " + nutritionInfo.getFatTotal() + "g\n"
                                             + "Protein: " + nutritionInfo.getProtein() + "g\n"
                                             + "Sodium: " + nutritionInfo.getSodium() + "mg\n"
                                             + "Cholesterol: " + nutritionInfo.getCholesterol() + "mg\n"
                                             + "Carbohydrates (Total): " + nutritionInfo.getCarbohydratesTotal() + "g\n"
                                             + "Fiber: " + nutritionInfo.getFiber() + "g\n"
                                             + "Sugar: " + nutritionInfo.getSugar() + "g");
                System.out.println(responseArea.getText());
            } else {
                responseArea.setText("No nutrition information found for the given query.");
            }
        } else {
            responseArea.setText("Please enter a query.");
        }
    }
    
    private javax.swing.JButton button;
    private javax.swing.JPanel requestContainer;
    private javax.swing.JTextArea responseArea;
    private javax.swing.JPanel responseContainer;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTextField textField;
    
    
    @Override
    public void keyTyped(KeyEvent e) {
    
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==10){
            textFieldAPI();
            String msg = textField.getText();
            System.out.println("Message: ( " + textField.getText() + " ) was sent");
            textField.setText("");
        }
    
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
    
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==button){
            textFieldAPI();
            String msg = textField.getText();
            System.out.println("Message: ( " + textField.getText() + " ) was sent");
            textField.setText("");
        }
        
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
    
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
    
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
    
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
    
    }
}