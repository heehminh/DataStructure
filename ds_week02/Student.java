package ds_week02;

import java.util.Comparator;

public class Student implements Comparable<Student> {
	public static Comparator<Student> CompName = new WithName(); // 방법 (1)
	// 방법 (2) 익명클래스로 만들어 선언
	public static Comparator<Student> CompGrade = new WithGrade();
	
	private int id;
	private String name;
	private String dept;
	private int grade;
	
	public Student(int id, String name, String dept, int grade) {
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.grade = grade;
	}
	public int getId() { return this.id; }
	public String getName() { return this.name; }
	public String getDept() { return this.dept; }
	public int getGrade() { return this.grade; }
	
	// 학번으로 비교하는 compareTo() 오버라이딩
	@Override
	public int compareTo(Student s) {
		return this.id - s.id;
		// + 0 - 값이 나옴 (id값은 정수) : 오름차순 정렬
	}
	// 방법(1) 내부 클래스로 구현 
	public static class WithName implements Comparator<Student> {
		public int compare(Student first, Student second) {
			return first.name.compareTo(second.name);
		}
	};
	// 방법(2) 익명 클래스
	public static Comparator<Student> CompDept = new Comparator<Student>() {
		public int compare(Student first, Student second) {
			return first.dept.compareTo(second.dept);
		}
	};
	
	public static class WithGrade implements Comparator<Student> {
		public int compare(Student first, Student second) {
			return first.grade - second.grade;
		}
	};

}
