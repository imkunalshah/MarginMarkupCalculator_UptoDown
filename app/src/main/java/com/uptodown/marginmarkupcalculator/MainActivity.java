package com.uptodown.marginmarkupcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText cp,sp,margin,markup;
    TextView result;
    Button calculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cp = findViewById(R.id.cp);
        sp = findViewById(R.id.sp);
        margin = findViewById(R.id.margin);
        markup = findViewById(R.id.markup);
        result = findViewById(R.id.results);
        calculate = findViewById(R.id.calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cost = cp.getText().toString().trim();
                String sell = sp.getText().toString().trim();
                String Margin = margin.getText().toString().trim();
                String Markup = markup.getText().toString().trim();

                DecimalFormat format = new DecimalFormat("#.##");
                double mark,marg;
                if (!cost.isEmpty() && !sell.isEmpty()){
                    double Cp = Double.parseDouble(cost);
                    double Sp = Double.parseDouble(sell);
                    mark = ((Sp - Cp)/(Cp))*100;
                    marg = ((Sp-Cp)/(Sp))*100;
                    String marku= format.format(mark);
                    String margi = format.format(marg);
                    result.setText("Cost Price : "+Cp +"\n" + "Sale Price : "+Sp +"\n"+"Margin : "+margi+"%"+"\n"+"Markup : "+ marku+"%");
                    markup.setText(marku+"%");
                    margin.setText(margi+"%");
                    cp.setEnabled(false);
                    sp.setEnabled(false);
                    margin.setEnabled(false);
                    markup.setEnabled(false);
                }
                else if (!cost.isEmpty() && !Margin.isEmpty()){
                    double Cp = Double.parseDouble(cost);
                    marg = Double.parseDouble(Margin);
                    double Sp = ((100*Cp)/(100-marg));
                    mark= ((Sp - Cp)/(Cp))*100;
                    String formatted_Sp = format.format(Sp);
                    String formatted_markup = format.format(mark);
                    result.setText("Cost Price : "+Cp +"\n" + "Sale Price : "+formatted_Sp +"\n"+"Margin : "+marg+"%"+"\n"+"Markup : "+formatted_markup+"%");
                    sp.setText(formatted_Sp);
                    markup.setText(formatted_markup+"%");
                    margin.setText(marg+"%");
                    cp.setEnabled(false);
                    sp.setEnabled(false);
                    margin.setEnabled(false);
                    markup.setEnabled(false);
                }
                else if (!cost.isEmpty() && !Markup.isEmpty()){
                    double Cp = Double.parseDouble(cost);
                    mark = Double.parseDouble(Markup);
                    double Sp = ((mark+100)/(100))*Cp;
                    marg = ((Sp-Cp)/(Sp))*100;
                    String formatted_sp = format.format(Sp);
                    String formatted_margin = format.format(marg);
                    result.setText("Cost Price : "+Cp +"\n" + "Sale Price : "+formatted_sp +"\n"+"Margin : "+formatted_margin+"%"+"\n"+"Markup : "+mark+"%");
                    sp.setText(formatted_sp);
                    margin.setText(formatted_margin+"%");
                    markup.setText(mark+"%");
                    cp.setEnabled(false);
                    sp.setEnabled(false);
                    margin.setEnabled(false);
                    markup.setEnabled(false);
                }
                else if (!sell.isEmpty() && !Margin.isEmpty()){
                    double Sp = Double.parseDouble(sell);
                    marg = Double.parseDouble(Margin);
                    double Cp = ((100-marg)/100)*Sp;
                    mark = ((Sp - Cp)/(Cp))*100;
                    String formatted_cp = format.format(Cp);
                    String formatted_markup = format.format(mark);
                    result.setText("Cost Price : "+formatted_cp +"\n" + "Sale Price : "+Sp +"\n"+"Margin : "+marg+"%"+"\n"+"Markup : "+formatted_markup+"%");
                    cp.setText(formatted_cp);
                    markup.setText(formatted_markup+"%");
                    margin.setText(marg+"%");
                    cp.setEnabled(false);
                    sp.setEnabled(false);
                    margin.setEnabled(false);
                    markup.setEnabled(false);
                }
                else if (!sell.isEmpty() && !Markup.isEmpty()){
                    double Sp = Double.parseDouble(sell);
                    mark = Double.parseDouble(Markup);
                    double Cp =((100)/(mark + 100))*Sp;
                    marg = ((Sp-Cp)/(Sp))*100;
                    String formatted_cp = format.format(Cp);
                    String formatted_margin =format.format(marg);
                    result.setText("Cost Price : "+formatted_cp +"\n" + "Sale Price : "+Sp +"\n"+"Margin : "+formatted_margin+"%"+"\n"+"Markup : "+mark+"%");
                    cp.setText(formatted_cp);
                    margin.setText(formatted_margin+"%");
                    markup.setText(mark+"%");
                    cp.setEnabled(false);
                    sp.setEnabled(false);
                    margin.setEnabled(false);
                    markup.setEnabled(false);
                }
                else if (!Markup.isEmpty() && !Margin.isEmpty()){
                    FancyToast.makeText(getApplicationContext(),"The combo not good ... please enter one more field",FancyToast.LENGTH_LONG,FancyToast.INFO,true).show();
                }
                else if (!cost.isEmpty() && !Margin.isEmpty() && !Markup.isEmpty()){
                    double Cp = Double.parseDouble(cost);
                    marg = Double.parseDouble(Margin);
                    mark = Double.parseDouble(Markup);
                    double Sp = ((mark+100)/(100))*Cp;
                    String formatted_sp = format.format(Sp);
                    result.setText("Cost Price : "+Cp +"\n" + "Sale Price : "+formatted_sp +"\n"+"Margin : "+marg+"%"+"\n"+"Markup : "+mark+"%");
                    cp.setText(""+Cp);
                    sp.setText(formatted_sp);
                    margin.setText(marg+"%");
                    markup.setText(mark+"%");
                    cp.setEnabled(false);
                    sp.setEnabled(false);
                    margin.setEnabled(false);
                    markup.setEnabled(false);
                }
                else if (!sell.isEmpty() && !Margin.isEmpty() && !Markup.isEmpty()){
                    double Sp = Double.parseDouble(sell);
                    marg = Double.parseDouble(Margin);
                    mark = Double.parseDouble(Markup);
                    double Cp = ((100-marg)/100)*Sp;
                    String formatted_cp = format.format(Cp);
                    result.setText("Cost Price : "+formatted_cp +"\n" + "Sale Price : "+Sp +"\n"+"Margin : "+marg+"%"+"\n"+"Markup : "+mark+"%");
                    cp.setText(formatted_cp);
                    sp.setText(""+Sp);
                    margin.setText(marg+"%");
                    markup.setText(mark+"%");
                    cp.setEnabled(false);
                    sp.setEnabled(false);
                    margin.setEnabled(false);
                    markup.setEnabled(false);
                }
                else {
                    FancyToast.makeText(getApplicationContext(),"Please Enter atleast two values",FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
                }

            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cp.setText("");
                sp.setText("");
                margin.setText("");
                markup.setText("");
                result.setText("");
                cp.setEnabled(true);
                sp.setEnabled(true);
                margin.setEnabled(true);
                markup.setEnabled(true);
            }
        });

    }
}
