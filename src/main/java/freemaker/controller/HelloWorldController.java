package freemaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/freeMarker")
public class HelloWorldController {
    
    @RequestMapping("/hello")
    public String sayHello(ModelMap map) {
        System.out.println("say Hello ……");
        map.addAttribute("name", " World!");
        return "/hello.ftl";
    }
    
    @RequestMapping("/hi")
    public String sayHi(ModelMap map) {
        System.out.println("say hi ……");
        map.put("name", "jojo");
        return "/hi.ftl";
    }
    
    @RequestMapping("/jsp")
    public String jspRequest(ModelMap map) {
        System.out.println("jspRequest ……");
        map.put("name", "jsp");
        return "/jsp/temp.jsp";
    }
}