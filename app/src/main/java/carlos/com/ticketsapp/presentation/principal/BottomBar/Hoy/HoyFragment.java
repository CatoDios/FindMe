package carlos.com.ticketsapp.presentation.principal.BottomBar.Hoy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import carlos.com.ticketsapp.R;
import carlos.com.ticketsapp.core.BaseActivity;
import carlos.com.ticketsapp.core.BaseFragment;
import carlos.com.ticketsapp.data.local.SessionManager;
import carlos.com.ticketsapp.data.models.Comida;
import carlos.com.ticketsapp.data.models.ComidaEntity;
import carlos.com.ticketsapp.data.models.MenuEntity;
import carlos.com.ticketsapp.data.models.ValidarEntity;
import carlos.com.ticketsapp.presentation.mapa.MapaActivity;
import carlos.com.ticketsapp.presentation.principal.PrincipalFragment;
import carlos.com.ticketsapp.utils.ProgressDialogCustom;

public class HoyFragment  extends BaseFragment implements HoyContract.View{

    @BindView(R.id.reservar)
    Button btnReservar;
    @BindView(R.id.desayuno)
    TextView tv_desayuno;
    @BindView(R.id.almuerzo)
    TextView tv_almuerzo;
    @BindView(R.id.cena)
    TextView tv_cena;

    Unbinder unbinder;

    SessionManager mSessionManager;

    HoyContract.Presenter mPresenter;
    private ProgressDialogCustom mProgressDialogCustom;

    public static PrincipalFragment newInstance() {
        return new PrincipalFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter=new HoyPresenter(this,getContext());
        mSessionManager=new SessionManager(getContext());
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.getCategorias();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_hoy, container, false);
        unbinder = ButterKnife.bind(this, root);

        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mProgressDialogCustom = new ProgressDialogCustom(getContext(), "Obteniendo datos...");
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void getMenu(ArrayList<ComidaEntity> body) {
            ComidaEntity desayuno=body.get(0);
            ComidaEntity almuerzo=body.get(1);
            ComidaEntity cena = body.get(2);

            tv_desayuno.setText(desayuno.getNombre());
            tv_almuerzo.setText(almuerzo.getNombre());
            tv_cena.setText(cena.getNombre());

            mSessionManager.setIdComida(String.valueOf(cena.getIdComida()));

    }

    @Override
    public void validarUser(ValidarEntity body) {
        Toast.makeText(getContext(), String.valueOf(body.getCode()), Toast.LENGTH_SHORT).show();

        nextActivity(getActivity(), null, MapaActivity.class, false);
    }

    @Override
    public void setPresenter(HoyContract.Presenter presenter) {

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


    @OnClick({R.id.reservar})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.reservar:

                mPresenter.validarUser();
                break;

        }
    }
}
