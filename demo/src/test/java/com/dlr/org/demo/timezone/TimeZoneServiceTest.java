/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dlr.org.demo.timezone;

import java.time.LocalTime;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.core.Is.is;

/**
 *
 * @author DiegoLazarte
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TimeZoneService.class})
public class TimeZoneServiceTest {
    
    private static final int ZERO = 0;
    
    private static final int THREE_NEGATIVE = -3;
    
    private static final int THREE_POSITIVE = 3;
    
    private static final int HOUR = 18;
    
    private static final int MINUTE = 31;
    
    private static final int SECOND = 45;
    
    private static final int VALID_HOUR_1 = 15;
    
    private static final int VALID_HOUR_2 = 21;
    
    @Autowired
    private TimeZoneService timeZoneService;
    
    @Test
    public void calculateTimeZoneWithNegativeNumberTest() {
        TimeItemDTO item = timeZoneService
                .calculateTimeZone(LocalTime.of(HOUR, MINUTE, SECOND), THREE_NEGATIVE);
        assertThat(item.getTime(), is(String.format("%s:%s:%s", VALID_HOUR_1, MINUTE, SECOND)));
    }
    
    @Test
    public void calculateTimeZoneWithPositieNumberTest() {
        TimeItemDTO item = timeZoneService
                .calculateTimeZone(LocalTime.of(HOUR, MINUTE, SECOND), THREE_POSITIVE);
        assertThat(item.getTime(), is(String.format("%s:%s:%s", VALID_HOUR_2, MINUTE, SECOND)));
    }
    
    @Test
    public void calculateTimeZoneWithZeroNumberTest() {
        TimeItemDTO item = timeZoneService
                .calculateTimeZone(LocalTime.of(HOUR, MINUTE, SECOND), ZERO);
        assertThat(item.getTime(), is(String.format("%s:%s:%s", HOUR, MINUTE, SECOND)));
    }
}
