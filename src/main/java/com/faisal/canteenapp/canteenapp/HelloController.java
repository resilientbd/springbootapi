package com.faisal.canteenapp.canteenapp;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.jvm.hotspot.HelloWorld;

@RestController
public class HelloController {
    @RequestMapping(method = RequestMethod.GET, path = "hello-world")
    public String HelloWorld() {
        return "Hello Wolrd!";
    }

    @RequestMapping(path = "hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("message");
    }

    @RequestMapping(path = "hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldBeanPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Name given:%s",name));
    }
}
