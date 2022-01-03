package queue;

import java.util.NoSuchElementException;

public class ArrayQueue {
    private Employee[] queue;
    private int front;
    private int back;

    public ArrayQueue(int capacity) {
        queue = new Employee[capacity];
    }

    public void add(Employee employee) {
        //We always add at the back of the queue
        if (back == queue.length) {
            //We need to resize the array if bak is equal to length of the queue
            Employee[] newArray = new Employee[2 * queue.length];
            // Copying the items of array back to newArray
            System.arraycopy(queue, 0, newArray, 0, queue.length);
            queue = newArray;
        }
        queue[back] = employee;
        back++;
    }
    /*
    If we keep on adding and removing people such that only 2 person are present in the max in a given time:
    If we have added and removed people in the array such that position 0-8 are null currently. In this case, front is 9 and back is 10 so,
    Array size is increased in this add case.(Even we have space).
     */
    public Employee remove() {
        if (size() == 0) {
            // Nothing on the queue
            throw new NoSuchElementException();
        }

        Employee employee = queue[front];
        queue[front] = null;
        front++;//Front increases by 1 after the employee is removed
        if (size() == 0) {
            // If we remove only element in the queue, we reset the queue
            front = 0;
            back = 0;
        }
        return employee;
    }
    public int size() {
        return back - front;
    }
    public Employee peek() {
        if (size() == 0) {
            // Nothing on the queue
            throw new NoSuchElementException();
        }
        return queue[front];
    }
    public void printQueue() {
        for (int i = front; i < back; i++) {
            System.out.println(queue[i]);
        }
    }
}
