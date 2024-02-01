package com.pratice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
		if (page==null) page=0; 
		if (pageSize==null) pageSize=10; 
		
		try {
			int totalCnt =  boardService.count();
			PageHandler pageHandler = new PageHandler(totalCnt, page, pageSize );
			System.out.println("controller total" + pageHandler.getTotalCount());
			System.out.println("controller page" + pageHandler.getPage());
			System.out.println("controller pagesize" + pageHandler.getPageSize());
			
			
			outDto = boardService.boardList(pageHandler);
			
			m.addAttribute("boardDto", outDto);
			m.addAttribute("ph", pageHandler);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "boardList";
	}
	
	@GetMapping("/search")
	public String search (String option, String keyword, Integer page , Integer pageSize , Model m, BoardDto indto ) {
		List <BoardDto> outDto = null;
		if (page==null) page=0; 
		if (pageSize==null) pageSize=10; 
		try {
			int totalCnt =  boardService.count();
			PageHandler pageHandler = new PageHandler(totalCnt, page, pageSize );
			System.out.println("controller total" + pageHandler.getTotalCount());
			System.out.println("keyword :: " + keyword);
			System.out.println("option :: " + option);
			if(option.equals("A")) {
				indto.setBno(Integer.parseInt(keyword));
				indto.setOption(option);
			} else {
				indto.setTitle(keyword);
				indto.setOption(option);
			}
			
			outDto = boardService.search(pageHandler, indto);
	        if (outDto.isEmpty()) {
	            // outDto가 비어있을 때, 빈 화면을 보이게 하거나 필요한 처리를 추가하세요.
	            // 여기에서는 빈 화면을 보이게 하는 로직을 추가합니다.
	            m.addAttribute("boardDto", new ArrayList<BoardDto>());
	            m.addAttribute("ph", pageHandler);
	            return "boardList";
	        }
			
			
			m.addAttribute("boardDto", outDto);
			m.addAttribute("ph", pageHandler);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "boardList";
	}
	
	
	@GetMapping("/select")
	public String select(Integer bno, Integer page , Integer pageSize, Model m) {
		BoardDto outDto = new BoardDto() ;
		try {
			outDto = boardService.select(bno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m.addAttribute("boardDto", outDto);
		m.addAttribute("page", page);
		m.addAttribute("pageSize", pageSize);
		System.out.println("조회 성공"+outDto.getTitle());
		System.out.println(outDto.getComment_cnt());
		System.out.println(outDto.getContent());
		return "board";
	}
	
	
	@GetMapping("/write")
	public String write(Integer bno, Integer page , Integer pageSize, Model m) {
		return "board";
	}
	
	
	@PostMapping("/write")
	public String write(BoardDto inDto, Model m) {
		System.out.println("컨트롤러  sts  : "+inDto.getSts());
		System.out.println("컨트롤러  sts  : "+inDto.getContent());
		try {
			 boardService.CRUDBoard(inDto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/board/list";
	}
	
}
