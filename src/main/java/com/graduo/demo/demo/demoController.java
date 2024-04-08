package com.graduo.demo.demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class demoController {
    
    @PostMapping(value = "demo")
    public String welcome() {
        return "welcome ";
    }
    
}
