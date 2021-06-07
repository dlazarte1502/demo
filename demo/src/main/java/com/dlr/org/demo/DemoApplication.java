package com.dlr.org.demo;

import com.dlr.org.demo.timezone.OffsetBase;
import java.util.TimeZone;
import javax.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    
        @PostConstruct
        public void started() {
            TimeZone.setDefault(TimeZone.getTimeZone(OffsetBase.UTC.toString()));
        }

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
