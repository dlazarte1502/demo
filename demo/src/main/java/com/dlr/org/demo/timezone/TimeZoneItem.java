/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dlr.org.demo.timezone;

import lombok.Data;

/**
 *
 * @author DiegoLazarte
 */
@Data
public class TimeZoneItem {
    private String zoneId;
    private String timeZone;
    private int hour;

    public TimeZoneItem(String zoneId, String timeZone, int hour) {
        this.zoneId = zoneId;
        this.timeZone = timeZone;
        this.hour = hour;
    }
}
