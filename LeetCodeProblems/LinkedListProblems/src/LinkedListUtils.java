package LinkedListProblems.src;

public class LinkedListUtils {

    Node head;

    public int get(int index) {
      return getNth(head,index);
    }

    private int getNth(Node head, int index) {
        if(head == null)
            return -1;

        if(index == 0)
            return head.data;

        return getNth(head.next, index-1);
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if(head == null)
            return;
        Node last = head;
        while(last.next!=null){
            last = last.next;
        }
        last.next = newNode;

    }

    public void addAtIndex(int index, int val) {

        if (index < 1)
            return;

        if (index == 1) {
            Node newNode = new Node(val);
            newNode.next = head;
        }

        Node curr = head;

        for (int i = 1; i < index - 1 && curr != null; i++) {
            curr = curr.next;
        }

        if (curr == null)
            return ;

        Node newNode = new Node(val);

        newNode.next = curr.next;
        curr.next = newNode;


    }

    public void deleteAtIndex(int index) {

    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next; // Move to the next node
        }
        System.out.println();
    }


    public static void main(String args[]){


        LinkedListUtils myLinkedList = new LinkedListUtils();
        myLinkedList.addAtHead(1);
        myLinkedList.printList();
        myLinkedList.addAtTail(3);
        myLinkedList.printList();
        myLinkedList.addAtIndex(1, 2);
        myLinkedList.printList();// linked list becomes 1->2->3
        myLinkedList.get(1);// return 2
        System.out.println(myLinkedList.get(1));
        myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
        myLinkedList.get(1);

    }
}
