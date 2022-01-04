package circularqueue;

import java.util.NoSuchElementException;

public class ArrayQueue {

    private Employee[] queue;
    private int front;
    private int back;

    public ArrayQueue(int capacity) {
        queue = new Employee[capacity];
    }

    public void add(Employee employee) {
        if (size() == queue.length - 1) {

             /*
//            For a case of 5,
//            0 - occupied -front
//            1- occupied
//            2- occupied
//            3- occupied
//            4-         -back
//            We resize the array when size=4
//             */

            int numItems=size();
            Employee[] newArray = new Employee[2 * queue.length];
            System.arraycopy(queue, front, newArray, 0, queue.length - front);
            System.arraycopy(queue, 0, newArray, queue.length - front, back);
            queue = newArray;

            //Resetting the queue.
            front = 0;
            back = numItems;
            // 0   jane
            // 1    john
            // 2  -   -back
            // 3  -mike - front
            // 4   -bill

            // 0 mike
            // 1 bill
            // 2 jane
            // 3 john
            // 4 - back
            // 5
            // 9
        }
        queue[back] = employee;
        if (back < queue.length - 1) {
            //Back will keep on increasing if we are adding and removing the elements in the array till it reaches the end of the stack
            back++;
        }

        else {
            //Wrapping the back if there is empty space in the front of the queue
            back = 0;
        }
    }

    public Employee remove() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        Employee employee = queue[front];
        queue[front] = null;
        front++;
        if (size() == 0) {
            front = 0;
            back = 0;
        }
        else if (front == queue.length) {
            front = 0;
        }
        return employee;
    }

    public Employee peek() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        return queue[front];
    }

    public int size() {
        if (front <= back) {
//            If front<=back, we know that the queue has not been wrapped as the back is still greater than the front.
            return back - front;
        }
        else {
            return back - front + queue.length;
//          If the queue is wrapped, we will subtract front from the back, and then add the length of the queue.
        }

    }

    public void printQueue() {
        if (front <= back) {
//            Normal condition, when the queue is not wrapped.
            for (int i = front; i < back; i++) {
                System.out.println(queue[i]);
            }
        }
        else {
//            If the queue is wrapped.
            for (int i = front; i < queue.length; i++) {
//                This will print whatever is in front of the queue to the end of the array.
                System.out.println(queue[i]);
            }
            for (int i = 0; i < back; i++) {
//                This will print whatever is from the starting of the array to the back.
                System.out.println(queue[i]);
            }
        }
    }

}
