package com.hiten.home.calculator;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.DecimalFormat;


public class menu3_fragment extends Fragment {

    View rootview;

    boolean pol1=true, pol2=true;
    RadioGroup rg1,rg2,operator;
    EditText one1,one2,two1,two2;
    RadioButton p,mi,mu,di;

    int operation = 1;

    final int multiply = 3;
    final int divide = 4;
    final int add = 1;
    final int subtract = 2;

    double x1,y1,x2,y2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.menu3_layout, container, false);


        rg1 = (RadioGroup) rootview.findViewById(R.id.polcar_radioGroup);
        rg2 = (RadioGroup) rootview.findViewById(R.id.polcar_radioGroup2);
        operator = (RadioGroup) rootview.findViewById(R.id.operator_radioGroup);

        RadioButton pol_radioButton = (RadioButton) rootview.findViewById(R.id.pol_radioButton);
        RadioButton car_radioButton = (RadioButton) rootview.findViewById(R.id.car_radioButton);

        RadioButton pol_radioButton2 = (RadioButton) rootview.findViewById(R.id.pol_radioButton2);
        RadioButton car_radioButton2 = (RadioButton) rootview.findViewById(R.id.car_radioButton2);

        Button clear = (Button) rootview.findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                cls();
            }
        });

        Button Calculate =(Button) rootview.findViewById(R.id.calculate);
        Calculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                calcu();
            }
        });

        p = (RadioButton) rootview.findViewById(R.id.plus_radioButton);
        mi = (RadioButton) rootview.findViewById(R.id.minus_radioButton);
        mu = (RadioButton) rootview.findViewById(R.id.multiply_radioButton);
        di = (RadioButton) rootview.findViewById(R.id.divide_radioButton);

        one1 = (EditText) rootview.findViewById(R.id.in1a);
        one2 = (EditText) rootview.findViewById(R.id.in1b);
        two1 = (EditText) rootview.findViewById(R.id.in2a);
        two2 = (EditText) rootview.findViewById(R.id.in2b);


        p.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                opp(v);
            }
        });
        mi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                opp(v);
            }
        });
        mu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                opp(v);
            }
        });
        di.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                opp(v);
            }
        });

        pol_radioButton.setOnClickListener(new View.OnClickListener(){
                                               @Override
                                   public void onClick(View v) {
                                       onradiobuttonclicked1(v);
                                   }
                               }
        );

        car_radioButton.setOnClickListener(new View.OnClickListener(){

                                               @Override
                                               public void onClick(View v) {
                                                   onradiobuttonclicked1(v);
                                               }
                                           }
        );

        pol_radioButton2.setOnClickListener(new View.OnClickListener(){

                                               @Override
                                               public void onClick(View v) {
                                                   onradiobuttonclicked2(v);
                                               }
                                           }
        );

        car_radioButton2.setOnClickListener(new View.OnClickListener(){

                                               @Override
                                               public void onClick(View v) {
                                                   onradiobuttonclicked2(v);
                                               }
                                           }
        );

        return rootview;
    }

    public void onradiobuttonclicked1(View view){
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.pol_radioButton:
                if (checked)
                    pol1=true;

                break;
            case R.id.car_radioButton:
                if (checked)
                    pol1=false;
                break;
        }

        changeText("pol1");

    }

    public void onradiobuttonclicked2(View view){
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.pol_radioButton2:
                if (checked)
                    pol2=true;

                break;
            case R.id.car_radioButton2:
                if (checked)
                    pol2=false;
                break;
        }

        changeText("pol2");

    }

    public void changeText(String which){
        TextView f = (TextView) rootview.findViewById(R.id.middleText);
        TextView s = (TextView) rootview.findViewById(R.id.middleText2);
        if(which.matches("pol1")){
            if(pol1){
                f.setText(R.string.theta);
            }
            else
                f.setText(R.string.j);
        }
        if(which.matches("pol2")){
            if(pol2){
                s.setText(R.string.theta);
            }
            else
                s.setText(R.string.j);
        }
    }

    public boolean not_empty1(){
        String x = one1.getText().toString();
        String y = one2.getText().toString();
        String p = two1.getText().toString();
        String q = two2.getText().toString();
        if(x.matches("") && y.matches("")){
            return false;
        }
        if(p.matches("") && q.matches("")){
            return false;
        }
        else{
            if(x.matches(""))
                x1=0;
            if(y.matches(""))
                y1=0;
            if(p.matches(""))
                x2=0;
            if(q.matches(""))
                y2=0;

            return true;
        }
    }

    public void opp(View view){
        if(view.getId() == R.id.plus_radioButton)
            operation = 1;
        if(view.getId() == R.id.minus_radioButton)
            operation = 2;
        if(view.getId() == R.id.multiply_radioButton)
            operation = 3;
        if(view.getId() == R.id.divide_radioButton)
            operation = 4;
    }

    public void cls(){

        ((EditText) rootview.findViewById(R.id.in1a)).getText().clear();
        ((EditText) rootview.findViewById(R.id.in1b)).getText().clear();
        ((EditText) rootview.findViewById(R.id.in2a)).getText().clear();
        ((EditText) rootview.findViewById(R.id.in2b)).getText().clear();
        ((TextView) rootview.findViewById(R.id.middleText)).setText(R.string.theta);
        ((TextView) rootview.findViewById(R.id.middleText2)).setText(R.string.theta);
        ((TextView) rootview.findViewById(R.id.result)).setVisibility(View.INVISIBLE);
        ((TextView) rootview.findViewById(R.id.result1)).setText("");
        ((TextView) rootview.findViewById(R.id.result2)).setText("");
        ((RadioGroup) rootview.findViewById(R.id.polcar_radioGroup)).check(R.id.pol_radioButton);
        ((RadioGroup) rootview.findViewById(R.id.polcar_radioGroup2)).check(R.id.pol_radioButton2);
        ((RadioGroup) rootview.findViewById(R.id.operator_radioGroup)).check(R.id.plus_radioButton);

    }

    public void calcu(){
        if(not_empty1()){
            if(!one1.getText().toString().matches(""))
                x1 = Double.parseDouble(one1.getText().toString());
            if(!one2.getText().toString().matches(""))
                y1 = Double.parseDouble(one2.getText().toString());
            if(!two1.getText().toString().matches(""))
                x2 = Double.parseDouble(two1.getText().toString());
            if(!two2.getText().toString().matches(""))
                y2 = Double.parseDouble(two2.getText().toString());

            switch(operation){

                case add:
                    if(pol1){
                        conptc1();
                    }
                    if(pol2){
                        conptc2();
                    }

                    ((TextView) rootview.findViewById(R.id.result)).setVisibility(View.VISIBLE);
                    ((TextView) rootview.findViewById(R.id.result2)).setText((x1 + x2) + " + j " + (y1 + y2));
                    conctp(x1+x2,y1+y2);

                    break;
                case subtract:
                    if(pol1){
                        conptc1();
                    }
                    if(pol2){
                        conptc2();
                    }

                    ((TextView) rootview.findViewById(R.id.result)).setVisibility(View.VISIBLE);
                    ((TextView) rootview.findViewById(R.id.result2)).setText(round1(x1 - x2) + " + j " + round1(y1 - y2));
                    conctp(x1-x2,y1-y2);
                    break;
                case multiply:
                    if(pol1){
                        conptc1();
                    }
                    if(pol2){
                        conptc2();
                    }

                    ((TextView) rootview.findViewById(R.id.result)).setVisibility(View.VISIBLE);
                    ((TextView) rootview.findViewById(R.id.result2)).setText(round1(x1*x2 - y1*y2) + " + j " + round1(x1*y2 + y1*x2));
                    conctp((x1*y2 + y1*x2),(x1*y2 + y1*x2));
                    break;
                case divide:
                    if(!pol1){
                        conctp1();
                    }
                    if(!pol2){
                        conctp2();
                    }

                    ((TextView) rootview.findViewById(R.id.result)).setVisibility(View.VISIBLE);
                    ((TextView) rootview.findViewById(R.id.result1)).setText(round1(x1 / x2) + " + Ɵ " + round1(y1 - y2));
                    conptc(x1 / x2, y1 - y2);
                    break;

            }

        }
    }

    public void conptc1(){
        double rad1 = x1;
        double ang1 = y1;

        if(y1 == 90){
            x1 = 0;
        }
        else{
            x1 = x1 * Math.cos(Math.toRadians(y1));
        }
        y1 = rad1 * Math.sin(Math.toRadians(ang1));

        x1=round1(x1);
        y1 = round1(y1);
    }

    public void conptc2(){
        double rad1 = x2;
        double ang1 = y2;

        if(y2 == 90){
            x2 = 0;
        }
        else{
            x2 = x2 * Math.cos(Math.toRadians(y2));
        }
        y2 = rad1 * Math.sin(Math.toRadians(ang1));

        x2=round1(x2);
        y2 = round1(y2);
    }

    public void conctp1(){

        double radius,ang,corx,cory;
        corx = x1;
        cory = y1;

        radius = Math.sqrt(corx * corx + cory * cory);
        ang = Math.toDegrees(Math.atan(cory / corx));

        radius = round1(radius);
        ang = round1(ang);

        x1 = radius;
        y1 = ang;

    }

    public void conctp2(){

        double radius,ang,corx,cory;
        corx = x2;
        cory = y2;

        radius = Math.sqrt(corx * corx + cory * cory);
        ang = Math.toDegrees(Math.atan(cory / corx));

        radius = round1(radius);
        ang = round1(ang);

        x2 = radius;
        y2 = ang;

    }

    double round1(double d)
    {
        DecimalFormat twoDForm = new DecimalFormat("#.#####");
        return Double.valueOf(twoDForm.format(d));
    }

    public void conptc(double x,double y){

        double radius,ang,corx,cory;
        radius = x;
        ang = y;

        if(ang == 90){
            corx = 0;
        }
        else{
            corx = radius * Math.cos(Math.toRadians(ang));
        }
        cory = radius * Math.sin(Math.toRadians(ang));

        corx = round1(corx);
        cory = round1(cory);

        ((TextView) rootview.findViewById(R.id.result2)).setText(corx + " + j " + cory);

    }

    public void conctp(double x, double y){

        double radius,ang,corx,cory;
        corx = x;
        cory = y;

        radius = Math.sqrt(corx * corx + cory * cory);
        ang = Math.toDegrees(Math.atan(cory / corx));

        radius = round1(radius);
        ang = round1(ang);

        ((TextView) rootview.findViewById(R.id.result1)).setText(radius + " + Ɵ " + ang);

    }

}
