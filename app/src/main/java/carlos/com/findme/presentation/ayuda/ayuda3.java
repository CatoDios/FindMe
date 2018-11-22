package carlos.com.findme.presentation.ayuda;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import carlos.com.findme.R;
import carlos.com.findme.core.BaseActivity;

public class ayuda3 extends BaseActivity {
    @BindView(R.id.btn_adelante)
    ImageView adelante;
    @BindView(R.id.boton_atras)
    ImageView atras;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ayuda3);
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
                nextActivity(ayuda3.this,null,ayuda2.class,false);
                overridePendingTransition(R.anim.right_in,R.anim.right_out);

                break;
            case R.id.btn_adelante:
                nextActivity(ayuda3.this,null,ayuda4.class,false);
                overridePendingTransition(R.anim.left_in,R.anim.left_out);

                break;
        }
    }
}
