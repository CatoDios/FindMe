package carlos.com.ticketsapp.presentation.tipo;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import carlos.com.ticketsapp.R;
import carlos.com.ticketsapp.core.BaseActivity;
import carlos.com.ticketsapp.presentation.reservacion_nivel.NivelFragment;
import carlos.com.ticketsapp.utils.ActivityUtils;

public class TipoActivity extends BaseActivity{
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


        toolbar.setTitle("Selecciona Tipo");


        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowHomeEnabled(true);
        Bundle bundle=getIntent().getExtras();
        String desayuno=bundle.getString("desayuno");
        String almuerzo=bundle.getString("almuerzo");
        String cena=bundle.getString("cena");
        Bundle bundle2=new Bundle();
        bundle2.putString("desayuno",desayuno);
        bundle2.putString("almuerzo",almuerzo);
        bundle2.putString("cena",cena);




        TipoFragment fragment = (TipoFragment) getSupportFragmentManager()
                .findFragmentById(R.id.body);

        if (fragment == null) {
            fragment = TipoFragment.newInstance();
            fragment.setArguments(bundle2);
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
