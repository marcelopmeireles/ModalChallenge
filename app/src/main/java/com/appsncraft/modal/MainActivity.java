package com.appsncraft.modal;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;

import com.appsncraft.modal.layout.MyDialog;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.modal_bottom);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.modal_bottom) {
            MyDialog dialog = new MyDialog();
            dialog.show(fm, "MyDialog");
        }
    }

}
