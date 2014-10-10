/*
 * InfixPostfixCalculator
 */
package i2pcalc;

/**
 * Linked List class
 * Author: SoporificDreamer
 */
public class linkedList<E> {

    int size = 0;
    Node<E> first;
    Node<E> last;

    /**
     * Creates Empty linked list
     */
    public linkedList() {
    }

    /**
     * Adds e as first element.
     */
    public void addFirst(E element) {
        Node<E> firstElem = first;
        Node<E> newNode = new Node<>(null, element, firstElem);
        first = newNode;
        if (firstElem == null) {
            last = newNode;
        } else {
            firstElem.prev = newNode;
        }
        size++;
    }
    
    /**
     * Removes the first element checking if element exits
     * @return 
     */
    public E removeFirst() {
        final Node<E> f = first;
        if (f == null) {
            System.out.println("No element exists! ");;
        }
        return removeFirstElement(f);
    }

    /**
     * Actually removes first element
     * @param firstElem
     * @return 
     */
    public E removeFirstElement(Node<E> firstElem) {
        E element = firstElem.elem;
        Node<E> next = firstElem.next;
        firstElem.elem = null;
        firstElem.next = null; 
        first = next;
        if (next == null) {
            last = null;
        } else {
            next.prev = null;
        }
        size--;
        return element;
    }
    
    /**
     * Push method
     * @param e 
     */
    public void push(E elem) {
        addFirst(e);
    }
    
    /**
     * Pop method
     * @return 
     */
    public E pop() {
        return removeFirst();
    }

}
