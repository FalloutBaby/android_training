package com.bbocelot.studentlist;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class StudentListActivity extends AppCompatActivity {
    private List<Student> students;
    private StudentAdapter studentAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        students = generateStudentsList();
        setContentView(R.layout.activity_student_list);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.activity_student_list__rv_students);
        studentAdapter = new StudentAdapter(students,this::onStudentClick);
        recyclerView.setAdapter(studentAdapter);
        LinearLayoutManager sLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(sLayoutManager);
    }

    private void onStudentClick(Student student) {
        EditText editTextName = findViewById(R.id.detailed_student__tv_name);
        EditText editTextSurname = findViewById(R.id.detailed_student__tv_surname);
        CheckBox checkBox = findViewById(R.id.detailed_student__tv_sex);
        ImageView avatar = findViewById(R.id.detailed_student__iv_avatar);
        editTextName.setText(student.name);
        editTextSurname.setText(student.surname);
        checkBox.setChecked(student.sex);
        avatar.setImageResource(student.avatar);
//        Toast.makeText(StudentListActivity.this, student.name+student.surname, Toast.LENGTH_SHORT).show();
    }

    private List<Student> generateStudentsList() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Мисс","Марпл",false, R.drawable.siesta_the_cat));
        students.add(new Student("Эркюль","Пуаро",true, R.drawable.silver_the_cat));
        students.add(new Student("Жюль","Мегре",true, R.drawable.silver_the_cat));
        return students;
    }
}
