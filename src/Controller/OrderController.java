/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB.OrderList;
import Model.OrderDetails;

/**
 *
 * @author shara
 */
public class OrderController {
    
    	// orders array
	public static OrderList list  = new OrderList();
	
	// generate order Id
	public static String generateOrderId() {
		if (list.size()==0){
			return "B0001";
		}
		String lastOrderId = list.get(list.size()-1).getOrderId();
		int number = Integer.parseInt(lastOrderId.split("B")[1]); //1
		number++;//2
		return String.format("B%04d",number); //printf("",) //B0002
	}

	// validation Customer ID
	public static boolean validationcustomerId(String customerId) {
        if (customerId.length() == 10) {
            if (customerId.startsWith("0")) {
                try {
                    int i = Integer.parseInt(customerId);
                    return true;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        }
        return false;
    }
    
    // view orders details
	public static String viewOrderDetails(int i){
		String line = String.format("%1s%-10s%-15s%-15s%-10d%8.2f", " ", list.get(i).getOrderId(), list.get(i).getCustomerId(),
									list.get(i).getCustomerName(), list.get(i).getOrderQTY(), list.get(i).getOrderValue());
		return line;
	}
	
	//searching for customer ID
	public static String isExistCustomer(String customerId){
		String name="";
		for(int i=0 ; i < list.size() ; i++){
			if(customerId.equals(list.get(i).getCustomerId())){
				name=list.get(i).getCustomerName();
				break;
			}
		}
		return name;
	}
	
	//add order
	public static void add(OrderDetails data){
		list.add(data);
	}
	
	public static OrderDetails[] toArray(){
		return list.toArray();
	}
	
//	public static OrderDetails[] addUniqueValuesToArray(OrderDetails[] orderArray){
//		OrderDetails[] sortOrderArray = new OrderDetails[0];
//		for (int i = 0; i < orderArray.length; i++) {
//			boolean isExist = false;
//			for (int j = 0; j < sortOrderArray.length; j++) {
//                if (sortOrderArray[j].getCustomerId().equals(orderArray[i].getCustomerId())) {
//                    if (orderArray[i].getOrderStatus()!=View.CANCEL){
//						sortOrderArray[j].setOrderValue(sortOrderArray[j].getOrderValue()+orderArray[i].getOrderValue());
//					}
//                    isExist = true;
//                }
//            }
//            if (!isExist) {
//				OrderDetails[] tempSortOrderArray = new OrderDetails[sortOrderArray.length+1];
//                for (int j = 0; j < sortOrderArray.length; j++) {
//					tempSortOrderArray[j]=new OrderDetails(
//						sortOrderArray[j].getOrderId(),
//						sortOrderArray[j].getCustomerId(),
//						sortOrderArray[j].getCustomerName(),
//						sortOrderArray[j].getOrderStatus(),
//						sortOrderArray[j].getOrderQTY(),
//						sortOrderArray[j].getOrderValue()
//					);
//                }
//                tempSortOrderArray[tempSortOrderArray.length-1]= new OrderDetails(
//					orderArray[i].getOrderId(),
//					orderArray[i].getCustomerId(),
//					orderArray[i].getCustomerName(),
//					orderArray[i].getOrderStatus(),
//					orderArray[i].getOrderQTY(),
//					orderArray[i].getOrderValue()	
//                );
//                sortOrderArray=tempSortOrderArray;
//            }
//        }
//        return sortOrderArray;
//	}
	
	public static OrderDetails[] sortArray(OrderDetails[] sortOrderArray){
		for (int i = 1; i < sortOrderArray.length; i++) {
            for (int j = 0; j < i; j++) {
                if (sortOrderArray[j].getOrderValue() < sortOrderArray[i].getOrderValue()) {
					String temp = sortOrderArray[j].getCustomerId();
					sortOrderArray[j].setCustomerId(sortOrderArray[i].getCustomerId());
					sortOrderArray[i].setCustomerId(temp);
                    
					temp = sortOrderArray[j].getCustomerName();
					sortOrderArray[j].setCustomerName(sortOrderArray[i].getCustomerName());
					sortOrderArray[i].setCustomerName(temp);
                    
					double tempd = sortOrderArray[j].getOrderValue();
					sortOrderArray[j].setOrderValue(sortOrderArray[i].getOrderValue());
					sortOrderArray[i].setOrderValue(tempd);
				}
			}
		}
		return sortOrderArray;
	}
	
//	public static String getOrderDetail(String orderId){
//		String line="";
//		for (int i = 0; i < list.size() ; i++) {
//			if (orderId.equals(list.get(i).getOrderId())) {
//				String status = "";
//                switch (list.get(i).getOrderStatus()) {
//					case View.CANCEL:
//						status = "Cancel";
//						break;
//					case View.PREPARING:
//						status = "Preparing";
//						break;
//					case View.DELIVERED:
//						status = "Delivered";
//						break;
//				}
//                line = String.format("%1s%-10s%-14s%-15s%-10d%-14.2f%-10s", " ", list.get(i).getOrderId(), list.get(i).getCustomerId(), 
//								list.get(i).getCustomerName(), list.get(i).getOrderQTY(), list.get(i).getOrderValue(), status);
//                break;
//			}
//		}
//		return line;
//	}
	
	public static OrderDetails getOrder(int index){
		return list.get(index);
	}
	
	//size of linked list
	public static int size(){
		return list.size();
	}
	
    
}
