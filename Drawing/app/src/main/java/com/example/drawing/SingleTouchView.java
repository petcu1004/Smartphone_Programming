package com.example.drawing;
// 소스만 입력하고 Alt+Enter를 눌러서 import 문장을 자동으로 생성한다.

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


public class SingleTouchView extends View {
    //View 클래스를 상속받은 SingleTouchView 클래스 선언
    //시간 걸리는 것은 미리 생성함 (Paint, Path객체)
    private Paint paint = new Paint();
    private Path path = new Path();
    private int paintColor = 0xFF000000; //검은색으로 설정
    private float paintSize=20f; //펜 사이즈는 20f 로 설정
    private Paint canvasPaint; //페인트 객체 생성
    private Canvas drawCanvas; //캔버스 객체 생성
    private Bitmap canvasBitmap; //비트맵 객체 생성

    public SingleTouchView(Context context, AttributeSet attrs) {
        //AttributeSet이 들어간 생성자가 무조건 있어야 함.
        super(context, attrs);

        paint.setAntiAlias(true);
        paint.setStrokeWidth(paintSize); //펜의 크기
        paint.setColor(paintColor);
        paint.setStyle(Paint.Style.STROKE); //채울 건 없지만 Stroke 방식으로 설정
        paint.setStrokeJoin(Paint.Join.ROUND); //선들이 만날 때는 Round 방식으로 설정
    }

    @Override
    //화면의 사이즈가 변하거나, 초기 액티비티가 생성될 떄 호출
    //onDraw가 호출되기 전에 높이와 너비를 알아야 할 때는 뷰의 크기를 조사해 그에 알맞게 그리기를 해야할 경우가 있음
    //이때 onSizeChanged 메서드를 재정의하면 된다. onDraw 보다도 먼저 호출됨.
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //비트맵을 save할 때 필요함.
        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);//비트맵 객체 생성
        drawCanvas = new Canvas(canvasBitmap); //캔버스 객체 생성(캔버스를 비트맵에 붙임)
        canvasPaint = new Paint(Paint.DITHER_FLAG);

    }

    @Override
    //View가 다시 그려져야 할 때 호출
    protected void onDraw(Canvas canvas) { //화면에 그림을 그리는 메서드
        canvas.drawBitmap(canvasBitmap, 0, 0, canvasPaint); //비트맵에 그려진걸 그대로 0, 0에 그린다는 것
        canvas.drawPath(path, paint); //새로운 path에 있는 경로를 paint에 다시 그리는 것
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //터치되는 좌표는 event 객체를 통해 넘어옴
        float touchX = event.getX(); //터치 x좌표를 가져옴
        float touchY = event.getY(); //터치 y좌표를 가져옴
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: //손가락을 내리면서 터치했을 경우
                //moveTo : 패스의 시작점을 가짐
                path.moveTo(touchX, touchY); //path라는 객체에 moveTo라는 메서드를 실행시킴
                break;
            case MotionEvent.ACTION_MOVE: //손가락을 화면에 대면서 움직인 경우
                //lineTo : 패스에 직선을 추가
                path.lineTo(touchX, touchY); //path라는 객체에 lineTo라는 메서드 실행시킴
                break;
            case MotionEvent.ACTION_UP: //손가락을 화면에서 떼었을 경우
                drawCanvas.drawPath(path, paint); //drawCanvas에 지금까지 그려진 path를 paint에 그려줌
                path.reset(); //path를 reset하여 path 객체에 있던 명령어들은 모두 지워짐.
                break;
            default:
                return false;
        }
        invalidate(); //다시 그리게 하는 메서드 -> onDraw()메서드가 다시 실행된다.
        return true;

    }

    public void setColor(String newColor) { //펜의 색 다시 설정하기
        invalidate(); //다시 그리기
        paintColor = Color.parseColor(newColor); //객체에 지정된 색의 문자열을 parseColor를 통해 색을 지정
        paint.setColor(paintColor);
    }

    public void setSize(float newSize) { //펜의 사이즈 다시 설정하기
        invalidate();//다시 그리기
        paint.setStrokeWidth(newSize); //새로운 펜 사이즈로 설정해줌.
    }

    public void clear() { //새로운 그림판으로 생성되도록 할 때 실행되는 함수
        drawCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR); //canvas 리셋하기
        invalidate(); //다시 그리기
    }


}
