package org.tarena.note.service;

import org.tarena.note.entity.NoteResult;

public interface NoteService {
	public NoteResult loadNotes(String bookId);
	public NoteResult addNote(String noteTitle,String bookId,String userId);
	public NoteResult loadNote(String noteId);
	public NoteResult updateNote(String noteId,String noteTitle,String noteBody);
	public NoteResult recycleNote(String noteId);
	public NoteResult shareNote(String noteId);
	public NoteResult searchNote(String keyword);
	public NoteResult loadShare(String shareId);
}
