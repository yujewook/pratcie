package com.pratice.dao;

import java.util.List;

import com.pratice.dto.BoardDto;
import com.pratice.dto.PageHandler;

public interface BoardDao {
	
	public List<BoardDto> boardList(PageHandler page) throws Exception;
	public BoardDto select (int bno) throws Exception ;
	public int countBoard() throws Exception;

}