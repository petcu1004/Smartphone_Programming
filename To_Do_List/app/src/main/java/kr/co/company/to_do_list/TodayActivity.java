package kr.co.company.to_do_list;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.text.DateFormat;
import java.util.Date;

public class TodayActivity extends AppCompatActivity{

//    BackgroundThread backgroundThread;
    TextView myText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today);

        myText = findViewById(R.id.mytext);
    }
//
//    private final MyHandler mHandler = new MyHandler(this);
//
//    private static class MyHandler extends Handler {
//        private final WeakReference<TodayActivity> mActivity;
//        public MyHandler(TodayActivity activity) {
//            mActivity = new WeakReference<TodayActivity>(activity);
//        }
//
//        @Override
//        public void handleMessage(Message msg){
//            TodayActivity activity = mActivity.get();
//            if (activity != null){
//
//                activity.handleMessage(msg);
//            }
//        }
//    }
//
//    public void handleMessage(Message msg) {
//        myText.setText(DateFormat.getDateTimeInstance().format(new Date()));
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        backgroundThread = new BackgroundThread();
//        backgroundThread.setRunning(true);
//        backgroundThread.start();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//
//        boolean retry = true;
//        backgroundThread.setRunning(false);
//
//        while(retry){
//            try{
//                backgroundThread.join();
//                retry = false;
//            } catch (InterruptedException e){
//                e.printStackTrace();
//            }
//        }
//        Toast.makeText(this, "onStop()", Toast.LENGTH_SHORT).show();
//    }
//
//    public class BackgroundThread extends Thread{
//        boolean running = false;
//        void setRunning(boolean b) {
//            running = b;
//        }
//
//        @Override
//        public void run(){
//            while (running){
//                try {
//                    sleep(1000);
//                } catch (InterruptedException e){
//                    e.printStackTrace();
//                }
//                mHandler.sendMessage(mHandler.obtainMessage());
//            }
//        }
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.today_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId())
        {
            case R.id.today_search:
                Toast.makeText(getApplicationContext(), "Search Action", Toast.LENGTH_LONG).show();
                return true;

            case R.id.today_add:
//                Toast.makeText(getApplicationContext(), "Add Action", Toast.LENGTH_LONG).show();
                final Dialog addlistDialog= new Dialog(this);
                addlistDialog.setContentView(R.layout.activity_add);
                addlistDialog.setTitle("할일 추가");


                addlistDialog.show();

                return true;

            default:

        }
        return super.onOptionsItemSelected(item);
    }

}