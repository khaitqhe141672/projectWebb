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
 * @author Shado
 */
@Getter
@Setter
@Builder
@ToString
public class Account implements Serializable{

    private int id;
    private String email;
    private String password;
    private int accountDetailId;
    private int roleId;
    private int status;
    private String createDate;
    private String activeCode;

    public String getFmDate() {
        String[] str = this.createDate.split("-");
        return str[2] + "-" + str[1] + "-" + str[0];
    }  
}
