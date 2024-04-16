package ListQueueEx;

public class Main {
    public static void main(String[] args) {
        ListQueue<String> lq = new ListQueue<String>();
        lq.add("apple");
        lq.add("banana");
        System.out.println(lq.remove());
        System.out.println(lq.remove());
        lq.add("kiwi");
        System.out.println(lq.front().getItem() == lq.rear().getItem());
    }
}
