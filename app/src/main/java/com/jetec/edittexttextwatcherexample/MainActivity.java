package com.jetec.edittexttextwatcherexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edInput,edBinary,edOctal,edHex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edInput = findViewById(R.id.edInput);
        edBinary= findViewById(R.id.edBinary);
        edOctal = findViewById(R.id.edOctal);
        edHex   = findViewById(R.id.edHex);
//        edInput.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL|InputType.TYPE_NUMBER_FLAG_SIGNED);
        edInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d("MyTAG", "beforeTextChanged: s= "+s+", start= "
                        +start+", count= "+count+", after= "+after);

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("MyTAG", "onTextChanged: s= "+s+", start= "
                        +start+", before= "+before+", count= "+count);
                try {
                    int getVal = Integer.parseInt(String.valueOf(s));
                    edBinary.setText(Integer.toBinaryString(getVal));
                    edOctal.setText(Integer.toOctalString(getVal));
                    edHex.setText(Integer.toHexString(getVal));

                }catch (Exception e){
                    edBinary.setText("");
                    edOctal.setText("");
                    edHex.setText("");
                }


            }
            @Override
            public void afterTextChanged(Editable s) {
                Log.d("MyTAG", "afterTextChanged: s= "+s);
                Log.d("MyTAG", "=========分隔線=========");
                try {
                    int getInput = Integer.parseInt(String.valueOf(s));
                    if (getInput>500){
                        edInput.setText("500");
                        edInput.setSelection(s.length());
                    }else if (getInput<-500){
                        edInput.setText("-500");
                        edInput.setSelection(s.length());
                    }

                    if (s.toString().length() > 1 && s.toString().startsWith("0")) {
                        s.replace(0,1,"");
                    }

                }catch (Exception e){
                    edBinary.setText("");
                    edOctal.setText("");
                    edHex.setText("");
                }

            }
        });

    }
}
