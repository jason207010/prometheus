package com.web.controller.admin;

import com.web.entity.ResourceEntity;
import com.web.entity.RoleEntity;
import com.web.form.admin.role.AddForm;
import com.web.form.admin.role.EditForm;
import com.web.service.ResourceService;
import com.web.service.RoleService;
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
 * @author jayson  <br/> 2016-01-19 21:58
 * @since v1.0
 */
@Controller
@RequestMapping("/admin/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private ResourceService resourceService;

    @RequestMapping("/list")
    public String list(Model model){
        List<RoleEntity> roleEntities = roleService.findAll();
        model.addAttribute("roleEntities" , roleEntities);
        return "admin/role/list";
    }

    @RequestMapping("/addInit")
    public String addInit(AddForm form , Model model){
        model.addAttribute("form" , form);

        List<ResourceEntity> resourceEntities = resourceService.findAll();
        model.addAttribute("resourceEntities" , resourceEntities);

        return "admin/role/add";
    }

    @RequestMapping("/add")
    public String add(@ModelAttribute("form") @Validated AddForm form , BindingResult bindingResult , Model model){
        if(bindingResult.hasErrors()){
            List<ResourceEntity> resourceEntities = resourceService.findAll();
            model.addAttribute("resourceEntities" , resourceEntities);

            return "admin/role/add";
        }

        RoleEntity role = new RoleEntity();
        role.setName(form.getName());

        if(form.getResourceIds() != null){
            List<ResourceEntity> resourceEntities = new ArrayList<>();
            for(Long id : form.getResourceIds()){
                ResourceEntity resource = resourceService.findOne(id);
                resourceEntities.add(resource);
            }
            role.setResourceEntities(resourceEntities);
        }

        roleService.save(role);

        return "forward:/admin/role/list.do";
    }

    @RequestMapping("/editInit")
    public String editInit(@RequestParam Long id , EditForm form , Model model){

        RoleEntity entity = roleService.findOne(id);
        model.addAttribute("entity", entity);

        BeanUtils.copyProperties(entity, form);
        if(entity.getResourceEntities() != null){
            List<Long> resourceIds = new ArrayList<>();
            for(ResourceEntity e : entity.getResourceEntities()){
                resourceIds.add(e.getId());
            }
            form.setResourceIds(resourceIds);
        }
        model.addAttribute("form", form);

        List<ResourceEntity> resourceEntities = resourceService.findAll();
        model.addAttribute("resourceEntities" , resourceEntities);

        return "admin/role/edit";
    }

    @RequestMapping("/edit")
    public String edit(@ModelAttribute("form") @Validated EditForm form , BindingResult bindingResult , Model model){
        if(bindingResult.hasErrors()){
            List<ResourceEntity> resourceEntities = resourceService.findAll();
            model.addAttribute("resourceEntities" , resourceEntities);
            return "admin/role/edit";
        }

        RoleEntity roleEntity = roleService.findOne(form.getId());
        roleEntity.setName(form.getName());

        if(form.getResourceIds() != null){
            List<ResourceEntity> resourceEntities = new ArrayList<>();
            for(Long id : form.getResourceIds()){
                ResourceEntity resourceEntity = resourceService.findOne(id);
                resourceEntities.add(resourceEntity);
            }
            roleEntity.setResourceEntities(resourceEntities);
        }

        roleService.save(roleEntity);

        return "redirect:/admin/role/list.do";
    }
}
