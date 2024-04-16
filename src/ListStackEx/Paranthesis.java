// �ڷᱸ��(6007) ���� #4 (60211665 ������)
package ListStackEx;

public class Paranthesis {
    private static void checkPaired(String s) {
        //�Ű����� ���ڿ�  s�� ��ȣ ¦�� �´��� �ƴ����� �˻�
        //��ȣ ¦�� ������ '��ȣ ¦�� �´�'�� ���
        //���� ������ '�Է½�Ʈ���� ��� �κп��� ¦�� ���� �ʴ���'�� ���
        ListStack<Character> ls = new ListStack<>();
        int index = 0;
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) { //String���� ���� str�� ���̸�ŭ �ݺ�
            char c = s.charAt(i); //���� ������ �ɰ�
            if (c == '(' || c == '{') ls.push(c); //���� ��ȣ�� ��� Ǫ��
            else { //�ݴ� ��ȣ�� ���
                if (ls.isEmpty()) { //������ ���������
                    //System.out.println(s.substring(0, i) + "^^^���� ��ȣ ���� ���� �ʽ��ϴ�.");
                    flag = false; 
                    break; //Ż��
                }
                char top = ls.pop(); //������ pop�ϰ� pop�� ���Ҹ� top�� ���� 
                if ((c == ')' && top != '(') || (c == '}' && top != '{')) { //���ݴ� ��ȣ ���� ���� ������
                    //System.out.println(s.substring(0, i) + "^^^���� ��ȣ ���� ���� �ʽ��ϴ�.");
                    flag = false;
                    break; //Ż��
                }
            }
            index = i;
        }
        if (ls.isEmpty() && flag) {
            System.out.println("��ȣ ���� �½��ϴ�."); //���� ���� for�� ������ �� ������ ����ִٸ�
        } else {
            System.out.println(s.substring(0, index + 1) + "^^^���� ��ȣ ���� ���� �ʽ��ϴ�.");
        }
    }

    public static void main(String[] args) {
        System.out.println("<< �ڷᱸ��(6007) ���� #4 (60211665 ������) >>");
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
