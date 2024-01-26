package com.pratice.service;

import com.pratice.dto.MemerInfoDto;
import com.pratice.dto.SaveResultDto;


public interface RegesiterService {
	SaveResultDto regesiter (MemerInfoDto inDto) throws Exception;
	public int insertMember(MemerInfoDto inDto) throws Exception;
}
