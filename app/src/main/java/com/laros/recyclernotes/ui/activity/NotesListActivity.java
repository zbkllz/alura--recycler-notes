package com.laros.recyclernotes.ui.activity;

import static com.laros.recyclernotes.utils.Constants.CODE_REQUEST_INSERT_NOTE;
import static com.laros.recyclernotes.utils.Constants.NOTE_KEY;
import static com.laros.recyclernotes.utils.Constants.OUTPUT_CODE_CREATED_NOTE;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.laros.recyclernotes.R;
import com.laros.recyclernotes.dao.NoteDAO;
import com.laros.recyclernotes.model.Note;
import com.laros.recyclernotes.ui.recyclerview.adapter.NotesListAdapter;

import java.util.List;

public class NotesListActivity extends AppCompatActivity {

    private NotesListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);

        List<Note> allNotes = getAllNotes();
        configRecyclerView(allNotes);
        btnConfigInsertNote();

    }

    private void btnConfigInsertNote() {
        TextView btnInsertNote = findViewById(R.id.tv_notes_list_insert_note);
        btnInsertNote.setOnClickListener(v ->
                toFormActivity()
        );
    }

    private void toFormActivity() {
        Intent initFormNote = new Intent(NotesListActivity.this,
                FormNotesActivity.class);
        startActivityForResult(initFormNote, CODE_REQUEST_INSERT_NOTE);
    }

    private List<Note> getAllNotes() {
        NoteDAO dao = new NoteDAO();
        return dao.all();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (isReturningNote(requestCode, resultCode, data)) {
            Note noteReceived = (Note) data.getSerializableExtra(NOTE_KEY);
            add(noteReceived);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void add(Note note) {
        new NoteDAO().insert(note);
        adapter.insertNote(note);
    }

    private boolean isReturningNote(int requestCode, int resultCode, Intent data) {
        return isCodeRequestInsertNote(requestCode) &&
                isOutputCodeCreatedNote(resultCode) &&
                hasNote(data);
    }

    private boolean hasNote(Intent data) {
        return data.hasExtra(NOTE_KEY);
    }
    private boolean isOutputCodeCreatedNote(int resultCode) {
        return resultCode == OUTPUT_CODE_CREATED_NOTE;
    }

    private boolean isCodeRequestInsertNote(int requestCode) {
        return requestCode == CODE_REQUEST_INSERT_NOTE;
    }

    private void configRecyclerView(List<Note> allNotes) {
        RecyclerView notesList = findViewById(R.id.rc_notes_list);
        configAdapter(allNotes, notesList);
    }

    private void configAdapter(List<Note> allNotes, RecyclerView notesList) {
        adapter = new NotesListAdapter(this, allNotes);
        notesList.setAdapter(adapter);
    }


}