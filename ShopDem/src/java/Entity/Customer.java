/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

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
public class Customer {
    private int id;
    private  String customerName;
    private int productId;
    private int sizeId;
    private String note;
}
