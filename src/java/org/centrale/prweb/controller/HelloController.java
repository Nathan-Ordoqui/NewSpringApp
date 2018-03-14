/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.prweb.controller;

import org.centrale.prweb.items.User;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Kevin
 */
@Controller
public class HelloController {

    public HelloController() {
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleGET(HttpServletRequest request, HttpServletResponse response) {
        //List<Object> theList = new LinkedList<Object>();
        //theList.add("HAHAHA");
        //theList.add(123);
        User anUser = new User();
        anUser.setLogin("admin");
        anUser.setPassw("password");

        ModelAndView result = new ModelAndView("hello");
        result.addObject("aUser", anUser);
        
//        result.addObject("FirstName", "Kévin");
//        result.addObject("LastName", "Jolly");
//        result.addObject("liste", theList);
        return result;
    }
}
