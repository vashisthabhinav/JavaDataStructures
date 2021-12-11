package linkedlists;

public class EmployeeLinkedListsNode {
    private EmployeeLinkedLists employee;
    private EmployeeLinkedListsNode next;

    public EmployeeLinkedListsNode(EmployeeLinkedLists employee) {
        this.employee = employee;
    }

    public EmployeeLinkedLists getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeLinkedLists employee) {
        this.employee = employee;
    }

    public EmployeeLinkedListsNode getNext() {
        return next;
    }

    public void setNext(EmployeeLinkedListsNode next) {
        this.next = next;
    }
    public String toString(){
        return employee.toString();
    }
}
