package com.impostocerto.statistics;


import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.impostocerto.areas.AreasActivity;
import com.impostocerto.areas.ProjectDetailsActivity;
import com.impostocerto.login.R;
import com.melnykov.fab.FloatingActionButton;
import com.melnykov.fab.ObservableScrollView;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.PieChartView;

/**
 * Created by nathand on 06/05/2015.
 */
public class StatisticsFragment extends Fragment {

    private PieChartView chart;
    private PieChartData data;

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

        Button ver_projeto = (Button) view.findViewById(R.id.icon2);
        ver_projeto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ProjectDetailsActivity.class);
                startActivity(intent);
            }
        });

        chart = (PieChartView) view.findViewById(R.id.chart);

        generateData();

        return view;
    }

    private void generateData() {
        List<SliceValue> values = new ArrayList<SliceValue>();

        SliceValue sliceSaude = new SliceValue((float) 12, getResources().getColor(R.color.color_saude));
        values.add(sliceSaude);
        SliceValue sliceEducacao = new SliceValue((float) 18, getResources().getColor(R.color.color_educacao));
        values.add(sliceEducacao);
        SliceValue sliceEntretenimento = new SliceValue((float) 22, getResources().getColor(R.color.color_entretenimento));
        values.add(sliceEntretenimento);
        SliceValue sliceSaneamento = new SliceValue((float)8, getResources().getColor(R.color.color_saneamento));
        values.add(sliceSaneamento);
        SliceValue sliceSeguranca = new SliceValue((float) 26, getResources().getColor(R.color.color_seguranca));
        values.add(sliceSeguranca);
        SliceValue sliceTransporte = new SliceValue((float) 4, getResources().getColor(R.color.color_transporte));
        values.add(sliceTransporte);
        SliceValue sliceUrbanizacao = new SliceValue((float) 10, getResources().getColor(R.color.color_urbanizacao));
        values.add(sliceUrbanizacao);

        data = new PieChartData(values);
        data.setHasLabels(true);
        data.setHasCenterCircle(true);
        data.setSlicesSpacing(2);
        data.setCenterText1("(%)");

        chart.setPieChartData(data);
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
