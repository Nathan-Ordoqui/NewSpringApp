/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.prweb.controller;

import java.util.Collection;
import org.centrale.prweb.items.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.centrale.prweb.items.Item;
import org.centrale.prweb.manager.ItemManager;
import org.centrale.prweb.manager.ItemManagerImpl;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Kevin
 */
@Controller
public class IndexController {

    public IndexController() {
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleGET(HttpServletRequest request, HttpServletResponse response) {
        //List<Object> theList = new LinkedList<Object>();
        //theList.add("HAHAHA");
        //theList.add(123);
//        User anUser = new User();
//        anUser.setLogin("admin");
//        anUser.setPassw("password");

        ModelAndView result = new ModelAndView("index");
        //result.addObject("aUser", anUser);
        
//        result.addObject("FirstName", "Kévin");
//        result.addObject("LastName", "Jolly");
//        result.addObject("liste", theList);
        return result;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView identify(@ModelAttribute("User") User aUser, BindingResult result){
        ModelAndView returned;
        if((aUser.getLogin() != null) && (aUser.getPassw() != null)){
            if((aUser.getLogin().equals("admin")) && (aUser.getPassw().equals("admin"))){
                ItemManager theItemManager = ItemManagerImpl.getInstance();
                Collection<Item> theItems = theItemManager.page();
                returned = new ModelAndView("items");
                returned.addObject("itemsList",theItems);
            } else{
                returned = new ModelAndView("index");
            }
        } else{
            returned = new ModelAndView("index");
        }
        return returned;
    }
}
