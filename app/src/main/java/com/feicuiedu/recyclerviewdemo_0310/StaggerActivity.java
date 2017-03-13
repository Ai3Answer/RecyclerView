package com.feicuiedu.recyclerviewdemo_0310;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

// 瀑布流
public class StaggerActivity extends AppCompatActivity {

    /**
     * 1. 设置布局管理：StaggeredGridLayoutMananger
     * 2. 设置分割线、动画
     * 3. 设置适配器、设置数据(展示的数据，高度)
     */

    @BindView(R.id.recyclerView_stagger)
    RecyclerView mRecyclerView;
    private StaggerAdapter mStaggerAdapter;
    private List<String> mData;
    private List<Integer> mHeights;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stagger);
        ButterKnife.bind(this);

        initView();

        initData();
    }

    // 初始化数据
    private void initData() {

        mData = new ArrayList<>();
        mHeights = new ArrayList<>();
        for (int i='A';i<'z';i++){
            mData.add(""+(char)i);

            // 采用随机数来添加:Math.random():0-1
            mHeights.add((int) (200+Math.random()*400));
        }
        mStaggerAdapter.setData(mData, mHeights);
    }

    // 初始化视图
    private void initView() {
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));

        mStaggerAdapter = new StaggerAdapter();
        mRecyclerView.setAdapter(mStaggerAdapter);
    }
}
