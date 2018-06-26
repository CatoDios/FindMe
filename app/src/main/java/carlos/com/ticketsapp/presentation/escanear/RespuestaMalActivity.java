package carlos.com.ticketsapp.presentation.escanear;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import carlos.com.ticketsapp.R;
import carlos.com.ticketsapp.core.BaseActivity;
import carlos.com.ticketsapp.presentation.auth.LoadActivity;
import carlos.com.ticketsapp.presentation.principal.PrincipalActivity;
import carlos.com.ticketsapp.presentation.reservar.ReservarActivity;
import carlos.com.ticketsapp.presentation.splash.InicioActivity;

public class RespuestaMalActivity extends BaseActivity {
    @BindView(R.id.respuesta)
    TextView tvrespuesta;
    private final int DURACION_SPLASH=3000;// 3 segundos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mal);
        ButterKnife.bind(this);


        Bundle bundle=getIntent().getExtras();
        String respuesta=bundle.getString("codigoreal");

        tvrespuesta.setText(respuesta);
        new Handler().postDelayed(new Runnable(){
            public void run(){
                // Cuando pasen los 3 segundos, pasamos a la actividad principal de la aplicación
                Intent intent = new Intent(RespuestaMalActivity.this, PrincipalActivity.class);
                startActivity(intent);
                finish();
            };
        }, DURACION_SPLASH);
        // Create the presenter
        // new LoginPresenter(fragment,this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
