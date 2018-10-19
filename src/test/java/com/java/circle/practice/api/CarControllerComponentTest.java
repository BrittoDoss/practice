package com.java.circle.practice.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CarControllerComponentTest {
    public static final String BASE_URL = "/v1/car/";
    @Autowired
    private MockMvc mockMvc;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void shouldReturnRequestedCarByLicencePlate() throws Exception {
        logger.info ( "should Return Requested Car By LicencePlate" );
        mockMvc.perform(get(BASE_URL + "ABC-123"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("{\"licensePlate\":\"ABC-123\",\"brand\":\"BMW\",\"consumption\":10}"));
    }

    @Test
    public void shouldReturnErrorMessage_whenLicencePlateIsTooLong() throws Exception {
        logger.info ( "should Return Error Message when Licence Plate Is Too Long" );
        mockMvc.perform(get(BASE_URL + "ABC-1233333333"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Bad licence plate format!"));
    }
}