package com.cpsc41102.homework2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.cpsc41102.homework2.model.CourseEnrollment;
import com.cpsc41102.homework2.model.Student;
import com.cpsc41102.homework2.model.StudentDB;

import java.util.ArrayList;

public class StudentDetailActivity extends AppCompatActivity {
    protected Menu detailMenu;
    protected final String TAG = "Detail Screen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_student_detail);


        Button btn = (Button) findViewById(R.id.add_course_button_id);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout nameView = (LinearLayout) findViewById(R.id.add_course_line);
                LinearLayout pageView = new LinearLayout(StudentDetailActivity.this);
                pageView.setOrientation(LinearLayout.HORIZONTAL);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                params.setMargins(1, 1, 1, 1);
                nameView.setBackgroundColor(Color.BLACK);

                EditText courseView = new EditText(StudentDetailActivity.this);

                courseView.setBackgroundColor(Color.WHITE);
                courseView.setWidth(328);
                courseView.setLayoutParams(params);
                courseView.setGravity(Gravity.CENTER_HORIZONTAL);
                pageView.addView(courseView);


                EditText gradeView = new EditText(StudentDetailActivity.this);

                gradeView.setBackgroundColor(Color.WHITE);
                gradeView.setWidth(328);
                gradeView.setLayoutParams(params);
                gradeView.setGravity(Gravity.CENTER_HORIZONTAL);
                pageView.addView(gradeView);

                nameView.addView(pageView);
                nameView.invalidate();

            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_screen_menu,menu);
        detailMenu = menu;
        menu.findItem(R.id.action_done).setVisible(true);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.action_done){
            EditText fNameView = findViewById(R.id.first_name_val_id);
            EditText lNameView = findViewById(R.id.last_name_val_id);
            EditText cwidView = findViewById(R.id.cwid_val_id);

            ArrayList<Student> sList = StudentDB.getInstance().getStudent();
            Student sObj = new Student();
            sObj.setFirstName(fNameView.getText().toString());
            sObj.setLastName(lNameView.getText().toString());
            sObj.setCWID(cwidView.getText().toString());

            ArrayList<CourseEnrollment> cList = new ArrayList<>();

            //go through each child/cell of the course table
            LinearLayout llView = findViewById(R.id.add_course_line);
            int count = llView.getChildCount();
            for(int i=0; i< count; i++){
               View view = llView.getChildAt(i);
                LinearLayout row = (LinearLayout) view;
                int counter = row.getChildCount();

                String courseId, grade;
                CourseEnrollment course = new CourseEnrollment();
                Log.d("CHILD", "onOptionsItemSelected: " + i);
                for(int j=0; j<counter; j++){
                    View v = row.getChildAt(j);
                    Log.d("CHILD", "onOptionsItemSelected: " + j);
                    EditText editText = (EditText)v;
                    Log.d("EDITTEXT CHILD", editText.getText().toString());
                    if(j == 0){
                        courseId = editText.getText().toString();
                        course.setCourseID(courseId);
                    }else{
                        grade = editText.getText().toString();
                        course.setGrade(grade);
                    }
                    editText.setEnabled(false);
                }
                cList.add(course);

            }

            sObj.setCourses(cList);

            fNameView.setEnabled(false);
            lNameView.setEnabled(false);
            cwidView.setEnabled(false);
            sList.add(sObj);


            StudentDB.getInstance().setStudent(sList);
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart() called ");
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
