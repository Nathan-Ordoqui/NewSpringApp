/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.prweb.controller;

import org.centrale.prweb.items.User;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.centrale.prweb.items.Item;
import org.centrale.prweb.manager.ItemManager;
import org.centrale.prweb.manager.ItemManagerImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author Kevin
 */

@Controller
public class ItemController {

    public ItemController() {
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleGet(HttpServletRequest request, HttpServletResponse response) {
        ItemManager theItemManager = ItemManagerImpl.getInstance();
        Collection<Item> theItems = theItemManager.page();
        
        ModelAndView result = new ModelAndView("items");
        result.addObject("itemsList", theItems);
        return result;
    }
}

