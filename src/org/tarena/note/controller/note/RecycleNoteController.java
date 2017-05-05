package org.tarena.note.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.note.entity.NoteResult;
import org.tarena.note.service.NoteService;

@Controller
@RequestMapping("/note")
public class RecycleNoteController {
	
	@Resource
	private NoteService noteSerivce;
	@RequestMapping("/recycle.do")
	@ResponseBody
	public NoteResult execute(String noteId){
		NoteResult result = noteSerivce.recycleNote(noteId);
		return result;
	}
}
