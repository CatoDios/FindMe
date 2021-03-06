package carlos.com.findme.presentation.auth;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import carlos.com.findme.R;
import carlos.com.findme.core.BaseActivity;
import carlos.com.findme.core.BaseFragment;
import carlos.com.findme.data.local.SessionManager;
import carlos.com.findme.presentation.principal.PrincipalActivity;
import carlos.com.findme.utils.ProgressDialogCustom;

/**
 * Created by kath on 06/04/18.
 */

public class LoginFragment extends BaseFragment implements Validator.ValidationListener,LoginContract.View {


    private ProgressDialogCustom mProgressDialogCustom;
    private LoginContract.Presenter mPresenter;
    private SessionManager mSessionManager;
    private boolean isLoading=false;
    Unbinder unbinder;
    private Validator validator;


    @NotEmpty(message = "No vacio")

    @BindView(R.id.et_email)
    EditText etEmail;

    @NotEmpty(message = "Contraseña inválida")
    @BindView(R.id.et_password)
    EditText etPassword;


    public LoginFragment() {
        //requires empty constructor
    }

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_login, container, false);
        unbinder = ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mProgressDialogCustom = new ProgressDialogCustom(getContext(), "Ingresando...");
        validator=new Validator(this);
        validator.setValidationListener(this);

    }

    @OnClick(R.id.btn_iniciar_sesion)
    public void onViewClicked(View view) {
        switch (view.getId()) {


            case R.id.btn_iniciar_sesion:
                validator.validate();
                break;
        }
    }

    @Override
    public void onValidationSucceeded() {
        mPresenter.loginUser(etEmail.getText().toString(),etPassword.getText().toString());
        isLoading=true;
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(getContext());
            // Display error messages ;)
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(getContext(), "Por favor ingrese lo campos correctamente", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void loginSuccesful() {
        showMessage("Login exitoso");
        newActivityClearPreview(getActivity(),null,PrincipalActivity.class);
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void errorLogin(String msg) {
        showErrorMessage(msg);
    }

    @Override
    public void setPresenter(LoginContract.Presenter mPresenter) {
        this.mPresenter=mPresenter;
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        if (getView() == null) {
            return;
        }
        if (active) {
            mProgressDialogCustom.show();
        } else {
            if (mProgressDialogCustom.isShowing()) {
                mProgressDialogCustom.dismiss();
            }
        }
    }

    @Override
    public void showMessage(String message) {
        ((BaseActivity) getActivity()).showMessage(message);
    }

    @Override
    public void showErrorMessage(String message) {
        ((BaseActivity) getActivity()).showMessageError(message);
    }
}
