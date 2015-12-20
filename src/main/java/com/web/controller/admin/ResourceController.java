package com.web.controller.admin;

import com.web.entity.ResourceEntity;
import com.web.form.admin.resource.AddForm;
import com.web.service.ResourceService;
import com.web.util.SpringFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

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

        resourceService.add(entity);
        return "forward:/admin/resource/list.do";
    }

    @RequestMapping("/list")
    public String list(Model model){
        List<ResourceEntity> resourceEntities = resourceService.findAll();
        model.addAttribute("resourceEntities" , resourceEntities);
        return "admin/resource/list";
    }
}
