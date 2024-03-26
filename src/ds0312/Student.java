// ��������0312-������60211665
package ds0312;

import java.util.Comparator;

public class Student implements Comparable<Student>{
    protected int id; //ID
    String name; //�̸�
    protected String dept; //����
    protected int grade; //�г�
    public Student(int id, String name, String dept, int grade) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.grade = grade;
    }
    //getter-setter �޼���
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDept() {
        return dept;
    }
    // �й����� ���ϴ� compareTo()
    public int getGrade() {
        return grade;
    }
    @Override
    public int compareTo(Student s) {
        return this.id -s.id;
    }
    // �̸����� ���ϴ� compare()
    public static Comparator<Student> CompName = new Comparator<Student>() {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.name.compareTo(s2.name);
        }
    };
    // �а��̸����� ���ϴ� compare()
    public static Comparator<Student> CompDept = new Comparator<Student>() {
        @Override
        public int compare(Student s1, Student s2) {return s1.dept.compareTo(s2.dept);}
    };
    // �г����� ���ϴ� compare()
    public static Comparator<Student> CompGrade = new Comparator<Student>() {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.grade - s2.grade;
        }
    };
}
