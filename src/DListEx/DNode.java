// 자료구조(6007) 과제 #3 (60211665 박진형)
package DListEx;

public class DNode<E> {
    private E item;
    private DNode previous;
    private DNode next;

    public DNode(E newItem, DNode p, DNode q) {
        item = newItem;
        previous = p;
        next = q;
    }
    //get 과 set 메소드
    public E getItem() {return item;}
    public DNode getPrevious() {return previous;}
    public DNode getNext() {return next;}
    public void setItem(E newItem) {item = newItem;}
    public void setPrevious(DNode p) {previous = p;}
    public void setNext(DNode q) {next = q;}
}
