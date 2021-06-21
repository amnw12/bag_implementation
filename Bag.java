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
 * @param <E>
 */

public interface Bag<E> 
{
    public boolean add(E item);
    public E grab();
    public boolean remove(E item);
    public int size();
    public int capacityRemaining();
    public boolean isFull();
    public boolean isEmpty();
    public void clear();
    public Iterator<E> iterator();
    public E[] toArray();
}
