package carlos.com.ticketsapp.presentation.auth;

import android.content.Context;

import carlos.com.ticketsapp.data.local.SessionManager;
import carlos.com.ticketsapp.data.models.AccessTokenEntity;
import carlos.com.ticketsapp.data.models.UserEntity;
import carlos.com.ticketsapp.data.remote.ServiceFactory;
import carlos.com.ticketsapp.data.remote.request.GetRequest;
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
        // hacer  token y get profile
        final AccessTokenEntity accessTokenEntity=new AccessTokenEntity();
        accessTokenEntity.setAccess_token("token");
        GetRequest loginService =
                ServiceFactory.createService(GetRequest.class);
        Call<UserEntity> call = loginService.getUser(username,password);
        mView.setLoadingIndicator(true);
        call.enqueue(new Callback<UserEntity>() {
            @Override
            public void onResponse(Call<UserEntity> call, Response<UserEntity> response) {
                if(!mView.isActive()){
                    return;
                }
                mView.setLoadingIndicator(false);

                if (response.isSuccessful()) {
                    openSession(accessTokenEntity,response.body());
                } else {
                    mView.setLoadingIndicator(false);
                    mView.errorLogin("login fallido");
                }
            }

            @Override
            public void onFailure(Call<UserEntity> call, Throwable t) {
                if(!mView.isActive()){
                    return;
                }
                mView.setLoadingIndicator(false);
                mView.errorLogin("Fallo al traer datos, comunicarse con su administrador");
            }
        });









    }

    public void openSession(AccessTokenEntity accessTokenEntity,UserEntity userEntity){
        mSessionManager.openSession(accessTokenEntity);
        mSessionManager.setUser(userEntity);
        mView.setLoadingIndicator(false);
        mView.loginSuccesful();

    }
}
