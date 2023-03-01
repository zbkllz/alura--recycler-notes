package com.laros.recyclernotes.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

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
        getMenuInflater().inflate(R.menu.menu_form_save_note,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menu_form_note_ic_save) {
            EditText title = findViewById(R.id.et_form_notes_title);
            EditText description = findViewById(R.id.et_form_notes_description);
            Note createdNote = new Note(title.getText().toString(), description.getText().toString());
            new NoteDAO().insert(createdNote);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}