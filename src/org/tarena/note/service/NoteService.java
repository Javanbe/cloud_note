package org.tarena.note.service;

import org.tarena.note.entity.NoteResult;

public interface NoteService {
	public NoteResult loadNotes(String bookId);
}
