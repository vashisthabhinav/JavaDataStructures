package hashtables.HashtablesJDK;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        Map<String, Employee> hashMap = new HashMap<String, Employee>();
        hashMap.put("Jones", janeJones);
        hashMap.put("Doe", johnDoe);
        hashMap.put("Smith", marySmith);
        //Employee employee = hashMap.put("Doe", mikeWilson);//Instead use putIfAbsent
        Employee employee = hashMap.putIfAbsent("Doe", mikeWilson);//No overriding
        // It will only insert Mike if the key "Doe" has not been used.
        System.out.println(employee);

        System.out.println(hashMap.get("Smith"));//It will give null if the element with the entered key is not present.

        //Instead, use getOrDefault
        System.out.println(hashMap.getOrDefault("someone", mikeWilson));
        //This stop the method from returning null and instead, it will return mikeWilson as default.


        Iterator<Employee> iterator = hashMap.values().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //After JDK 8 onwards
        hashMap.forEach((k, v) -> System.out.println("Key = " + k + ", Employee = " + v));

        System.out.println(hashMap.remove("Jones"));

        System.out.println(hashMap.containsKey("Doe"));
        System.out.println(hashMap.containsValue(janeJones));
    }
}
