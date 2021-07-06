/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.List;

/**
 *
 * @author Admin
 */
public interface IMethod<E> {
    //in ra tat ca nhung j mk co
    List<E> getAll();
    // chi in ra 1 cai mk muon
    E getOne(int id);
    
    boolean add(E obj);
    
    boolean update(int id, E obj);
    
    boolean remove(int id);
}
