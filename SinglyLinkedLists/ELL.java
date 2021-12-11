package linkedlists;

import javax.sound.midi.Soundbank;

public class ELL {

    private EmployeeLinkedListsNode head;
    private int size=0;

    public void addToFront(EmployeeLinkedLists employee){
        EmployeeLinkedListsNode node=new EmployeeLinkedListsNode(employee);
        node.setNext(head);
        head=node;
        size++;
    }
    public void printList(){
        EmployeeLinkedListsNode current= head;
        System.out.print("HEAD-->");
        while (current!=null){
            System.out.print(current);
            System.out.print(" --> ");
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
    public EmployeeLinkedListsNode removeFromFront(){
        if (isEmpty()){
            return null;
        }
        EmployeeLinkedListsNode removeNode=head;
        head=head.getNext();
        size--;
        removeNode.setNext(null);
        return  removeNode;
    }

}
