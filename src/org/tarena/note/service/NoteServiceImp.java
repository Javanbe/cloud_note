package org.tarena.note.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.tarena.note.dao.NoteDao;
import org.tarena.note.dao.ShareDao;
import org.tarena.note.entity.Note;
import org.tarena.note.entity.NoteResult;
import org.tarena.note.entity.Share;
import org.tarena.note.util.NoteUtil;

@Service
public class NoteServiceImp implements NoteService{
	@Resource
	private NoteDao noteDao;
	@Resource
	private ShareDao shareDao;
	public NoteResult loadNotes(String bookId) {
		List<Map> list = noteDao.findByBookId(bookId);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("查询笔记成功");
		result.setData(list);
		return result;
	}

	public NoteResult addNote(String noteTitle, String bookId, String userId) {
		NoteResult result = new NoteResult();
		//添加笔记
		Note note = new Note();
		note.setCn_note_title(noteTitle);
		note.setCn_user_id(userId);
		note.setCn_note_status_id("1");
		note.setCn_notebook_id(bookId);
		note.setCn_note_body("");
		note.setCn_note_create_time(System.currentTimeMillis());
		String noteId = NoteUtil.createId();
		note.setCn_note_id(noteId);
		noteDao.save(note);
		result.setStatus(0);
		result.setMsg("创建笔记成功");
		result.setData(noteId);
		return result;
	}

	public NoteResult loadNote(String noteId) {
		NoteResult result = new NoteResult();
		Note note = noteDao.findById(noteId);
		result.setStatus(0);
		result.setMsg("查询笔记成功");
		result.setData(note);
		return result;
	}

	public NoteResult updateNote(String noteId, String noteTitle,
			String noteBody) {
		NoteResult result = new NoteResult();
		//更新
		Note note = new Note();
		note.setCn_note_id(noteId);
		note.setCn_note_title(noteTitle);
		note.setCn_note_body(noteBody);
		note.setCn_note_last_modify_time(System.currentTimeMillis());
		noteDao.update(note);//更新
		//todo如果笔记分享,更新分享表信息
		result.setStatus(0);
		result.setMsg("更新笔记成功");
		
		return result;
	}

	public NoteResult recycleNote(String noteId) {
		noteDao.updateStatus(noteId);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("删除笔记成功");
		return result;
	}

	public NoteResult shareNote(String noteId) {
		NoteResult result = new NoteResult();
		//检查该笔记是否分享过
		Share has_share = shareDao.findByNoteId(noteId);
		if(has_share != null){
			result.setStatus(1);
			result.setMsg("已分享过");
			return result;
		}
		//未被分享,分享处理
		Note note = noteDao.findById(noteId);
		Share share = new Share();
		share.setCn_share_title(note.getCn_note_title());
		share.setCn_share_body(note.getCn_note_body());
		share.setCn_note_id(noteId);
		String shareId = NoteUtil.createId();
		share.setCn_share_id(shareId);
		shareDao.save(share);
		
		result.setData(0);
		result.setMsg("分享笔记成功");
		return result;
	}

	public NoteResult searchNote(String keyword){
		NoteResult result = new NoteResult();
		if(keyword != null&&!"".equals(keyword)){
			keyword = "%"+keyword+"%";
		}else{
			keyword = "%";
		}
		List<Map> list = shareDao.findLikeTitle(keyword);
		result.setStatus(0);
		result.setMsg("检索成功");
		result.setData(list);
		return result;
	}

}
