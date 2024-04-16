// 자료구조(6007) 과제 #4 (60211665 박진형)
package ListStackEx;

public class Paranthesis {
    private static void checkPaired(String s) {
        //매개변수 문자열  s의 괄호 짝이 맞는지 아닌지를 검사
        //괄호 짝이 맞으면 '괄호 짝이 맞다'를 출력
        //맞지 않으면 '입력스트링의 어느 부분에서 짝이 맞지 않는지'를 출력
        ListStack<Character> ls = new ListStack<>();
        int index = 0;
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) { //String으로 받은 str의 길이만큼 반복
            char c = s.charAt(i); //문자 단위로 쪼갬
            if (c == '(' || c == '{') ls.push(c); //여는 괄호일 경우 푸쉬
            else { //닫는 괄호일 경우
                if (ls.isEmpty()) { //스택이 비어있으면
                    //System.out.println(s.substring(0, i) + "^^^부터 괄호 쌍이 맞지 않습니다.");
                    flag = false; 
                    break; //탈출
                }
                char top = ls.pop(); //스택을 pop하고 pop된 원소를 top에 저장 
                if ((c == ')' && top != '(') || (c == '}' && top != '{')) { //여닫는 괄호 쌍이 맞지 않으면
                    //System.out.println(s.substring(0, i) + "^^^부터 괄호 쌍이 맞지 않습니다.");
                    flag = false;
                    break; //탈출
                }
            }
            index = i;
        }
        if (ls.isEmpty() && flag) {
            System.out.println("괄호 쌍이 맞습니다."); //문제 없이 for문 마무리 후 스택이 비어있다면
        } else {
            System.out.println(s.substring(0, index + 1) + "^^^부터 괄호 쌍이 맞지 않습니다.");
        }
    }

    public static void main(String[] args) {
        System.out.println("<< 자료구조(6007) 과제 #4 (60211665 박진형) >>");
        String str = new String("{{(){()}}}");
        System.out.println(str);
        checkPaired(str);

        str = new String("{{(){()})()}");
        System.out.println("\n" + str);
        checkPaired(str);

        str = new String("({{}}()){({{}})()})");
        System.out.println("\n" + str);
        checkPaired(str);
    }
}
