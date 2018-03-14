/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.prweb.controller;


import java.util.Collection;
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
public class ItemCreateController {

    public ItemCreateController() {
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleGET(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("index");
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addItem(@ModelAttribute("Item") Item anItem, BindingResult result){
        ModelAndView returnedValue;
        if(anItem != null){
            ItemManager theItemManager = ItemManagerImpl.getInstance();
            theItemManager.save(anItem);
            Collection<Item> theItems = theItemManager.page();
            returnedValue = new ModelAndView("items");
            returnedValue.addObject("itemsList", theItems);
        } else{
            returnedValue = new ModelAndView("itemAdd");
        }
        return returnedValue;
    }
}