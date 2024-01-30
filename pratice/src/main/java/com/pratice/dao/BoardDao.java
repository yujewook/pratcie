package com.pratice.dao;

import java.util.List;

import com.pratice.dto.BoardDto;
import com.pratice.dto.PageHandler;

public interface BoardDao {
	
	public List<BoardDto> boardList(PageHandler page) throws Exception;
	public BoardDto select (int bno) throws Exception;
	public List<BoardDto> boardSearch(PageHandler page,BoardDto indto) throws Exception;
	public int countBoard() throws Exception;
	public int insertBoard(BoardDto indto) throws Exception;
	public int updateBoard(BoardDto indto) throws Exception;
	public int deleteBoard(BoardDto indto) throws Exception;
}