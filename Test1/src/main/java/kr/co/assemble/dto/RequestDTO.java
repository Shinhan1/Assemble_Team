package kr.co.assemble.dto;

import java.util.Date;

public class RequestDTO {
   private int bno;
   private int groupno;
   private int categoryno;
   private int memberno;
   private int reqstatus;
   private String responseid;
   private Date reqdate;
   
   public RequestDTO() {}

   public RequestDTO(int bno, int groupno, int categoryno, int memberno, int reqstatus, String responseid,
         Date reqdate) {
      super();
      this.bno = bno;
      this.groupno = groupno;
      this.categoryno = categoryno;
      this.memberno = memberno;
      this.reqstatus = reqstatus;
      this.responseid = responseid;
      this.reqdate = reqdate;
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

   public int getMemberno() {
      return memberno;
   }

   public void setMemberno(int memberno) {
      this.memberno = memberno;
   }

   public int getReqstatus() {
      return reqstatus;
   }

   public void setReqstatus(int reqstatus) {
      this.reqstatus = reqstatus;
   }

   public String getResponseid() {
      return responseid;
   }

   public void setResponseid(String responseid) {
      this.responseid = responseid;
   }

   public Date getReqdate() {
      return reqdate;
   }

   public void setReqdate(Date reqdate) {
      this.reqdate = reqdate;
   }

   



}