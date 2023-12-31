package com.example.tp4calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tVResult;

    String a="0", b="0", hisOp;
    Boolean op = false, opUp = false, comma = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tVResult = (TextView) findViewById(R.id.res);

    }


    public void getNbr(View v){
        Button nbrBtn = (Button) v;
        setNbr(nbrBtn.getText().toString());
    }



    public void Clear(View v){
        tVResult.setText("0");
        a = "0";
        b = "0";
        op = false;
        opUp = false;
        comma = false;
    }
    public void Plus(View v){

        if(opUp){Equals();}

        a = tVResult.getText().toString();
        hisOp = "+";
        op = true;
        opUp = true;
    }
    public void Minus(View v){
        if(opUp){Equals();}

        a = tVResult.getText().toString();
        hisOp = "-";
        op = true;
        opUp = true;

    }
    public void Mul(View v){
        if(opUp){Equals();}

        a = tVResult.getText().toString();
        hisOp = "*";
        op = true;
        opUp = true;

    }
    public void Div(View v){
        if(opUp){Equals();}

        a = tVResult.getText().toString();
        hisOp = "/";
        op = true;
        opUp = true;

    }
    public void Equal(View v){
        Equals();
    }

    private void Equals() {

        if(a.equals("ERROR") || b.equals("ERROR")){
            tVResult.setText("ERROR");
        }else{
            if(opUp){
                b = tVResult.getText().toString();
                if(hisOp.equals("/") && Float.parseFloat(b)==0){
                    tVResult.setText("ERROR");
                }else {
                    String res = toStr(operation(a, b, hisOp));
                    if(res.contains(".")){
                        String result = res.substring(0, res.indexOf(".")+4);
                        tVResult.setText(result);
                    }else {
                        tVResult.setText(res);
                    }

                }



                op = false;
                opUp = false;

            }
        }

//        String value = tVResult.getText().toString();
//        if(value.contains(".")){comma=true;}else {comma=false;}


    }

    public void Comma(View v){
        if(comma == false){
            String t = tVResult.getText().toString() + '.';
            tVResult.setText(t);
            comma = true;
        }
    }
    public void Percent(View v){
//        if(opUp){Equals();}
        if(a.equals("ERROR") || b.equals("ERROR")){
            tVResult.setText("ERROR");
        }else {
            String t = tVResult.getText().toString();
            tVResult.setText(toStr(operation(t, "100", "/")));
        }
    }
    public void Sign(View v){
//        if(opUp){Equals();}

        if(a.equals("ERROR") || b.equals("ERROR")){
            tVResult.setText("ERROR");
        }else {
            String t = tVResult.getText().toString();
            tVResult.setText(toStr(-1*Float.parseFloat(t)));
        }

    }



    public void ClearOne(View v){
        String t = tVResult.getText().toString();
        if(t.length() == 1){
            tVResult.setText("0");
        }else{
            tVResult.setText(t.substring(0, t.length()-1));
        }
    }




    void setNbr(String n){
        if(tVResult.getText().toString().equals("0") || tVResult.getText().toString().equals("ERROR") || a.equals("ERROR") || b.equals("ERROR")){
            tVResult.setText(n);
            a = "0";
            comma = false;
        } else if (op) {
            tVResult.setText(n);
            op = false;
            comma = false;
        }else{
            String t = tVResult.getText().toString();
            tVResult.setText(t + n);
        }
    }







    Float add(String a, String b){return Float.parseFloat(a) + Float.parseFloat(b);
    }
    Float minus(String a, String b){
        return Float.parseFloat(a) - Float.parseFloat(b);
    }
    Float mul(String a, String b){
        return Float.parseFloat(a) * Float.parseFloat(b);
    }
    Float div(String a, String b){
        return Float.parseFloat(a) / Float.parseFloat(b);
    }


    Float operation(String a, String b, String op){
        if(op.equals("+")) return add(a, b);
        if(op.equals("-")) return minus(a, b);
        if(op.equals("*")) return mul(a, b);
        if(op.equals("/")){
            if(Float.parseFloat(b) != 0){
                return div(a, b);
            }else {
                return null;
            }
        };
        return null;
    }

    String toStr(Float f){
        int fInt = Math.round(f);
        if(f-fInt==0){
            return Integer.toString(fInt);
        }else{
            return Float.toString(f);
        }
    }




}