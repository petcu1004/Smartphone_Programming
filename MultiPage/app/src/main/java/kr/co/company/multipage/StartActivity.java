package kr.co.company.multipage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;

public class StartActivity extends AppCompatActivity { //시작 페이지

    private Chronometer chronometer; //스톱워치 시간을 보여줌
    private boolean running;
    private long pauseOffset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        ImageButton b= (ImageButton)findViewById(R.id.imageButton1); //뒤로 가는 Back 버튼은 ImageButton을 사용함.
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();//이벤트 리스너에서는 버튼이 클릭되면 finish() 메소드를 호출하여서 현재의 액티비티를 종료한다.
            }
        });

        chronometer = findViewById(R.id.chronometer2);
        chronometer.setFormat("%s"); //형식 문자열 지정, 첫번째 "%s"가 현재 타이머 값으로 대체됨.

        Button startBtn=findViewById(R.id.start1_btn); //시작 버튼
        Button stopBtn=findViewById(R.id.stop_btn); //정지 버튼
        Button resetBtn=findViewById(R.id.reset_btn); //초기화 버튼

       startBtn.setOnClickListener(new View.OnClickListener(){ //시작 버튼을 눌렀을 경우 발생
            @Override
            public void onClick(View v) {
                if(!running){
                    //elapsedRealtime() : 시스템이 부팅된 이후 경과된 시간을 반환(+절전 모드에서 지속)
                    chronometer.setBase(SystemClock.elapsedRealtime()-pauseOffset);
                    chronometer.start(); //카운트 시작
                    running=true;
                }
            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener() { //정지 버튼을 눌렀을 경우 발생
            @Override
            public void onClick(View v) {
                if(running){
                    chronometer.stop(); //카운트 중단
                    //getBase() : 설정된 기준 시간 반환
                    pauseOffset=SystemClock.elapsedRealtime()-chronometer.getBase();
                    running=false;
                }
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() { //초기화 버튼을 눌렀을 경우 발생
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime()); //setBase() : 기준 시간 설정
                pauseOffset=0;
                chronometer.stop(); //카운트 중단
                running=false;
            }
        });
    }
}