package com.pratice.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pratice.dto.MemerInfoDto;

@Repository
public class MemberDaoImple implements MemberDao{
    @Autowired
    private SqlSession session;
    private static String namespace = "com.pratice.dao.MemberInfoMapper.";
	
    @Override
	public List<MemerInfoDto> select(String id) throws Exception {
    	System.out.println("dao id"+id);
		return session.selectList(namespace+"select", id);
	}

    @Override
	public MemerInfoDto selectHis(String id) throws Exception {
    	System.out.println("dao id"+id);
		return session.selectOne(namespace+"selectHis", id);
	}

	@Override
	public int insert(MemerInfoDto indto) throws Exception {
		System.out.println("inset id" + indto.getId() );
		return session.insert(namespace+"memberinsert", indto);
	}



}
