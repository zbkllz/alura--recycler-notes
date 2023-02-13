package com.laros.recyclernotes.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.laros.recyclernotes.R;
import com.laros.recyclernotes.model.Note;

import java.util.List;

public class NotesListAdapter extends BaseAdapter {
    private final List<Note> notes;
    private final Context context;

    public NotesListAdapter(Context context, List<Note> notes) {
        this.context = context;
        this.notes = notes;
    }


    @Override
    public int getCount() {
        return notes.size();
    }

    @Override
    public Object getItem(int position) {
        return notes.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View View, ViewGroup viewGroup) {
        View createdView = LayoutInflater.from(context).inflate(R.layout.item_note, viewGroup, false);
        Note note = notes.get(position);

        TextView title = createdView.findViewById(R.id.tv_item_note_title);
        title.setText(note.getTitle());

        TextView description = createdView.findViewById(R.id.tv_item_note_description);
        description.setText(note.getDescription());
        return createdView;
    }
}
