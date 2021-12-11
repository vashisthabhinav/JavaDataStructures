package doublylinkedlists;


public class EmployeeNodeDLL {
    private EmployeeDLL employee;
    private EmployeeNodeDLL next;
    private EmployeeNodeDLL previous;

    public EmployeeNodeDLL getPrevious() {
        return previous;
    }

    public void setPrevious(EmployeeNodeDLL previous) {
        this.previous = previous;
    }

    public EmployeeNodeDLL(EmployeeDLL employee) {
        this.employee = employee;
    }

    public EmployeeDLL getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDLL employee) {
        this.employee = employee;
    }

    public EmployeeNodeDLL getNext() {
        return next;
    }

    public void setNext(EmployeeNodeDLL next) {
        this.next = next;
    }
    public String toString(){
        return employee.toString();
    }
}
