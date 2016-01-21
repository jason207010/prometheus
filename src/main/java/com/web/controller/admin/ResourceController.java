package com.web.controller.admin;

import com.web.entity.ResourceEntity;
import com.web.form.admin.resource.AddForm;
import com.web.form.admin.resource.EditForm;
import com.web.service.ResourceService;
import com.web.util.SpringFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * @author jayson  <br/> 2015-12-17 16:32
 * @since v1.0
 */
@Controller
@RequestMapping("/admin/resource")
public class ResourceController {

    @Autowired
    private SpringFactory factory;

    @Autowired
    private ResourceService resourceService;

    @RequestMapping("/addInit")
    public String addInit(){
        return "admin/resource/add";
    }

    @RequestMapping("/add")
    public String add(@Valid AddForm form , BindingResult result , Model model){
        if(result.hasErrors()){
            model.addAttribute("result" , result);
            return "admin/resource/add";
        }

        ResourceEntity entity = factory.create(ResourceEntity.class);
        entity.setUrl(form.getUrl());

        resourceService.save(entity);
        return "forward:/admin/resource/list.do";
    }

    @RequestMapping("/list")
    public String list(Model model){
        List<ResourceEntity> resourceEntities = resourceService.findAll();
        model.addAttribute("resourceEntities", resourceEntities);
        return "admin/resource/list";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam Long id){
        resourceService.delete(id);
        return "admin/resource/list";
    }

    @RequestMapping("/editInit")
    public String editInit(@RequestParam Long id , Model model){
        ResourceEntity entity = resourceService.findOne(id);
        model.addAttribute("entity", entity);
        return "admin/resource/edit";
    }

    @RequestMapping("/edit")
    public String edit(@Validated EditForm form , BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "admin/resource/edit";

        ResourceEntity entity = resourceService.findOne(form.getId());
        entity.setUrl(form.getUrl());
        resourceService.save(entity);
        return "forward:/admin/resource/list.do";
    }
}
