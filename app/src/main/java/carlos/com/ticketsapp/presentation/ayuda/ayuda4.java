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

public class ayuda4 extends BaseActivity {
    @BindView(R.id.btn_adelante)
    ImageView adelante;
    @BindView(R.id.boton_atras)
    ImageView atras;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ayuda4);
        ButterKnife.bind(this);




        // Create the presenter
        // new LoginPresenter(fragment,this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @OnClick({R.id.boton_atras,R.id.btn_adelante})
    public void onclick(View view){
        switch (view.getId()){
            case R.id.boton_atras:
                nextActivity(ayuda4.this,null,ayuda3.class,false);
                overridePendingTransition(R.anim.right_in,R.anim.right_out);

                break;
            case R.id.btn_adelante:
                nextActivity(ayuda4.this,null,ayuda5.class,false);
                overridePendingTransition(R.anim.left_in,R.anim.left_out);

                break;
        }
    }
}
