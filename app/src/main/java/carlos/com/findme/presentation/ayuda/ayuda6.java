package carlos.com.findme.presentation.ayuda;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import carlos.com.findme.R;
import carlos.com.findme.core.BaseActivity;
import carlos.com.findme.presentation.principal.PrincipalActivity;

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
