package com.gharin.belajarloginregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    UserModel userModel;
    SaveShared saveShared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveShared = new SaveShared(this);
        setData();
    }

    private void setData() {
        userModel = saveShared.getUser();

        String nama = userModel.getName();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuLogout:
                userModel = saveShared.getUser();
                userModel.setStatusLogin(false);
                saveShared.setUser(userModel);
                startActivity(new Intent(MainActivity.this, LoginAct.class));
                finish();
                break;

            case R.id.setting:
                startActivity(new Intent(MainActivity.this, SettingAct.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
