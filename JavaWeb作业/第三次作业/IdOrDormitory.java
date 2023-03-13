package 第三次作业;

public class IdOrDormitory extends IdOrName {
  @Override
  public NameUtil StudentId_dormitoryId(String s_id, String dormitory_id) {
    return new NameUtil(null, s_id, dormitory_id);
  }
}
