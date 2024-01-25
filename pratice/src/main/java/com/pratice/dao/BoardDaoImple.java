package com.pratice.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pratice.dto.BoardDto;
import com.pratice.dto.PageHandler;
@Repository
public class BoardDaoImple implements BoardDao {
	@Autowired
    private SqlSession session;
    private static String namespace = "com.pratice.dao.BoardMapper.";
	
    @Override
    public BoardDto select (int bno) throws Exception {
    	return session.selectOne(namespace+"select",bno);
	}
    
    @Override
    public int countBoard() throws Exception {
    	BoardDto outDto = session.selectOne(namespace+"countBoard");
    	return outDto.getBno();
	}
    
    
    @Override
    public List <BoardDto> boardList (PageHandler page) throws Exception {
    	System.out.println("dao 페이지 :::: "+page.getPage());
    	System.out.println("dao 페이지 사이즈 :::: "+page.getPageSize());
    	page.setOffset((page.getPage()) * page.getPageSize());
    	System.out.println("dao offset 사이즈 :::: "+page.getOffset());
    	return session.selectList(namespace+"boardList", page );
    }

	@Override
	public int insertBoard(BoardDto indto) throws Exception {
		System.out.println("dao title" + indto.getTitle());
		return session.insert(namespace+"insertBoard", indto);
	}

	@Override
	public int updateBoard(BoardDto indto) throws Exception {
		System.out.println("dao sts" + indto.getSts());
		System.out.println("dao bno" + indto.getBno());
		return session.update(namespace+"updateBoard", indto);
	}
}
