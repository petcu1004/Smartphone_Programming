package kr.co.company.multipage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SetupActivity extends AppCompatActivity { //설정 페이지

    SeekBar seekBar;
    TextView outcome;
    public int number;

    CalendarView calendarView;
    TextView collect_day; //달력에서 선택한 날짜가 보이도록 함.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        ImageButton b= (ImageButton)findViewById(R.id.imageButton2); //뒤로 가는 Back 버튼은 ImageButton을 사용함.
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            } //이벤트 리스너에서는 버튼이 클릭되면 finish() 메소드를 호출하여서 현재의 액티비티를 종료한다.
        });

        seekBar=(SeekBar)findViewById(R.id.seekBar2); //경기 인원에 관련된 seekbar
        outcome=(TextView)findViewById(R.id.textView7); //경기 인원에 관련해서 seekbar 값이 보여짐.

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            //seekbar를 조작하고 있는 중
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                number=seekBar.getProgress();
            }

            @Override
            //seekbar를 처음 터치했을 떄
            public void onStartTrackingTouch(SeekBar seekBar) {
                number=seekBar.getProgress();
            }

            @Override
            //seekbar 터치가 끝났을 떄
            public void onStopTrackingTouch(SeekBar seekBar) {
                number=seekBar.getProgress();
                update();
            }
        });

        collect_day=findViewById(R.id.day); //선택한 날짜를 보여주는 부분
        calendarView=findViewById(R.id.calendarView); //달력

        //날짜 변환
        DateFormat formatter=new SimpleDateFormat("yyyy년MM월dd일");
        Date date= new Date(calendarView.getDate());
        collect_day.setText(formatter.format(date)); //처음 실행했을 경우 현재 날짜 가져오기
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            //달력의 아무 날짜를 선택했을 경우 선택한 날짜가 보여짐
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String day;
                day=year+"년 "+(month+1)+"월 "+dayOfMonth+"일";
                collect_day.setText(day);
            }
        });
    }

    //seek bar 터치를 끝낸 후 그에 해당하는 값이 보여짐.
    public void update(){
        outcome.setText(new StringBuilder().append(number));
    }
}