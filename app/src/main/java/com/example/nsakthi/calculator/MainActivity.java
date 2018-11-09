package com.example.nsakthi.calculator;

import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.util.Stack;

public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {

    MyRecyclerViewAdapter adapter;
    Stack<String> stack = new Stack<String>();
    String mystring = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // data to populate the RecyclerView with
        String[] data = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "+","-","*","/"};

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvNumbers);
        int numberOfColumns = 5;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        adapter = new MyRecyclerViewAdapter(this, data);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Log.i("TAG", "You clicked number " + adapter.getItem(position) + ", which is at cell position " + position);
    }

    public void mybutton(View V)
    {
        Log.d("sak", "mybutton");
        Button b = (Button)V;
        String buttonText = b.getText().toString();
        mystring = mystring+buttonText;
        Toast.makeText(getBaseContext(), buttonText , Toast.LENGTH_SHORT).show();
        stack.push(buttonText);
        EditText myText = (EditText) this.findViewById(R.id.Selection);

// Setting the text:
        myText.setText( mystring );

    }
    public void myoperation(View V)
    {
        String a1;
        if(stack.size() == 0 )
            a1 = 0+"";
        else
            a1 = stack.pop().toString();
        String op;
        if(stack.size() == 0 )
            op = "+";
        else
            op = stack.pop().toString();

        String b1 ;
        if(stack.size() == 0 )
            b1 = 0+"";
        else
            b1 = stack.pop().toString();
        Log.d("sak",a1);
        int a = Integer.parseInt(a1);

        if( b1== null)
            b1 = 0+"";
        Log.d("sak",b1);
        int b = Integer.parseInt(b1);
        int c;
        switch (op) {
            case "+":
                c= a+b ;
                break;
            case "-":
                c= b-a ;
                break;
            case "*":
                c= a*b ;
                break;
            case "/":
                c= a/b ;
                break;
            default:
                c= a+b;
                break;
        }


        Log.d("sak",c+"");
        Button button = (Button)findViewById(R.id.Result);
        button.setText(c+"");
        stack.clear();

    }

    public void mysub(View V)
    {
        String a1;
        if(stack.size() == 0 )
            a1 = 0+"";
        else
            a1 = stack.pop().toString();
        String b1 ;
        if(stack.size() == 0 )
            b1 = 0+"";
        else
            b1 = stack.pop().toString();
        Log.d("sak",a1);
        int a = Integer.parseInt(a1);

        if( b1== null)
            b1 = 0+"";
        Log.d("sak",b1);
        int b = Integer.parseInt(b1);

        int c = a+b ;
        Log.d("sak",c+"");
        Button button = (Button)findViewById(R.id.Result);
        button.setText(c+"");

    }

}