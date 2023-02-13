package com.laros.recyclernotes.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.laros.recyclernotes.R;
import com.laros.recyclernotes.dao.NoteDAO;
import com.laros.recyclernotes.model.Note;

import java.util.List;

public class NotesListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);
        ListView notesList = findViewById(R.id.listView);

        NoteDAO dao = new NoteDAO();
        dao.insert(new Note("First Note",
                "First Description"));
        List<Note> allNotes = dao.all();
    }







}