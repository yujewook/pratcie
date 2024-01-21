package com.pratice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pratice.dto.BoardDto;
import com.pratice.dto.PageHandler;
import com.pratice.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	BoardService boardService;
	
	
	@GetMapping("/list")
	public String boardList ( Integer page , Integer pageSize , Model m) {
		List <BoardDto> outDto = null;
		if (page==null) page=1; 
		if (pageSize==null) pageSize=10; 
		
		try {
			int totalCnt =  boardService.count();
			PageHandler pageHandler = new PageHandler(totalCnt, page, pageSize );
			System.out.println("controller total" + pageHandler.getTotalCount());
			System.out.println("controller page" + pageHandler.getPage());
			System.out.println("controller pagesize" + pageHandler.getPageSize());
			
			
			outDto = boardService.boardList(pageHandler);
			
			m.addAttribute("list", outDto);
			m.addAttribute("ph", pageHandler);
		
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
		return "boardList";
	}
	
	
	
	@GetMapping("/select")
	public String select(int bno, Model m) {
		bno=1;
		BoardDto outDto = new BoardDto() ;
		try {
			outDto = boardService.select(bno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m.addAttribute("list", outDto);
		System.out.println("조회 성공"+outDto.getTitle());
		
		return null;
	}
}
