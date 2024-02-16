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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author shara
 */
public class ViewOrdersPage extends JFrame{
    private JTable ordersTable;
    private DefaultTableModel dtm;
    private JLabel lblTitle;
    
    public ViewOrdersPage(){
        setTitle("View Orders Form");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        
        lblTitle = new JLabel();
        lblTitle.setText("View Orders Form");
        lblTitle.setFont(new Font("",Font.PLAIN,40));
        lblTitle.setForeground(Color.white);
        lblTitle.setBounds(0,0,800,70);
        
        lblTitle.setVerticalAlignment(JLabel.CENTER);
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        lblTitle.setBackground(new Color(47,79,79));
        lblTitle.setOpaque(true);
        
        String [] columnNames ={"Order Id","Customer Id","Customer Name","Order Status","QTY","Total"};
        dtm= new DefaultTableModel(columnNames,0);
        ordersTable=new JTable(dtm);
        
        JScrollPane tblPane=new JScrollPane(ordersTable);
        tblPane.setBounds(70, 80, 650, 400);
        
        add(tblPane);
        add(lblTitle);
        
        loadTable();
    }
    private void loadTable(){
        OrderDetails [] orderArray=OrderController.toArray();
        dtm.setRowCount(0);
        for(int i=0;i<orderArray.length;i++){
            OrderDetails obj = orderArray[i];
            Object[] rowdata={
                obj.getOrderId(),
                obj.getCustomerId(),
                obj.getCustomerName(),
                obj.getOrderStatus(),
                obj.getOrderQTY(),
                obj.getOrderValue()
            };
            dtm.addRow(rowdata);
        }
    }
}
