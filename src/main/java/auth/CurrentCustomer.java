package auth;

import pojo.Customer;

public class CurrentCustomer {

    private static Customer customer = null;


    private CurrentCustomer(){}

    public static Customer getCustomer(){
        return customer;
    }

    public static void setCustomer(Customer c){

        customer = c;
    }


}
