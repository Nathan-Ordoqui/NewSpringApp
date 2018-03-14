/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.prweb.manager;

import java.util.Collection;
import org.centrale.prweb.items.Category;
import org.centrale.prweb.items.Item;

/**
 *
 * @author Kevin
 */

public interface ItemManager {
    public Collection<Item> page();
    public void save(Item anItem);

    public Collection<Category> listCategories();
}
