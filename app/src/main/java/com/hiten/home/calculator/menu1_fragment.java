package com.hiten.home.calculator;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.*;

import java.text.DecimalFormat;


public class menu1_fragment extends Fragment {

    boolean pol,poltocar = true;
    EditText rad,angle,carx,cary;


    View rootview;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.menu1_layout, container, false);


        try{
            SharedPreferences sharedPreferences = getActivity().getSharedPreferences(getString(R.string.FILE_NAME),Context.MODE_PRIVATE);

            int c = sharedPreferences.getInt(getString(R.string.radio),R.id.ptc);
            String r,a,cx,cy;
            r = sharedPreferences.getString(getString(R.string.r),"");
            a = sharedPreferences.getString(getString(R.string.a),"");
            cx = sharedPreferences.getString(getString(R.string.cx),"");
            cy = sharedPreferences.getString(getString(R.string.cy),"");

            ((RadioGroup) rootview.findViewById(R.id.radioGroup)).check(c);
            ((EditText) rootview.findViewById(R.id.radius)).setText(r);
            ((EditText) rootview.findViewById(R.id.angle)).setText(a);
            ((EditText) rootview.findViewById(R.id.carx)).setText(cx);
            ((EditText) rootview.findViewById(R.id.cary)).setText(cy);

        }catch (Exception e){
            Log.i("Shared_Preferences",e.toString());
        }

        Button button = (Button) rootview.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onButtonClicked(v);
            }
        });

        Button b = (Button) rootview.findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                cls();
            }
        });

        RadioButton ptc = (RadioButton) rootview.findViewById(R.id.ptc);
        ptc.setOnClickListener(new View.OnClickListener(){

                                   @Override
                                   public void onClick(View v) {
                                       onradiobuttonclicked(v);
                                   }
                               }
        );

        RadioButton ctp = (RadioButton) rootview.findViewById(R.id.ctp);
        ctp.setOnClickListener(new View.OnClickListener() {

                                   @Override
                                   public void onClick(View v) {
                                       onradiobuttonclicked(v);
                                   }
                               }
        );
        return rootview;
    }

    public void onButtonClicked(View view) {
        rad = (EditText)rootview.findViewById(R.id.radius);
        angle = (EditText)rootview.findViewById(R.id.angle);
        carx = (EditText)rootview.findViewById(R.id.carx);
        cary = (EditText)rootview.findViewById(R.id.cary);

        if(poltocar){
            if(rad.getText().toString().matches("") && angle.getText().toString().matches("")){
                //Do Nothing
            }
            else{
                if(rad.getText().toString().matches(""))
                    rad.setText(""+0);
                if(angle.getText().toString().matches(""))
                    angle.setText(""+0);
                conptc();
            }
        }
        else{
            if(carx.getText().toString().matches("") && cary.getText().toString().matches("")){
                //Do Nothing
            }
            else{
                if(carx.getText().toString().matches(""))
                    carx.setText(""+0);
                if(cary.getText().toString().matches(""))
                    cary.setText(""+0);
                conctp();
            }
        }


    }

    public void cls(){

        try{
            ((EditText) rootview.findViewById(R.id.radius)).getText().clear();
            ((EditText) rootview.findViewById(R.id.angle)).getText().clear();
            ((EditText) rootview.findViewById(R.id.carx)).getText().clear();
            ((EditText) rootview.findViewById(R.id.cary)).getText().clear();
            ((RadioGroup) rootview.findViewById(R.id.radioGroup)).check(R.id.ptc);

            set_poltocar();
        }catch(Exception e){
            Log.e("",e.toString());
        }
    }

    public void set_poltocar(){
        switch(((RadioGroup) rootview.findViewById(R.id.radioGroup)).getCheckedRadioButtonId()){
            case R.id.ptc:
                poltocar = true;
                break;
            case R.id.ctp:
                poltocar = false;
                break;
        }
    }

    public void conptc(){

            double radius,ang,corx,cory;
            radius = Double.parseDouble(rad.getText().toString());
            ang = Double.parseDouble(angle.getText().toString());

            if(ang == 90){
                corx = 0;
            }
            else{
                corx = radius * Math.cos(Math.toRadians(ang));
            }
            cory = radius * Math.sin(Math.toRadians(ang));

            corx=round1(corx);
            cory = round1(cory);

            carx.setText(""+corx);
            cary.setText(""+cory);

        }

        public void conctp(){

            double radius,ang,corx,cory;
            corx = Double.parseDouble(carx.getText().toString());
            cory = Double.parseDouble(cary.getText().toString());

            radius = Math.sqrt(corx * corx + cory * cory);
            ang = Math.toDegrees(Math.atan(cory/corx));

            radius = round1(radius);
            ang = round1(ang);

            rad.setText("" + radius);
            angle.setText("" + ang);

        }

        public void onradiobuttonclicked(View view) {
            // Is the button now checked?
            boolean checked = ((RadioButton) view).isChecked();

            // Check which radio button was clicked
            switch(view.getId()) {
            case R.id.ptc:
                if (checked)
                    poltocar=true;

                break;
            case R.id.ctp:
                if (checked)
                    poltocar=false;
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Context context = getActivity();
        SharedPreferences sharedPreferences = context.getSharedPreferences(getString(R.string.FILE_NAME), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(getString(R.string.radio),((RadioGroup) rootview.findViewById(R.id.radioGroup)).getCheckedRadioButtonId());
        editor.putString(getString(R.string.r), ((EditText) rootview.findViewById(R.id.radius)).getText().toString());
        editor.putString(getString(R.string.a),((EditText) rootview.findViewById(R.id.angle)).getText().toString());
        editor.putString(getString(R.string.cx),((EditText) rootview.findViewById(R.id.carx)).getText().toString());
        editor.putString(getString(R.string.cy),((EditText) rootview.findViewById(R.id.cary)).getText().toString());
        editor.commit();

    }

    double round1(double d)
    {
        DecimalFormat twoDForm = new DecimalFormat("#.#####");
        return Double.valueOf(twoDForm.format(d));
    }

}
