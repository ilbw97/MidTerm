package kr.ac.smu_201721572.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvTodo, tvRes;
    Button btnAdd, btnSub, btnMul, btnDiv, btnClear, btnPre, btnDot, btnCal,btnDel;
    boolean dob = false;
    String value, operator, num1, num2;
    Double doubleresult, doublenum1, doublenum2;
    Button[] numButtons = new Button[10];
    Integer[] numBtnIDs = {R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btn0};
    int i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("계산기");
        tvTodo = (TextView) findViewById(R.id.tvTodo);
        tvRes = (TextView) findViewById(R.id.tvRes);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnDiv = (Button) findViewById(R.id.btnDiv);

        btnClear = (Button) findViewById(R.id.btnClear);
        btnDel = (Button) findViewById(R.id.btnDel);
        btnPre = (Button) findViewById(R.id.btnPre);

        btnDot = (Button) findViewById(R.id.btnDot);
        btnCal = (Button) findViewById(R.id.btnCal);
        num1 ="";
        num2="";

        for (i = 0; i < numBtnIDs.length; i++) {
            numButtons[i] = (Button) findViewById(numBtnIDs[i]);
        }

        for (i = 0; i < numBtnIDs.length; i++) {
            final int index;
            index = i;

            numButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    value = tvTodo.getText().toString();
                    if (operator == "") {
                        num1 = num1 + numButtons[index].getText().toString();
                        tvTodo.setText(value+num1);
                    } else {
                        num2 = num2 + numButtons[index].getText().toString();
                        tvTodo.setText(value+num2);
                    }
                }
            });
        }
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String temp = tvTodo.getText().toString();
                    if (temp.equals("0")) {
                        throw new IndexOutOfBoundsException();
                    }
                    temp = temp.substring(0, temp.length() - 1);
                    tvTodo.setText(temp);
                    if (temp.length() == 0) {
                        tvTodo.setText("0");
                        doublenum1 = 0.0;

                    }
                }catch (IndexOutOfBoundsException e){
                    Toast.makeText(getApplicationContext(), "계산 할 숫자를 먼저 입력하세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dob = true;
                    value = tvTodo.getText().toString();
                    if (value.equals(null) || value.equals("0")|| value.equals("")) {
                        tvTodo.setText(value + "0"+btnDot.getText().toString());
                    }else {
                        tvTodo.setText(value + btnDot.getText().toString());
                    }
            }} );

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    value = tvTodo.getText().toString();
                    if (value.equals(null) || value.equals("0")|| value.equals("")) {
                        throw new IndexOutOfBoundsException();
                    }else {
                        tvTodo.setText(value + btnAdd.getText().toString());
                        operator = "+";
                    }
                } catch (IndexOutOfBoundsException e) {
                    Toast.makeText(getApplicationContext(), "계산 할 숫자를 먼저 입력하세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    value = tvTodo.getText().toString();
                    if (value.equals(null) || value.equals("0")|| value.equals("")) {
                        throw new IndexOutOfBoundsException();
                    }

                tvTodo.setText(value + btnSub.getText().toString());
                operator = "-";
            }catch (IndexOutOfBoundsException e){
                    Toast.makeText(getApplicationContext(), "계산 할 숫자를 먼저 입력하세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    value = tvTodo.getText().toString();
                    if (value.equals(null) || value.equals("0")|| value.equals("")) {
                        throw new IndexOutOfBoundsException();
                    }else{
                    tvTodo.setText(value + btnMul.getText().toString());
                    operator = "*";}
                } catch (IndexOutOfBoundsException e) {
                    Toast.makeText(getApplicationContext(), "계산 할 숫자를 먼저 입력하세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    value = tvTodo.getText().toString();
                    if (value.equals(null) || value.equals("0") || value.equals("")) {
                        throw new IndexOutOfBoundsException();
                    }else {
                        tvTodo.setText(value + btnDiv.getText().toString());
                        operator = "/";
                    }
                } catch (IndexOutOfBoundsException e) {
                    Toast.makeText(getApplicationContext(), "계산 할 숫자를 먼저 입력하세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvTodo.setText("");
                tvRes.setText("");
                operator = "";

            }
        });


        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    value = tvTodo.getText().toString();
                    if (value.equals("")) {
                        throw new NullPointerException();
                    }
                    doublenum1 = Double.parseDouble(num1);
                    doublenum2 = Double.parseDouble(num2);
                    doubleresult = 0.0;

//                formular = tvTodo.getText().toString();

                    if (operator == "+") {
                        doubleresult = doublenum1 + doublenum2;
                    } else if (operator == "-") {
                        doubleresult = doublenum1 - doublenum2;
                    } else if (operator == "*") {
                        doubleresult = doublenum1 * doublenum2;
                    } else if (operator == "/") {
                        if (doublenum2 != 0) {
                            doubleresult = doublenum1 / doublenum2;
                        } else {
                            Toast.makeText(getApplicationContext(), "0이 아닌 다른 수를 입력하세요.", Toast.LENGTH_SHORT).show();
                            doublenum1 = 0.0;
                            doublenum2 = 0.0;
                            operator = "";
                        }
                    }
                    if (dob != true) {
                        Integer intres;

                        intres = Integer.parseInt(String.valueOf(Math.round(doubleresult)));
                        String result = Integer.toString(intres);
                        tvRes.setText("= " + result);
                    } else {
                        String result = Double.toString(doubleresult);
                        tvRes.setText("= " + result);
                    }
                    num2 = "";
                    operator = "";
                } catch (NullPointerException e) {
                    Toast.makeText(getApplicationContext(), "계산 할 숫자를 먼저 입력하세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}