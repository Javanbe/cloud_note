package org.tarena.note.service;

import org.tarena.note.entity.NoteResult;

public interface NoteService {
	public NoteResult loadNotes(String bookId);
	public NoteResult addNote(String noteTitle,String bookId,String userId);
}
