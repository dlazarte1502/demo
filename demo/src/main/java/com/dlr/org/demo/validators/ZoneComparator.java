/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dlr.org.demo.validators;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Comparator;

/**
 *
 * @author DiegoLazarte
 */
public class ZoneComparator implements Comparator<ZoneId> {

    @Override
    public int compare(ZoneId zoneId1, ZoneId zoneId2) {
        LocalDateTime now = LocalDateTime.now();
        ZoneOffset offset1 = now.atZone(zoneId1).getOffset();
        ZoneOffset offset2 = now.atZone(zoneId2).getOffset();

        return offset1.compareTo(offset2);
    }
}