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
public class Cart implements Serializable{
    private int id;
    private String name;
    private double price;
    private int quantily;
    private String imgName;
    
    
}
