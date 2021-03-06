package com.mvc.upgrade.model.dto;

import java.util.Date;

public class MYBoardDto {

	private int myno;
	private int groupno;
	private int groupseq;
	private int titletab;
	private String delflag;
	private String myname;
	private String mytitle;
	private String mycontent;
	private Date mydate;
	private int viewCnt;

	public MYBoardDto() {

	}

	public MYBoardDto(int myno, int groupno, int groupseq, int titletab, String delflag, String myname, String mytitle,
			String mycontent, Date mydate, int viewCnt) {
		this.myno = myno;
		this.groupno = groupno;
		this.groupseq = groupseq;
		this.titletab = titletab;
		this.delflag = delflag;
		this.myname = myname;
		this.mytitle = mytitle;
		this.mycontent = mycontent;
		this.mydate = mydate;
		this.viewCnt = viewCnt;
	}

	public int getMyno() {
		return myno;
	}

	public void setMyno(int myno) {
		this.myno = myno;
	}

	public int getGroupno() {
		return groupno;
	}

	public void setGroupno(int groupno) {
		this.groupno = groupno;
	}

	public int getGroupseq() {
		return groupseq;
	}

	public void setGroupseq(int groupseq) {
		this.groupseq = groupseq;
	}

	public int getTitletab() {
		return titletab;
	}

	public void setTitletab(int titletab) {
		this.titletab = titletab;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

	public String getMyname() {
		return myname;
	}

	public void setMyname(String myname) {
		this.myname = myname;
	}

	public String getMytitle() {
		return mytitle;
	}

	public void setMytitle(String mytitle) {
		this.mytitle = mytitle;
	}

	public String getMycontent() {
		return mycontent;
	}

	public void setMycontent(String mycontent) {
		this.mycontent = mycontent;
	}

	public Date getMydate() {
		return mydate;
	}

	public void setMydate(Date mydate) {
		this.mydate = mydate;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

}