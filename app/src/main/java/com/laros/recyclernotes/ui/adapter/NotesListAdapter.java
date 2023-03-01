package com.laros.recyclernotes.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.laros.recyclernotes.R;
import com.laros.recyclernotes.model.Note;

import java.util.List;

public class NotesListAdapter extends RecyclerView.Adapter<NotesListAdapter.NoteViewHolder> {
    private List<Note> notes;
    private Context context;

    public NotesListAdapter(Context context, List<Note> notes) {
        this.context = context;
        this.notes = notes;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View createdView = LayoutInflater.from(context)
                .inflate(R.layout.item_note, parent, false);
        return new NoteViewHolder(createdView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note note = notes.get(position);
        holder.attach(note);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class NoteViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final TextView description;

        public NoteViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_item_note_title);
            description = itemView.findViewById(R.id.tv_item_note_description);

        }

        public void attach(Note note) {
            title.setText(note.getTitle());
            description.setText(note.getDescription());
        }
    }


}
