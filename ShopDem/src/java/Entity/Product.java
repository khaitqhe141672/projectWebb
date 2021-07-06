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

 * @author Admin
 */
@Setter
@Getter
@Builder
@ToString
public class Product implements Serializable{
    //khai bao cac doi tuong o trong bang sql
    private int id;
    private int brandID;
    private int categoryID;
    private int colorID;
    private int sizeID;
    private int materialID;
    private String name;
    private double price;
    private int quantity;
    private String description;
    private String imgName;
    private String note;
    private int status;
    
}
