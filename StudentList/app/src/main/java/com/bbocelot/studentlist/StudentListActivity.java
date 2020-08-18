package com.bbocelot.studentlist;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.function.Predicate;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

public class StudentListActivity extends AppCompatActivity {
    private List<Student> students;
    private StudentAdapter studentAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        students = generateStudentsList();
        setContentView(R.layout.activity_student_list);
        setupRecyclerView();
        setupAllStudentButtons();
    }

    private void setupAllStudentButtons() {
        Button newStudentButton = findViewById(R.id.new_student__button);
        newStudentButton.setOnClickListener(v -> this.onNewClick());
        Button addStudentButton = findViewById(R.id.add_student__button);
        addStudentButton.setOnClickListener(v -> this.onAddClick());
        Button delStudentButton = findViewById(R.id.del_student__button);
        delStudentButton.setOnClickListener(v -> this.onDelClick());
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.activity_student_list__rv_students);
        studentAdapter = new StudentAdapter(students, this::onStudentClick);
        recyclerView.setAdapter(studentAdapter);
        LinearLayoutManager sLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(sLayoutManager);
    }

    private void onStudentClick(Student student) {
        ConstraintLayout studentLayout = findViewById(R.id.student__layout);
        EditText editTextName = findViewById(R.id.detailed_student__tv_name);
        EditText editTextSurname = findViewById(R.id.detailed_student__tv_surname);
        CheckBox checkBox = findViewById(R.id.detailed_student__tv_sex);
        ImageView avatar = findViewById(R.id.detailed_student__iv_avatar);
        editTextName.setText(student.name);
        editTextSurname.setText(student.surname);
        checkBox.setChecked(student.sex);
        avatar.setImageResource(student.avatar);
    }

    private void onNewClick() {
        EditText editTextName = findViewById(R.id.detailed_student__tv_name);
        EditText editTextSurname = findViewById(R.id.detailed_student__tv_surname);
        CheckBox checkBox = findViewById(R.id.detailed_student__tv_sex);
        ImageView avatar = findViewById(R.id.detailed_student__iv_avatar);
        editTextName.setText("");
        editTextSurname.setText("");
        checkBox.setChecked(false);
        avatar.setImageResource(R.drawable.anonym_cat);
    }

    private void onAddClick() {
        students.add(generateNewStudent());
        studentAdapter.notifyDataSetChanged();
    }

    private void onDelClick() {
        EditText editTextName = findViewById(R.id.detailed_student__tv_name);
        EditText editTextSurname = findViewById(R.id.detailed_student__tv_surname);
        CheckBox checkBox = findViewById(R.id.detailed_student__tv_sex);
        String name = editTextName.getText().toString();
        String surname = editTextSurname.getText().toString();
        boolean sex = checkBox.isChecked();
        Student student = new Student(name, surname, sex, null);
        int idx = 100;
        for (int i = 0; i < this.students.size(); i++) {
            if (this.students.get(i).name.equals(name)) {
                Toast.makeText(StudentListActivity.this, "Студент удалён!", Toast.LENGTH_LONG).show();
                idx = i;
                break;
               }
        }
        students.remove(idx);
        studentAdapter.notifyDataSetChanged();
    }

    private Student generateNewStudent() {
        EditText editTextName = findViewById(R.id.detailed_student__tv_name);
        EditText editTextSurname = findViewById(R.id.detailed_student__tv_surname);
        CheckBox checkBox = findViewById(R.id.detailed_student__tv_sex);

        Student student = new Student(editTextName.getText().toString(), editTextSurname.getText().toString(), checkBox.isChecked(), null);
        Toast.makeText(StudentListActivity.this, "Студент " + student.name + " " + student.surname + " добавлен", Toast.LENGTH_SHORT).show();
        return student;

    }

    private List<Student> generateStudentsList() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Fake", "Person", false, null));
        students.add(new Student("Мисс", "Марпл", false, null));
        students.add(new Student("Эркюль", "Пуаро", true, null));
        students.add(new Student("Жюль", "Мегре", true, null));
        return students;
    }
}
