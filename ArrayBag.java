/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bagImplementations;

import java.util.Iterator;
import java.util.Random;
import java.util.NoSuchElementException;

/**
 *
 * @author amnwaqar
 * @param <E>
 */

public class ArrayBag<E> implements Bag<E>
{
    private final int CAPACITY;
    protected int numElements;
    protected E[] elements;

    public ArrayBag() {
        super();
        CAPACITY = 10;
        numElements = 0;
        elements = (E[])(new Object[CAPACITY]);
    }

    public ArrayBag(int CAPACITY) {
        super();
        this.CAPACITY = CAPACITY;
        numElements = 0;
        elements = (E[])(new Object[CAPACITY]);
    }
    
    @Override
    public boolean add(E item) {
        if (!this.isFull())
        {
            elements[numElements] = item;
            numElements++;
            return true;
        }
        
        return false;
    }

    @Override
    public E grab() {
        Random rand = new Random();
        if (!this.isEmpty())
        {
            int chosen = rand.nextInt(numElements);
            return elements[chosen];
        }
        return null;
    }

    @Override
    public boolean remove(E item) throws NoSuchElementException{
        int index = 0;
        boolean found = false;
        
        while (!false && index < numElements)
        {
            if ((elements[index] == null && item == null) || (elements[index] != null && elements[index].equals(item)))
            {
                found =  true;
                elements[index] = elements[numElements - 1];
                elements[numElements - 1] = null;
                numElements--;
            }
            else
            {
                index++;
            }
        }
        
        if (!found)
        {
            throw new NoSuchElementException();
        }
        
        return found;
    }

    @Override
    public int size() {
        return numElements;
    }

    @Override
    public int capacityRemaining() {
        return CAPACITY - numElements;
    }

    @Override
    public boolean isFull() {
        return (this.capacityRemaining() == 0);
    }

    @Override
    public boolean isEmpty() 
    {
       return (this.capacityRemaining() == CAPACITY);
    }

    @Override
    public void clear() 
    {
        for (int k = 0; k < numElements; k++)
        {
            elements[k] = null;
        }
        numElements = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<E>(elements, numElements);
    }

    @Override
    public E[] toArray() 
    {
        E[] array = (E[])(new Object[numElements]);
        System.arraycopy(elements, 0, array, 0, numElements);
        return array;
    }

    @Override
    public String toString() {
        String output = "[";
        
        for (int k  = 0; k < this.size(); k++)
        {
            output += elements[k];
            
            if (k != this.size() -1)
            {
                output += ", ";
            }
        }
        
        output += "]";
        return output;
    }
    
    
    
    private class ArrayIterator<E> implements Iterator<E>
    {
        private int numElements; 
        private E[] elements; 
        private int nextIndex;
      
        public ArrayIterator(E[] elements, int numElements)
        {  
            if (numElements > elements.length)
            { 
               numElements = elements.length;
            }
        
            this.numElements = numElements;
            this.elements = elements;
            nextIndex = 0; 
        }       
        
        @Override
        public boolean hasNext()
        {  
            return (nextIndex < numElements);
        }
      
      
        @Override
        public E next() throws NoSuchElementException
        {  
            if (!hasNext())
            {
                throw new NoSuchElementException();
            }
         
            return elements[nextIndex++];
        }
    } 
}
