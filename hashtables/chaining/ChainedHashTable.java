package hashtables.chaining;

import java.util.LinkedList;
import java.util.ListIterator;

public class ChainedHashTable {
    private LinkedList<StoredEmployee>[] hashtable;

    public ChainedHashTable() {
        hashtable = new LinkedList[10];

        for (int i = 0; i < hashtable.length; i++) {
            //Creating LinkedList for every position of the array.
            hashtable[i] = new LinkedList<StoredEmployee>();
        }
    }

    public void put(String key, Employee employee) {
        int hashedKey = hashKey(key);//Hashing the key
        hashtable[hashedKey].add(new StoredEmployee(key, employee));//Adding to the Linked list.
    }

    public Employee get(String key) {
        int hashedKey = hashKey(key);//Hashing the key
        ListIterator<StoredEmployee> iterator = hashtable[hashedKey].listIterator();//Used to search the employee
        StoredEmployee employee = null;
        while (iterator.hasNext()) {
            employee = iterator.next();
            if (employee.key.equals(key)) {
                // We have found our employee.
                return employee.employee;
            }
        }
        /*
        If we drop out of the above loop, it means that we have iterated over the entire list, and we have not found a StoredEmployee instance.
        So, null is returned
         */

        return null;
    }

    public Employee remove(String key) {
        int hashedKey = hashKey(key);
        //Using iterator as in JDK LinkedList class-(we only have head and tail)
        //So to find the employee , we need to traverse the list and then remove that employee.
        ListIterator<StoredEmployee> iterator = hashtable[hashedKey].listIterator();
        StoredEmployee employee = null;
        int index = -1;
        //Index made -1 so that when we come here, we increment it to 0
        while (iterator.hasNext()) {
            employee = iterator.next();
            //Index is incremented.
            index++;
            if (employee.key.equals(key)) {
                break;
            }
        }

        if (employee == null || !employee.key.equals(key)) {
            return null;
            // It means that we have traversed the entire list,
            // and we didn't find the employee we are looking for,
            // so we return null.
        }
        else {
            // We have found the employee to be removed
            hashtable[hashedKey].remove(index);
            return employee.employee;
        }
    }

    private int hashKey(String key) {
        //return key.length() % hashtable.length;
        //This load factor can be adjusted depending upon the situation

        return Math.abs(key.hashCode() % hashtable.length);
        //Using inbuilt class. Math.abs will give only the positive value coz hashcode method for string can produce negative values as well.
    }

    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {
            //Traversing the linkedList at every position
            if (hashtable[i].isEmpty()) {
                System.out.println("Position " + i + ": empty");
                //For an empty linkedList, no traversing required
            }
            else {
                System.out.print("Position " + i + ": ");
                ListIterator<StoredEmployee> iterator = hashtable[i].listIterator();
                while (iterator.hasNext()) {
                    //We want to print the employee field in the StoredEmployee.
                    System.out.print(iterator.next().employee);
                    System.out.print("->");
                }
                System.out.println("null");
            }
        }
    }

}
