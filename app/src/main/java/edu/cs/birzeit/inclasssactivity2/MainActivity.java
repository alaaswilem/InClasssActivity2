package edu.cs.birzeit.inclasssactivity2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    public static final String BookT = "Book Title";
    public static final String AutherN = "Auther Name";
    public static final String Pages = "Pages";
    public static final String Available = "ava";

    private EditText edtBook;
    private EditText edtName;
    private EditText edtPages;
    private Switch swt;

    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();
        setupSharedPrefs();
        checkPrefs();
    }



    public void ADD(View view) {

        String book = edtBook.getText().toString();
        String pag = edtPages.getText().toString();
        String name = edtName.getText().toString();

        Intent intent = new Intent(this, ListActivity.class);
        intent.putExtra("data",book);
        intent.putExtra("data",pag);
        intent.putExtra("data",name);
        startActivity(intent);

    }



    public void SaveAll(View view) {
        String book = edtBook.getText().toString();
        String name = edtName.getText().toString();
        String page = edtPages.getText().toString();


        if(swt.isChecked()){
            editor.putString(BookT,book );
            editor.putString(AutherN ,name);
            editor.putString(Pages,page);

            editor.commit();
        }
    }

    private void setupViews() {
        edtName = findViewById(R.id.AutherN);
        edtPages = findViewById(R.id.Pages);
        edtBook = findViewById(R.id.BookT);
        swt = findViewById(R.id.ava);
    }


    private void setupSharedPrefs() {
        prefs= PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
    }

    private void checkPrefs() {
        Boolean ava = prefs.getBoolean(Available, false);

        if(ava){
            String book = prefs.getString(BookT,"");
            String name = prefs.getString(AutherN,"");
            String pages = prefs.getString(Pages,"");

            edtBook.setText(book);
            edtName.setText(name);
            edtPages.setText(pages);
            swt.setChecked(true);
        }
    }
}