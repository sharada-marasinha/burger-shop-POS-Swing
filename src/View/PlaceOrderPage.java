/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.OrderController;
import Model.OrderDetails;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author shara
 */
public class PlaceOrderPage extends JFrame{
    private JLabel lblHome;
    
    private JLabel lblOrderId;
    private JLabel lblCustomerName;
    private JLabel lblCustomerId;
    private JLabel lblQty;
    private JLabel lblNetTotal;
    private JLabel lblNetTotalValue;
    
    private JButton btnPlaceOrder;
    private JButton btnAddCustomer;
    private JButton btnAddingTotal;
    
    private JTextField txtOrderId;
    private JTextField txtNamePh;
    private JTextField txtCustomerId;
    private JTextField txtQty;
    
    private int qty;
    
    public PlaceOrderPage(){
        setTitle("Place Order Page");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setLayout(null);
        
        Font lblFonts=new Font("",Font.BOLD,15);
        
        lblHome = new JLabel();
        lblHome.setText("Place Order Form");
        lblHome.setFont(new Font("",Font.PLAIN,40));
        lblHome.setForeground(Color.white);
        lblHome.setBounds(0,0,500,70);
        
        lblHome.setVerticalAlignment(JLabel.CENTER);
        lblHome.setHorizontalAlignment(JLabel.CENTER);
        lblHome.setBackground(new Color(47,79,79));
        lblHome.setOpaque(true);
        
        lblOrderId=new JLabel();
        lblOrderId.setText("Order Id :");
        lblOrderId.setFont(lblFonts);
        lblOrderId.setBounds(50, 100, 100, 20);
        
        
        lblCustomerName=new JLabel();
        lblCustomerName.setText("Name or PH :");
        lblCustomerName.setFont(lblFonts);
        lblCustomerName.setBounds(50, 150, 100, 20);
        
        lblCustomerId=new JLabel();
        lblCustomerId.setText("Customer Id :");
        lblCustomerId.setFont(lblFonts);
        lblCustomerId.setBounds(50, 200, 100, 20);
        
        lblQty=new JLabel();
        lblQty.setText("QTY :");
        lblQty.setFont(lblFonts);
        lblQty.setBounds(50, 250, 100, 20);
        
        lblNetTotal=new JLabel();
        lblNetTotal.setText("Net Total :");
        lblNetTotal.setFont(lblFonts);
        lblNetTotal.setBounds(50, 300, 100, 20);
        
        lblNetTotalValue=new JLabel();
        lblNetTotalValue.setText("0");
        lblNetTotalValue.setFont(lblFonts);
        lblNetTotalValue.setBounds(150, 300, 100, 20);
        lblNetTotalValue.setForeground(Color.red);
        
        txtOrderId=new JTextField("O000");
        txtOrderId.setEditable(false);
        txtOrderId.setBounds(120, 100, 100, 25);
        txtOrderId.setText(OrderController.generateOrderId());
        
        txtNamePh=new JTextField();
        txtNamePh.setBounds(150, 150, 150, 25);
        
        txtCustomerId=new JTextField();
        txtCustomerId.setBounds(150, 200, 150, 25);
        txtCustomerId.setEditable(false);
        txtCustomerId.setText(OrderController.generateCustomerId());
        
        txtQty=new JTextField();
        txtQty.setBounds(150, 250, 150, 25);
        
        btnAddingTotal=new JButton("+");
        btnAddingTotal.setFont(lblFonts);
        btnAddingTotal.setBounds(300, 250, 50, 25);
        btnAddingTotal.setFocusable(false);
        btnAddingTotal.addActionListener(evt ->{
            qty=Integer.parseInt(txtQty.getText());
            qty*=OrderController.burgerPrice;
            lblNetTotalValue.setText(qty+"/=");
        });
        
        btnPlaceOrder=new JButton("Place Order");
        btnPlaceOrder.setFont(lblFonts);
        btnPlaceOrder.setBounds(300, 400, 150, 40);
        btnPlaceOrder.setFocusable(false);
        btnPlaceOrder.addActionListener(evt ->{
            System.out.println("Order Placed");
         OrderDetails orderObj = new OrderDetails(
                    txtOrderId.getText(),
                    txtCustomerId.getText(),
                    txtNamePh.getText(),
                    1,
                    Integer.parseInt(txtQty.getText()),
                    qty
            );
            System.out.println(orderObj);
            OrderController.add(orderObj);
            clearTxt();
            setNextId();
        });
        
        
        add(lblOrderId);
        add(lblCustomerName);
        add(lblCustomerId);
        add(lblQty);
        add(lblNetTotal);
        add(lblNetTotalValue);
        add(lblHome);
        
        add(txtOrderId);
        add(txtNamePh);
        add(txtCustomerId);
        add(txtQty);
        
        add(btnPlaceOrder);
        add(btnAddingTotal);
    }
    private void clearTxt(){
        txtNamePh.setText(null);
        txtQty.setText(null);
        lblNetTotalValue.setText("0");
    }
    private void setNextId(){
        txtCustomerId.setText(OrderController.generateCustomerId());
        txtOrderId.setText(OrderController.generateOrderId());
    }
}
