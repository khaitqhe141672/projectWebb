/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Admin
 */
@Setter
@Getter
@Builder
@ToString
public class OrderDetail implements Serializable{
    
    private int id;
    private int orderId;
    private int productId;
    private String productName;
    private double productPrice;
    private int quantity;
}
