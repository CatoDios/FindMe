package carlos.com.findme.presentation.auth;

import android.os.Bundle;
import android.support.annotation.Nullable;

import carlos.com.findme.R;
import carlos.com.findme.core.BaseActivity;
import carlos.com.findme.data.local.SessionManager;
import carlos.com.findme.presentation.principal.PrincipalActivity;


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
