/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author Vinit
 */
public class StackLL {

    ListNode head = new ListNode();
    public void Push(int pushVal){
        if(head == null){
            head = new ListNode(pushVal);
        }else{
            ListNode temp = new ListNode(pushVal);
            temp.next = head;
            head = temp;
        }
    }
    
    
    public int Pop(){
        ListNode temp = head;
        if(temp == null){
            return -1;
        }else{
            head = head.next;
            temp.next = null;
        }
        return temp.val;
    }
    public void traverseLL(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.println(temp.val);
            temp = temp.next; 
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        StackLL obj = new StackLL();
        obj.Push(1);
        obj.traverseLL(obj.head);
    }
}

public class ListNode{
    int val;
    ListNode next;
    
    ListNode(){}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
