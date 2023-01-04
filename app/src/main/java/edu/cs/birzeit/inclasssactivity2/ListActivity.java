package edu.cs.birzeit.inclasssactivity2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        ArrayAdapter<Book> listAdapter = new ArrayAdapter<Book>(this, android.R.layout.simple_list_item_1, Book.books);
        ListView listView = (ListView) findViewById(R.id.book_menu);
        listView.setAdapter(listAdapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListActivity.this,MainActivity.class);
                intent.putExtra("Bookid", (int)id);
                startActivity(intent);

            }
        };
        listView.setOnItemClickListener(itemClickListener);


    }
}
