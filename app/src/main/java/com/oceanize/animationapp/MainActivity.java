package com.oceanize.animationapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView list_item;
    RelativeLayout title;
List<Item> itemList;
    ItemAdapter itemAdapter;
    LinearLayoutManager lm;
    private ClickInterface mClick = new ClickInterface() {
        @Override
        public void onItemClick(int position) {

       // Item item=list_item.getI
            Log.e("Click", position + "");

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CorrectSizeUtil.getInstance(this).correctSize(findViewById(R.id.root));

        list_item=(RecyclerView)findViewById(R.id.list_item);
        title=(RelativeLayout)findViewById(R.id.title);
        setScrollState();
        itemList=Data.getData();
        lm = new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        list_item.setLayoutManager(lm);

        itemAdapter = new ItemAdapter(this, itemList, mClick);
        list_item.setAdapter(itemAdapter);
    }



    private void setScrollState() {
        list_item.addOnScrollListener(new RecyclerView.OnScrollListener() {
            int over = 0;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (lm.findFirstVisibleItemPosition() == 0) {
                    View v = lm.findViewByPosition(0);
                    if (v != null) {
                        scrollHeader(-v.getTop());

                    }
                }
            }
        });
    }

    private void scrollHeader(int top) {
        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) title.getLayoutParams();
        lp.topMargin = -top;

        title.setLayoutParams(lp);
    }
}
