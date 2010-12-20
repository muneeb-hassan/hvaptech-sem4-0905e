/*
 * Billing.java
 *
 * This program demonstrates the the use of bean and it calculate the total bill
 *
 * Copyright © 2007 Aptech Software Limited. All rights reserved.
 */
package Mybean;
import java.io.*;
/**
 * The Billing class calculate the total bill.
 *
 * @author Vincent
 */
public class Billing {
    /**
     * Initialize the registrationcost and quantity as zero
     */
    private int registrationcost = 0;
    private int quantity = 0;
    /** 
     * Creates a new instance of Billing 
     */
    public Billing() {
    }
    public void setRegistrationcost(int prod) {
        this.registrationcost = prod;
    }
    /**
     * Return the total cost
     */
    public int getRegistrationcost() {
        return (registrationcost * quantity);
    }
    public void setQuantity(int quant) {
        this.quantity = quant;
    }
    /**
     * Return the total quantity
     */
    public int getQuantity() {
        return quantity;
    }
}
