package carlos.com.ticketsapp.presentation.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;



import butterknife.ButterKnife;
import carlos.com.ticketsapp.R;
import carlos.com.ticketsapp.core.BaseActivity;
import carlos.com.ticketsapp.presentation.auth.LoadActivity;

/**
 * Created by kath on 06/04/18.
 */

public class InicioActivity extends BaseActivity {

    private final int DURACION_SPLASH=3000;// 3 segundos


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        new Handler().postDelayed(new Runnable(){
            public void run(){
                // Cuando pasen los 3 segundos, pasamos a la actividad principal de la aplicación
                Intent intent = new Intent(InicioActivity.this, LoadActivity.class);
                startActivity(intent);
                finish();
            };
        }, DURACION_SPLASH);




        // Create the presenter
        // new LoginPresenter(fragment,this);
    }

}
