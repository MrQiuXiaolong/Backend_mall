package com.qiu.controller;




import com.qiu.service.SmallTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/smallType")
public class SmallTypeController {
    @Autowired
    private SmallTypeService smallTypeService;

}
