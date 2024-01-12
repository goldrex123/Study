package ch07.sec07.exam03;

public class ChildExample {
	public static void main(String[] args) {
		Parent parent = new Child();
		
		parent.field1 = "data1";
		parent.method1();
		parent.method2();
		
		/* 자식객체에 선언된 필드와 메소드 사용 불가
		 * parent.filed2; 
		 * parent.method3();
		 */
		
		Child child = (Child) parent;
		
		// 자식 타입으로 강제 형변환 후에는 자식 객체에 선언된 필드와 메소드도 사용할 수 있다.
		child.field2 = "data2";
		child.method3();
	}

}
