package com.example.shapechanger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void moveShapes(View view) {
        int curr=((Shapes)view).getSelectedindex();
        ((Shapes)view).setSelectedindex((curr+1)%3);
        ((Shapes)view).invalidate();
        Toast.makeText(this,"you selected "+((Shapes)view).getSelectedShape(),Toast.LENGTH_SHORT).show();
    }
}
