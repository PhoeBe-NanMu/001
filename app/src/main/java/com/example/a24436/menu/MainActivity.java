package com.example.a24436.menu;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;

public class MainActivity extends AppCompatActivity {


    PopupWindow popupWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onMenu(View view) {

        View popupWindowView = getLayoutInflater().inflate(R.layout.menu,null,true);
        popupWindow = new PopupWindow(popupWindowView, ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT,true);
        popupWindow.showAsDropDown(findViewById(R.id.btn_menu),0,0);

        popupWindowView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (popupWindow!= null&&popupWindow.isShowing()){
                    popupWindow.dismiss();
                    popupWindow = null;
                }

                return false;
            }
        });
    }
}
