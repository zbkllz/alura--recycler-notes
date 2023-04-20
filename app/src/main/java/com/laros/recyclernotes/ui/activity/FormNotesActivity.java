package com.laros.recyclernotes.ui.activity;

import static com.laros.recyclernotes.utils.Constants.NOTE_KEY;
import static com.laros.recyclernotes.utils.Constants.OUTPUT_CODE_CREATED_NOTE;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.laros.recyclernotes.R;
import com.laros.recyclernotes.dao.NoteDAO;
import com.laros.recyclernotes.model.Note;

public class FormNotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_notes);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_form_save_note, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (isSavingNote(item)) {
            Note createdNote = createOneNote();
            returnNote(createdNote);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void returnNote(Note note) {
        Intent resultInsertion = new Intent();
        resultInsertion.putExtra(NOTE_KEY, note);
        setResult(OUTPUT_CODE_CREATED_NOTE, resultInsertion);
    }

    @NonNull
    private Note createOneNote() {
        EditText title = findViewById(R.id.et_form_notes_title);
        EditText description = findViewById(R.id.et_form_notes_description);
        return new Note(title.getText().toString(), description.getText().toString());
    }

    private boolean isSavingNote(MenuItem item) {
        return item.getItemId() == R.id.menu_form_note_ic_save;
    }
}