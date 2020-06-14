package kr.co.assemble.dto;

import java.util.Date;

public class MemReqGroupDTO {
   private int bno;
   private int memberno;
   private int reqstatus;
   private String responseid;
   private String boardcontents;
   private Date boarddate;
   private int boardlike;
   private int boardhate;
   private String filename;
   
   public MemReqGroupDTO() {}

   public MemReqGroupDTO(int bno, int memberno, int reqstatus, String responseid, String boardcontents, Date boarddate,
         int boardlike, int boardhate, String filename) {
      super();
      this.bno = bno;
      this.memberno = memberno;
      this.reqstatus = reqstatus;
      this.responseid = responseid;
      this.boardcontents = boardcontents;
      this.boarddate = boarddate;
      this.boardlike = boardlike;
      this.boardhate = boardhate;
      this.filename = filename;
   }

   public int getBno() {
      return bno;
   }

   public void setBno(int bno) {
      this.bno = bno;
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

   public String getBoardcontents() {
      return boardcontents;
   }

   public void setBoardcontents(String boardcontents) {
      this.boardcontents = boardcontents;
   }

   public Date getBoarddate() {
      return boarddate;
   }

   public void setBoarddate(Date boarddate) {
      this.boarddate = boarddate;
   }

   public int getBoardlike() {
      return boardlike;
   }

   public void setBoardlike(int boardlike) {
      this.boardlike = boardlike;
   }

   public int getBoardhate() {
      return boardhate;
   }

   public void setBoardhate(int boardhate) {
      this.boardhate = boardhate;
   }

   public String getFilename() {
      return filename;
   }

   public void setFilename(String filename) {
      this.filename = filename;
   }
   
   
   
   
   
}