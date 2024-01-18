package com.pratice.dao;

import java.util.List;

import com.pratice.dto.MemerInfoDto;


public interface MemberDao {
	List<MemerInfoDto> select(String id) throws Exception;
	public MemerInfoDto selectHis(String id) throws Exception;
	public int insert(MemerInfoDto indto) throws Exception;
}
