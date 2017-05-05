package org.tarena.note.dao;

import java.util.List;
import java.util.Map;

import org.tarena.note.entity.Note;

public interface NoteDao {
	public List<Map> findByBookId(String bookId);
	public void save(Note note);
	public Note findById(String noteId);
	public void update(Note note);
	public void updateStatus(String noteId);
}
