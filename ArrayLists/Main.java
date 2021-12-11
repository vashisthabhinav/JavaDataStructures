package arraylists;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList= new ArrayList<>();
        employeeList.add(new Employee("Abhinav","Vashisth",10));
        employeeList.add(new Employee("Anubhav","Pandey",11));
        employeeList.add(new Employee("Aryaman","Pathania",12));
        employeeList.add(new Employee("Ashutosh","Sharma",13));

//        employeeList.forEach(employee -> System.out.println(employee));
//        System.out.println("------------------");
//        System.out.println(employeeList.get(1));
//        System.out.println("------------------");
//        System.out.println(employeeList.isEmpty());
//        System.out.println("------------------");
//        employeeList.set(1,new Employee("Prachi","Sharma",14));
//        System.out.println(employeeList.get(1));
//        System.out.println("------------------");
//        System.out.println("Size: "+employeeList.size());
//        Employee[] employeeArray= employeeList.toArray(new Employee[employeeList.size()]);
//        for (Employee employee:employeeArray){
//            System.out.println(employee);
//        }
        System.out.println(employeeList.contains(new Employee("Ashutosh","Sharma",13)));
        // We get false because we haven't implemented equals method(implemented afterwards) in the Employee class
        // They are structurally same but have different instances.
        // If true is returned, it means we have implemented equals method in Employee class
        System.out.println("Index :"+employeeList.indexOf(new Employee("Abhinav","Vashisth",10)));
        employeeList.remove(1);
        employeeList.forEach(employee -> System.out.println(employee));

    }
}
