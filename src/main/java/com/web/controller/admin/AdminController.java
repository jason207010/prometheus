package com.web.controller.admin;

import com.web.form.admin.LoginForm;
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

    @RequestMapping("/loginInit")
    public String loginInit(){
        return "admin/login";
    }

    @RequestMapping("/login")
    public String login(LoginForm form){
        return "admin/index";
    }
}
