// 자료구조(6007) 과제 #5 (60211665 박진형)
package ListStackEx;

public class MidToPost {
    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0; 
        }
    }
    private static String toPostExp(String s) {
        ListStack<Character> ls = new ListStack<>();
        String res = "";
        for (int i = 0; i < s.length(); i++) { //문자열 길이만큼 반복
            char c = s.charAt(i); //문자
            if (Character.isAlphabetic(c)) { //피연산자이면
                res += c;

            }
            else if (c == '(') ls.push(c); //여는 괄호 push
            else if (c == ')') { //닫는 괄호의 경우
                while (ls.peek() != '(') { // 여는 괄호가 나올 때까지
                    res += ls.pop(); // 스택에서 팝하고 출력
                }
                ls.pop(); // 여는 괄호 제거
            }
            //연산자
            else {
                //이미 연산자가 있는 경우
                //현재 연산자와 top의 연산자중 높은 우선순위의 연산자 출력
                while(!ls.isEmpty() && precedence(c) <= precedence(ls.peek())) {
                    res += ls.pop();
                }
                ls.push(c);
            }
        }

        while(!ls.isEmpty()) { //남은 원소 출력
            res += ls.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("<< 자료구조(6007) 과제 #5 (60211665 박진형) >>");

        String str = new String("A*(B+C/D)");
        System.out.println("중위표기법: " + str);
        System.out.println("후위표기법: " + toPostExp(str) + "\n");

        str = new String("A-B+C/D");
        System.out.println("중위표기법: " + str);
        System.out.println("후위표기법: " + toPostExp(str) + "\n");

        str = new String("A/B-C*D");
        System.out.println("중위표기법: " + str);
        System.out.println("후위표기법: " + toPostExp(str) + "\n");

        str = new String("A-B*C+D/E-F");
        System.out.println("중위표기법: " + str);
        System.out.println("후위표기법: " + toPostExp(str) + "\n");

        str = new String("(A-B)*C-(D/(E+F))");
        System.out.println("중위표기법: " + str);
        System.out.println("후위표기법: " + toPostExp(str) + "\n");
    }
}
