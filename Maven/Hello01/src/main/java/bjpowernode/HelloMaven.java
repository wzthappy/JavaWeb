package JavaWeb.Maven.Hello01.src.main.java.bjpowernode;

public class HelloMaven {
	public int addNumber(int n1, int n2) {
		System.out.println("HellMaven addNumber");
		return n1 + n2;
	}
	
	public static void main(String args[]) {
		HelloMaven hello = new HelloMaven();
		int res = hello.addNumber(10, 20);
		System.out.println("在main方法中，执行hello的方法=" + res);
	}
}