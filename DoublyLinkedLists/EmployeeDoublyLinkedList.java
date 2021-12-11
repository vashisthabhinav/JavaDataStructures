package doublylinkedlists;


public class EmployeeDoublyLinkedList {
    private EmployeeNodeDLL head;
    private EmployeeNodeDLL tail;
    private int size=0;

    public void addToFront(EmployeeDLL employee){
        EmployeeNodeDLL node=new EmployeeNodeDLL(employee);
        if (head==null){
            tail=node;
        }else {
            head.setPrevious(node);
            node.setNext(head);
        }
        head=node;
        size++;
    }
    public void addToEnd(EmployeeDLL employee){
        EmployeeNodeDLL node=new EmployeeNodeDLL(employee);
        if (tail==null){
            head=node;
        }else {
            tail.setNext(node);
            node.setPrevious(tail);
        }
        tail=node;
        size++;
    }
    public void printList(){
        EmployeeNodeDLL current= head;
        System.out.print("HEAD-->");
        while (current!=null){
            System.out.print(current);
            System.out.print(" <=> ");
            current = current.getNext();
        }
        System.out.println("null");
    }
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return head== null;
    }
    public EmployeeNodeDLL removeFromFront(){
        if (isEmpty()){
            return null;
        }
        EmployeeNodeDLL removeNode=head;
        if (head.getNext()==null){
            tail=null;
        }else{
            head.getNext().setPrevious(null);
        }
        head=head.getNext();
        size--;
        removeNode.setNext(null);
        return  removeNode;
    }
    public EmployeeNodeDLL removeFromEnd(){
        if (isEmpty()){
            return null;
        }
        EmployeeNodeDLL removeNode=tail;
        if (tail.getPrevious()==null){
            head=null;
        }
        else{
            tail.getPrevious().setNext(null);
        }
        tail=tail.getPrevious();
        size--;
        removeNode.setPrevious(null);
        return  removeNode;
    }
    public boolean addBefore(EmployeeDLL newEmployee, EmployeeDLL existingEmployee) {
         /*return true if you were able to successfully add the employee
         into the list before the existing employee. Return false
         if the existing employee doesn't exist in the list
          */
        if (head == null) {
            return false;
        }
        // Find the existing employee
        EmployeeNodeDLL current= head;
        while(current!=null && !current.getEmployee().equals(existingEmployee)){
            current=current.getNext();
        }
        if (current == null) {
            return false;
        }
        EmployeeNodeDLL newNode=new EmployeeNodeDLL(newEmployee);
        newNode.setPrevious(current.getPrevious());
        newNode.setNext(current);
        current.setPrevious(newNode);
        if (head==current){
            head=newNode;
        }else{
            newNode.getPrevious().setNext(newNode);
        }
        size++;
        return true;
    }
}
