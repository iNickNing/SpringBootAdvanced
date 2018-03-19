package top.imyzt.springboot.app.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Api(value = "hello")
public class HelloController {

    @Value("${testYmlValue}")
    private String ymlValue;

    @Value("${testYmlValueAdd}")
    private String testYmlValueAdd;

    @ApiOperation(value = "Get方式传递内容")
    @GetMapping(value = "hello/{word}")
    public @ResponseBody String hello(@PathVariable(value = "word") String word){
        return word;
    }

    @ApiOperation(value = "Post方式读取Yml文件内容")
    @PostMapping(value = "readYmlValue/{num}")
    public @ResponseBody String readYmlValue(@PathVariable(value = "num") Integer num,
                                             @RequestParam(value = "def", required = false, defaultValue = "default") String def){
        if (num == 1)
            return ymlValue;
        else
            return testYmlValueAdd;
    }

    @ApiOperation(value = "Get方式请求模板页面")
    @GetMapping(value = {"index","blog"})
    public String index(){
        return "index";
    }
}
