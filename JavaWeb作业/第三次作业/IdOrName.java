package 第三次作业;

public abstract class IdOrName extends OutAllNames {

  @Override
  public NameUtil studentIdName(String s_id, String name) {
    return new NameUtil(name, s_id, null);
  }

  public abstract NameUtil StudentId_dormitoryId(String s_id, String dormitory_id);
}
