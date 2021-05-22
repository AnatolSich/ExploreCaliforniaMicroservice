package com.example.explore.exploreCalifornia;

import com.example.explore.exploreCalifornia.domain.Difficulty;
import com.example.explore.exploreCalifornia.domain.Region;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class ExploreCaliforniaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExploreCaliforniaApplication.class, args);
    }

}
