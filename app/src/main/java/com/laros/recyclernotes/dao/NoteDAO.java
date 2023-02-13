package com.laros.recyclernotes.dao;

import com.laros.recyclernotes.model.Note;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NoteDAO {
    private final static ArrayList<Note> notes = new ArrayList <>();

    public List<Note> all(){

        return (List<Note>) notes.clone();
    }

    public void insert(Note... notes) {

        NoteDAO.notes.addAll(Arrays.asList(notes));
    }

    public void modify(int position, Note note){

        notes.set(position, note);
    }

    public void remove(int position){

        notes.remove(position);
    }
    public void shift(int positionBeginning, int positionEnd){
        Collections.swap(notes,positionBeginning,positionEnd);
    }
    public void removeAll(){

        notes.clear();
    }
}
