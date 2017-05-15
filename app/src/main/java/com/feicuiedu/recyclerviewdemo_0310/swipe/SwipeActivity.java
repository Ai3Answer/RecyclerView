package com.feicuiedu.recyclerviewdemo_0310.swipe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.feicuiedu.recyclerviewdemo_0310.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SwipeActivity extends AppCompatActivity {

    @BindView(R.id.lvSwipe)
    ListView mLvSwipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_main);
        ButterKnife.bind(this);

        ListViewAdapter adapter = new ListViewAdapter(this);
        mLvSwipe.setAdapter(adapter);
    }
}
