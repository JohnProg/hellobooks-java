package com.kelechi.andela.hellobooks.controllers;

import com.kelechi.andela.hellobooks.pojo.TestPojo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping(path="/testing")
    public TestPojo testPojo(){
        return new TestPojo("Kelechi Ihenyichukwu", "kelechi");
    }
}
