package StudentEx;

import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Student[] studs = {
                new Student(14042, "��**", "����", 2),
                new Student(62028, "��**", "����", 3),
                new Student(49064, "��**", "����", 4),
                new Student(14055, "��**", "����", 2),
                new Student(31076, "��**", "�濵", 3),
                new Student(29010, "��**", "��ǻ��", 1),
                new Student(67034, "��**", "����", 4),
                new Student(14020, "��**", "����", 1),
                new Student(14007, "��**", "����", 2),
                new Student(51061, "��**", "�濵", 3)
        };
        // sort(�迭): �迭�� compareTo()�� ���ؼ� ����
        Arrays.sort(studs); // �й����� ����
        print(studs, "id");
        Arrays.sort(studs, Student.CompName);// �̸����� ����
        print(studs, "�̸�");
        Arrays.sort(studs, Student.CompDept);// �а��̸����� ����
        print(studs, "�а�");
        Arrays.sort(studs, Student.CompGrade);// �г����� ����
        print(studs, "�г�");
    }
    public static void print(Student[] studs, String key) {
        System.out.println();
        System.out.println(key + "(��)�� ����");
        System.out.println("-----------------");
        for (Student s : studs) {
            System.out.println(s.getId() + " " + s.getName() + " " +
                    s.getDept() + "\t" + s.getGrade());
        }
    }
}