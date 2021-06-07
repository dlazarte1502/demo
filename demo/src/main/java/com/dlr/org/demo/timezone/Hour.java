/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dlr.org.demo.timezone;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author DiegoLazarte
 */
@Data
public class Hour implements Serializable{
    private int hour;
    private int minute;
    private int second;
    
    @Override
    public String toString() {
        return String.format("%s:%s:%s", hour, minute, second);
    }
}
