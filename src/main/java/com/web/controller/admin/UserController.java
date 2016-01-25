package com.web.controller.admin;

import com.web.entity.RoleEntity;
import com.web.entity.UserEntity;
import com.web.form.admin.user.AddForm;
import com.web.form.admin.user.EditForm;
import com.web.service.RoleService;
import com.web.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jayson  <br/> 2016-01-21 15:37
 * @since v1.0
 */
@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/list")
    public String list(Model model){
        List<UserEntity> userEntities = userService.findAll();
        model.addAttribute("userEntities" , userEntities);
        return "admin/user/list";
    }

    @RequestMapping("/addInit")
    public String addInit(AddForm form , Model model){
        model.addAttribute("form" , form);
        
        List<RoleEntity> roleEntities = roleService.findAll();
        model.addAttribute("roleEntities" , roleEntities);
        return "admin/user/add";
    }

    @RequestMapping("/add")
    public String add(@ModelAttribute("form") @Validated AddForm form , BindingResult result , Model model){
        if(result.hasErrors()){
            List<RoleEntity> roleEntities = roleService.findAll();
            model.addAttribute("roleEntities" , roleEntities);

            return "admin/user/add";
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setName(form.getName());
        userEntity.setPassword(form.getPassword());
        userEntity.setEnable(form.getEnable());

        if(form.getRoleIds() != null){
            List<RoleEntity> roleEntities = new ArrayList<>();
            for(Long id : form.getRoleIds()){
                RoleEntity roleEntity = roleService.findOne(id);
                roleEntities.add(roleEntity);
            }
            userEntity.setRoleEntities(roleEntities);
        }

        userService.save(userEntity);

        return "forward:/admin/user/list.do";
    }

    @RequestMapping("/editInit")
    public String editInit(@RequestParam Long id , Model model , EditForm form){

        UserEntity userEntity = userService.findOne(id);
        if(userEntity == null){
            model.addAttribute("errorMsg" , "该用户不存在");
            return "admin/user/list";
        }

        List<RoleEntity> roleEntities = roleService.findAll();
        model.addAttribute("roleEntities" , roleEntities);

        BeanUtils.copyProperties(userEntity , form);
        if(userEntity.getRoleEntities() != null){
            List<Long> roleIds = new ArrayList<>();
            for(RoleEntity r : userEntity.getRoleEntities()){
                roleIds.add(r.getId());
            }
            form.setRoleIds(roleIds);
        }
        model.addAttribute("form" , form);

        return "admin/user/edit";
    }

    @RequestMapping("/edit")
    public String edit(@ModelAttribute("form") @Validated EditForm form , BindingResult result , Model model){
        if(result.hasErrors()){
            List<RoleEntity> roleEntities = roleService.findAll();
            model.addAttribute("roleEntities" , roleEntities);

            return "admin/user/edit";
        }

        UserEntity userEntity = userService.findOne(form.getId());
        if(userEntity == null){
            model.addAttribute("errorMsg" , "该用户不存在");
            return "admin/user/edit";
        }

        userEntity.setName(form.getName());
        userEntity.setPassword(form.getPassword());
        userEntity.setEnable(form.getEnable());

        if(form.getRoleIds() != null){
            List<RoleEntity> roleEntities = new ArrayList<>();
            for(Long id : form.getRoleIds()){
                RoleEntity roleEntity = roleService.findOne(id);
                roleEntities.add(roleEntity);
            }
            userEntity.setRoleEntities(roleEntities);
        }

        userService.save(userEntity);
        return "admin/user/list";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam Long id){
        userService.delete(id);

        return "forward:/admin/user/list.do";
    }
}
