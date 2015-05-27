package com.impostocerto.areas;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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

        final Bundle extras = getIntent().getExtras();
        String title = "";
        String subtitle = "";
        if (extras != null) {
            title = extras.getString("AREA");
            subtitle = extras.getString("SUBAREA");
        }

        if (title.equals("Educação"))
            tintActionBar(getResources().getColor(R.color.color_educacao), getResources().getColor(R.color.color_educacao));
        if (title.equals("Saúde"))
            tintActionBar(getResources().getColor(R.color.color_saude), getResources().getColor(R.color.color_saude));
        if (title.equals("Saneamento"))
            tintActionBar(getResources().getColor(R.color.color_saneamento), getResources().getColor(R.color.color_saneamento));
        if (title.equals("Segurança"))
            tintActionBar(getResources().getColor(R.color.color_seguranca), getResources().getColor(R.color.color_seguranca));
        if (title.equals("Transporte"))
            tintActionBar(getResources().getColor(R.color.color_transporte), getResources().getColor(R.color.color_transporte));
        if (title.equals("Urbanização"))
            tintActionBar(getResources().getColor(R.color.color_urbanizacao), getResources().getColor(R.color.color_urbanizacao));
        if (title.equals("Entretenimento"))
            tintActionBar(getResources().getColor(R.color.color_entretenimento), getResources().getColor(R.color.color_entretenimento));

        toolbar.setTitle(title);
        toolbar.setSubtitle(subtitle);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        ListView list_projetos = (ListView) findViewById(R.id.list_subareas);

        String[] values = new String[] { "Construção de Centro de Saúde no Parque Oziel" };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.list_item_project, R.id.project_title, values);

        list_projetos.setAdapter(adapter);

        final String finalTitle = title;
        final String finalSubtitle = subtitle;
        list_projetos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ProjectActivity.this, ProjectDetailsActivity.class);
                if (extras != null) {
                    intent.putExtra("AREA", finalTitle);
                    intent.putExtra("SUBAREA", finalSubtitle);
                }
                startActivity(intent);
            }
        });
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void tintActionBar(int color_ab, int color_sb) {
        toolbar.setBackgroundColor(color_ab);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(color_sb);
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
