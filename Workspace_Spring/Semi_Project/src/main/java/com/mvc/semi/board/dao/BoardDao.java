package com.mvc.semi.board.dao;

public interface BoardDao {

	public List<BoardDto> accompany_selectList();
	public List<BoardDto> notice_selectList();
	public List<BoardDto> photo_selectList();
	public BoardDto accompany_selectOne(int postId);
	public BoardDto notice_selectOne(int postId);
	public BoardDto photo_selectList();
	public int accompany_insert(BoardDto dto);
	public int photo_insert(BoardDto dto);
	public int notice_insert(BoardDto dto);
	public int accompany_update(BoardDto dto);
	
}
