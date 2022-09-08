package com.confidenceb.javanotetakingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoteRecyclerAdapter extends RecyclerView.Adapter<NoteRecyclerAdapter.ViewHolder> {

    private final Context myContext;
    private final LayoutInflater layoutInflater;
    private final List<NoteInfo> notesL;

    public NoteRecyclerAdapter(Context myContext, List<NoteInfo> notesL) {
        this.myContext = myContext;
        layoutInflater = LayoutInflater.from(myContext);
        this.notesL = notesL;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View noteView = layoutInflater.inflate(R.layout.notelist_items_design, parent, false);
        return new ViewHolder(noteView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NoteInfo note = notesL.get(position);
        holder.courseText.setText(note.getCourse().getTitle());
        holder.courseTitle.setText(note.getTitle());
    }

    @Override
    public int getItemCount() {
        return notesL.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public final TextView courseText;
        public final TextView courseTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            courseText = (TextView) itemView.findViewById(R.id.textCourse);
            courseTitle = (TextView) itemView.findViewById(R.id.noteTitle);
        }

    }
}
