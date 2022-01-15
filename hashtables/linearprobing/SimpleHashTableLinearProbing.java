package hashtables.linearprobing;

public class SimpleHashTableLinearProbing {
    private StoredEmployee[] hashtable;

    public SimpleHashTableLinearProbing() {
        hashtable = new StoredEmployee[10];
    }

    public void put(String key, Employee employee) {
        int hashedKey = hashKey(key);//Hashing the key
        if (occupied(hashedKey)) {
            // Checking whether the position is empty or not using occupied method.
            int stopIndex = hashedKey;
            // We will loop around until we find an empty spot, or we hit the stop index.
            if (hashedKey == hashtable.length - 1) {
                //When we have looked the entire array
                hashedKey = 0;
            }
            else {
                hashedKey++;
            }
            /*
            All the above if-else code is doing is creating the first value for the first probe.
             */

            while (occupied(hashedKey) && hashedKey != stopIndex) {
                //If the slot is occupied & hashedKey is not equal to stopIndex-
                hashedKey = (hashedKey + 1) % hashtable.length;
                /*
                As we may want to wrap to the front of the array at some point.
                 This code just sets the very first probe value.
                 We don't want to check 10(it will give ArraysOutOfBounds exception).
                When hashedKey=9, hashedKey = (hashedKey + 1) % hashtable.length will give 0 (10 mod 10)
                 And that wraps hashedKey back to the beginning of the array.
                 */
            }
        }

        if (occupied(hashedKey)) {
            System.out.println("Sorry, there's already an employee at position " + hashedKey);
        }
        else {
            hashtable[hashedKey] = new StoredEmployee(key, employee);
        }
    }

    public Employee get(String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
            //No employee with the key that we are looking for
        }
        return hashtable[hashedKey].employee;
    }

    public Employee remove(String key) {
        //It will also remove linear probing
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
        }

        Employee employee = hashtable[hashedKey].employee;
        hashtable[hashedKey] = null;

        StoredEmployee[] oldHashtable = hashtable;//Saving the current hashtable into a temporary variable.
        hashtable = new StoredEmployee[oldHashtable.length];//Creating a new employee array that's gonna be same size as our old hash table.
        for (int i = 0; i < oldHashtable.length; i++) {
            //Traversing the oldHashtable
            if (oldHashtable[i] != null) {
                //If value at index i != null we will rehash it by putting it into the new hash table
                put(oldHashtable[i].key, oldHashtable[i].employee);

            }
        }

        return employee;
    }

    private int findKey(String key) {
        int hashedKey = hashKey(key);
        if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
            // If the key that was used to store the employee ID has key is equal to the key that we are using to retrieve,then we can just go ahead and return the hashed value
            // coz that means that the employee at hashtable hashedKey was stored using the key that we are looking for.
        }

        int stopIndex = hashedKey;
        if (hashedKey == hashtable.length - 1) {
            hashedKey = 0;
        }
        else {
            hashedKey++;
        }

        while (hashedKey != stopIndex && hashtable[hashedKey] != null &&
                !hashtable[hashedKey].key.equals(key)) {
            hashedKey = (hashedKey + 1) % hashtable.length;
            //When we haven't looked at the entire array,and the position is null i.e., it won't contain the employee, and the position we are looking at is not the employee that was added with the key we are interested in
            // So we go to the next probe and loop back around and keep looking.
        }
        //Two possibilities after exiting while loop-
        //Either we have looked the entire array, or we have found the employee.
        if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        }
        else {
            return -1;
        }
    }

    private int hashKey(String key) {
        return key.length() % hashtable.length;
    }
    private boolean occupied(int index) {
        // To check whether the position is already occupied or not.
        return hashtable[index] != null;
        // If it's != null, we return true. If it is == null, that means it's empty, and so we return false.
    }

    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {
            if (hashtable[i] == null) {
                System.out.println("empty");
            }
            else {
                System.out.println("Position " + i + ": " +hashtable[i].employee);
            }
        }
    }
}
/*
Common strategies to handle collisions-
OPEN ADDRESSING
With open addressing what we do is-
 if we try to put an employee into the table, and we find out that there is already an employee at the slot where we want to put the new employee, then we look for another position in the array.
LINEAR PROBING
When we discover that a position for a hash key value is already occupied, we increment hashed value by one, and then we check the resulting index.
We will keep doing this until we find an empty slot, or we have checked the entire hashtable.
 */