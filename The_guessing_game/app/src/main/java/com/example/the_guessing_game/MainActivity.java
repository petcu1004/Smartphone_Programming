package com.example.the_guessing_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText eText; //추측한 값을 넣는 컴포넌트
    Button btn; //GUESS 버튼
    Button btn1; //RESTART 버튼
    TextView textView; //추측한 값이 정답에 비해 낮은지, 높은지 아니면 정답인지 확인할 수 있는 컴포넌트
    TextView textView2; //정답 보여주는 컴포넌트 (사실 없어야하는데 잘 되는지 확인 차 넣어놓음)
    String str; //추측한 값이 정답에 비해 낮은지, 높은지 아니면 정답인지 메시지로 알려주는 문자열 변수

    int cnt=0; //몇 번 틀렸는지 세는 정수형 변수

    Random random=new Random(); //매 게임마자 랜덤한 정답 값을 사용하기 위해 사용
    int num=random.nextInt(100)+1; //1~100까지의 랜덤한 값을 정수형 변수 num에 할당

    @Override
    //콜백 메소드이며, Activity의 생명 주기에서 생성 단계에 한 번 실행되는 메소드
    protected void onCreate(Bundle savedInstanceState) { //savedInstanceState라는 파라미터를 수신하며 이 파라미터는 Activity의 이전 상태를 저장한 Bundle 객체
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //activity_main라는 레이아웃을 전달하여 화면의 정의한다.

        //이벤트 처리가 가능한 메소드를 지원받기 위해 View의 id를 R클래스에서 받아옴
        eText=(EditText) findViewById(R.id.editTextNumber); //숫자만 넣을 것이기 때문에 editTextNumber을 사용하였다.
        btn=(Button) findViewById(R.id.button);
        btn1=(Button) findViewById(R.id.button2);
        textView=(TextView) findViewById(R.id.textView);
        textView2=(TextView) findViewById(R.id.textView2);

        //버튼 클릭 이벤트를 처리
        //익명 클래스
        btn.setOnClickListener(new View.OnClickListener(){  //GUESS 버튼을 클릭하면 아래 코드 실행
            public void onClick(View v){
                str=eText.getText().toString(); //내가 입력한 값을 가져와서 str 변수에 할당
                textView2.setText(Integer.toString(num)); //정답 보여주는 칸에 정답 값 설정

                if(Integer.parseInt(str)==num){ //정답인 경우
                    textView.setText("You are Correct!");
                    textView.setTextColor(Color.parseColor("#0000ff"));
                    Toast.makeText(getApplicationContext(), cnt+"번 만에 맞췄습니다", Toast.LENGTH_SHORT).show();
                }
                else if (Integer.parseInt(str)>num){ //정답에 비해 추측한(입력한)값이 큰 경우
                    textView.setText("Down!");
                    textView.setTextColor(Color.parseColor("#ffa500"));
                    cnt++;
                }
                else if (Integer.parseInt(str)<num){//정답에 비해 추측한(입력한)값이 작은 경우
                    textView.setText("UP!");
                    textView.setTextColor(Color.parseColor("#6a5acd"));
                    cnt++;
                }
            }
        });
        btn1.setOnClickListener(new View.OnClickListener(){ //RESTART 버튼을 클릭하면 아래 코드 실행
            public void onClick(View v){
                //창을 재시작하는 방법
//                finish();
//                Intent intent = new Intent(MainActivity.this, MainActivity.class);
//                startActivity(intent);
                num=random.nextInt(100)+1; //정답 랜덤하게 다시 생성
                cnt=0; //몇 번만에 맞췄는지 카운트 값도 0으로 초기화
                eText.setText(null); //숫자 입력하는 칸 초기화
                textView.setText("Result"); //결과 보여주는 메시지 초기화
                textView2.setText("answer"); //정답 보여주는 메시지 초기화
                textView.setTextColor(Color.parseColor("#000000")); //결과 보여주는 메시지 글씨 검정색 초기화
            }
        });
    }}