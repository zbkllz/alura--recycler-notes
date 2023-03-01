package com.laros.recyclernotes.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.laros.recyclernotes.R;
import com.laros.recyclernotes.dao.NoteDAO;
import com.laros.recyclernotes.model.Note;
import com.laros.recyclernotes.ui.adapter.NotesListAdapter;

import java.util.List;

public class NotesListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);

        TextView btnInsertNote = findViewById(R.id.tv_notes_list_insert_note);
        btnInsertNote.setOnClickListener(v -> {
            Intent initFormNotes = new Intent( NotesListActivity.this, FormNotesActivity.class);
            startActivity(initFormNotes);
        });

        List<Note> allNotes = templateNotes();

    }

    @Override
    protected void onResume() {
        NoteDAO dao = new NoteDAO();
        List<Note> allNotes = dao.all();
        configRecyclerView(allNotes);
        super.onResume();
    }

    private List<Note> templateNotes() {
        NoteDAO dao = new NoteDAO();
        for (int i = 1; i <= 10000; i++) {
            dao.insert(new Note("First Note" + i,
                    "First Description" + i));
        }
        return dao.all();
    }

    private void configRecyclerView(List<Note> allNotes) {
        RecyclerView notesList = findViewById(R.id.rc_notes_list);
        configAdapter(allNotes, notesList);
    }

    private void configAdapter(List<Note> allNotes, RecyclerView notesList) {
        notesList.setAdapter(new NotesListAdapter(this, allNotes));
    }


}