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
public class Order implements Serializable{
    private  int id;
    private String name;
    private String mobile;
    private String address;
    private double total;
    private String note;
    private int accountId;
    private String createDate;
    private int status;
    
    public String getFmDate() {
        String[] str = this.createDate.split("-");
        return str[2] + "-" + str[1] + "-" + str[0];
    }  
}
