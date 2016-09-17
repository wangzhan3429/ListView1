package com.wz.thelast;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

/**
 * 可以实现listview头部悬浮效果
 * @author wangzhan
 *
 */
public class MainActivity extends Activity {

	private LinearLayout invis;
    private ListView lv;
    String[] strs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        invis = (LinearLayout) findViewById(R.id.invis);

        strs = new String[100];

        for (int i = 0; i < 100; i++) {
            strs[i] = "data-----" + i;
        }

        lv = (ListView) findViewById(R.id.lv);
        View header1 = View.inflate(this, R.layout.first, null);//头部内容
        lv.addHeaderView(header1);//添加头部

        View header2 = View.inflate(this, R.layout.second, null);
        lv.addHeaderView(header2);

        lv.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, strs));
        lv.setOnScrollListener(new AbsListView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (firstVisibleItem >= 1) {
                    invis.setVisibility(View.VISIBLE);
                } else {
                    invis.setVisibility(View.GONE);
                }
            }
        });

    }
	
}
