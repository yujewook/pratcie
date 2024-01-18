package com.pratice.serviceImple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratice.dao.MemberDao;
import com.pratice.dto.MemerInfoDto;
import com.pratice.service.RegesiterService;

@Service("Regesiter")
public class RegesiterServiceImpl implements RegesiterService {
	@Autowired
    private MemberDao dao;
	
	@Override
	public List<MemerInfoDto> regesiter(MemerInfoDto inDto) throws Exception {
		System.out.println("service inDto :: "+ inDto.getId());
		//validation
//		if ( inDto.getId() == null || inDto.getId() == "") {
//			throw new IllegalArgumentException("ID cannot be null or empty");
//		}
	
		MemerInfoDto hisresult = dao.selectHis(inDto.getId());
		System.out.println(hisresult.getRowCnt());
		if( hisresult!=null && hisresult.getRowCnt() > 0 ) {
			throw new IllegalArgumentException("ID existed");
		}
		dao.insert(inDto);
		
		return null ;
	}

}
