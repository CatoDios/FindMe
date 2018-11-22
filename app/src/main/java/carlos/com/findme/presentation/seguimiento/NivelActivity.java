package carlos.com.findme.presentation.seguimiento;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import carlos.com.findme.R;
import carlos.com.findme.core.BaseActivity;
import carlos.com.findme.presentation.seguimiento.seguimiento_tabs.FragmentAdapter;
import carlos.com.findme.utils.ActivityUtils;

/**
 * Created by carlos on 12/06/2018.
 */

public class NivelActivity extends BaseActivity{
    @BindView(R.id.toolbar)
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seguimiento);
        ButterKnife.bind(this);


        toolbar.setTitle("Mis reportes");

        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        ViewPager viewPager  = findViewById(R.id.view_pager);


        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowHomeEnabled(true);
        FragmentAdapter adapter= new FragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabs.setupWithViewPager(viewPager);

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



        // Create the presenter
        // new LoginPresenter(fragment,this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
