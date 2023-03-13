package 第三次作业;

public class NameUtil {
  String name; // 姓名
  String studentNumber; // 学号
  String dormitoryNumber; // 寝室号

  public NameUtil() {
  }

  public NameUtil(String name, String studentNumber, String dormitoryNumber) {
    this.name = name;
    this.studentNumber = studentNumber;
    this.dormitoryNumber = dormitoryNumber;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStudentNumber() {
    return studentNumber;
  }

  public void setStudentNumber(String studentNumber) {
    this.studentNumber = studentNumber;
  }

  public String getDormitoryNumber() {
    return dormitoryNumber;
  }

  public void setDormitoryNumber(String dormitoryNumber) {
    this.dormitoryNumber = dormitoryNumber;
  }

  @Override
  public String toString() {
    return "NameTool{" +
        "name='" + name + '\'' +
        ", studentNumber='" + studentNumber + '\'' +
        ", dormitoryNumber='" + dormitoryNumber + '\'' +
        '}';
  }
}
