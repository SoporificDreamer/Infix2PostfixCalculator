/**
 * InfixPostfixCalculator
 */
package i2pcalc;

/**
 * Node class
 * Author: SoporificDreamer
 * @param <E> 
 */
public class Node<E> {
    
        E elem;
        Node<E> next;
        Node<E> prev;

      public  Node(Node<E> prev, E element, Node<E> next) {
            this.elem = element;
            this.next = next;
            this.prev = prev;
        }
    }
