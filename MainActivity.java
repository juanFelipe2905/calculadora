package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private  TextView Screen;
    private Button ac,back,eleva,div,siete,ocho,nuev,mult,cuatro,cinco,seis,restar,uno,dos,tres,sumar,punto,cero,ans,igual;
    private String input,Answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Screen=findViewById(R.id.Screen);
        ac=findViewById(R.id.ac);
        back=findViewById(R.id.back);
        eleva=findViewById(R.id.eleva);
        div=findViewById(R.id.div);
        siete=findViewById(R.id.siete);
        ocho=findViewById(R.id.ocho);
        nuev=findViewById(R.id.nuev);
        mult=findViewById(R.id.mult );
        cuatro=findViewById(R.id.cuatro);
        cinco=findViewById(R.id.cinco);
        seis=findViewById(R.id.seis);
        restar=findViewById(R.id.restar);
        uno=findViewById(R.id.uno);
        dos=findViewById(R.id.dos);
        tres=findViewById(R.id.tres);
        sumar=findViewById(R.id.sumar);
        punto=findViewById(R.id.punto);
        cero=findViewById(R.id.cero);
        ans=findViewById(R.id.ans);
        igual=findViewById(R.id.igual);

    }
    public void ButtonClick(View view)
    {
    Button button=(Button) view;
    String data=button.getText().toString();
    switch (data)
    {
        case"AC":
            input="";
            break;
        case "ANS":
            input+=Answer;
            break;
        case"X":
            solve();
            input+="*";
            break;
        case"^":
            solve();
            input+="^";
            break;
        case"=":
            solve();
            Answer=input;
            break;
        case"reg":
            String newText=input.substring(0,input.length()-1);
            input=newText;
            break;
        default:
            if(input==null)
            {
                input="";
            }
            if(data.equals("+")||data.equals("-")||data.equals("/"))
            {
                solve();
            }
            input+=data;
    }
    Screen.setText(input);
    }
    private void solve()
    {
if(input.split("\\*").length==2)
        {
        String number []=input.split("\\*");
        try {
            double mult = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
            input = mult+"";
        }
        catch (Exception e)
        {
            //toggle error
        }
        }
        else if(input.split("/").length==2) {
    String number[] = input.split("/");
    try {
        double div = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
        input = div+"";
    } catch (Exception e) {
        //toggle error
    }
}
       else if(input.split("\\^").length==2)
        {
            String number []=input.split("\\^");
            try {
                double eleva = Math.pow(Double.parseDouble(number[0]),Double.parseDouble(number[1]));
                input = eleva+"";
            }
            catch (Exception e)
            {
                //toggle error
            }
        }
        else if(input.split("\\+").length==2) {
            String number[] = input.split("\\+");

            try {
                double sumar = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                input = sumar+"";
            } catch (Exception e) {
                //toggle error
            }
        }
        else if(input.split("-").length>1) {
        String number[] = input.split("-");
    //to substract  negative numero
    if(number[0]=="" && number.length==2)
    {
        number[0]=0+"";

    }
        try {
            double restar=0;
            if(number.length==2) {
                restar = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
            }
            else if(number.length==3)
            {
                restar = -Double.parseDouble(number[1]) - Double.parseDouble(number[2]);
            }
            input= restar+"";
        }
            catch (Exception e) {
            //toggle error
        }
    }
        String n[]=input.split("\\.");
        if(n.length>1){
            if(n[1].equals("0"))
            {
                input=n[0];
            }
        }
        Screen.setText(input);
    }
    }
