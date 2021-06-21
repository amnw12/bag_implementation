/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bagImplementations;

import java.util.Iterator;

/**
 *
 * @author amnwaqar
 */

public class BagTest {
    
    public static void main(String[] args) {
        ArrayBag<String> groceries = new ArrayBag<>();
        LinkedBag<String> makeup = new LinkedBag<>(8);
        
        System.out.println("\nGROCERIES TEST:\n");
        
        System.out.println("Grocery bag empty? " + groceries.isEmpty());
        
        groceries.add("Cheese");
        groceries.add("Peanuts");
        groceries.add("Green Tea");
        groceries.add("Pasta");
        groceries.add("Milk");
        groceries.add("Eggs");
        
        System.out.println("\nGroceries:\n" + groceries);
        System.out.println("\nGrabbing grocery item...\n" + groceries.grab());
        System.out.println("\nBag full? " + groceries.isFull());
        System.out.println("Number of items in  bag: " + groceries.size());
        System.out.println("Can add " + groceries.capacityRemaining() + " more items.");
        
        if (groceries.remove("Peanuts"))
        {
            System.out.println("\n...Item removed...");
            System.out.println("Number of items in  bag: " + groceries.size());
        }
        else
        {
            System.out.println("\nError! Item not in bag");
        }
        
        System.out.println("\nGroceries:\n" + groceries);
        
        groceries.add("Salmon");
        groceries.add("Peanut Butter");
        groceries.add("Apples");
        groceries.add("Raspberries");
        groceries.add("Hummus");
        
        System.out.println("\nBag full? " + groceries.isFull());
        System.out.println("Number of items in  bag: " + groceries.size());
        
        Object[] groceryList  = groceries.toArray();
        Iterator loop = groceries.iterator();
        int index = 0;
        
        System.out.println("\nGrocery Array:");
        while (loop.hasNext())
        {
            System.out.println(index+1 + ". " +groceryList[index]);
            index++;
            loop.next();
        }
        
        groceries.clear();
        System.out.println("\n...Bag cleared...");
        System.out.println("\nGrocery bag empty? " + groceries.isEmpty());
        System.out.println("Can add " + groceries.capacityRemaining() + " more to bag");
        
        System.out.println("\n\nMAKEUP TEST:\n");
        System.out.println("Makeup bag empty? " + makeup.isEmpty());
        
        makeup.add("Lipstick");
        makeup.add("Mascara");
        makeup.add("Foundation");
        makeup.add("Eyeshadow");
        makeup.add("Blush");
        makeup.add("Loose Powder");
        
        System.out.println("\nMakeup:\n" + makeup);
        System.out.println("\nGrabbing makeup product...\n" + makeup.grab());
        System.out.println("\nBag full? " + makeup.isFull());
        System.out.println("Number of products in  bag: " + makeup.size());
        System.out.println("Can add " + makeup.capacityRemaining() + " more to bag");
                
        if (makeup.remove("Loose Powder"))
        {
            System.out.println("\n...Item removed...");
            System.out.println("Number of items in  bag: " + makeup.size());
        }
        else
        {
            System.out.println("\nError! Item not in bag");
        }
        
        System.out.println("\nMakeup:\n" + makeup);
       
        makeup.add("Higlighter");
        makeup.add("Eyeliner");
        makeup.add("Contour");
        
        System.out.println("\nBag full? " + makeup.isFull());
        System.out.println("Number of items in  bag: " + makeup.size());
        
        Object[] makeupList  = makeup.toArray();
        loop = makeup.iterator();
        index = 0;
        
        System.out.println("\nMakeup Array:");
        while (loop.hasNext())
        {
            System.out.println(index+1 + ". " +makeupList[index]);
            index++;
            loop.next();
        }
        
        makeup.clear();
        System.out.println("\n...Bag cleared...");
        System.out.println("\nMakeup bag empty? " + makeup.isEmpty());
        System.out.println("Can add " + makeup.capacityRemaining() + " more to bag");
    }
}
