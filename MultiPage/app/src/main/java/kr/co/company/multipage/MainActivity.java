package kr.co.company.multipage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //소개 버튼
        Button b= (Button)findViewById(R.id.intro_btn); //소개 버튼 객체를 찾아 변수 b에 할당
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //버튼이 클릭되면 IntroActivity를 시작한다.
                // 명시적 Intent 사용함.
                //인텐트 객체 생성
                Intent intent = new Intent(MainActivity.this,IntroActivity.class); //인텐트 객체에 실행하고 싶은 액티비티의 클래스 이름인 IntroActivity를 지정한다.
                startActivity(intent); // intent 객체에 기술된 액티비티를 시작한다.
            }
        });

        //시작 버튼
        Button b1= (Button)findViewById(R.id.start_btn); //시작 버튼 객체를 찾아 변수 b1에 할당
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //버튼이 클릭되면 StartActivity를 시작한다.
                Intent intent = new Intent(MainActivity.this, StartActivity.class); //인텐트 객체에 실행하고 싶은 액티비티의 클래스 이름인 StartActivity를 지정한다.
                startActivity(intent);// intent 객체에 기술된 액티비티를 시작한다.
            }
        });

        //설정 버튼
        Button b2= (Button)findViewById(R.id.setting_btn); //설정 버튼 객체를 찾아 변수 b2에 할당
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //버튼이 클릭되면 SetupActivity를 시작한다.
                Intent intent = new Intent(MainActivity.this,SetupActivity.class); //인텐트 객체에 실행하고 싶은 액티비티의 클래스 이름인 SetupActivity를 지정한다.
                startActivity(intent); // intent 객체에 기술된 액티비티를 시작한다.
            }
        });

    }
}