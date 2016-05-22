package com.skburgart.rwr.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by skburgart on 5/22/16.
 */
@Controller
@RequestMapping("/")
public class Index {

    @Value("${rwr.title}")
    private String title;

    @RequestMapping
    protected String index (Model model) {
        model.addAttribute("title", title);
        return "index";
    }
}
