package com.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jayson  <br/> 2015-12-08 16:16
 * @since v1.0
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping("/index")
    public String index(){
        return "admin/index";
    }
}
