package com.example.pimpakarnw.jsonexample;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //listView1
        final ListView listView1 = (ListView)findViewById(R.id.listView1);

        String strJSON = "[{\"MemberID\":\"1\",\"Name\":\"Weerachai\",\"Tel\":\"0812365986\"}" +
                        ",{\"MemberID\":\"2\",\"Name\":\"Win\",\"Tel\":\"029434971\"}" +
                        ",{\"MemberID\":\"3\",\"Name\":\"Tao\",\"Tel\":\"0915526545\"}]";

        try {
            JSONArray data = new JSONArray(strJSON);

            ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
            HashMap<String,String> map;

            for(int i = 0; i < data.length(); i++){
                JSONObject jsonObject = data.getJSONObject(i);

                map = new HashMap<String,String>();
                map.put("MemberID", jsonObject.getString("MemberID"));
                map.put("Name", jsonObject.getString("Name"));
                map.put("Tel", jsonObject.getString("Tel"));
                MyArrList.add(map);
            }

            SimpleAdapter simpleAdapter;
            simpleAdapter = new SimpleAdapter(MainActivity.this, MyArrList, R.layout.activity_column,
                    new String[]{"MemberID", "Name", "Tel"}, new int[]{R.id.ColMemberID,
                    R.id.ColName, R.id.ColTel});

            listView1.setAdapter(simpleAdapter);

        }catch (JSONException e)
        {
            e.printStackTrace();
        }

        /*Test*/
        System.out.println("TAO");
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main,menu);
        return super.onCreateOptionsMenu(menu);
    }*/
}
