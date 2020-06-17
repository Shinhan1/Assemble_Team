package kr.co.assemble.dto;

import java.util.Date;

public class MemReqGroupDTO {
   private String mi_memname;
   private String mi_memid;
   private String groupname;
   private int bno;
   private Date boarddate;
   private String boardcontents;
   private int boardnotice;
   private int boardlike;
   private int boardhate;
   private int requestboolean;
   private int reqstatus;
   private String responseid;
   private String filename;
   private String valueid;
   private String valuename;
   private int groupno;
   private String assemblename;
   private int roomname;
	private int senderno;
	private String chatcontent;
	private String chattime;
  
   
   public MemReqGroupDTO() {}

   







public int getRoomname() {
	return roomname;
}









public void setRoomname(int roomname) {
	this.roomname = roomname;
}









public int getSenderno() {
	return senderno;
}









public void setSenderno(int senderno) {
	this.senderno = senderno;
}









public String getChatcontent() {
	return chatcontent;
}









public void setChatcontent(String chatcontent) {
	this.chatcontent = chatcontent;
}









public String getChattime() {
	return chattime;
}









public void setChattime(String chattime) {
	this.chattime = chattime;
}









public MemReqGroupDTO(String mi_memname, String mi_memid, String groupname, int bno, Date boarddate,
		String boardcontents, int boardnotice, int boardlike, int boardhate, int requestboolean, int reqstatus,
		String responseid, String filename, String valueid, String valuename, int groupno, String assemblename) {
	super();
	this.mi_memname = mi_memname;
	this.mi_memid = mi_memid;
	this.groupname = groupname;
	this.bno = bno;
	this.boarddate = boarddate;
	this.boardcontents = boardcontents;
	this.boardnotice = boardnotice;
	this.boardlike = boardlike;
	this.boardhate = boardhate;
	this.requestboolean = requestboolean;
	this.reqstatus = reqstatus;
	this.responseid = responseid;
	this.filename = filename;
	this.valueid = valueid;
	this.valuename = valuename;
	this.groupno = groupno;
	this.assemblename = assemblename;
}









public String getMi_memname() {
      return mi_memname;
   }

   public void setMi_memname(String mi_memname) {
      this.mi_memname = mi_memname;
   }

   public String getMi_memid() {
      return mi_memid;
   }

   public void setMi_memid(String mi_memid) {
      this.mi_memid = mi_memid;
   }

   public String getGroupname() {
      return groupname;
   }

   public void setGroupname(String groupname) {
      this.groupname = groupname;
   }

   public int getBno() {
      return bno;
   }

   public void setBno(int bno) {
      this.bno = bno;
   }

   public Date getBoarddate() {
      return boarddate;
   }

   public void setBoarddate(Date boarddate) {
      this.boarddate = boarddate;
   }

   public String getBoardcontents() {
      return boardcontents;
   }

   public void setBoardcontents(String boardcontents) {
      this.boardcontents = boardcontents;
   }

   public int getBoardnotice() {
      return boardnotice;
   }

   public void setBoardnotice(int boardnotice) {
      this.boardnotice = boardnotice;
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

   public int getRequestboolean() {
      return requestboolean;
   }

   public void setRequestboolean(int requestboolean) {
      this.requestboolean = requestboolean;
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

   public String getFilename() {
      return filename;
   }

   public void setFilename(String filename) {
      this.filename = filename;
   }

   public String getValueid() {
      return valueid;
   }

   public void setValueid(String valueid) {
      this.valueid = valueid;
   }

   public String getValuename() {
      return valuename;
   }

   public void setValuename(String valuename) {
      this.valuename = valuename;
   }



	public int getGroupno() {
		return groupno;
	}
	
	
	
	public void setGroupno(int groupno) {
		this.groupno = groupno;
	}

	public String getAssemblename() {
		return assemblename;
	}


	public void setAssemblename(String assemblename) {
		this.assemblename = assemblename;
	}


   
   
   
}