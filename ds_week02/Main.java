package ds_week02;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Student[] studs = {
			new Student(14042, "박**", "융소", 2),
			new Student(62028, "한**", "국문", 3),
			new Student(49064, "정**", "경제", 4),
			new Student(14055, "장**", "융소", 2),
			new Student(31076, "박**", "경영", 3),
			new Student(29010, "이**", "컴퓨터", 1),
			new Student(67034, "김**", "영문", 4),
			new Student(14020, "최**", "융소", 1),
			new Student(14007, "강**", "융소", 2),
			new Student(51061, "남**", "경영", 3)
		};
		
		Arrays.sort(studs); // 학번으로 정렬
		print(studs, "id");
		
		Arrays.sort(studs, Student.CompName);
		print(studs, "이름");
		
		Arrays.sort(studs, Student.CompDept);
		print(studs, "학과");
		
		Arrays.sort(studs, Student.CompGrade);
		print(studs, "학년");
	}
	
	public static void print(Student[] studs, String key) {
		System.out.println();
		System.out.println(key+"로 정렬");
		System.out.println("--------------");
		for(Student s: studs) {
			System.out.println(s.getId()+" "+s.getName()+" "
							+s.getDept()+"\t"+s.getGrade());
		}
	}

}
