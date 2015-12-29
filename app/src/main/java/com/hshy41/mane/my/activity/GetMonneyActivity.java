package com.hshy41.mane.my.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hshy41.mane.R;
import com.hshy41.mane.adapter.recyclerviewadapter.GetMonney;
import com.hshy41.mane.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 赚钱页面
 *
 * @author lichao
 */
public class GetMonneyActivity extends BaseActivity implements View.OnClickListener {

    /**
     * 数据源
     */
    List<Drawable> mData = new ArrayList<Drawable>();
    /**
     * 赚钱信息列表
     */

    private RecyclerView rv_getMonney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int setContent() {
        return R.layout.activity_getmonney;
    }

    @Override
    protected void initViews() {
        for (int i = 0; i < 10; i++)
            mData.add(getResources().getDrawable(R.drawable.ad1));
        rv_getMonney = (RecyclerView) findViewById(R.id.rv_getmonney);
        rv_getMonney.setHasFixedSize(true);
        GetMonney adpater = new GetMonney(this, mData);
        adpater.setOnItemClickLitener(new GetMonney.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(GetMonneyActivity.this, ADActivity.class);
                startActivity(intent);
            }
        });
        rv_getMonney.setAdapter(adpater);
        rv_getMonney.setLayoutManager(new LinearLayoutManager(this));
        rv_getMonney.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    protected void initTitleBar() {
        rl_title_left = (RelativeLayout) findViewById(R.id.rl_title_left);
        rl_title_right = (RelativeLayout) findViewById(R.id.rl_title_right);
        iv_title_gps = (ImageView) findViewById(R.id.iv_title_gps);
        tv_title_text = (TextView) findViewById(R.id.tv_title_text);
        tv_title_right = (TextView) findViewById(R.id.tv_title_right);
        bt_title_right = (Button) findViewById(R.id.bt_title_right);
        bt_title_left = (Button) findViewById(R.id.bt_title_left);
        tv_title_right = (TextView) findViewById(R.id.tv_title_right);
    }

    @Override
    protected void setTitleBar() {
        rl_title_left.setVisibility(View.VISIBLE);
        rl_title_right.setVisibility(View.GONE);
        iv_title_gps.setVisibility(View.GONE);
        tv_title_text.setVisibility(View.VISIBLE);
        bt_title_right.setVisibility(View.GONE);
        bt_title_left.setVisibility(View.VISIBLE);
        tv_title_right.setVisibility(View.GONE);

        tv_title_text.setText(R.string.getmonney);

        bt_title_left.setOnClickListener(this);
        rl_title_left.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_title_left:
            case R.id.bt_title_left:
                finish();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}
