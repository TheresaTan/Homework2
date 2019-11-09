package com.cpsc41102.homework2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;

import com.cpsc41102.homework2.adapter.SummaryLVAdapter;
import com.cpsc41102.homework2.model.Student;
import com.cpsc41102.homework2.model.StudentDB;

import java.util.ArrayList;


public class SummaryLVActivity extends Activity {

    protected ListView mSummaryView;
    protected Menu detailMenu;
    protected Button btn;
    protected final String TAG = "Summary Screen";
    protected SummaryLVAdapter ad;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.student_summary);
        //
        createStudentObjects();
        mSummaryView = findViewById(R.id.student_summary_list_view_id);
        ad = new SummaryLVAdapter();
        mSummaryView.setAdapter(ad);

        btn = (Button)findViewById(R.id.add_student_button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SummaryLVActivity.this, StudentDetailActivity.class));
            }
        });

    }

    protected void createStudentObjects(){
        Student student = new Student("Theresa", "Tanubrata", "123456789");
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(student);


        student = new Student("Marie","Bae","234567891");
        studentList.add(student);

        student = new Student("Joann","Fu","987654321");
        studentList.add(student);

        //
        StudentDB.getInstance().setStudent(studentList);

    }
    @Override
    protected void onStart() {
        Log.d(TAG, "onStart() called ");
        ad.notifyDataSetChanged();
        super.onStart();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause() called ");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop() called");
        super.onStop();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume() called");
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy() called");
        super.onDestroy();
    }
}
