package com.web.controller;

import com.web.common.Page;
import com.web.entity.WebPageEntity;
import com.web.lucene.SearchResult;
import com.web.service.LuceneService;
import com.web.service.WebPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author jayson  <br/> 2015-12-01 21:53
 * @since v1.0
 */
@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private LuceneService luceneService;

    @Autowired
    private WebPageService webPageService;

    @RequestMapping("/searchIndex")
    public String searchIndex(){
        return "search/index";
    }

    @RequestMapping("/search")
    public String search(String keyWord , Page<SearchResult> page , Model model){
        model.addAttribute("keyWord" , keyWord);
        if(page.getCurPage() <= 0)
            page.setCurPage(1);
        if(page.getPageSize() <= 0)
            page.setPageSize(10);
        luceneService.search(keyWord , page);
        return "search/list";
    }

    @RequestMapping("/view")
    public String view(@RequestParam("id") long id, Model model) {
        WebPageEntity entity = webPageService.getById(id);
        model.addAttribute("entity", entity);
        return "search/view";
    }
}
