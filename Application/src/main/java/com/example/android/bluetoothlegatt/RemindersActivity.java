package com.example.android.bluetoothlegatt;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;

public class RemindersActivity extends AppCompatActivity {
    static ArrayList<String> notes = new ArrayList<>();
    static ArrayAdapter arrayAdapter;
    ListView lView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        if(item.getItemId() == R.id.add_note){
            Intent x = new Intent(getApplicationContext(), EditnoteActivity.class);
            startActivity(x);
            return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_reminder);
        lView = (ListView) findViewById(R.id.listView);
        lView.setLongClickable(true);

        //when we display content of list view, we need to check the contents of the listview (i.e. what was saved before) and display the content
        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("com.example.android.bluetoothlegatt", Context.MODE_PRIVATE);
        HashSet<String> set = (HashSet<String>) sharedPref.getStringSet("notes", null);

        if(set == null){
            notes.add("Sample Note");
        }
        else{
            notes = new ArrayList(set);//brings back all of the data from set that's been saved
        }


        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, notes);

        lView.setAdapter(arrayAdapter);

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent1 = new Intent(getApplicationContext(), EditnoteActivity.class);
                intent1.putExtra("noteId", i);
                startActivity(intent1);
            }
        });

        lView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int itemToDelete = i;
                new AlertDialog.Builder(RemindersActivity.this).setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Are you sure?")
                        .setMessage("Do you want to delete this note?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                arrayAdapter.notifyDataSetChanged();
                                notes.remove(itemToDelete);

                                SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("com.example.android.bluetoothlegatt", Context.MODE_PRIVATE);
                                HashSet<String> set1 = new HashSet<>(RemindersActivity.notes);
                                sharedPref.edit().putStringSet("notes", set1).apply();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
                return true;
            }
        });
    }


}
