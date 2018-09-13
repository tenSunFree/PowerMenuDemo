package com.example.administrator.powermenudemo;

import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import android.view.View;

import com.skydoves.powermenu.CustomPowerMenu;
import com.skydoves.powermenu.MenuAnimation;
import com.skydoves.powermenu.MenuBaseAdapter;

/** 自定義Dialog的樣式 */
public class PowerMenuUtils {

    public static CustomPowerMenu getCustomDialogPowerMenu(Context context, LifecycleOwner lifecycleOwner) {
        return new CustomPowerMenu.Builder<>(context, new MenuBaseAdapter<Object>())
                .setHeaderView(R.layout.layout_custom_dialog_header)
                .setFooterView(R.layout.layout_custom_dialog_footer)
                .setLifecycleOwner(lifecycleOwner)
                .setAnimation(MenuAnimation.SHOWUP_TOP_LEFT)
                .setWidth(800)
                .setMenuRadius(10f)
                .setMenuShadow(10f)
                .setFocusable(true)                                                                 // 點擊背景不會有反應
                .setOnBackgroundClickListener(new View.OnClickListener() {                          // 點擊背景不會有反應
                    @Override
                    public void onClick(View view) {
                    }
                }).build();
    }
}
