package org.tarena.note.dao;

import java.util.List;
import java.util.Map;

import org.tarena.note.entity.Share;

public interface ShareDao {
	public void save(Share share);
	public Share findByNoteId(String noteId);
	public List<Map> findLikeTitle(String keyword);
	public Share findById(String shareId);
}
