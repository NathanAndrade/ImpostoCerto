package com.impostocerto.areas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import com.impostocerto.login.R;

/**
 * Created by Nathan on 26/05/2015.
 */
public class ProjectActivity extends ActionBarActivity {

    private Toolbar toolbar;                              // Declaring the Toolbar Object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projetos);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);

        Bundle extras = getIntent().getExtras();
        String title = "";
        String subtitle = "";
        if (extras != null) {
            title = extras.getString("AREA");
            subtitle = extras.getString("SUBAREA");
        }

        if (title.equals("Educação"))
            toolbar.setBackgroundColor(getResources().getColor(R.color.color_educacao));
        if (title.equals("Saúde"))
            toolbar.setBackgroundColor(getResources().getColor(R.color.color_saude));
        if (title.equals("Saneamento"))
            toolbar.setBackgroundColor(getResources().getColor(R.color.color_saneamento));
        if (title.equals("Segurança"))
            toolbar.setBackgroundColor(getResources().getColor(R.color.color_seguranca));
        if (title.equals("Transporte"))
            toolbar.setBackgroundColor(getResources().getColor(R.color.color_transporte));
        if (title.equals("Urbanização"))
            toolbar.setBackgroundColor(getResources().getColor(R.color.color_urbanizacao));
        if (title.equals("Entretenimento"))
            toolbar.setBackgroundColor(getResources().getColor(R.color.color_entretenimento));

        toolbar.setTitle(title);
        toolbar.setSubtitle(subtitle);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public void onBackPressed() {
        backToAreas();
        super.onBackPressed();
    }

    private void backToAreas() {
        Intent intent = new Intent(this, AreasActivity.class);
        startActivity(intent);
    }
}
