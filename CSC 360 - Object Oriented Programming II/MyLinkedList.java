/*
Luke Norberg

This code completes a linked list data structure by implementing the following methods:
  * contains(e: E): boolean - checks if the list contains e
  * get(index: int): E - returns an object from the list at the index provided
  * indexOf(e: E): int - returns the first index of an object e in the list
  * lastIndexOf(e: E): int - returns the last index of an object e in the list
  * set(index: int, e: E): E - replaces the original node at index with node of object E. returns original nodes value
  * reverse(): void - reverses the list in O(n) time

 */

import java.util.NoSuchElementException;

public class MyLinkedList<E> extends MyAbstractList<E> {
  private Node<E> head, tail;

  /** Create a default list */
  public MyLinkedList() {
  }

  /** Create a list from an array of objects */
  public MyLinkedList(E[] objects) {
        super(objects);
  }

  /** Return the head element in the list */
  public E getFirst() {
    if (size == 0) {
      throw new NoSuchElementException();
    }
    else {
      return head.element;
    }
  }

  /** Return the last element in the list */
  public E getLast() {
    if (size == 0) {
    	throw new NoSuchElementException();
    }
    else {
      return tail.element;
    }
  }

  /** Add an element to the beginning of the list */
  public void addFirst(E e) {
    Node<E> newNode = new Node<E>(e); // Create a new node
    newNode.next = head; // Link the new node with the head
    head = newNode; // head points to the new node
    size++; // Increase list size

    if (tail == null) // If the new node is the only node in list
      tail = head;
  }

  /** Add an element to the end of the list */
  public void addLast(E e) {
    Node<E> newNode = new Node<E>(e); // Create a new for element e

    if (tail == null) {
      head = tail = newNode; // The new node is the only node in list
    }
    else {
      tail.next = newNode; // Link the new with the last node
      tail = tail.next; // tail now points to the last node
    }

    size++; // Increase size
  }

  @Override /** Add a new element at the specified index 
   * in this list. The index of the head element is 0 */
  public void add(int index, E e) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
    else if (index == 0) {
      addFirst(e);
    }
    else if (index == size) {
      addLast(e);
    }
    else {
      Node<E> current = head;
      for (int i = 1; i < index; i++) { // Traverse list to position before insertion point
        current = current.next;
      }
      Node<E> temp = current.next; // Insert new node between current and current.next
      current.next = new Node<E>(e);
      (current.next).next = temp;
      size++;
    }
  }

  /** Remove the head node and
   *  return the object that is contained in the removed node. */
  public E removeFirst() {
    if (size == 0) {
      throw new NoSuchElementException();
    }
    else {
      Node<E> temp = head;
      head = head.next;
      size--;
      if (head == null) {
        tail = null;
      }
      return temp.element;
    }
  }

  /** Remove the last node and
   * return the object that is contained in the removed node. */
  public E removeLast() {
    if (size == 0) {
      throw new NoSuchElementException();
    }
    else if (size == 1) {
      Node<E> temp = head;
      head = tail = null;
      size = 0;
      return temp.element;
    }
    else {
      Node<E> current = head;

      for (int i = 0; i < size - 2; i++) { // Traverse list elements until current is second to last node in list
        current = current.next;
      }

      Node<E> temp = tail;
      tail = current;
      tail.next = null;
      size--;
      return temp.element;
    }
  }

  @Override /** Remove the element at the specified position in this 
   *  list. Return the element that was removed from the list. */
  public E remove(int index) {
    checkIndex(index);
    
    if (index == 0) {
      return removeFirst();
    }
    else if (index == size - 1) {
      return removeLast();
    }
    else {
      Node<E> previous = head;

      for (int i = 1; i < index; i++) {
        previous = previous.next;
      }

      Node<E> current = previous.next;
      previous.next = current.next;
      size--;
      return current.element;
    }
  }

  @Override /** Override toString() to return elements in the list */
  public String toString() {
    StringBuilder result = new StringBuilder("[");

    Node<E> current = head;
    for (int i = 0; i < size; i++) {
      result.append(current.element);
      current = current.next;
      if (current != null) {
        result.append(", "); // Separate two elements with a comma
      }
    }
    result.append("]"); // Insert the closing ] in the string
    return result.toString();
  }

  @Override /** Clear the list */
  public void clear() {
    size = 0;
    head = tail = null;
  }

  @Override /** Return true if this list contains the element e */
  public boolean contains(E e) {
    return (indexOf(e) != -1);
  }

  @Override /** Return the element at the specified index */
  public E get(int index) {
    checkIndex(index);
    Node<E> currNode = head;
    for (int i = 0; i < index; i++) {
      currNode = currNode.next;
    }
    return currNode.element;
  }

  @Override /** Return the index of the first matching element in
   *  this list. Return -1 if no match. */
  public int indexOf(E e) {
    int currIndex = 0;
    Node<E> currNode = head;
    while (currNode != null) {
      if (currNode.element.equals(e)) return currIndex;
      currNode = currNode.next;
      currIndex++;
    }
    return -1;
  }

  @Override /** Return the index of the last matching element in 
   *  this list. Return -1 if no match. */
  public int lastIndexOf(E e) {
    int currIndex = 0;
    int savedIndex = -1;
    Node<E> currNode = head;

    while (currNode != null) {
      if (currNode.element.equals(e)) savedIndex = currIndex;
      currNode = currNode.next;
      currIndex++;
    }
    return savedIndex;
  }

  @Override /** Replace the element at the specified position 
   *  in this list with the specified element. Return the old element. */
  public E set(int index, E e) {
    checkIndex(index);

    Node<E> currNode = head;
    Node<E> newNode = new Node<>(e);

    if (index == 0) {
      Node<E> nextNode = head.next;
      E originalElement = head.element;
      head = newNode;
      head.next = nextNode;
      return originalElement;
    }
    currNode = currNode.next;

    for (int i = 1; i < index-1; i++) {
      currNode = currNode.next;
    }
    if (index == size - 1) {
      E originalElement = tail.element;
      tail = newNode;
      currNode.next = tail;
      return originalElement;
    }
    Node<E> nodeAtIndex = currNode.next;
    currNode.next = newNode;
    newNode.next = nodeAtIndex.next;
    return nodeAtIndex.element;
  }

  @Override /** Reverses this list's elements in place.
   For the linked list, this is done by changing the direction of the node links.*/
  public void reverse() {
    if (isEmpty() || size == 1) return;

    Node<E> oldHead = head;
    Node<E> oldTail = tail;
    Node<E> n1 = head;
    Node<E> n2 = n1.next;
    Node<E> n3 = n2.next;

    while (n3 != null) {
      n2.next = n1;
      n1 = n2;
      n2 = n3;
      n3 = n3.next;
    }
    n2.next = n1;
    head = oldTail;
    tail = oldHead;
    tail.next = null;
  }

  private void checkIndex(int index) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
  }

  @Override /** Override iterator() defined in Iterable */
  public java.util.Iterator<E> iterator() {
    return new LinkedListIterator();
  }

  private class LinkedListIterator implements java.util.Iterator<E> {
    private Node<E> current = MyLinkedList.this.head; // Node of the next element in the iteration
    
    @Override
    public boolean hasNext() {
       return (this.current != null);
    }

    @Override
    public E next() {
      if (!hasNext())
    	throw new NoSuchElementException();
      E e = current.element;
      current = current.next;
      return e;
    }

    @Override
    public void remove() {
      System.out.println("Implementation left as OPTIONAL exercise (7)");
    }
  }
  
  private static class Node<E> {
    E element;
    Node<E> next;

    public Node(E element) {
      this.element = element;
    }
  }
}
