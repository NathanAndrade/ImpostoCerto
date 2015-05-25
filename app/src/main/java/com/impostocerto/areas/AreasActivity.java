package com.impostocerto.areas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.impostocerto.login.LoginActivity;
import com.impostocerto.login.R;
import com.impostocerto.main.MainActivity;

/**
 * Created by Nathan on 05/05/2015.
 */
public class AreasActivity extends ActionBarActivity {

    private Toolbar toolbar;                              // Declaring the Toolbar Object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_areas);

    /* Assinging the toolbar object ot the view
    and setting the the Action bar to our toolbar
     */
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar.setTitle("Selecione uma Area");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public void onBackPressed() {
        discardVote();
        super.onBackPressed();
    }

    private void discardVote() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
