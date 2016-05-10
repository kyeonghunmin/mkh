package bitcamp.pms.domain;

import java.sql.Date;

public class Lecture {
  int lno;
  String rno;
  String title;
  String desc;
  Date startDate;
  Date endDate;
  int dayHr;
  int totalHr;
  Date finalDate;

  public Lecture() {}

  @Override
  public String toString() {
    return "Lecture [lno=" + lno + ", rno=" + rno + ", title=" + title + ", desc=" + desc + ", startDate=" + startDate
        + ", endDate=" + endDate + ", dayHr=" + dayHr + ", totalHr=" + totalHr + ", finalDate=" + finalDate + "]";
  }

  public int getLno() {
    return lno;
  }

  public void setLno(int lno) {
    this.lno = lno;
  }

  public String getRno() {
    return rno;
  }

  public void setRno(String rno) {
    this.rno = rno;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
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

  public int getDayHr() {
    return dayHr;
  }

  public void setDayHr(int dayHr) {
    this.dayHr = dayHr;
  }

  public int getTotalHr() {
    return totalHr;
  }

  public void setTotalHr(int totalHr) {
    this.totalHr = totalHr;
  }

  public Date getFinalDate() {
    return finalDate;
  }

  public void setFinalDate(Date finalDate) {
    this.finalDate = finalDate;
  }
  
}
