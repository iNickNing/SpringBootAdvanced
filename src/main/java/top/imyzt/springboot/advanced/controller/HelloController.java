package top.imyzt.springboot.advanced.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${testYmlValue}")
    private String ymlValue;

    @GetMapping(value = "hello/{word}")
    public String hello(@PathVariable(value = "word") String word){
        return word;
    }

    @PostMapping(value = "readYmlValue")
    public String readYmlValue(){
        return ymlValue;
    }
}
