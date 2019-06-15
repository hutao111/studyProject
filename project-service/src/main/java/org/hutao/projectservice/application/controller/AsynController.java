package org.hutao.projectservice.application.controller;

import org.hutao.projectservice.application.service.impl.AsnyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/asyn")
public class AsynController {

    @Autowired
    AsnyService asnyService;

    @GetMapping("/hello")
    public String  h() {
        asnyService.hello();
        return "success";
    }
}
