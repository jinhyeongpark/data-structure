// �ڷᱸ��(6007) ���� #5 (60211665 ������)
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
        for (int i = 0; i < s.length(); i++) { //���ڿ� ���̸�ŭ �ݺ�
            char c = s.charAt(i); //����
            if (Character.isAlphabetic(c)) { //�ǿ������̸�
                res += c;

            }
            else if (c == '(') ls.push(c); //���� ��ȣ push
            else if (c == ')') { //�ݴ� ��ȣ�� ���
                while (ls.peek() != '(') { // ���� ��ȣ�� ���� ������
                    res += ls.pop(); // ���ÿ��� ���ϰ� ���
                }
                ls.pop(); // ���� ��ȣ ����
            }
            //������
            else {
                //�̹� �����ڰ� �ִ� ���
                //���� �����ڿ� top�� �������� ���� �켱������ ������ ���
                while(!ls.isEmpty() && precedence(c) <= precedence(ls.peek())) {
                    res += ls.pop();
                }
                ls.push(c);
            }
        }

        while(!ls.isEmpty()) { //���� ���� ���
            res += ls.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("<< �ڷᱸ��(6007) ���� #5 (60211665 ������) >>");

        String str = new String("A*(B+C/D)");
        System.out.println("����ǥ���: " + str);
        System.out.println("����ǥ���: " + toPostExp(str) + "\n");

        str = new String("A-B+C/D");
        System.out.println("����ǥ���: " + str);
        System.out.println("����ǥ���: " + toPostExp(str) + "\n");

        str = new String("A/B-C*D");
        System.out.println("����ǥ���: " + str);
        System.out.println("����ǥ���: " + toPostExp(str) + "\n");

        str = new String("A-B*C+D/E-F");
        System.out.println("����ǥ���: " + str);
        System.out.println("����ǥ���: " + toPostExp(str) + "\n");

        str = new String("(A-B)*C-(D/(E+F))");
        System.out.println("����ǥ���: " + str);
        System.out.println("����ǥ���: " + toPostExp(str) + "\n");
    }
}
