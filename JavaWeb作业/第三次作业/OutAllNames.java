package 第三次作业;

import java.util.Arrays;

public abstract class OutAllNames implements Wzt {

  @Override
  public void outNames() {
    // 遍历同宿舍的姓名
    System.out.println(Arrays.toString(Wzt.DORMITORY_NAMES));
  }

  public abstract NameUtil studentIdName(String s_id, String name);

  public abstract NameUtil StudentId_dormitoryId(String s_id, String dormitory_id);
}
