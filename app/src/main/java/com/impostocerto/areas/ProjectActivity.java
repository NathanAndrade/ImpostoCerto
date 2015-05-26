package com.impostocerto.areas;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.impostocerto.login.R;

/**
 * Created by Nathan on 26/05/2015.
 */
public class ProjectActivity extends ActionBarActivity {

    private Toolbar toolbar;                              // Declaring the Toolbar Object

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
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

        String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2" };

        if (title.equals("Educação")) {
            toolbar.setBackgroundColor(getResources().getColor(R.color.color_educacao));
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.color_educacao));
        }if (title.equals("Saúde")) {
            toolbar.setBackgroundColor(getResources().getColor(R.color.color_saude));
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.color_saude));
        }
        if (title.equals("Saneamento")){
            toolbar.setBackgroundColor(getResources().getColor(R.color.color_saneamento));
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.color_saneamento));
        }if (title.equals("Segurança")) {
            toolbar.setBackgroundColor(getResources().getColor(R.color.color_seguranca));
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.color_seguranca));
        }if (title.equals("Transporte")) {
            toolbar.setBackgroundColor(getResources().getColor(R.color.color_transporte));
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.color_transporte));
        }if (title.equals("Urbanização")) {
            toolbar.setBackgroundColor(getResources().getColor(R.color.color_urbanizacao));
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.color_urbanizacao));
        }if (title.equals("Entretenimento")) {
            toolbar.setBackgroundColor(getResources().getColor(R.color.color_entretenimento));
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.color_entretenimento));
        }

        toolbar.setTitle(title);
        toolbar.setSubtitle(subtitle);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        ListView list_projetos = (ListView) findViewById(R.id.list_subareas);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.list_item_project, R.id.project_title, values);

        list_projetos.setAdapter(adapter);
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
