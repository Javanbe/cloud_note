package org.tarena.note.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.tarena.note.dao.NoteDao;
import org.tarena.note.entity.NoteResult;

@Service
public class NoteServiceImp implements NoteService{
	@Resource
	private NoteDao noteDao;
	
	public NoteResult loadNotes(String bookId) {
		List<Map> list = noteDao.findByBookId(bookId);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("查询笔记成功");
		result.setData(list);
		return result;
	}

}
