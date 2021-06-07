/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dlr.org.demo.timezone;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author DiegoLazarte
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TimeZoneControllerTest {
    
    private static final int HOUR = 18;
    
    private static final int MINUTE = 31;
    
    private static final int SECOND = 45;
    
    private static final int TIME_DIFFERENCE = -3;
    
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void testGetTimeZoneList() throws Exception {
        mockMvc.perform(get(URI.create("/time-zones"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    
    @Test
    public void testCalculateTimeZoneCreated() throws Exception {
        Hour hour = new Hour();
        hour.setHour(HOUR);
        hour.setMinute(MINUTE);
        hour.setSecond(SECOND);
        TimeItem item = new TimeItem();
        item.setHour(hour);
        item.setTimeDifference(TIME_DIFFERENCE);
        mockMvc.perform(post("/time-zones/events")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(item)))
            .andExpect(status().isCreated());
    }
    
    @Test
    public void testCalculateTimeZoneBadRequest() throws Exception {
        mockMvc.perform(post("/time-zones/events")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(null)))
            .andExpect(status().isBadRequest());
    }
}
