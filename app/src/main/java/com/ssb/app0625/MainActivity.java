package com.ssb.app0625;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    //리스트 뷰에 출력할 데이터
    List<Map<String,String>> list = new ArrayList<>();
    //리스트 뷰 출력을 위한 Adapter
    SimpleAdapter adapter;
    //화면에 출력할 ListView
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ListView에 출력할 데이터 만들기
        Map<String,String> map = new HashMap<>();
        map.put("nation","holland");
        map.put("player","베르캄프");
        list.add(map);

        map = new HashMap<>();
        map.put("nation","아르헨티나");
        map.put("player","마라도나");
        list.add(map);

        map = new HashMap<>();
        map.put("nation","대한민국");
        map.put("player","차범근");
        list.add(map);

        //adapter 만들기
        adapter = new SimpleAdapter(MainActivity.this,list,
                android.R.layout.simple_expandable_list_item_2,
                new String[]{"nation","player"},
                new int[]{android.R.id.text1,android.R.id.text2});

        //listView를 가져와서 연결하기
        listView = (ListView)findViewById(R.id.listview1);
        listView.setAdapter(adapter);

    }
}
