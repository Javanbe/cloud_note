package org.tarena.note.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.tarena.note.dao.NoteBookDao;
import org.tarena.note.entity.NoteBook;
import org.tarena.note.entity.NoteResult;

@Service
public class NoteBookServiceImp implements NoteBookService{
	
	@Resource	
	private NoteBookDao bookDao;
	public NoteResult loadBooks(String userId) {
		List<NoteBook> list = bookDao.findByUser(userId);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("查询笔记本成功");
		result.setData(list);
		return result;
	}
	

}
