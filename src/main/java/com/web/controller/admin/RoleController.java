package com.web.controller.admin;

import com.web.entity.RoleEntity;
import com.web.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author jayson  <br/> 2016-01-19 21:58
 * @since v1.0
 */
@Controller
@RequestMapping("/admin/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/list")
    public String list(Model model){
        List<RoleEntity> roleEntities = roleService.findAll();
        model.addAttribute("roleEntities" , roleEntities);
        return "admin/role/list";
    }

    @RequestMapping("/addInit")
    public String addInit(){
        return "";
    }
}
