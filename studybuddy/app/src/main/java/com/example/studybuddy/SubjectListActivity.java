package com.example.studybuddy;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.List;

public class SubjectListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_list);

        RecyclerView rv = findViewById(R.id.rv_subjects);
        List<String> mySubjects = Arrays.asList("Mobile Dev", "Data Structures", "Networking", "Ethics");

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new SubjectAdapter(mySubjects));
    }
}