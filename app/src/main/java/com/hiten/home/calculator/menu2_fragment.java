package com.hiten.home.calculator;

import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Button;

import java.text.DecimalFormat;


public class menu2_fragment extends android.support.v4.app.Fragment implements View.OnClickListener {
    View rootview;

    RadioButton radbt;
    TextView stack;
    EditText input;

    double a=0,b=0;
    boolean operand_pressed = false;
    int operation = 0;

    final double exp = 2.7182818284590452353602874713527;
    final int none = 0;
    final int multiply = 1;
    final int divide = 2;
    final int add = 3;
    final int subtract = 4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.menu2_layout, container, false);

        radbt = (RadioButton) rootview.findViewById(R.id.degree);
        stack = (TextView) rootview.findViewById(R.id.stack);
        input = (EditText) rootview.findViewById(R.id.editText);


        try{
            SharedPreferences sharedPreferences = getActivity().getSharedPreferences(getString(R.string.calc), Context.MODE_PRIVATE);
            String i,s;
            i = sharedPreferences.getString("i","");
            s = sharedPreferences.getString("s","");
            int r = sharedPreferences.getInt("r",R.id.degree);
            double c = getDouble(sharedPreferences,"a",0);
            a=c;
            operand_pressed = sharedPreferences.getBoolean("o",false);
            operation = sharedPreferences.getInt("op",0);

            input.setText(i);
            stack.setText(s);
            ((RadioGroup) rootview.findViewById(R.id.radioGroup2)).check(r);

        }catch (Exception e){
            Log.i("Shared_Preferences", e.toString());
        }

        Button sin = (Button) rootview.findViewById(R.id.sin);
        Button cos = (Button) rootview.findViewById(R.id.cos);
        Button tan = (Button) rootview.findViewById(R.id.tan);
        Button asin = (Button) rootview.findViewById(R.id.asin);
        Button log = (Button) rootview.findViewById(R.id.log);
        Button acos = (Button) rootview.findViewById(R.id.acos);
        Button atan = (Button) rootview.findViewById(R.id.atan);
        Button ln = (Button) rootview.findViewById(R.id.ln);
        Button root = (Button) rootview.findViewById(R.id.root);
        Button invert = (Button) rootview.findViewById(R.id.invert);
        Button ex = (Button) rootview.findViewById(R.id.ex);
        Button tenx = (Button) rootview.findViewById(R.id.tenx);
        Button del = (Button) rootview.findViewById(R.id.del);
        Button ac = (Button) rootview.findViewById(R.id.ac);
        Button pi = (Button) rootview.findViewById(R.id.pi);
        Button e = (Button) rootview.findViewById(R.id.e);
        Button mul = (Button) rootview.findViewById(R.id.mul);
        Button div = (Button) rootview.findViewById(R.id.div);
        Button plus = (Button) rootview.findViewById(R.id.plus);
        Button minus = (Button) rootview.findViewById(R.id.minus);
        Button equal = (Button) rootview.findViewById(R.id.equal);
        Button square = (Button) rootview.findViewById(R.id.square);



        sin.setOnClickListener(this);
        cos.setOnClickListener(this);
        tan.setOnClickListener(this);
        log.setOnClickListener(this);
        asin.setOnClickListener(this);
        acos.setOnClickListener(this);
        atan.setOnClickListener(this);
        ln.setOnClickListener(this);
        root.setOnClickListener(this);
        invert.setOnClickListener(this);
        ex.setOnClickListener(this);
        tenx.setOnClickListener(this);
        del.setOnClickListener(this);
        ac.setOnClickListener(this);
        pi.setOnClickListener(this);
        e.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        equal.setOnClickListener(this);
        square.setOnClickListener(this);

        return rootview;
    }


    Boolean deg = true;

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.sin:
                    if(not_empty()){
                        check();
                        if(deg){
                            double a = Double.parseDouble(input.getText().toString());
                            double x = Math.sin(Math.toRadians(a));
                            x=round(x);
                            input.setText(""+x);
                        }
                        else {
                            double a = Double.parseDouble(input.getText().toString());
                            double x = Math.sin(a);
                            x=round(x);
                            input.setText(""+x);
                        }
                    }
                break;
            case R.id.cos:
                if(not_empty()){
                    check();
                    if(deg){
                        double a = Double.parseDouble(input.getText().toString());
                        double x = Math.cos(Math.toRadians(a));
                        x=round(x);
                        input.setText(""+x);
                    }
                    else {
                        double a = Double.parseDouble(input.getText().toString());
                        double x = Math.cos(a);
                        x=round(x);
                        input.setText(""+x);
                    }
                }
                break;
            case R.id.tan:
                if(not_empty()){
                    check();
                    if(deg){
                        double a = Double.parseDouble(input.getText().toString());
                        double x = Math.tan(Math.toRadians(a));
                        x=round(x);
                        input.setText(""+x);
                    }
                    else {
                        double a = Double.parseDouble(input.getText().toString());
                        double x = Math.tan(a);
                        x=round(x);
                        input.setText(""+x);
                    }
                }
                break;
            case R.id.asin:
                if(not_empty()){
                    check();
                    double a = Double.parseDouble(input.getText().toString());
                    double x = Math.asin(a);
                    if(deg)
                        input.setText(""+round(Math.toDegrees(x)));
                    else
                        input.setText(""+round(x));
                }
                break;
            case R.id.acos:
                if(not_empty()){
                    check();
                    double a = Double.parseDouble(input.getText().toString());
                    double x = Math.acos(a);
                    if(deg)
                        input.setText(""+round(Math.toDegrees(x)));
                    else
                        input.setText(""+round(x));
                }
                break;
            case R.id.atan:
                if(not_empty()){
                    check();
                    double a = Double.parseDouble(input.getText().toString());
                    double x = Math.atan(a);
                    if(deg)
                        input.setText(""+round(Math.toDegrees(x)));
                    else
                        input.setText(""+round(x));
                }
                break;
            case R.id.log:
                if(not_empty()){
                    double a = Double.parseDouble(input.getText().toString());
                    if(a>0) {
                        double x = Math.log10(a);
                        input.setText("" + x);
                    }
                    else
                        input.setText("Not Defined");
                }
                break;
            case R.id.root:
                if(not_empty()){
                    double a = Double.parseDouble(input.getText().toString());
                    if(a>=0){
                        double x = Math.pow(a, 0.5);
                        x=round(x);
                        input.setText(""+x);
                    }
                    else
                        input.setText("Imaginary");
                }
                break;
            case R.id.ln:
                if(not_empty()){
                    double a = Double.parseDouble(input.getText().toString());
                    if(a>0) {
                        double x = Math.log(a);
                        input.setText("" + x);
                    }
                    else
                        input.setText("Not Defined");
                }
                break;
            case R.id.invert:
                if(not_empty()){
                    double a = Double.parseDouble(input.getText().toString());
                    if(a!=0) {
                        double x = Math.pow(a, -1);
                        input.setText("" + x);
                    }
                    else
                        input.setText("NaN");
                }
                break;
            case R.id.ex:
                if(not_empty()){
                    double a = Double.parseDouble(input.getText().toString());
                    double x = Math.pow(exp,a);
                    input.setText(""+x);
                }
                break;
            case R.id.tenx:
                if(not_empty()){
                    double a = Double.parseDouble(input.getText().toString());
                    if(a<100){
                        double x = Math.pow(10,a);
                        input.setText(""+x);
                    }
                    else
                        input.setText("NaN");
                }
                break;
            case R.id.del:
                    input.setText("");
                break;
            case R.id.ac:
                    input.setText("");
                    operand_pressed = false;
                    operation = none;
                    stack.setText("");
                ((RadioGroup) rootview.findViewById(R.id.radioGroup2)).check(R.id.degree);
                break;
            case R.id.pi:
                input.setText(""+round(Math.PI));
                break;
            case R.id.e:
                input.setText(""+round(exp));
                break;
            case R.id.square:
                if(not_empty()){
                    double a = Double.parseDouble(input.getText().toString());
                    double x = Math.pow(a,2);
                    input.setText(""+x);
                }
                break;
            case R.id.mul:

                    if(!operand_pressed && not_empty()) {
                        a = Double.parseDouble(input.getText().toString());
                        operation = multiply;
                        stack.setText("" + round(a) + " x");
                        input.setText("");
                        operand_pressed = true;
                    }
                    else{
                        if(not_empty()){
                            b=Double.parseDouble(input.getText().toString());
                            do_calc();
                            operation = multiply;
                            stack.setText("" + round(a) + " x");
                            input.setText("");
                        }
                        else{
                            if(operation != none) {
                                operation = multiply;
                                stack.setText("" + round(a) + " x");
                                input.setText("");
                            }
                        }
                    }

                break;
            case R.id.div:

                    if(!operand_pressed && not_empty()) {
                        a = Double.parseDouble(input.getText().toString());
                        operation = divide;
                        stack.setText("" + round(a) + " ÷");
                        operand_pressed = true;
                    }
                    else{
                        if(not_empty()){
                            b=Double.parseDouble(input.getText().toString());
                            do_calc();
                            operation = divide;
                            stack.setText("" + round(a) + " ÷");
                        }
                        else{
                            if(operation != none) {
                                operation = divide;
                                stack.setText("" + round(a) + " ÷");
                                input.setText("");
                            }
                        }
                    }
                input.setText("");
                break;
            case R.id.plus:

                    if(!operand_pressed && not_empty()) {
                        a = Double.parseDouble(input.getText().toString());
                        operation = add;
                        stack.setText("" + round(a) + " +");
                        operand_pressed = true;
                    }
                    else{
                        if(not_empty()){
                            b=Double.parseDouble(input.getText().toString());
                            do_calc();
                            operation = add;
                            stack.setText("" + round(a) + " +");
                        }
                        else{
                            if(operation != none) {
                                operation = add;
                                stack.setText("" + round(a) + " +");
                                input.setText("");
                            }
                        }
                    }
                input.setText("");
                break;
            case R.id.minus:

                    if(!operand_pressed && not_empty()) {
                        a = Double.parseDouble(input.getText().toString());
                        operation = subtract;
                        stack.setText("" + round(a) + " -");
                        operand_pressed = true;
                    }
                    else{
                        if(not_empty()){
                            b=Double.parseDouble(input.getText().toString());
                            do_calc();
                            operation = subtract;
                            stack.setText("" + round(a) + " -");
                        }
                        else{
                            if(operation != none) {
                                operation = subtract;
                                stack.setText("" + round(a) + " -");
                                input.setText("");
                            }
                        }
                    }
                input.setText("");
                break;
            case R.id.equal:
                switch(operation){
                    case multiply:
                        if(not_empty()){

                            b = Double.parseDouble(input.getText().toString());
                            double c = a*b;
                            input.setText(""+round(c));
                            stack.setText("");
                            a=0;
                            b=0;

                        }
                        break;
                    case divide:
                        if(not_empty()){

                            b = Double.parseDouble(input.getText().toString());
                            double c = a/b;
                            input.setText(""+round(c));
                            stack.setText("");
                            a=0;
                            b=0;

                        }
                        break;
                    case add:
                        if(not_empty()){

                            b = Double.parseDouble(input.getText().toString());
                            double c = a+b;
                            input.setText(""+round(c));
                            stack.setText("");
                            a=0;
                            b=0;

                        }
                        break;
                    case subtract:
                        if(not_empty()){

                            b = Double.parseDouble(input.getText().toString());
                            double c = a-b;
                            input.setText(""+round(c));
                            stack.setText("");
                            a=0;
                            b=0;

                        }
                        break;
                }
                operand_pressed=false;
                break;
        }
    }

    public boolean check(){
        if(radbt.isChecked())
              deg = true;
        else
            deg = false;

        return deg;
    }

    public boolean not_empty(){
        String x = input.getText().toString();
        if(x.matches("") || x.matches("NaN") || x.matches("Imaginary") || x.matches("Not Defined"))
            return false;
        else
            return true;
    }

    double round(double d)
    {
        DecimalFormat twoDForm = new DecimalFormat("#.#####");
        return Double.valueOf(twoDForm.format(d));
    }

    public  void do_calc(){

        switch(operation){
            case multiply:
                a = a*b;
                break;
            case divide:
                a = a/b;
                break;
            case add:
                a=a+b;
                break;
            case subtract:
                a=a-b;
                break;
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Context context1 = getActivity();
        SharedPreferences s = context1.getSharedPreferences(getString(R.string.calc), Context.MODE_PRIVATE);
        SharedPreferences.Editor e = s.edit();
        e.putString("i",input.getText().toString());
        e.putString("s", stack.getText().toString());
        e.putInt("r", ((RadioGroup) rootview.findViewById(R.id.radioGroup2)).getCheckedRadioButtonId());
        putDouble(e, "a", a);
        e.putBoolean("o", operand_pressed);
        e.putInt("op",operation);
        e.commit();

    }

    SharedPreferences.Editor putDouble(final SharedPreferences.Editor edit, final String key, final double value) {
        return edit.putLong(key, Double.doubleToRawLongBits(value));
    }

    double getDouble(final SharedPreferences prefs, final String key, final double defaultValue) {
        return Double.longBitsToDouble(prefs.getLong(key, Double.doubleToLongBits(defaultValue)));
    }
}
