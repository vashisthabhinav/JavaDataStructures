package hashtables.chaining;
public class Main {

    public static void main(String[] args) {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        ChainedHashTable ht = new ChainedHashTable();
        ht.put("Jones", janeJones);
        ht.put("Doe", johnDoe);
        ht.put("Wilson", mikeWilson);
        ht.put("Smith", marySmith);

        ht.printHashtable();

//        System.out.println("Retrieve key Smith: " + ht.get("Smith"));
//
//        ht.remove("Doe");
//        ht.remove("Jones");
//        ht.printHashtable();
//

    }
}
/*
CHAINING
When we use chaining, instead of storing the value directly into the array, each array position contains a linked list.
For ex., instead of storing the employees or StoredEmployee instances, we would store a linked list.
And if we go to add an employee, and the key that we use has a hashed value that collides with the hashed value for another key, that's fine coz at that position in the array, there is a linked list & linked list don't have boundaries.
It doesn't mean that the chaining is better than the linear probing-
On average, linear probing performs better than chaining does.
Chaining just has a simpler implementation.

Worst case time complexity for chaining is O(n).
It depends upon the hashing function and the load factor.
 */