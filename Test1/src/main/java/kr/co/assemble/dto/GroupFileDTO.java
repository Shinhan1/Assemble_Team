package kr.co.assemble.dto;

public class GroupFileDTO {
   private int bno;
   private String filename;
   private String filepath;
   private int groupno;
   
   public GroupFileDTO() {}

   public GroupFileDTO(int bno, String filename, String filepath, int groupno) {
      super();
      this.bno = bno;
      this.filename = filename;
      this.filepath = filepath;
      this.groupno = groupno;
   }

   public int getBno() {
      return bno;
   }

   public void setBno(int bno) {
      this.bno = bno;
   }

   public String getFilename() {
      return filename;
   }

   public void setFilename(String filename) {
      this.filename = filename;
   }

   public String getFilepath() {
      return filepath;
   }

   public void setFilepath(String filepath) {
      this.filepath = filepath;
   }

   public int getGroupno() {
      return groupno;
   }

   public void setGroupno(int groupno) {
      this.groupno = groupno;
   }
   
   
   
   
}