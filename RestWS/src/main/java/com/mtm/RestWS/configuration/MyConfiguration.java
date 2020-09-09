package com.mtm.RestWS.configuration;

import com.mtm.RestWS.tools.AsyncHttpTester;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {
    @Bean
    public AsyncHttpTester getAsyncHttpTest(){
        return new AsyncHttpTester();
    }
}
