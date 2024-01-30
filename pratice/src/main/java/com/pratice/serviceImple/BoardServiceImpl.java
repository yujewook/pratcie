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
	public List<BoardDto> search(PageHandler page, BoardDto indto) throws Exception {
		// TODO Auto-generated method stub
		return dao.boardSearch(page, indto);
	}

	
	
	
	@Override
	public BoardDto select(int bno) throws Exception {
		return dao.select(bno);
	}


	@Override
	public String CRUDBoard (BoardDto indto) throws Exception {
		System.out.println("서비스 sts" + indto.getSts());
		
		if( indto.getSts().equals("I")) {
			//writer를 찾아서 ... bno를 찔러 넣기도 생각 해보자.
			System.out.println("Insert dao로 가기전");
			dao.insertBoard(indto);
		} else if(indto.getSts().equals("U")) {
			System.out.println("update dao로 가기전");
			dao.updateBoard(indto);
		} else if(indto.getSts()!=null) {
			dao.deleteBoard(indto);
		}
		return null;
	}







	


}
