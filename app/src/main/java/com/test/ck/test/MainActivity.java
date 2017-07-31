package com.test.ck.test;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.stateviewlib.View.StateLayout;

public class MainActivity extends AppCompatActivity {
    int a;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int i = msg.what % 4;
            Log.i("TAG", "handleMessage: "+a);
            switch (i) {
                case 0:
                    stateLayout.showLoading();
                    break;
                case 1:
                    stateLayout.showEmpty("kong","sssss" ,R.mipmap.ic_launcher_round,new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(v.getContext(), "dd", 0).show();
                        }
                    });
                    break;
                case 2:
                    stateLayout.showContent();
                    break;
                case 3:
                    stateLayout.showError("cuwoeo", "sss:",R.mipmap.ic_launcher, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(v.getContext(), "dzzd", 0).show();
                        }
                    });
                    break;

            }
            a++;
            handler.sendEmptyMessageDelayed(a, 2000);
        }
    };
    private StateLayout stateLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        stateLayout = new StateLayout(this).setContent(R.layout.content);
        setContentView(stateLayout);
        ((Button)findViewById(R.id.button100)).setText("dfsssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
        handler.sendEmptyMessageDelayed(a,2000);
    }
}
