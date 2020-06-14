package kr.co.assemble.dto;

public class ComposedMemberInfoDTO {
   private String mi_memid;
   private String mi_memname;
   private int groupno;
   
   public ComposedMemberInfoDTO() {}

   public ComposedMemberInfoDTO(String mi_memid, String mi_memname, int groupno) {
      super();
      this.mi_memid = mi_memid;
      this.mi_memname = mi_memname;
      this.groupno = groupno;
   }

   public String getMi_memid() {
      return mi_memid;
   }

   public void setMi_memid(String mi_memid) {
      this.mi_memid = mi_memid;
   }

   public String getMi_memname() {
      return mi_memname;
   }

   public void setMi_memname(String mi_memname) {
      this.mi_memname = mi_memname;
   }

   public int getGroupno() {
      return groupno;
   }

   public void setGroupno(int groupno) {
      this.groupno = groupno;
   }

   
   
}