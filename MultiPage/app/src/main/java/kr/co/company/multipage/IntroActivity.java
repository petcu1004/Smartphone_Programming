package kr.co.company.multipage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class IntroActivity extends AppCompatActivity { //소개 페이지

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        ImageButton b= (ImageButton)findViewById(R.id.imageButton); //뒤로 가는 Back 버튼은 ImageButton을 사용함.
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            } //이벤트 리스너에서는 버튼이 클릭되면 finish() 메소드를 호출하여서 현재의 액티비티를 종료한다.
        });
    }
}