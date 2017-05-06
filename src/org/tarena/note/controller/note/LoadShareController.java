package org.tarena.note.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.note.entity.NoteResult;
import org.tarena.note.service.NoteService;

@Controller
@RequestMapping("/note")
public class LoadShareController {
	
	@Resource
	private NoteService noteService;
	
	@RequestMapping("/loadshare.do")
	@ResponseBody
	public NoteResult execute(String shareId){
		NoteResult result = noteService.loadShare(shareId);
		return result;
		
	}
}
