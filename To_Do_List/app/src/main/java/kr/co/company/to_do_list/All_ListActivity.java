package kr.co.company.to_do_list;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ListActivity extends AppCompatActivity {

    TodayActivity.DBHelper helper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        helper=new TodayActivity.DBHelper(this);
        db=helper.getWritableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM list", null);
        startManagingCursor(cursor);

        String[] from ={"title", "date"};

        int[] to={android.R.id.text1, android.R.id.text2};
        SimpleCursorAdapter adapter= new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor, from, to);
        ListView list =(ListView) findViewById(R.id.listview);
        list.setAdapter(adapter);



        ///////////////////리스트////////////////////

//        ListView listView=(ListView) findViewById(R.id.listview);
//        final ArrayList<String> list= new ArrayList<>();
//
//        for(int i=0;i<30;i++){
//            list.add("item "+i);
//        }
//
//        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                this,
//                android.R.layout.simple_list_item_activated_1, list);
//
//        listView.setAdapter(adapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                String selected_item=(String)adapterView.getItemAtPosition(position);
//                list.remove(selected_item);
//                adapter.notifyDataSetChanged();
//            }
//        });

    }
}