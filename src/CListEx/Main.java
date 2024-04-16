package CListEx;

import CListEx.CList;

public class Main {
    public static void main(String[] args) {
        CList<String> cl = new CList<>();
        cl.insert("pear"); cl.print();
        cl.insert("cherry"); cl.print();
        cl.insert("orange"); cl.print();
        cl.insert("apple"); cl.print();
        System.out.print(": s의  길이 = " + cl.getSize() + "\n");

        cl.delete(); cl.print();
        System.out.print(": s의  길이 = " + cl.getSize() + "\n");
    }
}
