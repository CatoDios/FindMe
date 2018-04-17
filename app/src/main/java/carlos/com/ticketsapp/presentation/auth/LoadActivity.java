package carlos.com.ticketsapp.presentation.auth;

import android.os.Bundle;
import android.support.annotation.Nullable;

import carlos.com.ticketsapp.R;
import carlos.com.ticketsapp.core.BaseActivity;
import carlos.com.ticketsapp.data.local.SessionManager;
import carlos.com.ticketsapp.presentation.principal.PrincipalActivity;


/**
 * Created by kath on 09/04/18.
 */

public class LoadActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if (savedInstanceState == null)
            initialProcess();
    }

    private void initialProcess() {
        SessionManager mSessionManager = new SessionManager(getApplicationContext());
        if(mSessionManager.isLogin()){
            //Bundle con los datos
            next(this,null, PrincipalActivity.class, true);
        }else{
            //Sin logeo aún
            next(this,null, LoginActivity.class, true);
        }
    }
}
