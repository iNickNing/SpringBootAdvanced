package top.imyzt.springboot.advanced.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @Value("${testYmlValue}")
    private String ymlValue;

    @Value("${testYmlValueAdd}")
    private String testYmlValueAdd;

    @GetMapping(value = "hello/{word}")
    public @ResponseBody String hello(@PathVariable(value = "word") String word){
        return word;
    }

    @PostMapping(value = "readYmlValue/{num}")
    public @ResponseBody String readYmlValue(@PathVariable(value = "num") Integer num){
        if (num == 1){
            return ymlValue;
        }
        return testYmlValueAdd;
    }

    @GetMapping(value = "index")
    public String index(){
        return "index";
    }
}
