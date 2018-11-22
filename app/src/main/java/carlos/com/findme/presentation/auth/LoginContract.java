package carlos.com.findme.presentation.auth;


import carlos.com.findme.core.BasePresenter;
import carlos.com.findme.core.BaseView;

/**
 * Created by kath on 09/04/18.
 */

public interface LoginContract {
    interface View extends BaseView<Presenter> {
        void loginSuccesful();
        boolean isActive();
        void errorLogin(String msg);
    }

    interface  Presenter extends BasePresenter {
        void loginUser(String username, String password);
    }
}
