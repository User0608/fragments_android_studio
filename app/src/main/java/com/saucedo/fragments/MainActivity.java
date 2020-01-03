package com.saucedo.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements OnClickListenerMenuItem{
    public final static String ID_ITEM_EXTRA="com.saucedo.fragments.mainAtivity.id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment,new MenuFragment()).commit();
    }


    @Override
    public void onClickItem(View viewSelect) {
        viewSelect.setBackgroundColor(ContextCompat.getColor(this,R.color.itemSelect));
        Intent intent=new Intent(MainActivity.this, SecondAntivity.class);
        intent.putExtra(MainActivity.ID_ITEM_EXTRA,viewSelect.getId());
        startActivity(intent);
    }
}
