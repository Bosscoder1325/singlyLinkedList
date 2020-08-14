package com.bosscoder;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner sc = new Scanner(System.in);
        while (true){
            int ch;
            System.out.println("1. insert element at first");
            System.out.println("2. insert element at last");
            System.out.println("3. get size of list");
            System.out.println("4. view list");
            System.out.println("5. Exit");
            System.out.println("6. insert at position");
            System.out.println("7. delete at first");
            System.out.println("8. delete at last");
            System.out.println("9. delete at position");
            System.out.println("10. reverse list");
            System.out.println("enter your choice");
            ch = sc.nextInt();
            int val,pos;
            switch (ch){
                case 1 :
                    System.out.println("enter value");
                    val = sc.nextInt();
                    list.insertAtStart(val);
                    break;
                case 2:
                    System.out.println("enter value");
                    val = sc.nextInt();
                    list.insertAtEnd(val);
                    break;
                case 3: list.getListSize();break;
                case 4 : list.view();break;
                case 5 : System.exit(0);break;
                case 6:
                    System.out.println("enter position");
                    pos = sc.nextInt();
                    System.out.println("enter value");
                    val = sc.nextInt();
                    list.insertAtPosition(val,pos);
                    break;
                case 7:list.deleteFirst();break;
                case 8:list.deleteLast();break;
                case 9:
                    System.out.println("enter the position");
                    pos = sc.nextInt();
                    list.deleteAtPosition(pos);
                    break;
                case 10: list.reverse();break;
                default:
                    System.out.println("invallid choice");
            }
        }
    }
}

class LinkedList{
        private Node start;
        private int size;

        public LinkedList(){
            start = null;
            size = 0;
        }

        public void insertAtStart(int val){
            Node n;
            n = new Node();
            n.setData(val);
            if (start == null){
                start = n;
                size++;
            }else{
                n.setNext(start);
                start = n;
                size++;
            }
        }

        public void insertAtEnd(int val){
            Node n,t;
            n = new Node();
            n.setData(val);
            if (start ==  null){
                start = n;
                size++;
            }else{
                t= start;
                for (int i = 1; i<size; i++){
                    t = t.getNext();
                }
                t.setNext(n);
                n.setNext(null);
                size++;
            }
        }

        public void insertAtPosition(int val, int pos){
            if (pos < 0 || pos > size + 1){
                System.out.println("invalid position");
            }else if(start == null){
                System.out.println("list is empty");
            }
            else if (pos == 1){
                insertAtStart(val);
            }else if (pos == size + 1){
                    insertAtEnd(val);
            }else{
                Node n , t;
                n = new Node(val, null);
                n.setData(val);
                n.setNext(null);
                t = start;
                for (int i = 1; i<pos-1; i++){
                    t = t.getNext();
                }
                n.setNext(t.getNext());
                t.setNext(n);
                size++;
            }
        }

        public void deleteFirst(){
            if (start == null) {
                System.out.println("list is already empty");
            }else if(size == 1){
                    start = null;
            }else{
                start = start.getNext();
                size--;
            }
        }

        public void deleteLast(){
            if (start == null){
                System.out.println("list is already empty");
            }else if(size == 1){
                start = null;
            }else{
                Node t;
                t = start;
                for (int i = 1; i<size-1; i++){
                    t = t.getNext();
                }
                t.setNext(null);
                size--;
            }
        }

        public void deleteAtPosition(int pos){
            if (pos<0 || pos>size){
                System.out.println("invalid position");
            }else if (pos == 1){
                deleteFirst();
            }else if (pos == size){
                deleteLast();
            }else{
                Node t,t1;
                t = start;
                for (int i = 1; i<pos-1; i++){
                    t = t.getNext();
                }
                t1 = t.getNext();
                t.setNext(t1.getNext());
                size--;
            }
        }

        public void reverse(){
            Node current = start;
            Node previous = null;
            Node n = null;
            Node t;

            if (start == null){
                System.out.println("empty list cant't be reversed");
            }
            else{
                while(current != null){
                    n = current.getNext();
                    current.setNext(previous);
                    previous = current;
                    current = n;
                }

                t = previous;

                while (t != null){
                    System.out.print(t.getData() + " ");
                    t = t.getNext();
                }
                System.out.println();
            }

        }

        public int getListSize(){
            System.out.println("list size is : " + size);
            return size;
        }

        public void view(){
            Node t;
            t = start;
            if (start == null){
                System.out.println("no data in the list");
            }else{
                while (t != null){
                    System.out.print(t.getData() + " ");
                    t = t.getNext();
                }
                System.out.println();
            }
        }

}

class Node{
    private int data;
    private Node next;

    public Node(){
        data = 0;
        next = null;
    }

    public Node(int val, Node n){
        data = val;
        next = n;
    }

    public void setData(int val){
        data = val;
    }

    public int getData(){
        return data;
    }

    public void setNext(Node n){
        next = n;
    }

    public Node getNext(){
        return next;
    }
}