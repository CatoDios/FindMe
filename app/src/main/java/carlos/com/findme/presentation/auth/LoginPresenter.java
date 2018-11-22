package carlos.com.findme.presentation.auth;

import android.content.Context;

import carlos.com.findme.data.local.SessionManager;
import carlos.com.findme.data.models.AccessTokenEntity;
import carlos.com.findme.data.models.UserEntity;
import carlos.com.findme.data.remote.ServiceFactory;
import carlos.com.findme.data.remote.request.GetRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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
        UserEntity userEntity=new UserEntity();
        userEntity.setUser(user);
        userEntity.setPassword(password);
        // hacer  token y get profile
        final AccessTokenEntity accessTokenEntity=new AccessTokenEntity();
        accessTokenEntity.setAccess_token("token");

        if(user.equals("CatoDios") && pass.equals("cato")){
            openSession(accessTokenEntity,userEntity);

        }
        else{
            mView.errorLogin("Datos incorrectos");
        }


    }

    public void openSession(AccessTokenEntity accessTokenEntity,UserEntity userEntity){
        mSessionManager.openSession(accessTokenEntity);
        mSessionManager.setUser(userEntity);
        mView.setLoadingIndicator(false);
        mView.loginSuccesful();

    }
}
