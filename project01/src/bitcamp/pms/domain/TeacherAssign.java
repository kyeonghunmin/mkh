package bitcamp.pms.domain;
 
import java.sql.Date;
 
public class TeacherAssign {
  
  //강사배치 번호
  private int tano;
  //교육과정 번호
  private int lno;
  //강사 번호
  private int tno;
  //강의 시작일
  private Date startDate;
  //강의 종료일
  private Date endDate;
  //강의 내용
  private String description;
  //강의 시간
  private int hr;
  
  
  public int getTano() {
    return tano;
  }
  public void setTano(int tano) {
    this.tano = tano;
  }
  public int getLno() {
    return lno;
  }
  public void setLno(int lno) {
    this.lno = lno;
  }
  public int getTno() {
    return tno;
  }
  public void setTno(int tno) {
    this.tno = tno;
  }
  public Date getStartDate() {
    return startDate;
  }
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }
  public Date getEndDate() {
    return endDate;
  }
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public int getHr() {
    return hr;
  }
  public void setHr(int hr) {
    this.hr = hr;
  }
  @Override
  public String toString() {
    return "TeacherAssign [tano=" + tano + ", lno=" + lno + ", tno=" + tno + ", startDate=" + startDate + ", endDate="
        + endDate + ", description=" + description + ", hr=" + hr + "]";
  }
 
}