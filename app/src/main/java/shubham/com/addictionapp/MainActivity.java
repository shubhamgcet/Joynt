package shubham.com.addictionapp;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ViewPager mslideviewpager;
    private SliderAdapter sliderAdapter;
    private LinearLayout mDotLayout;
    private TextView[] mDots;
    private Button btn_next;
    private Button btn_back;
    private int mCurrentPage;
    private PrefManager prefManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Checking for first time launch - before calling setContentView()
        prefManager = new PrefManager(this);
        if (!prefManager.isFirstTimeLaunch()) {
            launchHomeScreen();
            finish();
        }
        setContentView(R.layout.activity_main);
        mslideviewpager=(ViewPager)findViewById(R.id.slideviewpager);
        mDotLayout=(LinearLayout)findViewById(R.id.dotsLayout);
        btn_next=(Button)findViewById(R.id.btn_next);
        btn_back=(Button)findViewById(R.id.btn_back);

        sliderAdapter = new SliderAdapter(this);
        mslideviewpager.setAdapter(sliderAdapter);
        addDotIndicator(0);
        mslideviewpager.addOnPageChangeListener(viewListner);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int current = getItem(+1);
                if (current < mDots.length) {
                    // move to next screen
                    mslideviewpager.setCurrentItem(mCurrentPage+1);
                } else {
                    launchHomeScreen();
                }

            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mslideviewpager.setCurrentItem(mCurrentPage-1);
            }
        });

    }
    public  void addDotIndicator(int position){
        mDots=new TextView[3];
        for(int i=0;i<mDots.length;i++)
        {
            mDots[i]=new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colourTransparentWhite));
            mDotLayout.addView(mDots[i]);
        }

        if(mDots.length>0)
        {
            mDots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }
    private int getItem(int i) {
        return mslideviewpager.getCurrentItem() + i;
    }
    private void launchHomeScreen() {
        prefManager.setFirstTimeLaunch(false);
        startActivity(new Intent(MainActivity.this,Second.class));
        finish();
    }

    ViewPager.OnPageChangeListener viewListner = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {


        }

        @Override
        public void onPageSelected(int i) {
            addDotIndicator(i);
            mCurrentPage=i;
            if(i==0)
            {
                btn_next.setEnabled(true);
                btn_back.setEnabled(false);
                btn_back.setVisibility(View.INVISIBLE);
                btn_next.setText("NEXT");
                btn_back.setText("");
            }
            else if(i== mDots.length-1)
            {
                btn_next.setEnabled(true);
                btn_back.setEnabled(true);
                btn_back.setVisibility(View.VISIBLE);
                btn_next.setText("FINISH");
                btn_back.setText("BACK");
            }
            else{
                btn_next.setEnabled(true);
                btn_back.setEnabled(true);
                btn_back.setVisibility(View.VISIBLE);
                btn_next.setText("NEXT");
                btn_back.setText("BACK");
            }

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
