package com.laros.recyclernotes.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;

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
        RecyclerView notesList = findViewById(R.id.rc_notes_list);

        NoteDAO dao = new NoteDAO();
        for (int i = 1; i <= 100; i++) {
            dao.insert(new Note("First Note" + i,
                    "First Description" + i));
            List<Note> allNotes = dao.all();

            notesList.setAdapter(new NotesListAdapter());
        }
    }







}