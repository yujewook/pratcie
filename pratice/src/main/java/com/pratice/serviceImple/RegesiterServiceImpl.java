package com.pratice.serviceImple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pratice.dao.MemberDao;
import com.pratice.dto.MemerInfoDto;
import com.pratice.dto.SaveResultDto;
import com.pratice.service.RegesiterService;

@Service("Regesiter")
public class RegesiterServiceImpl implements RegesiterService {
	@Autowired
    private MemberDao dao;
	
	@Override
	public SaveResultDto regesiter(MemerInfoDto inDto) throws Exception {
		int resultCnt = 0;
		String msg = "";
		SaveResultDto outDto = new SaveResultDto(); 
//////////////////////////////////////////////////////////////////////////////
//validation
//////////////////////////////////////////////////////////////////////////////
		if ( inDto.getId() == null || inDto.getId() == "") {
	    //outDto.setRestltMsg("아이디 미입력");
		msg = "아이디 미입력";
		throw new RuntimeException(msg);
		}

		if ( inDto.getPwd() == null || inDto.getPwd() == "") {
			outDto.setRestltMsg("패스워드 미입력");
			msg = "패스워드 미입력";
			throw new RuntimeException(msg);
		}
//////////////////////////////////////////////////////////////////////////////
//logicStart
//////////////////////////////////////////////////////////////////////////////
			MemerInfoDto hisresult = dao.selectHis(inDto.getId());
			System.out.println(hisresult.getRowCnt());
			if( hisresult != null && hisresult.getRowCnt() > 0 ) {
				outDto.setRestltMsg("ID 존재합니다");
				throw new Exception(outDto.getRestltMsg());
			} else {
				resultCnt = insertMember(inDto);
				if( resultCnt <= 0 ) {
					outDto.setRestltMsg("가입실패");
					throw new Exception(outDto.getRestltMsg());
				}
				
				outDto.setRestltMsg("가입성공");
			}
			

		return outDto ;
	}

	@Override
	@Transactional
	public int insertMember(MemerInfoDto inDto) throws Exception {
		return dao.insert(inDto);
	}

}
