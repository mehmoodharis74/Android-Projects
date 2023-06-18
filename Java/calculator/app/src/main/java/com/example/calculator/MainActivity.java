package com.example.calculator;

import static android.graphics.Color.*;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;

import android.graphics.Color;
import android.os.Bundle;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.Stack;


public class MainActivity extends AppCompatActivity {
   public TextView frontScreen, backScreen;
    public String final_string="0";
    public long n=0L;
    public long mod_num=0L;
    public boolean chck=true;
    public String neg_start_check="";


    public int precedence(char ch){
    if(ch=='+' || ch=='-'){
        return 1;
    }
    else if(ch=='*' || ch=='/'){
        return 2;
    }
    else if(ch=='^')
        return 3;
    else{
        return 0;
    }
}
public boolean checksOperand(char op) {
    return op == '+' || op == '-' ||
            op == '^' || op == '*' ||
            op == '/' ||
             op == '%';
}

public  void reset(){

    backScreen.setText("");
    frontScreen.setText("0");
    final_string="0";
}
//all clear button method
@SuppressLint("SetTextI18n")
public  void  allClear(){
    reset();
}

@SuppressLint("SetTextI18n")
public void equalButtonMethod(){



    if(frontScreenClear()||!chck)
        return;
    else {
        int temp=final_string.indexOf('.');
      // if(backScreen.getText().toString().equals(""))
        backScreen.setText(final_string + "=");
        if(temp>=0)
            final_string=calculate_decimal_numbers(infix_to_postfix(final_string));
        else
        final_string = calculate(infix_to_postfix(final_string));

        if(final_string.charAt(final_string.length()-1)=='0'&& !final_string.equals("0")&&temp>=0){
            final_string=final_string.substring(0,final_string.length()-1);
            final_string=final_string.substring(0,final_string.length()-1);
        }
        frontScreen.setText(final_string);
    }
    chck=false;
}

public long calcMod(long n, long mod_num){
    this.n=n;
    this.mod_num=mod_num;
    while(this.n >= this.mod_num)
        this.n -= this.mod_num;
    return this.n;
}

//front screen clear method
public boolean frontScreenClear(){
   // TextView frontScreen=findViewById(R.id.main_screen_text);

    //||(frontScreen.getText().charAt(frontScreen.getText().toString().length() - 1) == '.' && frontScreen.getText().toString().equals( "0"))
    return (frontScreen.getText().toString().equals("0") || frontScreen.length() == 0)  ||
            (frontScreen.getText().charAt(frontScreen.getText().toString().length() - 1) == '.' )||
            (checksOperand(frontScreen.getText().charAt(frontScreen.getText().toString().length() - 1)));
}

public void set_string(String pressed_button){
    chck=true;

        if (checksOperand(pressed_button.charAt(0))&&(final_string.equals("0")||checksOperand(final_string.charAt(final_string.length()-1)))
        )
            if(final_string.equals("0")&&pressed_button.equals("-")){ neg_start_check="-";}
            else
            return;
    if(final_string.equals("0")&&!pressed_button.equals("."))
        final_string="";

    if((pressed_button.equals(".")&&
                (checksOperand(frontScreen.getText().charAt(frontScreen.getText().toString().length() - 1)))))
        final_string+="0";
        final_string+=pressed_button;

        frontScreen.setText(final_string);
    }
    public String infix_to_postfix(String infix){
        StringBuilder postfix= new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<infix.length();i++){
            char ch = infix.charAt(i);
            if(checksOperand(ch)){
                while(!stack.isEmpty() && stack.peek()!='(' && precedence(stack.peek())>=precedence(ch)){
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            }
            else if(ch=='('){
                stack.push(ch);
            }
            else if(ch==')'){
                while(!stack.isEmpty() && stack.peek()!='('){
                    postfix.append(stack.pop());
                }
                stack.pop();
            }
            else{
                postfix.append(ch);
                if((i+1>=infix.length())||checksOperand(infix.charAt(i+1))) postfix.append('@');
            }
        }
        while(!stack.isEmpty()){
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }

    //calculate the postfix string

    public String calculate(String postfix){
        
        Stack<Long> stack = new Stack<>();
        StringBuilder tmp_num= new StringBuilder();
        for(int i=0;i<postfix.length();i++){
            char ch = postfix.charAt(i);
           if(ch=='@'){
               stack.push(Long.parseLong(tmp_num.toString()));
               tmp_num = new StringBuilder();
           }
            else if(checksOperand(ch)){
                Long val1 = stack.pop();
                Long val2 = stack.pop();
                if(ch=='+'){
                    stack.push(val2+val1);
                }
                else if(ch=='-'){
                    stack.push(val2-val1);
                }
                else if(ch=='*'){
                    stack.push(val2*val1);
                }
                else if(ch=='/'){
                    stack.push(val2/val1);
                }
                else if(ch=='%')
                    stack.push(calcMod(val2,val1));
                else if(ch=='^'){
                    stack.push((long) Math.pow(val2,val1));
                }
            }
            else{
                tmp_num.append(ch);
                
            }
        }
        return stack.pop().toString();
    }
    //calculate decimal numbers
    public String calculate_decimal_numbers(String postfix){

        Stack<Double> stack = new Stack<>();
        StringBuilder tmp_num = new StringBuilder();
        for(int i=0;i<postfix.length();i++){
            char ch = postfix.charAt(i);
           if(ch=='@'){
               stack.push(Double.parseDouble(tmp_num.toString()));
               tmp_num = new StringBuilder();
           }
            else if(checksOperand(ch)){
                Double val1 = stack.pop();
                Double val2 = stack.pop();
                if(ch=='+'){
                    stack.push(val2+val1);
                }
                else if(ch=='-'){
                    stack.push(val2-val1);
                }
                else if(ch=='*'){
                    stack.push(val2*val1);
                }
                else if(ch=='/'){
                    stack.push(val2/val1);
                }

                else if(ch=='^'){
                    stack.push(Math.pow(val2,val1));
                }
            }
            else{
                tmp_num.append(ch);

            }
        }
        return stack.pop().toString();
    }


//function to detect if dark mode is on or off
    public boolean isDarkModeOn(){
        int nightModeFlags =
                this.getResources().getConfiguration().uiMode &
                        android.content.res.Configuration.UI_MODE_NIGHT_MASK;
        switch (nightModeFlags) {
            case android.content.res.Configuration.UI_MODE_NIGHT_YES:
                return true;
            case android.content.res.Configuration.UI_MODE_NIGHT_NO:
            case android.content.res.Configuration.UI_MODE_NIGHT_UNDEFINED:
                return false;
        }
        return false;
    }
    @SuppressLint("UseCompatLoadingForDrawables")
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frontScreen=findViewById(R.id.main_screen_text);
        backScreen=findViewById(R.id.small_screen_text);
        Button equal=findViewById(R.id.btn_equal);
        Button ac=findViewById(R.id.btn_ac);
        Button del=findViewById(R.id.btn_c);
        Button div=findViewById(R.id.btn_div);
        Button mul=findViewById(R.id.btn_mul);
        Button sub=findViewById(R.id.btn_sub);
        Button add=findViewById(R.id.btn_add);
        Button dot=findViewById(R.id.btn_dot);
        Button btn9=findViewById(R.id.btn_9);
        Button btn8=findViewById(R.id.btn_8);
        Button btn7=findViewById(R.id.btn_7);
        Button btn6=findViewById(R.id.btn_6);
        Button btn5=findViewById(R.id.btn_5);
        Button btn4=findViewById(R.id.btn_4);
        Button btn3=findViewById(R.id.btn_3);
        Button btn2=findViewById(R.id.btn_2);
        Button btn1=findViewById(R.id.btn_1);
        Button btn0=findViewById(R.id.btn_0);
        Button pow=findViewById(R.id.btn_pow);
        Button mod=findViewById(R.id.btn_mod);
        LinearLayout buttonTopLayout=findViewById(R.id.buttonTopLayout);
        LinearLayout buttonsLayout=findViewById(R.id.buttons_layout);

        //set background of button layout to black if dark mode is enabled
        if(isDarkModeOn()){
            buttonsLayout.setBackgroundColor(Color.parseColor("#1a1a1a"));
            frontScreen.setTextColor(WHITE);
            backScreen.setTextColor(WHITE);
            //set button top layout background to drawable top button shape
            buttonTopLayout.setBackground(getDrawable(R.drawable.top_button_shape));
        }
        else{
            buttonsLayout.setBackgroundColor(Color.parseColor("#f2f2f2"));
            frontScreen.setTextColor(BLACK);
            backScreen.setTextColor(BLACK);
            //set button top layout to #f4f8f9
            buttonTopLayout.setBackground(getDrawable(R.drawable.top_button_shape_white));
        }

        ac.setOnClickListener(view-> allClear());
        equal.setOnClickListener(view->equalButtonMethod());
        del.setOnClickListener(view->{
            //remove last character of final string
            if(final_string.length()>0){
                final_string=final_string.substring(0,final_string.length()-1);
            }
            if(final_string.length()==0){
                final_string="0";
            }
            frontScreen.setText(final_string);
            
        });
        div.setOnClickListener(view->{
            Button b = (Button)view;
            
            set_string(b.getText().toString());
            
        });
        mul.setOnClickListener(view->{
            Button b = (Button)view;
            set_string(b.getText().toString());
            
        });
        mod.setOnClickListener(view->set_string("%"));
        pow.setOnClickListener(view->{
            Button b=(Button)view;
            set_string(b.getText().toString());
        });
        sub.setOnClickListener(view->{
            Button b = (Button)view;
            set_string(b.getText().toString());
            
        });
        add.setOnClickListener(view->{
            Button b = (Button)view;
            set_string(b.getText().toString());
            

        });
        dot.setOnClickListener(view->{
            Button b = (Button)view;
            set_string(b.getText().toString());
            

        });
        
        btn0.setOnClickListener(view->{
            Button b = (Button)view;
            set_string(b.getText().toString());
            

        });
        btn1.setOnClickListener(view->{
            Button b = (Button)view;
            set_string(b.getText().toString());
            
        });
        btn2.setOnClickListener(view->{
            Button b = (Button)view;
            set_string(b.getText().toString());
            

        });
        btn3.setOnClickListener(view->{
            Button b = (Button)view;
            set_string(b.getText().toString());
            

        });
        btn4.setOnClickListener(view->{
            Button b = (Button)view;
            set_string(b.getText().toString());
            

        });
        btn5.setOnClickListener(view->{
            Button b = (Button)view;
            set_string(b.getText().toString());
            
        });
        btn6.setOnClickListener(view->{
            Button b = (Button)view;
            set_string(b.getText().toString());
            
        });
        btn7.setOnClickListener(view->{
            Button b = (Button)view;
            set_string(b.getText().toString());
            
        });
        btn8.setOnClickListener(view->{
            Button b = (Button)view;
            set_string(b.getText().toString());
            
        });
        btn9.setOnClickListener(view->{
            Button b = (Button)view;
            set_string(b.getText().toString());
            
        });

    }
}