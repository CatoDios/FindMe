package carlos.com.ticketsapp.presentation.ayuda;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import carlos.com.ticketsapp.R;
import carlos.com.ticketsapp.core.BaseActivity;
import carlos.com.ticketsapp.presentation.estado.EstadoFragment;
import carlos.com.ticketsapp.presentation.principal.PrincipalActivity;
import carlos.com.ticketsapp.utils.ActivityUtils;

public class ayuda1 extends BaseActivity {

    @BindView(R.id.btn_adelante)
    ImageView adelante;
    @BindView(R.id.salir)
    ImageView salir;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ayuda1);
        ButterKnife.bind(this);









        // Create the presenter
        // new LoginPresenter(fragment,this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @OnClick({R.id.btn_adelante,R.id.salir})
    public void onclick(View view){
        switch (view.getId()){

            case R.id.btn_adelante:
                nextActivity(ayuda1.this,null,ayuda2.class,false);
                overridePendingTransition(R.anim.left_in,R.anim.left_out);
                break;
            case R.id.salir:
                nextActivity(ayuda1.this,null,PrincipalActivity.class,false);
                break;
        }
    }
}
