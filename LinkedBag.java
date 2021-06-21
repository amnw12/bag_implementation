/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bagImplementations;

/**
 *
 * @author amnwaqar
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class LinkedBag<E> implements Bag<E>{

    private final int CAPACITY;
    protected LinkedList<E> elements;
    
    public LinkedBag() {
        CAPACITY = 10;
        elements = new LinkedList<>();
    }

    public LinkedBag(int CAPACITY) {
        this.CAPACITY = CAPACITY;
        elements = new LinkedList<>();
    }

    @Override
    public boolean add(E item) {
       if (!this.isFull())
       {
           elements.add(item);
           return true;
       }
       return false;
    }

    @Override
    public E grab() {
        Random rand = new Random();
        if (!this.isEmpty())
        {
            int chosen = rand.nextInt(elements.size());
            return elements.get(chosen);
        }
        
        return null;
    }

    @Override
    public boolean remove(E item) {
        return elements.remove(item);
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public int capacityRemaining() {
        return CAPACITY - elements.size();
    }

    @Override
    public boolean isFull() {
        return (this.capacityRemaining() == 0);
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public void clear() {
        elements.clear();
    }

    @Override
    public Iterator<E> iterator() {
        return elements.iterator();
    }

    @Override
    public E[] toArray() {
        return (E[])elements.toArray();
    }

    @Override
    public String toString() {
        return elements.toString();
    }
}
