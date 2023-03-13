package 第三次作业;

public interface Wzt {
  String NAME = "万志涛"; // 姓名
  String STUDENT_NYNBER = "210401030"; // 学号
  String DORMITORY_NUMBER = "1B604"; // 寝室号
  String[] DORMITORY_NAMES = {"左堂辉", "高毅", "许键伟", "王浩东", "张荆州"}; // 寝室其他成员

  // 学号 + 姓名
  NameUtil studentIdName (String s_id, String name);

  // 学号 + 寝室号
  NameUtil StudentId_dormitoryId (String s_id, String dormitory_id);

  // 输出 同宿舍 姓名
  void outNames ();
}
