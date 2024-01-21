package com.pratice.serviceImple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratice.dao.BoardDao;
import com.pratice.dto.BoardDto;
import com.pratice.dto.PageHandler;
import com.pratice.service.BoardService;

@Service("Board")
public class BoardServiceImpl implements BoardService {
	@Autowired
    private BoardDao dao;

	//총페이지수
	@Override
	public int count() throws Exception {
		return dao.countBoard();
	}
	
	
	@Override
	public List<BoardDto> boardList(PageHandler page) throws Exception {
		return dao.boardList(page);
	}
	
	
	@Override
	public BoardDto select(int bno) throws Exception {
		return dao.select(bno);
	}





	


}
