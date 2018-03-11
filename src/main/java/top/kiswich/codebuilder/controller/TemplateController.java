package top.kiswich.codebuilder.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TemplateController {

    @GetMapping("/date/")
    @ResponseBody
    public String getDate(){


        return null;
    }
}
