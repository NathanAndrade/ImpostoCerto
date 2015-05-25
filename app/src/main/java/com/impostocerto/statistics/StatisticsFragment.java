package com.impostocerto.statistics;


import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.impostocerto.areas.AreasActivity;
import com.impostocerto.login.R;
import com.melnykov.fab.FloatingActionButton;
import com.melnykov.fab.ObservableScrollView;

/**
 * Created by nathand on 06/05/2015.
 */
public class StatisticsFragment extends Fragment {

    public StatisticsFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_statistics, container, false);
        ObservableScrollView stats_scrollView = (ObservableScrollView) view.findViewById(R.id.stats_scrollview);
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.attachToScrollView(stats_scrollView);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callAreas();
            }
        });

        return view;
    }

    private void callAreas() {
        Intent intent = new Intent(getActivity(), AreasActivity.class);
        startActivity(intent);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

}
