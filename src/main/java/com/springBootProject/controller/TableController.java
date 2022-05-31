package com.springBootProject.controller;

import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springBootProject.dto.TableDTO;
import com.springBootProject.service.TableService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TableController {
	
	@Autowired
	TableService tableService;
	
	@GetMapping("/tableMain")
	public ModelAndView listController() throws Exception{
		ModelAndView mav = new ModelAndView();

		List<TableDTO> list = tableService.selectTableList();
		mav.addObject("list", list);
		mav.setViewName("tableMain.html");
		return mav;
	}
    
	//등록
    @GetMapping("/tableInsert")
    public String tableInsert() {
        return "/tableInsert";
    }
    
    //등록 완료
    @PostMapping("/insesrtTable")
    public String insertTable(@ModelAttribute TableDTO tableDto) throws Exception{
    	tableService.insertTable(tableDto);
    	return "redirect:/tableMain";	//게시글 리스트로 이동
    }
    
    // 게시물 상세 페이지이며, {index}로 페이지 넘버를 받는다.
    // PathVariable 애노테이션을 통해 index를 받음
    //상세보기
    @GetMapping("/readTable/{index}")
    public ModelAndView readTable(@PathVariable("index") int index) throws Exception{
    	ModelAndView mav = new ModelAndView();
    	TableDTO tableDto  = tableService.readTable(index);
    	mav.addObject("tableDto",tableDto);
    	mav.setViewName("readTable.html");
    	return mav;
    }
    
    //수정 페이지 접근
   @GetMapping("/tableUpdate/{index}")
   public ModelAndView tableUpdate(@PathVariable int index) throws Exception{
	   	ModelAndView mav = new ModelAndView();
	   	TableDTO tableDto  = tableService.readTable(index);
    	mav.addObject("tableDto",tableDto);
	   	mav.setViewName("updateTable.html");
	   return mav;
	   
   }
   
  	//수정
  	@PostMapping("/updateTable/{index}")
  	public String updateTable(@PathVariable int index, @ModelAttribute TableDTO tableDto) throws IOException {
//  		ModelAndView mav = new ModelAndView();
//  		log.info("tableDto : {}",tableDto.toString());
  		tableDto.setIndex(index);
  		tableService.updateTable(tableDto);
//  		mav.setViewName("redirect:/tableMain");
  		return "redirect:/tableMain";

  }
   	
    //삭제
    @DeleteMapping("/deleteTable/{index}")
    public String delete(@PathVariable int index) {
        tableService.deleteTable(index);
        return "redirect:/tableMain";
    }

    
}
