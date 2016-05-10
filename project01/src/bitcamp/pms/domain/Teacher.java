package bitcamp.pms.domain;

public class Teacher {
  protected int tno;
  protected String name;
  protected String tel;
  protected String email;
  protected String photo;

  public Teacher() {}

  @Override
  public String toString() {
    return "Teacher [tno=" + tno + ", name=" + name + ", tel=" + tel + ", email=" + email + ", photo=" + photo + "]";
  }

  public int getTno() {
    return tno;
  }

  public void setTno(int tno) {
    this.tno = tno;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

}