package com.example.drawing;
// 소스만 입력하고 Alt+Enter를 눌러서 import 문장을 자동으로 생성한다.

import android.graphics.Bitmap;
import android.graphics.Canvas;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private SingleTouchView drawView; //SingleTouchView 클래스의 객체 drawView 생성
    private ImageButton currPaint; //그림판 아래 색을 선택할 수 있는 이미지 버튼 변수 생성
    String current_Color; //현재 색의 값을 담는 String 변수 생성, 직전에 선택한 펜 색이 뭔지 저장하여 이후에 지우기를 진행하고 다시 그리기 버튼을 눌러도 이전에 선택한 펜 색으로 나오게 하기 위함.

    @Override
    protected void onCreate(Bundle savedInstanceState) { //Activity의 생명 주기에서 생성단계에 한 번 실행되는 메서드 (=main 함수 역할)
        super.onCreate(savedInstanceState);
        //생성하는데 시간이 오래 걸릴 수 있는 객체들은 onCreate 함수에서 바로 만들어줌.
        setContentView(R.layout.activity_main); //activity_main이라는 레이아웃을 전달하여 화면 정의
        drawView = (SingleTouchView) findViewById(R.id.drawing); //SingleTouchView 클래스의 아이디를 통해 찾아 drawView라는 변수에 할당
        LinearLayout paintLayout = (LinearLayout) findViewById(R.id.paint_colors); //색을 선택하는 객체들을 선형 레이아웃으로 설정
        currPaint = (ImageButton) paintLayout.getChildAt(0); //이미지 버튼을 통해 선택할 수 있는 그리기 색 선언

        //새로운 그림판 생성하는 버튼
        findViewById(R.id.new_pic).setOnClickListener(new View.OnClickListener() { //새노트로 초기화
            @Override
            public void onClick(View v) {
                drawView.clear(); //그림판 안에 있는 값들은 모두 삭제 (=clear())
            }
        });

        //그리기 버튼
        findViewById(R.id.brush).setOnClickListener(new View.OnClickListener() {
            @Override
            //버튼을 눌렀을 떄 그 직전에 선택했던 펜 색으로 나오게 하면서 그려짐
            public void onClick(View v) {
                drawView.setColor(current_Color);
            }
        });

        //지우개 버튼
        findViewById(R.id.eraser).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String color = v.getTag().toString(); //지우개 버튼에 관련된 xml파일의 tag값은 흰색으로 설정
                drawView.setColor(color); //그 색으로 지정해서 drawView에 그려지도록 함.
            }
        });

        //저장하기 버튼
        findViewById(R.id.save_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveImageToStorage(); //저장기능을 수행하는 메서드 실행
            }
        });
    }

    //펜 색 지정
    public void clicked(View view) {

        if (view != currPaint) { //선택되어있는 펜의 색이 현재 내가 선택한 펜의 색과 다르다면
            String color = view.getTag().toString(); //선택한 펜의 색을 설정하기 위해 imageButton에 해당되는 tag값(색 지정값)을 가져와서 setColor로 바꿈
            drawView.setColor(color);
            currPaint = (ImageButton) view;
            current_Color = view.getTag().toString(); //선택한 펜의 색을 current_Color 변수에 넣어 다른 기능을 사용한 후에도 똑같은 색이 나오도록 하기 위해 할당함.
        }
    }

    //펜 크기 지정
    public void size_clicked(View view) {


            String size = view.getTag().toString();
            float f=Float.parseFloat(size); //색과 다르게 펜의 크기를 설정하는 값은 Float형으로 String이 아닌 float 형으로 바꿔준다.
            drawView.setSize(f); //setSize함수를 사용해 펜의 크기를 바꿔줌.
//            currPaint = (ImageButton) view;


    }







    // 갤러리에 현재 캔버스 저장
    public void saveImageToStorage(){
        View imageView = (View) drawView;
        imageView.setDrawingCacheEnabled(true);
        Bitmap bitmap = imageView.getDrawingCache();
        SimpleDateFormat mFormat=new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        MediaStore.Images.Media.insertImage(this.getContentResolver(), bitmap, mFormat.format(new Date()), "image_from_myDraw");
    }
}

