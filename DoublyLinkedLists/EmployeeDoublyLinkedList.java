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
            return false;//Means the list is empty. isEmpty() can also be used.
        }
        // Finding the existing employee
        EmployeeNodeDLL current= head;// Starts with the head of the list.
        while(current!=null && !current.getEmployee().equals(existingEmployee)){
            //When current is not equal to null and not equal to the existing employee
            current=current.getNext();//Moving to next node.
        }
        if (current == null) {
            return false;//Existing Employee is not in the list
        }
        //If Existing employee found.
        EmployeeNodeDLL newNode=new EmployeeNodeDLL(newEmployee);//Create node for the new employee
        newNode.setPrevious(current.getPrevious());//Previous field of the new employee will point to the prevoius field of the current/existing employee.
        newNode.setNext(current);//New employee's next field should point to the current/existing employee.
        current.setPrevious(newNode);//Current/existing employee's previous field will now point to the new employee.
        if (head==current){
            //If the employee that we want to insert before might be at the head of the list.
            head=newNode;//Change the head field to the new employee.
        }else{//If this is not the case, then handeling the next field of the node was in the front of the current node.
            newNode.getPrevious().setNext(newNode);//Settig it to the new node.
        }
        size++;
        return true;// Returned true only if the employee is successfully added. Else false.
    }
}
