package carlos.com.ticketsapp.presentation.auth;

import android.content.Context;

import carlos.com.ticketsapp.data.local.SessionManager;
import carlos.com.ticketsapp.data.models.AccessTokenEntity;
import carlos.com.ticketsapp.data.models.UserEntity;


/**
 * Created by kath on 09/04/18.
 */

public class LoginPresenter implements LoginContract.Presenter {
    private String user;
    private String pass;
    private final SessionManager mSessionManager;
    private final LoginContract.View mView;
    private Context context;

    public LoginPresenter(LoginContract.View mView, Context context) {
        this.mView = mView;
        this.context = context;
        this.mView.setPresenter(this);
        mSessionManager=new SessionManager(context);
    }

    @Override
    public void start() {

    }


    @Override
    public void loginUser(String username, String password) {
        user=username;
        pass=password;
        // hacer  token y get profile
        AccessTokenEntity accessTokenEntity=new AccessTokenEntity();
        accessTokenEntity.setAccess_token("token");




        UserEntity userEntity=new UserEntity();
        userEntity.setCorreo(user);
        userEntity.setContraseña(pass);

        openSession(accessTokenEntity,userEntity);


    }

    public void openSession(AccessTokenEntity accessTokenEntity,UserEntity userEntity){
        mSessionManager.openSession(accessTokenEntity);
        mSessionManager.setUser(userEntity);
        mView.setLoadingIndicator(false);
        mView.loginSuccesful();

    }
}
