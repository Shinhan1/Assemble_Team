package kr.co.assemble.dto;

import java.util.Date;

public class RecommentDTO {
   private int reno;
   private int bno;
   private int groupno;
   private int categoryno;
   private Date redate;
   private String reid;
   private String recontents;
   
   public RecommentDTO() {}

   public RecommentDTO(int reno, int bno, int groupno, int categoryno, Date redate, String reid,
         String recontents) {
      super();
      this.reno = reno;
      this.bno = bno;
      this.groupno = groupno;
      this.categoryno = categoryno;
      this.redate = redate;
      this.reid = reid;
      this.recontents = recontents;
   }

   public int getReno() {
      return reno;
   }

   public void setReno(int reno) {
      this.reno = reno;
   }

   public int getBno() {
      return bno;
   }

   public void setBno(int bno) {
      this.bno = bno;
   }

   public int getGroupno() {
      return groupno;
   }

   public void setGroupno(int groupno) {
      this.groupno = groupno;
   }

   public int getCategoryno() {
      return categoryno;
   }

   public void setCategoryno(int categoryno) {
      this.categoryno = categoryno;
   }

   public Date getRedate() {
      return redate;
   }

   public void setRedate(Date redate) {
      this.redate = redate;
   }

   public String getReid() {
      return reid;
   }

   public void setReid(String reid) {
      this.reid = reid;
   }

   public String getRecontents() {
      return recontents;
   }

   public void setRecontents(String recontents) {
      this.recontents = recontents;
   }

   
   
   
}