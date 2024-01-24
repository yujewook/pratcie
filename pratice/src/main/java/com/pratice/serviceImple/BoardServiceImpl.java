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


	@Override
	public String CRUDBoard (BoardDto indto) throws Exception {
		System.out.println("서비스 " + indto.getSts());
		
		if(indto.getSts()=="I"|| indto.getSts()=="U" ) {
			//writer를 찾아서 ... bno를 찔러 넣기도 생각 해보자.
			if(indto.getBno() == null || indto.getSts()=="I" ) {
				System.out.println("서비스 " + indto.getSts());
				dao.insertBoard(indto);
			}else {
				dao.updateBoard(indto);
			}
		} else if (indto.getSts()=="D" ) {

		}
		return null;
	}





	


}
