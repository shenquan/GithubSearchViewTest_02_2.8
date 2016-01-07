package com.example.administrator.searchviewtest;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    private SearchView sv;
    private AutoCompleteTextView lv;
    private final String[] mStrings ={"aaaaa","bbbbbbb","ccccccccccc"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(AutoCompleteTextView)findViewById(R.id.lv);
        lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,mStrings));

//        lv.setTextFilterEnabled(true);
        sv=(SearchView)findViewById(R.id.sv);
        sv.setIconifiedByDefault(false);
        sv.setIconified(true);
        sv.setSubmitButtonEnabled(true);
        sv.setQueryHint("查找");
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this,"您的选择是："+query,Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
               /* if(TextUtils.isEmpty(newText)){
                    lv.clearTextFilter();
                }
                else{
                    lv.setFilterText(newText);
                }*/
                return true;
            }
        });

    }
}
