/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dlr.org.demo.timezone;

import java.time.LocalTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DiegoLazarte
 */
@RestController
@RequestMapping("/time-zones")
public class TimeZoneController {
    
    @Autowired
    private TimeZoneService service;

    @PostMapping("/events")
    public ResponseEntity<?> getTimes(@RequestBody final TimeItem item) {
        Hour value = item.getHour();
        LocalTime time = LocalTime.of(value.getHour(), value.getMinute(), value.getSecond());
        TimeItemDTO data = service.calculateTimeZone(time, item.getTimeDifference());
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }
    
    @GetMapping
    public ResponseEntity<List<TimeZoneItem>> getTimeZoneList() {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(service.getTimeZoneList(OffsetBase.UTC));
    }

}
