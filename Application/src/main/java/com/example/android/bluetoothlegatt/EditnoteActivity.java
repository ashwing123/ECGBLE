package com.example.android.bluetoothlegatt;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.HashSet;

public class EditnoteActivity extends Activity {
    int noteId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        EditText editText = (EditText) findViewById(R.id.editText);
        Intent intent1 = getIntent();
        noteId = intent1.getIntExtra("noteId", -1);
        if (noteId != -1){
            editText.setText(RemindersActivity.notes.get(noteId));
        }
        else {
            RemindersActivity.notes.add("");
            noteId = RemindersActivity.notes.size() - 1;
            RemindersActivity.arrayAdapter.notifyDataSetChanged();
        }
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                RemindersActivity.notes.set(noteId, String.valueOf(charSequence));
                RemindersActivity.arrayAdapter.notifyDataSetChanged();

                SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("com.example.android.bluetoothlegatt", Context.MODE_PRIVATE);
                HashSet<String> set1 = new HashSet<>(RemindersActivity.notes);
                sharedPref.edit().putStringSet("notes", set1).apply();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
