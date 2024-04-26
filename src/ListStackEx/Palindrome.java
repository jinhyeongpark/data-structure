package ListStackEx;

public class Palindrome {
    public static boolean checkPalindrome(String s) {
        ListStack<Character> ls = new ListStack<>();
        boolean flag = true;
        for(int i = 0; i < s.length()/2; i++) {
            ls.push(s.charAt(i));
        }
        int index = s.length()/2;
        if (s.length() % 2 != 0) index++;
        for(int j = index; j < s.length(); j++) {
            if(ls.pop() != s.charAt(j)) {
                flag = false;
                break;
            }
        } return flag;
    }

    public static void main(String[] args) {
        System.out.println(checkPalindrome("abdfba"));
    }


}
