package ArrQueueEx;

public class Main {
    public static void main(String[] args) {
        ArrayQueue<String> aq = new ArrayQueue<>();
        aq.add("apple");
        aq.add("banana");
        System.out.println(aq.remove());
        System.out.println(aq.remove());
    }
}
