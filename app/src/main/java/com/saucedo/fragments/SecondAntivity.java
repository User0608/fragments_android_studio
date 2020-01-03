package com.saucedo.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SecondAntivity extends AppCompatActivity implements OnClickListenerMenuItem {
    private Fragment containerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, new MenuFragment()).commit();
        int id = getIntent().getExtras().getInt(MainActivity.ID_ITEM_EXTRA);
        atenderClickItem(id);
    }
    @Override
    public void onClickItem(View viewSelect) {
        this.atenderClickItem(viewSelect.getId());
    }

    private void atenderClickItem(int iditem) {
        switch (iditem) {
            case R.id.menu_time:
                containerFragment = new TimeFragment();
                break;
            case R.id.menu_storage:
                containerFragment = new StorageFragment();
                break;
            case R.id.menu_settings:
                containerFragment = new SettingFragment();
                break;
        }

        if (this.containerFragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment, containerFragment).commit();
        }
    }
}
