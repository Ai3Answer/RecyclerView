package com.feicuiedu.recyclerviewdemo_0310;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

// RecyclerView的使用
public class SecondActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private List<String> mData;
    private LinearAdapter mLinearAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);

        initView();
        initData();

    }

    // 初始化布局相关
    private void initView() {

        // 1. 设置布局管理器：让他展示的样式是什么
        // StaggeredGridLayoutManager、LinearLayoutManager、GridLayoutManager
        // ListView
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // GridLayout
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,4));

        // 2. 如果添加或删除item，可以设置动画,他为我们提供一个可以直接使用的动画：DefaultItemAnimator
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        // 3. 设置分割线:默认提供的一个：DividerItemDecoration，都可以自己定义，可以在item布局中设置
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL));

        // 4. 设置适配器
        mLinearAdapter = new LinearAdapter();
        mRecyclerView.setAdapter(mLinearAdapter);

        //设置item的点击事件
        mLinearAdapter.setOnItemClickListener(new LinearAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(SecondActivity.this, "click"+position, Toast.LENGTH_SHORT).show();
            }
        });

        // 长按事件
        mLinearAdapter.setOnItemLongClickListener(new LinearAdapter.OnItemLongClickListener() {
            @Override
            public void onItemLongClick(int position) {
                Toast.makeText(SecondActivity.this, "onlongClick"+position, Toast.LENGTH_SHORT).show();
                // 删除数据
                mLinearAdapter.removeData(position);
            }
        });
    }

    @OnClick(R.id.btnAdd)
    public void addData(){
        mLinearAdapter.addData(1);
    }

    // 数据填充
    private void initData() {
        mData = new ArrayList<>();

        for (int i='A';i<'z';i++){
            mData.add(""+(char)i);
        }
        mLinearAdapter.setData(mData);
    }
}
