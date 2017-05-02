package org.tarena.note.controller.notebook;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.note.entity.NoteResult;
import org.tarena.note.service.NoteBookService;

@Controller
@RequestMapping("/notebook")
public class AddBookController {
	@Resource
	private NoteBookService bookService;
	@RequestMapping("/add.do")
	@ResponseBody
	public NoteResult execute(String bookName,String userId){
	NoteResult result =	bookService.addBook(bookName, userId);
	  return result;
	}
}
