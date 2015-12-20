package com.web.controller.admin;

import com.web.entity.MenuEntity;
import com.web.form.admin.LoginForm;
import com.web.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * @author jayson  <br/> 2015-12-08 16:16
 * @since v1.0
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/index")
    public String index(HttpSession session){
        List<MenuEntity> menus = menuService.findAll();
        session.setAttribute("menus" , menus);
        return "admin/index";
    }

    @RequestMapping("/loginInit")
    public String loginInit(@ModelAttribute("LoginForm") LoginForm form){
        return "admin/login";
    }

    @RequestMapping("/login")
    public String login(@Valid @ModelAttribute("LoginForm") LoginForm form , BindingResult result , Model model){
        return "admin/login";
    }
}
