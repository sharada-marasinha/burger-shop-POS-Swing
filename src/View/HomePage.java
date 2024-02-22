/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
    private JButton btnExit;
    
    private JLabel lblHome;
    
    public HomePage(){
        initComponents();
    }
    private void initComponents(){
    
        btnAddCustomer=new JButton("Add Customer");
        btnAddCustomer.setFont(new Font("",Font.PLAIN,15));
        btnAddCustomer.setBounds(100, 100, 300, 40);
        btnAddCustomer.setFocusable(false);
        btnAddCustomer.addActionListener(evt ->{
            
        });
        
        btnPlaceOrder=new JButton("Place Order");
        btnPlaceOrder.setFont(new Font("",Font.PLAIN,15));
        btnPlaceOrder.setBounds(100, 150, 300, 40);
        btnPlaceOrder.setFocusable(false);
        btnPlaceOrder.addActionListener(evt ->{
            new PlaceOrderPage().setVisible(true);
        });
        
        btnSearch=new JButton("Search");
        btnSearch.setFont(new Font("",Font.PLAIN,15));
        btnSearch.setBounds(100, 200, 300, 40);
        btnSearch.setFocusable(false);
        btnSearch.addActionListener(evt ->{
            new SearchMenuForm().setVisible(true);
        });
        
        btnViewOrder=new JButton("View Orders");
        btnViewOrder.setFont(new Font("",Font.PLAIN,15));
        btnViewOrder.setBounds(100, 250, 300, 40);
        btnViewOrder.setFocusable(false);
        btnViewOrder.addActionListener(evt ->{
            new ViewOrdersPage().setVisible(true);
        });
        
        btnUpdateOrder=new JButton("Update order");
        btnUpdateOrder.setFont(new Font("",Font.PLAIN,15));
        btnUpdateOrder.setBounds(100, 300, 300, 40);
        btnUpdateOrder.setFocusable(false);
        btnUpdateOrder.addActionListener(evt ->{
            new UpdateOrderForm().setVisible(true);
        });
        
        btnExit=new JButton("EXIT");
        btnExit.setFont(new Font("",Font.PLAIN,15));
        btnExit.setBounds(300, 370, 100, 40);
        btnExit.setFocusable(false);
        btnExit.addActionListener(evt ->{
            System.exit(0);
        });
        
        lblHome = new JLabel();
        lblHome.setText("Home Page");
        lblHome.setFont(new Font("",Font.PLAIN,40));
        lblHome.setForeground(Color.white);
        lblHome.setBounds(0,0,500,70);
        
        lblHome.setVerticalAlignment(JLabel.CENTER);
        lblHome.setHorizontalAlignment(JLabel.CENTER);
        lblHome.setBackground(new Color(47,79,79));
        lblHome.setOpaque(true);
        
        setTitle("Home Page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setLayout(null);
        
        
        add(lblHome);
        
        add(btnPlaceOrder);
        add(btnAddCustomer);
        add(btnSearch);
        add(btnViewOrder);
        add(btnUpdateOrder);
        add(btnExit);
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../img/icon/icons8-customer-48.png")));
        
    }
}
