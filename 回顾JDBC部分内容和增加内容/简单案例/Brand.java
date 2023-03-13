package JavaWeb.回顾JDBC部分内容和增加内容.简单案例;

/**
 * 品牌
 *
 * alt + 鼠标左键: 整列编辑
 *
 * 在实体类中，基本数据类型建议使用其对应的包装类型
 */

public class Brand {
  // id 主键
  private Integer id;
  // 品牌名称
  private String brandName;
  // 企业名称
  private String companyName;
  // 排序字段
  private Integer ordered;
  // 描述消息
  private String description;
  // 状态: 0(禁用)， 1(启用)
  private Integer status;

  public Integer getId() {
    return id;
  }

  public String getBrandName() {
    return brandName;
  }

  public String getCompanyName() {
    return companyName;
  }

  public Integer getOrdered() {
    return ordered;
  }

  public String getDescription() {
    return description;
  }

  public Integer getStatus() {
    return status;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setBrandName(String brandName) {
    this.brandName = brandName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public void setOrdered(Integer ordered) {
    this.ordered = ordered;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Brand{" +
            "id=" + id +
            ", brandName='" + brandName + '\'' +
            ", companyName='" + companyName + '\'' +
            ", ordered=" + ordered +
            ", description='" + description + '\'' +
            ", status=" + status +
            '}';
  }
}
