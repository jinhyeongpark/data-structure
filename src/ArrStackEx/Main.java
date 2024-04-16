package ArrStackEx;

public class Main {
    public static void main(String[] args) {
        ArrayStack<String> as = new ArrayStack<>();
        as.push("apple");
        as.push("orange");
        as.push("cherry");
        System.out.println(as.pop());
        System.out.println(as.peek());
    }
}
