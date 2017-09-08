package cn.edu.fjnu.realtimecolor.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import cn.edu.fjnu.realtimecolor.activity.BrowserActivity;
import cn.edu.fjnu.realtimecolor.data.ConstData;

/**
 * Created by Administrator on 2017\9\2 0002.
 * 规律分析模块
 */

public class RegularFragment extends ListFragment {
    public static final String[] HEADERS = new String[]{"红球", "篮球"};
    public static final String[] URLS = {
            "http://b.zhcw.com/chart/ZSSQ/SSQ_hongqiu.html",
            "http://b.zhcw.com/chart/ZSSQ/SSQ_lanqiu.html"
    };

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, HEADERS);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), BrowserActivity.class);
                intent.putExtra(ConstData.IntentKey.WEB_LOAD_URL, URLS[i]);
                startActivity(intent);
            }
        });
    }
}
