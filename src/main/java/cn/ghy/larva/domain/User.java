package cn.ghy.larva.domain;

import java.util.Date;
import java.util.List;

import jakarta.validation.constraints.*;

/**
 * @author Ziyang
 */
public class User {

  private Long userId;

  @NotBlank
  @Size(min = 2, max = 50)
  private String userName;

  @NotBlank
  @Pattern(regexp = "^(?![A-Z]+$)(?![a-z]+$)(?!\\d+$)(?![\\W_]+$)\\S{6,}$")
  private String password;

  @NotBlank
  @Size(min = 2, max = 15)
  private String realName;

  @NotBlank
  @Email
  private String userEmail;

  private Integer userStatus;

  @Past
  private Date createTime;

  @Past
  private Date modifiedTime;

  private List<Meta> metas;

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }

  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  public Integer getUserStatus() {
    return userStatus;
  }

  public void setUserStatus(Integer userStatus) {
    this.userStatus = userStatus;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getModifiedTime() {
    return modifiedTime;
  }

  public void setModifiedTime(Date modifiedTime) {
    this.modifiedTime = modifiedTime;
  }

  public List<Meta> getMetas() {
    return metas;
  }

  public void setMetas(List<Meta> metas) {
    this.metas = metas;
  }
}