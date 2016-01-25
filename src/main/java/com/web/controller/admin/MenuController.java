package com.web.controller.admin;

import com.web.entity.MenuEntity;
import com.web.entity.ResourceEntity;
import com.web.form.admin.menu.AddForm;
import com.web.form.admin.menu.EditForm;
import com.web.service.MenuService;
import com.web.service.ResourceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author jayson  <br/> 2016-01-18 17:11
 * @since v1.0
 */
@Controller
@RequestMapping("/admin/menu")
public class MenuController {

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private MenuService menuService;

    @RequestMapping("/addInit")
    public String addInit(AddForm form , Model model){
        model.addAttribute("form" , form);

        List<ResourceEntity> resourceEntities = resourceService.findAll();
        model.addAttribute("resourceEntities" , resourceEntities);
        return "admin/menu/add";
    }

    @RequestMapping("/add")
    public String add(@ModelAttribute("form") @Validated AddForm form , BindingResult bindingResult , Model model){
        if(bindingResult.hasErrors()){
            List<ResourceEntity> resourceEntities = resourceService.findAll();
            model.addAttribute("resourceEntities" , resourceEntities);
            return "admin/menu/add";
        }

        MenuEntity parent = null;
        if(form.getParentId() != null)
            parent = menuService.findOne(form.getParentId());

        ResourceEntity resourceEntity = resourceService.findOne(form.getResourceId());

        MenuEntity entity = new MenuEntity();
        entity.setMenuEntity(parent);
        entity.setName(form.getName());
        entity.setResourceEntity(resourceEntity);
        menuService.save(entity);

        return "forward:list.do";
    }

    @RequestMapping("/list")
    public String list(Model model){
        List<MenuEntity> menuEntities = menuService.findAll();
        model.addAttribute("menuEntities", menuEntities);
        return "admin/menu/list";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam Long id){
        menuService.delete(id);
        return "forward:list.do";
    }

    @RequestMapping("/editInit")
    public String editInit(@RequestParam Long id , EditForm form , Model model){

        List<ResourceEntity> resourceEntities = resourceService.findAll();
        model.addAttribute("resourceEntities" , resourceEntities);

        MenuEntity entity = menuService.findOne(id);
        model.addAttribute("entity" , entity);

        BeanUtils.copyProperties(entity , form);
        form.setResourceId(entity.getResourceEntity().getId());
        model.addAttribute("form" , form);

        return "admin/menu/edit";
    }

    @RequestMapping("/edit")
    public String edit(@ModelAttribute("form") @Validated EditForm form , BindingResult bindingResult , Model model){
        if(bindingResult.hasErrors()){
            List<ResourceEntity> resourceEntities = resourceService.findAll();
            model.addAttribute("resourceEntities" , resourceEntities);
            return "admin/menu/edit";
        }

        MenuEntity parent = null;
        if(form.getParentId() != null)
            parent = menuService.findOne(form.getParentId());

        ResourceEntity resourceEntity = resourceService.findOne(form.getResourceId());

        MenuEntity entity = menuService.findOne(form.getId());
        if(entity == null){
            return "admin/menu/edit";
        }

        entity.setMenuEntity(parent);
        entity.setName(form.getName());
        entity.setResourceEntity(resourceEntity);
        menuService.save(entity);

        return "forward:list.do";
    }
}
