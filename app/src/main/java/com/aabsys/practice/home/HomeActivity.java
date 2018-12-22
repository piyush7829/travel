package com.aabsys.practice.home;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.aabsys.practice.R;
import com.ramotion.expandingcollection.ECBackgroundSwitcherView;
import com.ramotion.expandingcollection.ECCardData;
import com.ramotion.expandingcollection.ECPagerView;
import com.ramotion.expandingcollection.ECPagerViewAdapter;

import java.util.List;

import static android.util.TypedValue.COMPLEX_UNIT_DIP;

public class HomeActivity extends Activity {

    private ECPagerView ecPagerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Get pager from layout
        ecPagerView = (ECPagerView) findViewById(R.id.ec_pager_element);

        // Generate example dataset
        List<ECCardData> dataset = CardDataImpl.generateExampleData();

        // Implement pager adapter and attach it to pager view
        ecPagerView.setPagerViewAdapter(new ECPagerViewAdapter(getApplicationContext(), dataset) {
            @Override
            public void instantiateCard(LayoutInflater inflaterService, ViewGroup head, ListView list, ECCardData data) {
                // Data object for current card
                CardDataImpl cardData = (CardDataImpl) data;

                // Set adapter and items to current card content list
                list.setAdapter(new CardListItemAdapter(getApplicationContext(), cardData.getListItems()));
                // Also some visual tuning can be done here
                list.setBackgroundColor(Color.WHITE);

                // Here we can create elements for head view or inflate layout from xml using inflater service
                TextView cardTitle = new TextView(getApplicationContext());
                cardTitle.setText(cardData.getCardTitle());
                cardTitle.setTextSize(COMPLEX_UNIT_DIP, 20);
                cardTitle.setTextColor(Color.WHITE);
                cardTitle.setPadding(20,20,20,20);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
                layoutParams.gravity = Gravity.BOTTOM;
                head.addView(cardTitle, layoutParams);

                // Card toggling by click on head element
                head.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        ecPagerView.toggle();
                    }
                });
            }
        });

        // Add background switcher to pager view
        ecPagerView.setBackgroundSwitcherView((ECBackgroundSwitcherView) findViewById(R.id.ec_bg_switcher_element));

    }
}
