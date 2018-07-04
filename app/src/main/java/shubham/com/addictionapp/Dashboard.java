package shubham.com.addictionapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

public class Dashboard extends AppCompatActivity {

    RelativeLayout rellay_timeline, rellay_user, rellay_music, rellay_chat, rellay_box1,rellay_box2, rellay_box3, rellay_box4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        rellay_timeline = findViewById(R.id.rellay_timeline);
        rellay_user = findViewById(R.id.rellay_user);
        rellay_music = findViewById(R.id.rellay_music);
        rellay_chat = findViewById(R.id.rellay_chat);
        rellay_box1 = findViewById(R.id.rellay_box1);
        rellay_box2 = findViewById(R.id.rellay_box2);
        rellay_box3 = findViewById(R.id.rellay_box3);
        rellay_box4 = findViewById(R.id.rellay_box4);

        rellay_timeline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Dashboard.this, Timeline.class);
                i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(i);
            }
        });

        rellay_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Dashboard.this, Timeline2.class);
                i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(i);
            }
        });

        rellay_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Dashboard.this, Timeline3.class);
                i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(i);
            }
        });

        rellay_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Dashboard.this, Timeline4.class);
                i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(i);
            }
        });

    }
}
