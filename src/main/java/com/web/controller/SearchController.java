package com.web.controller;

import com.web.common.Page;
import com.web.lucene.SearchResult;
import com.web.service.LuceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jayson  <br/> 2015-12-01 21:53
 * @since v1.0
 */
@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private LuceneService luceneService;

    @RequestMapping("/searchIndex")
    public String searchIndex(){
        return "search/index";
    }

    @RequestMapping("/search")
    public String search(String keyWord , Page<SearchResult> page , Model model){
        model.addAttribute("keyWord" , keyWord);
        luceneService.search(keyWord , page);
        return "search/list";
    }
}
