package com.example.productservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//This controller supports Rest API's (HTTP Request)
//The Request coming to endpoint /hello, transfer them to this controller
@RestController
@RequestMapping("/hello")
public class SampleController {
    @GetMapping("/xyz/{name}")
    public String sayHello(@PathVariable String name){
        return "Hel" + name;
    }

}
