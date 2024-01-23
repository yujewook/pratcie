package com.pratice.service;

import java.util.List;

import com.pratice.dto.BoardDto;
import com.pratice.dto.PageHandler;

public interface BoardService {
	public int count() throws Exception;
	public List<BoardDto> boardList(PageHandler page) throws Exception;
	public BoardDto select(int bno) throws Exception;
	public String CRUDBoard (BoardDto indto) throws Exception;
}
