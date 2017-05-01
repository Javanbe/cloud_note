package org.tarena.note.dao;

import java.util.List;
import java.util.Map;

public interface NoteDao {
	public List<Map> findByBookId(String bookId);
}
