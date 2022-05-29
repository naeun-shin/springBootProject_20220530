package com.springBootProject.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springBootProject.dto.TableDTO;
import com.springBootProject.service.TableService;

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
    @PostMapping("/insesrtTable")		//작성된 게시글 등록 기능 메소드, html의 form 태그 action에서 입력한 주소
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
    
    //수정 페이지 	접근
  @RequestMapping("/tableUpdate/{index}")
   public String updateTable(@PathVariable int index, Model model) throws Exception{
	   	TableDTO tableDto = tableService.readTable(index);
	   	model.addAttribute("tableDto", tableDto);
	   return "updateTable";
	   
   }
  
  @PutMapping("/updateTable")
  	public String updateTable(TableDTO tableDto) {
//	 tableService.updateTable(tableDto);
	  return "redirect:/tableMain";
  }
    //삭제
    @RequestMapping("/deleteTable/{index}")
    public String delete(@PathVariable int index) {
        tableService.deleteTable(index);
        return "redirect:/tableMain";
    }

    
}
