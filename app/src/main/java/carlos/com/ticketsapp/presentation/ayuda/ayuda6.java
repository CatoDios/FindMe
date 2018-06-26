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
import carlos.com.ticketsapp.presentation.principal.PrincipalActivity;

public class ayuda6 extends BaseActivity{

    @BindView(R.id.boton_atras)
    ImageView atras;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ayuda6);
        ButterKnife.bind(this);





        // Create the presenter
        // new LoginPresenter(fragment,this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @OnClick({R.id.boton_atras,R.id.salir})
    public void onclick(View view){
        switch (view.getId()){
            case R.id.boton_atras:
                nextActivity(ayuda6.this,null,ayuda5.class,false);
                overridePendingTransition(R.anim.right_in,R.anim.right_out);

                break;
            case R.id.salir:
                nextActivity(ayuda6.this,null,PrincipalActivity.class,false);


                break;

        }
    }
}
