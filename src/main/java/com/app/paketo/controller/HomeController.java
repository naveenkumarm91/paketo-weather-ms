package com.app.paketo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("v1/app/")
public class HomeController {

    @GetMapping("home")
    public ResponseEntity<?> getGreeting() {
        Date date = new Date();
        return new ResponseEntity<>("Hello welcome... @" + date, HttpStatus.OK);
    }
}
