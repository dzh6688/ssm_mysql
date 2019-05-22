package com.test.controller;

import com.test.model.User;
import com.test.service.ItestService;
import com.util.ResultJOdd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/home")
public class testController {
    @Autowired
    private ItestService testService;

    @RequestMapping(value={"/test"},method = {RequestMethod.POST})
    @ResponseBody
    public ResultJOdd test(@RequestParam (value="id") String id, User user){
        return ResultJOdd.getDefaultResult(testService.test());
    }

    @RequestMapping(value={"/hi"},method = {RequestMethod.GET})
    @ResponseBody
    public String test(){
        User aa = testService.test();
//        return ResultJOdd.getDefaultResult(testService.test());
        return aa.toString();
    }

}
