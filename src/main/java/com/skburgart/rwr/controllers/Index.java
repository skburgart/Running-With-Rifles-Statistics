package com.skburgart.rwr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by skburgart on 5/22/16.
 */
@Controller
@RequestMapping("/")
public class Index {

    @RequestMapping
    protected String index () {
        return "index";
    }
}
