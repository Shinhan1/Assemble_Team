package kr.co.assemble.dto;

public class NavbarDTO {
   private int categoryno;
   private String categoryname;
   private int memberno;
   private String assemblename;
   private int checkcategoryno;
   private int publicsecret;
   
   public NavbarDTO() {}

   public NavbarDTO(int categoryno, String categoryname, int memberno, String assemblename, int checkcategoryno,
         int publicsecret) {
      super();
      this.categoryno = categoryno;
      this.categoryname = categoryname;
      this.memberno = memberno;
      this.assemblename = assemblename;
      this.checkcategoryno = checkcategoryno;
      this.publicsecret = publicsecret;
   }





   public int getCategoryno() {
      return categoryno;
   }


   public void setCategoryno(int categoryno) {
      this.categoryno = categoryno;
   }


   public String getCategoryname() {
      return categoryname;
   }


   public void setCategoryname(String categoryname) {
      this.categoryname = categoryname;
   }


   public int getMemberno() {
      return memberno;
   }


   public void setMemberno(int memberno) {
      this.memberno = memberno;
   }


   public String getAssemblename() {
      return assemblename;
   }

   public void setAssemblename(String assemblename) {
      this.assemblename = assemblename;
   }

   public int getCheckcategoryno() {
      return checkcategoryno;
   }

   public void setCheckcategoryno(int checkcategoryno) {
      this.checkcategoryno = checkcategoryno;
   }

   public int getPublicsecret() {
      return publicsecret;
   }

   public void setPublicsecret(int publicsecret) {
      this.publicsecret = publicsecret;
   }
   
   
   
   

}