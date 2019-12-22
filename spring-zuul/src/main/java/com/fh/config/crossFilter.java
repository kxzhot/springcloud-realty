package com.fh.config;

import com.fh.filter.Crossfilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class crossFilter {

    @Bean
    Crossfilter crosFilter(){
        return  new Crossfilter();
    }
}
