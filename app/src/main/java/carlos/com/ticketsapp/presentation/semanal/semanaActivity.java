package carlos.com.ticketsapp.presentation.semanal;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import carlos.com.ticketsapp.R;
import carlos.com.ticketsapp.core.BaseActivity;
import carlos.com.ticketsapp.presentation.principal.BottomBar.Semana.SemanaFragment;
import carlos.com.ticketsapp.presentation.reservar.ReservarFragment;
import carlos.com.ticketsapp.utils.ActivityUtils;

public class semanaActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.body)
    FrameLayout body;
    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back);
        ButterKnife.bind(this);


        toolbar.setTitle("Menú semanal");


        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowHomeEnabled(true);

        SemanaFragment fragment = (SemanaFragment) getSupportFragmentManager()
                .findFragmentById(R.id.body);

        if (fragment == null) {
            fragment = SemanaFragment.newInstance();

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    fragment, R.id.body);
        }

        // Create the presenter
        // new LoginPresenter(fragment,this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
