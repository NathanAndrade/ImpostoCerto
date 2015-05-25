package com.impostocerto.main;

import android.content.Context;

import com.impostocerto.login.R;

public enum OptionsBarItem {
    USER(0, R.string.closeDrawer), PERFIL(1,R.string.profile), AJUDA(2, R.string.help),  LOGOUT(99, R.string.logout), ;
    
    public final int id;
    private final String title;
    private int resourceId;
    
    private OptionsBarItem(int id, String title) {
        this.id = id;
        this.title = title;
        this.resourceId = -1;
    }
    
    private OptionsBarItem(int id, int titleResourceId) {
        this.id = id;
        this.title = null;
        this.resourceId = titleResourceId;
    }
    
    public String getTitle(Context context) {
        if (title != null) {
            return title;
        }
        if (this.resourceId >= 0) {
            return context.getString(this.resourceId);
        }
        return null;
    }
}
