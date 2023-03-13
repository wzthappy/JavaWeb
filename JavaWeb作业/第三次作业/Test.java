package 第三次作业;

public class Test{
  public static void main(String[] args) {
    Wzt abcBbj = new IdOrDormitory();
    System.out.println("--------- 1 --------");
    abcBbj.outNames();

    System.out.println("--------- 2 --------");
    System.out.println(abcBbj.studentIdName(Wzt.STUDENT_NYNBER, Wzt.NAME));

    System.out.println("--------- 3 --------");
    System.out.println(abcBbj.StudentId_dormitoryId(Wzt.STUDENT_NYNBER, Wzt.DORMITORY_NUMBER));
  }
}
