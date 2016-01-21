package com.web.controller.admin;

import com.web.entity.UserEntity;
import com.web.form.admin.user.AddForm;
import com.web.form.admin.user.EditForm;
import com.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author jayson  <br/> 2016-01-21 15:37
 * @since v1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public String list(Model model){
        List<UserEntity> userEntities = userService.findAll();
        model.addAttribute("userEntities" , userEntities);
        return "admin/user/list";
    }

    @RequestMapping("/addInit")
    public String addInit(){
        return "admin/user/add";
    }

    @RequestMapping("/add")
    public String add(@Validated AddForm form , BindingResult result , Model model){
        if(result.hasErrors())
            return "admin/user/add";

        UserEntity userEntity = new UserEntity();
        userEntity.setName(form.getName());
        userEntity.setPassword(form.getPassword());
        userEntity.setEnable(form.getEnable());

        userService.save(userEntity);

        return "admin/user/list";
    }

    @RequestMapping("/editInit")
    public String editInit(@RequestParam Long id , Model model){
        UserEntity userEntity = userService.findOne(id);
        if(userEntity == null){
            model.addAttribute("errorMsg" , "该用户不存在");
            return "admin/user/list";
        }

        model.addAttribute("userEntity", userEntity);
        return "admin/user/edit";
    }

    @RequestMapping("/edit")
    public String edit(@Validated EditForm form , BindingResult result , Model model){
        if(result.hasErrors())
            return "admin/user/edit";

        UserEntity userEntity = userService.findOne(form.getId());
        if(userEntity == null){
            model.addAttribute("errorMsg" , "该用户不存在");
            return "admin/user/edit";
        }

        userEntity.setName(form.getName());
        userEntity.setPassword(form.getPassword());
        userEntity.setEnable(form.getEnable());

        userService.save(userEntity);
        return "admin/user/list";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam Long id){
        userService.delete(id);

        return "admin/user/list";
    }
}
