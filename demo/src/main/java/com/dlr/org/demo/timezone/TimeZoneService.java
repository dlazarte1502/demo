/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dlr.org.demo.timezone;

import com.dlr.org.demo.validators.ZoneComparator;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 *
 * @author DiegoLazarte
 */
@Service
public class TimeZoneService {
    
    private static final String TO_CHANGE = ":";
    private static final String REPLACE_TIMEZONE = "+00:00";
    private static final String REPLACE_UTC = "Z";
    private static final int ZERO = 0;
    
    public TimeItemDTO calculateTimeZone(LocalTime time, int hour) {
        TimeItemDTO item = new TimeItemDTO();
        LocalTime result;
        Hour data = new Hour();
        if(hour > ZERO) {
            result = time.plusHours(hour);
        } else {
            result = time.minusHours(Math.abs(hour));
        }
        data.setHour(result.getHour());
        data.setMinute(result.getMinute());
        data.setSecond(result.getSecond());
        item.setTime(data.toString());
        item.setTimeZone(OffsetBase.UTC.toString());
        return item;
    }
    
    public List<TimeZoneItem> getTimeZoneList(OffsetBase base) {
    LocalDateTime now = LocalDateTime.now();
    return ZoneId.getAvailableZoneIds().stream()
      .map(ZoneId::of)
      .sorted(new ZoneComparator())
      .map(id -> generateTimeZoneItem(id.getId(), base + getOffset(now, id), getOffset(now, id)))
      .collect(Collectors.toList());
    }
    
    private TimeZoneItem generateTimeZoneItem(String id, String timezone, String data) {
        int hour = Integer.parseInt(data.substring(ZERO, data.indexOf(TO_CHANGE)));
        return new TimeZoneItem(id, timezone, hour);
    }
    
    private String getOffset(LocalDateTime dateTime, ZoneId id) {
    return dateTime
      .atZone(id)
      .getOffset()
      .getId()
      .replace(REPLACE_UTC, REPLACE_TIMEZONE);
    }
}
