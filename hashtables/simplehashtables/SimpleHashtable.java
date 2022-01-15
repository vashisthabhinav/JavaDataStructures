package hashtables.simplehashtables;

public class SimpleHashtable {

    private Employee[] hashtable;

    public SimpleHashtable() {
        hashtable = new Employee[10];
    }

    public void put(String key, Employee employee) {
        int hashedKey = hashKey(key);//Hashing the key
        // The hash key will give us the index into the array, and then we are going to have a simple hash table.(This hash table doesn't handle collisions)
        // To make this table handle collisions, using if-else statement-
        if (hashtable[hashedKey] != null) {
            System.out.println("Sorry, there's already an employee at position " + hashedKey);
            // If the position is already occupied
        }
        else {
            hashtable[hashedKey] = employee;
        }
    }

    public Employee get(String key) {
        // Method for retrieving
        int hashedKey = hashKey(key);//Hashing the key
        return hashtable[hashedKey];
    }
//The retrieval is constant time complexity
    private int hashKey(String key) {
        return key.length() % hashtable.length;
        // This is taking a string, and it's hashing it to an int.
        // This is exactly what a hash function does
    }

    public void printHashtable() {
        // Printing the hash table
        for (int i = 0; i < hashtable.length; i++) {
            System.out.println(hashtable[i]);
        }
    }
}
/*
Hash Tables-

- Abstract data type.
- Provide access to data using keys.
- Key doesn't have to be an integer.
- Key doesn't have to be an integer.
- Consists of key/value pairs- data types don't have to match.
- Optimized for retrieval (when you know the key).
- Associative array(in php) is one of the types of hash table.

Hashing-

- Map keys of any data type to an integer
- Hash function maps key to int
- In Java, hash function is Object.hashCode()
- Collision occurs when more than one value had the same hashed value.

Load Factor-

- Tells us how full a hash table is
- Load factor = # of items/capacity = size/capacity
- Load factor is used to decide when to resize the array backing the hash table
- Don't want Load factor too low(lots of empty space)
- Don't want load factor too high(will increase the likelihood of collisions)\
- Can play a role in determining the time complexity for retrieval.

Add to a Hash Table backed by an array-

- Provide a key value pair
- Use a hash function to hash the key to an int value
- Store the value at the hashed key value- this is the index into the array.
 */