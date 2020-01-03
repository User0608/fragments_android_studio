package com.saucedo.fragments;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import static android.view.View.*;

public class MenuFragment extends Fragment{
    private int[] menuItems={ R.id.menu_time,R.id.menu_storage,R.id.menu_settings};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_fragment,container,false);
        this.setListenerItems(view);
        return view;
    }

    private void setListenerItems(final View view){
        for (int i=0;i<menuItems.length;i++){
            view.findViewById(menuItems[i]).setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    resetColor(view);
                    ((OnClickListenerMenuItem)getActivity()).onClickItem(v);
                }
            });
        }

    }
    private void resetColor(final View view){
        for (int i=0;i<menuItems.length;i++){
            view.findViewById(menuItems[i]).setBackgroundColor(ContextCompat.getColor(getContext(),R.color.item));
        }
    }
}
