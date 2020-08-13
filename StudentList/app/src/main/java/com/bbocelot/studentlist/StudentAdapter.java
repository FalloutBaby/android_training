package com.bbocelot.studentlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private final List<Student> students;
    private final Listener onStudentClickListener;

    public StudentAdapter(List<Student> students, Listener onStudentClickListener) {
        this.students = students;
        this.onStudentClickListener = onStudentClickListener;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.student, viewGroup, false);
        view.setOnClickListener(v -> onStudentClickListener.onStudentClick((Student) v.getTag()));
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder viewHolder, int i) {
        Student student = students.get(i);
        viewHolder.bind(student);
        viewHolder.itemView.setTag(student);
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    static final class StudentViewHolder extends RecyclerView.ViewHolder {
        private final TextView nameTextView;
        private final TextView surnameTextView;
        private final TextView sexTextView;
        private final ImageView avatarImageView;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.student__tv_name);
            surnameTextView = itemView.findViewById(R.id.student__tv_surname);
            sexTextView = itemView.findViewById(R.id.student__tv_sex);
            avatarImageView = itemView.findViewById(R.id.student__iv_avatar);
        }

        private void bind(@NonNull Student student) {
            nameTextView.setText(student.name);
            surnameTextView.setText(student.surname);
            sexTextView.setText(student.sex ? "м" : "ж");
            avatarImageView.setImageResource(student.avatar);
        }
    }

    interface Listener {

        void onStudentClick(Student student);
    }
}
