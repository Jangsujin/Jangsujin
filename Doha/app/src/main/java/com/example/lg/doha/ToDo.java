package com.example.lg.doha;
// http://sharp57dev.tistory.com/11 참고자료!

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class ToDo extends AppCompatActivity {

    private List<String> list; // 데이터 넣은 리스트
    private ListView listView; // 검색을 보여줄 리스트뷰
    private EditText editSearch;
    private ArrayAdapter adapter;
    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do);

        editSearch = (EditText) findViewById(R.id.search);
        listView = (ListView) findViewById(R.id.listView);
        list = new ArrayList<String>();

        list.add("hello");
        list.add("hi");
        //데이터 미리 저장시키는 메소드를 만들자.

        arrayList = new ArrayList<String>();
        arrayList.addAll(list); // arrayList에 list에 있는거 모두 저장.

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String text = editSearch.getText().toString();
                search(text);
                // 검색어가 바뀔 때 마다 search() 실행
            }
        });

    }
    public void search(String charText){
        list.clear();
        if(charText.length()==0){
            list.addAll(arrayList);
        }
        else{
            for(int i=0;i<arrayList.size();i++){
                if(arrayList.get(i).contains(charText)){
                    list.add(arrayList.get(i));
                    // list 다시 만듦.
                }
            }
        }
        adapter.notifyDataSetChanged();
        // 바뀐 데이터 다시 보여줌. list 다시 보여주는 것임.

    }




}

