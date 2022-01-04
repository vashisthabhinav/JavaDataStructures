package circularqueue;

import queue.ArrayQueue;
import queue.Employee;

public class Main {

    public static void main(String[] args) {

        queue.Employee janeJones = new queue.Employee("Jane", "Jones", 123);
        queue.Employee johnDoe = new queue.Employee("John", "Doe", 4567);
        queue.Employee marySmith = new queue.Employee("Mary", "Smith", 22);
        queue.Employee mikeWilson = new queue.Employee("Mike", "Wilson", 3245);
        queue.Employee billEnd = new Employee("Bill", "End", 78);

        queue.ArrayQueue queue = new ArrayQueue(5);

        queue.add(johnDoe);
        queue.add(janeJones);
        queue.remove();
        queue.add(marySmith);
        queue.remove();
        queue.add(mikeWilson);
        queue.remove();
        queue.add(billEnd);
        queue.remove();
        queue.add(janeJones);
        queue.printQueue();

    }

}
