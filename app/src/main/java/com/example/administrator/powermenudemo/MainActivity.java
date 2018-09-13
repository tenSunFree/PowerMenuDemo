package com.example.administrator.powermenudemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.skydoves.powermenu.CustomPowerMenu;

import de.hdodenhof.circleimageview.CircleImageView;
import me.zhouzhuo.zzhorizontalprogressbar.ZzHorizontalProgressBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout enterLinearLayout, cancelLinearLayout;
    private View layoutView, headerView, footerView;
    private CardView charmanderCardView, pikachuCardView, squirtleCardView;
    private CustomPowerMenu customDialogMenu;
    private CircleImageView avatarCircleImageView;
    private ZzHorizontalProgressBar hpZzHorizontalProgressBar, attackZzHorizontalProgressBar,
            defenseZzHorizontalProgressBar, speedZzHorizontalProgressBar;
    private TextView nameTextView, hpTextView, attackTextView, defenseTextView, speedTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        initializationView();
        initializationOnClickListener();
        initializeCustomDialogMenu(1);
    }

    private void initializationView() {
        charmanderCardView = findViewById(R.id.charmanderCardView);
        pikachuCardView = findViewById(R.id.pikachuCardView);
        squirtleCardView = findViewById(R.id.squirtleCardView);
        nameTextView = findViewById(R.id.nameTextView);
    }

    private void initializationOnClickListener() {
        charmanderCardView.setOnClickListener(this);
        pikachuCardView.setOnClickListener(this);
        squirtleCardView.setOnClickListener(this);
    }

    /** 點擊監聽的處理 */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.charmanderCardView:
                initializeCustomDialogMenu(1);
                layoutView = findViewById(R.id.mainLinearLayout);
                customDialogMenu.showAtCenter(layoutView);
                break;
            case R.id.squirtleCardView:
                initializeCustomDialogMenu(2);
                layoutView = findViewById(R.id.mainLinearLayout);
                customDialogMenu.showAtCenter(layoutView);
                break;
            case R.id.pikachuCardView:
                initializeCustomDialogMenu(3);
                layoutView = findViewById(R.id.mainLinearLayout);
                customDialogMenu.showAtCenter(layoutView);
                break;
        }
    }

    /** 初始化Dialog */
    private void initializeCustomDialogMenu(int number) {
        customDialogMenu = PowerMenuUtils.getCustomDialogPowerMenu(this, this);
        headerView = customDialogMenu.getHeaderView();
        avatarCircleImageView = headerView.findViewById(R.id.avatarCircleImageView);
        nameTextView = headerView.findViewById(R.id.nameTextView);
        footerView = customDialogMenu.getFooterView();
        hpZzHorizontalProgressBar = footerView.findViewById(R.id.hpZzHorizontalProgressBar);
        attackZzHorizontalProgressBar = footerView.findViewById(R.id.attackZzHorizontalProgressBar);
        defenseZzHorizontalProgressBar = footerView.findViewById(R.id.defenseZzHorizontalProgressBar);
        speedZzHorizontalProgressBar = footerView.findViewById(R.id.speedZzHorizontalProgressBar);
        hpTextView = footerView.findViewById(R.id.hpTextView);
        attackTextView = footerView.findViewById(R.id.attackTextView);
        defenseTextView = footerView.findViewById(R.id.defenseTextView);
        speedTextView = footerView.findViewById(R.id.speedTextView);
        enterLinearLayout = footerView.findViewById(R.id.enterLinearLayout);
        cancelLinearLayout = footerView.findViewById(R.id.cancelLinearLayout);
        enterLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        cancelLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialogMenu.dismiss();
            }
        });
        switch (number) {
            case 1:
                initializeCustomDialogMenuDetail(R.drawable.charmander, "小火龍",
                        39, 52, 43, 65);
                break;
            case 2:
                initializeCustomDialogMenuDetail(R.drawable.squirtle, "傑尼龜",
                        44, 48, 65, 43);
                break;
            case 3:
                initializeCustomDialogMenuDetail(R.drawable.pikachu, "皮卡丘",
                        35, 55, 40, 90);
                break;
        }
    }

    /** 更新Dialog顯示的相關數據 */
    private void initializeCustomDialogMenuDetail(
            int resourceId, String name, int hp, int attack, int defense, int speed) {
        avatarCircleImageView.setImageResource(resourceId);
        nameTextView.setText(name);
        hpZzHorizontalProgressBar.setProgress(hp);
        attackZzHorizontalProgressBar.setProgress(attack);
        defenseZzHorizontalProgressBar.setProgress(defense);
        speedZzHorizontalProgressBar.setProgress(speed);
        hpTextView.setText("" + hp);
        attackTextView.setText("" + attack);
        defenseTextView.setText("" + defense);
        speedTextView.setText("" + speed);
    }

    /** 對於返回鍵的監聽處理 */
    @Override
    public void onBackPressed() {
        if (customDialogMenu.isShowing()) {
            customDialogMenu.dismiss();
        } else {
            super.onBackPressed();
        }
    }
}
