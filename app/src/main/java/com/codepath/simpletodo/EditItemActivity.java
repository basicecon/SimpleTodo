package com.codepath.simpletodo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    private static final String TAG = "EditItemActivity";

    final static String L_TASK_INDEX = "TASK_IDX";
    final static String L_TASK_NAME = "TASK_NAME";

    String taskIndex;

    EditText etEditItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        String taskname = getIntent().getStringExtra(EditItemActivity.L_TASK_NAME);
        taskIndex = getIntent().getStringExtra(EditItemActivity.L_TASK_INDEX);

        etEditItem = (EditText)findViewById(R.id.etEditItem);
        etEditItem.setText(taskname);
    }

    public void onSaveItem(View view) {
        String itemText = etEditItem.getText().toString();
        Intent returnIntent = new Intent();
        returnIntent.putExtra(EditItemActivity.L_TASK_INDEX, taskIndex);
        returnIntent.putExtra(EditItemActivity.L_TASK_NAME, itemText);

        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }
}
