package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView input; //계산기의 버튼을 눌렀을 경우 실질적으로 연산이 수행되어 보여지는 컴포넌트
    private TextView record; //사용자가 누른 버튼으로 생성된 계산식을 보여주는 컴포넌트
    private double Value; //연산을 수행하기 위해 입력한 값을 담는 실수형 변수
    private char current_Operator; //연산자의 종류를 담는 변수

    @Override
    //Activity의 생명 주기에서 생성 단계에 한 번 실행되는 메소드
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //activity_main라는 레이아웃을 전달하면 화면 정의
        input = (TextView) findViewById(R.id.number); //연산 수행하여 결과값을 보여주는 것
        record = (TextView) findViewById(R.id.record); //연산식(과정)을 보여주는 것
    }

    public void onClick(View v){ //버튼 클릭 이벤트 처리
        String current=input.getText().toString(); //현재 누른 숫자 값
        String record_current=record.getText().toString(); //연산식

        switch (v.getId()){
            case R.id.n0: //숫자0버튼을 눌렀을 경우
                input.setText(current + "0"); //0의 값이 화면에 보여지도록 setText 사용
                record.setText(record_current + "0");
                break;
            case R.id.n00: //숫자 00버튼을 눌렀을 경우
                input.setText(current+"00"); //00의 값이 화면에 보여지도록 setText 사용
                record.setText(record_current+"00");
                break;
            case R.id.n1: //숫자 1버튼을 눌렀을 경우
                input.setText(current+"1"); //1의 값이 화면에 보여지도록 setText 사용
                record.setText(record_current+"1");
                break;
            case R.id.n2: //숫자 2버튼을 눌렀을 경우
                input.setText(current+"2"); //2의 값이 화면에 보여지도록 setText 사용
                record.setText(record_current+"2");
                break;
            case R.id.n3: //숫자 3버튼을 눌렀을 경우
                input.setText(current+"3"); //3의 값이 화면에 보여지도록 setText 사용
                record.setText(record_current+"3");
                break;
            case R.id.n4: //숫자 4버튼을 눌렀을 경우
                input.setText(current+"4"); //4의 값이 화면에 보여지도록 setText 사용
                record.setText(record_current+"4");
                break;
            case R.id.n5: //숫자 5버튼을 눌렀을 경우
                input.setText(current+"5"); //5의 값이 화면에 보여지도록 setText 사용
                record.setText(record_current+"5");
                break;
            case R.id.n6: //숫자 6버튼을 눌렀을 경우
                input.setText(current+"6"); //6의 값이 화면에 보여지도록 setText 사용
                record.setText(record_current+"6");
                break;
            case R.id.n7: //숫자 7버튼을 눌렀을 경우
                input.setText(current+"7"); //7의 값이 화면에 보여지도록 setText 사용
                record.setText(record_current+"7");
                break;
            case R.id.n8: //숫자 8버튼을 눌렀을 경우
                input.setText(current+"8"); //8의 값이 화면에 보여지도록 setText 사용
                record.setText(record_current+"8");
                break;
            case R.id.n9: //숫자 9버튼을 눌렀을 경우
                input.setText(current+"9"); //9의 값이 화면에 보여지도록 setText 사용
                record.setText(record_current+"9");
                break;
            case R.id.plus: //더하기 버튼을 눌렀을 경우
                if(current.equals("")){ //어떠한 숫자도 누르지 않았을 경우
                    Toast.makeText(getApplicationContext(), "숫자를 먼저 입력하시오.", Toast.LENGTH_SHORT).show();}
                else { //숫자를 입력했을 경우
                    //=이 포함되어 있다면 결과값이 나오고 다음 연산이 자연스럽게 수행되도록 화면에 보여지는 값을 수정해줌
                    if(record.getText().toString().contains("=")){
                        record.setText(current+"+");
                    }
                    else{ //=이 없다는 것은 아직 결과값을 출력하지 않았다는 것으로 + 연산자만 보여지도록 함.
                        record.setText(record_current+"+");
                    }
                    Value =Double.parseDouble(current); //현재 입력한 값을 실수형 변수에 할당
                    current_Operator ='+'; //현재 실행한 연산자인 +에 맞춰서 연산을 수행할 수 있도록 해당 연산자를 변수에 할당
                    input.setText(""); //연산을 수행할 때 방해되지 않도록 빈칸으로 설정함.
                    break; //case문에 break를 걸지않으면 다음 case로 넘어가기 때문에 이를 방지하기 위함.
                }
            case R.id.sub:
                if(current.equals("")){
                    Toast.makeText(getApplicationContext(), "숫자를 먼저 입력하시오.", Toast.LENGTH_SHORT).show();}
                else {
                    if(record.getText().toString().contains("=")){ //=이 포함되어 있다면
                        record.setText(current+"-");
                    }
                    else{
                        record.setText(record_current+"-");
                    }
                    Value =Double.parseDouble(current);
                    current_Operator ='-';
                    input.setText("");
                    break;
                }
            case R.id.mul:
                if(current.equals("")){
                    Toast.makeText(getApplicationContext(), "숫자를 먼저 입력하시오.", Toast.LENGTH_SHORT).show();}
                else {
                    if(record.getText().toString().contains("=")){ //=이 포함되어 있다면
                        record.setText(current+"*");
                    }
                    else{
                        record.setText(record_current+"*");
                    }
                    Value =Double.parseDouble(current);
                    current_Operator ='*';
                    input.setText("");
                    break;
                }
            case R.id.div:
                if(current.equals("")){
                    Toast.makeText(getApplicationContext(), "숫자를 먼저 입력하시오.", Toast.LENGTH_SHORT).show();}
                else {
                    if(record.getText().toString().contains("=")){ //=이 포함되어 있다면
                        record.setText(current+"/");
                    }
                    else{
                        record.setText(record_current+"/");
                    }
                    Value =Double.parseDouble(current);
                    current_Operator ='/';
                    input.setText("");
                    break;
                }
            case R.id.clear: //계산기로 수행한 연산들을 초기화 시키는 버튼 C를 눌렀을 경우
                input.setText(""); //보여지는 모든 칸을 빈칸으로 설정
                record.setText(""); //연산기록을 보여주는 칸도 빈칸으로 설정
                Value =0.0; //사용자가 입력한 값도 0으로 초기화
                break;
            case R.id.ok: //연산 수행 결과값을 얻기 위해 = 버튼을 눌렀을 경우
                if(current.equals("")) { //어떠한 숫자도 입력하지 않았는데 결과값이 나오는 것은 오류이기 때문에 숫자를 입력해달라는 메시지 출력되도록 함.
                    Toast.makeText(getApplicationContext(), "숫자를 먼저 입력하시오", Toast.LENGTH_SHORT).show();
                }
                else { //사칙 연산을 수행하는 곳
                    double result=0; //결과값은 초기화 시킴
                    double thisValue=Double.parseDouble(input.getText().toString()); //사용자가 입력한 값을 가져와 문자를 실수로 바꾸고 해당 값을 thisValue에 할당
                    switch (current_Operator){ //사용자가 원하는 연산 수행
                        case '+': //더하기 연산일 경우
                            result= Value +thisValue;
                            break;
                        case '-': //빼기 연산일 경우
                            result= Value -thisValue;
                            break;
                        case '*': //곱하기 연산일 경우
                            result= Value *thisValue;
                            break;
                        case '/': //난누기 연산일 경우
                            result= Value /thisValue;
                            break;
                    }
                    input.setText(""+result); //연산 수행 후 나온 결과값 출력
                    record.setText(record_current+"=");
                    Value =0.0; //해당 결과값은 이전 연산에 영향이 안가도록 0으로 초기화시킴
                    break;
                }
            }
        }

    }
