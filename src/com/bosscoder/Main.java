package com.bosscoder;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();
        while (true){
            System.out.println("1. Add item to the list at start");
            System.out.println("2. Add item to the list at last");
            System.out.println("3. Add item to the list at position");
            System.out.println("4. Delete first item from the list");
            System.out.println("5. Delete last item from the list");
            System.out.println("6. Delete last item from the list with given position");
            System.out.println("7. View list");
            System.out.println("8. Size of the list");
            System.out.println("9. Exit");
            System.out.println("\nEnter your choice : ");
            int choice = sc.nextInt();
            int pos,val;
            switch (choice){
                case 1:
                    System.out.println("enter value");
                    val = sc.nextInt();
                    list.insertAtFirst(val);
                    break;
                case 2:
                    System.out.println("enter value");
                    val = sc.nextInt();
                    list.insertAtLast(val);
                    break;
                case 3:
                    System.out.println("enter position");
                    pos = sc.nextInt();
                    System.out.println("enter value");
                    val = sc.nextInt();
                    list.insertAtPosition(val,pos);
                    break;
                case 4:
                    list.deleteFirst();
                    break;
                case 5:
                    list.deleteLast();
                    break;
                case 6:
                    System.out.println("enter position");
                    pos = sc.nextInt();
                    list.deleteAtPositon(pos);
                    break;
                case 7:
                    list.viewList();
                    break;
                case 8:list.getListSize();break;
                case 9:
                    System.out.println("thanks for using my program @bosscoder");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}


class LinkedList{
    private int size;
    private Node start;

    public LinkedList(){
        size = 0;
        start = null;
    }

    public void insertAtFirst(int val){
        Node n;
        n = new Node();
        n.setData(val);
        n.setNext(start);
        start = n;
        size++;
    }

    public void insertAtLast(int val){
        Node n,t;
        n = new Node();
        n.setData(val);
        t = start;
        if (t == null){
            start = n;
        }
        else {
            while (t.getNext() != null){
                t = t.getNext();
            }
            t.setNext(n);
        }
        size++;
    }

    public void insertAtPosition(int val, int pos){
        if (pos == 1){
            insertAtFirst(val);
        }else if (pos == size+1){
            insertAtLast(val);
        }else if (pos > 1 && pos <=size){
            Node t,n;
            n = new Node(val, null);
            t = start;
            for (int i = 1; i < pos-1; i++){
                t = t.getNext();
            }
            n.setNext(t.getNext());
            t.setNext(n);
            size++;
        }else{
            System.out.println("Insertion not possible at position" + pos);
        }
    }

    public void deleteFirst(){
        if (start == null){
            System.out.println("list is already empty");
        }else {
            start = start.getNext();
            size--;
        }
    }

    public void deleteLast(){
        if (start == null){
            System.out.println("list is already empty");
        }else if (size == 1){
            start = null;
            size--;
        }else{
            Node t;
            t = start;
            for (int i = 1; i<size-1;i++){
                t = t.getNext();
            }
            t.setNext(null);
            size--;
        }
    }

    public void deleteAtPositon(int pos){
        if (start == null){
            System.out.println("List is already empty");
        }else if (pos<1 || pos>size){
            System.out.println("Invalid position");
        }else if(pos == 1){
            deleteFirst();
        }else if(pos == size){
            deleteLast();
        }else{
            Node t ,t1;
            t = start;
            for (int i = 1; i<pos-1; i++){
                t = t.getNext();
            }
            t1 = t.getNext();
            t.setNext(t1.getNext());
            size--;
        }
    }

    public boolean isEmpty(){
        if (start == null){
            return true;
        }else{
            return false;
        }
    }

    public int getListSize(){
        System.out.println("list size is : " + size);
        return size;
    }

    public void viewList(){
        Node t;
        if (isEmpty()){
            System.out.println("no data in the list");
        }else{
            t = start;
            for (int i = 1; i<=size; i++){
                System.out.print(" " + t.getData());
                t = t.getNext();
            }
            System.out.println();
        }
    }


}


// node class
class Node{
    private int data;
    private Node next;

    public Node(){
        data = 0;
        next = null;
    }
    public Node(int d, Node n){
        data = d;
        next = n;
    }

    public void setData(int d){
        data = d;
    }
    public void setNext(Node n){
        next = n;
    }

    public int getData(){
        return data;
    }
    public Node getNext(){
        return next;
    }
}
