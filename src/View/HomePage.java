/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author shara
 */
public class HomePage extends JFrame{
    
    private JButton btnAddCustomer;
    private JButton btnPlaceOrder;
    private JButton btnSearch;
    private JButton btnViewOrder;
    private JButton btnUpdateOrder;
    
    public HomePage(){
        setTitle("Home Page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        
        btnAddCustomer=new JButton("Add Customer");
        btnAddCustomer.setFont(new Font("",Font.PLAIN,15));
        btnAddCustomer.setBounds(100, 100, 300, 40);
        
        
        add(btnAddCustomer);
        
    }
}
