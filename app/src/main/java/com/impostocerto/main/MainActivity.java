package com.impostocerto.main;

/**
 * Created by nathand on 05/05/2015.
 */
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.impostocerto.areas.ProjectDetailsActivity;
import com.impostocerto.login.LoginActivity;
import com.impostocerto.login.R;
import com.impostocerto.login.RegisterActivity;
import com.impostocerto.statistics.StatisticsFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private Toolbar toolbar;                              // Declaring the Toolbar Object
    private DrawerLayout mDrawerLayout;
    private View mDrawerContent;
    private ListView mDrawerList;
    private ListView mDrawerBottomList;
    private ActionBarDrawerToggle mDrawerToggle;
    List<DrawerItem> dataList;
    List<DrawerItem> dataBottomList;
    private CharSequence mTitle;

    CustomDrawerAdapter adapter;
    CustomDrawerAdapter bottomListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar.setTitle(R.string.closeDrawer);
        setSupportActionBar(toolbar);

        // Initializing
        dataList = new ArrayList<DrawerItem>();
        dataBottomList = new ArrayList<DrawerItem>();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.DrawerLayout);
        mDrawerContent = (View) findViewById(R.id.drawer_content_layout);
        mDrawerList = (ListView) findViewById(R.id.option_items);
        mDrawerBottomList = (ListView) findViewById(R.id.button_option_items);

        loadDrawer();

        loadUserInfo();

        if (savedInstanceState == null) {
            SelectItem(0);
        }

        mDrawerToggle.syncState(); // Finally we set the drawer toggle sync
        // State

    }

    private void loadDrawer() {
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        // Add Drawer Item to dataList
        dataList.add(new DrawerItem(OptionsBarItem.USER.id, OptionsBarItem.USER.getTitle(this),
                R.drawable.ic_home));
        dataList.add(new DrawerItem(OptionsBarItem.PERFIL.id, OptionsBarItem.PERFIL.getTitle(this),
                R.drawable.ic_home));
        dataList.add(new DrawerItem(OptionsBarItem.AJUDA.id, OptionsBarItem.AJUDA.getTitle(this),
                R.drawable.ic_home));


        dataBottomList.add(new DrawerItem(OptionsBarItem.LOGOUT.id, OptionsBarItem.LOGOUT
                .getTitle(this), R.drawable.logout));

        adapter = new CustomDrawerAdapter(this, R.layout.drawer_item, dataList);

        mDrawerList.setAdapter(adapter);

        bottomListAdapter = new CustomDrawerAdapter(this, R.layout.drawer_item,
                dataBottomList);

        mDrawerBottomList.setAdapter(bottomListAdapter);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SelectItem(position);
            }
        });
        mDrawerBottomList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SelectBottomItem(position);
            }
        });

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,
                R.string.openDrawer, R.string.closeDrawer) {
            public void onDrawerClosed(View view) {
                toolbar.setTitle(mTitle);
                invalidateOptionsMenu(); // creates call to
                // onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View drawerView) {
                invalidateOptionsMenu(); // creates call to
                // onPrepareOptionsMenu()
            }
        };

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    private void loadUserInfo() {
        final TextView userName = (TextView) mDrawerLayout.findViewById(R.id.user_name);
        final TextView userEmail = (TextView) mDrawerLayout.findViewById(R.id.user_email);

        userName.setText(getSharedPreferences(RegisterActivity.RegPREFERENCES, Context.MODE_PRIVATE).getString(RegisterActivity.rName, "Nathan").toString());
        userEmail.setText(getSharedPreferences(RegisterActivity.RegPREFERENCES, Context.MODE_PRIVATE).getString(RegisterActivity.rEmail, "nathan@gmail").toString());
    }

    public void SelectItem(int position) {
        if (mDrawerList != null) {
            mDrawerList.setItemChecked(position, true);
        }
        // Handle
        final DrawerItem item = dataList.get(position);
        onSelectDrawerItem(item);
    }

    private void SelectBottomItem(int position) {
        if (mDrawerBottomList != null) {
            mDrawerBottomList.setItemChecked(position, true);
        }
        // Handle
        final DrawerItem item = dataBottomList.get(position);
        onSelectDrawerItem(item);
    }

    private void onSelectDrawerItem(final DrawerItem item) {
        Fragment fragment = null;
        Bundle args = new Bundle();
        final Integer imgResID = item.getImgResID();
        final String itemName = item.getItemName();
        final int id = item.getId();
        if (id == OptionsBarItem.USER.id) {
            fragment = showStatistics();
        } else if (id == OptionsBarItem.LOGOUT.id) {
            logout();
            return;
        }
        if (fragment == null) {
            return;
        }

        fragment.setArguments(args);
        FragmentManager frgManager = getFragmentManager();
        frgManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

        mTitle = itemName;
        mDrawerLayout.closeDrawers();
    }

    private StatisticsFragment showStatistics() {
        StatisticsFragment fragment = new StatisticsFragment();
        return fragment;
    }

    public void logout(){
        SharedPreferences sharedpreferences = getSharedPreferences
                (LoginActivity.MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.clear();
        if (editor.commit()) {
            moveTaskToBack(true);
            MainActivity.this.finish();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
    }
}