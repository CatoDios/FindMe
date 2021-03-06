package carlos.com.findme.presentation.principal.BottomBar.Hoy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import carlos.com.findme.R;
import carlos.com.findme.core.BaseActivity;
import carlos.com.findme.core.BaseFragment;
import carlos.com.findme.data.local.SessionManager;
import carlos.com.findme.data.models.ComidaEntity;
import carlos.com.findme.data.models.ValidarEntity;
import carlos.com.findme.presentation.principal.PrincipalFragment;
import carlos.com.findme.presentation.tipo.TipoActivity;
import carlos.com.findme.utils.ProgressDialogCustom;

public class HoyFragment  extends BaseFragment implements HoyContract.View{

    Bundle bundle;

    @BindView(R.id.error)
    RelativeLayout error;
    @BindView(R.id.cuerpo)
    RelativeLayout cuerpo;

    @BindView(R.id.reservar)
    Button btnReservar;
    @BindView(R.id.desayuno)
    TextView tv_desayuno;
    @BindView(R.id.almuerzo)
    TextView tv_almuerzo;
    @BindView(R.id.cena)
    TextView tv_cena;

    Unbinder unbinder;
ProgressBar progressBar;
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
        bundle=new Bundle();
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
        //setLoadingIndicator(true);
        progressBar = new ProgressBar(getContext(),null,android.R.attr.progressBarStyleLarge);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(100,100);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);
        RelativeLayout layout = getActivity().findViewById(R.id.root);
        layout.addView(progressBar,params);
        progressBar.setVisibility(View.VISIBLE);  //To show ProgressBar
        cuerpo.setVisibility(View.GONE);
        // To Hide ProgressBar
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void getMenu(ArrayList<ComidaEntity> body) {
            progressBar.setVisibility(View.GONE);
            cuerpo.setVisibility(View.VISIBLE);
            error.setVisibility(View.GONE);
            ComidaEntity desayuno=body.get(0);
            ComidaEntity almuerzo=body.get(1);
            ComidaEntity cena = body.get(2);

            bundle.putString("desayuno",String.valueOf(desayuno.getIdComida()));
            bundle.putString("almuerzo",String.valueOf(almuerzo.getIdComida()));
            bundle.putString("cena",String.valueOf(cena.getIdComida()));

            tv_desayuno.setText(desayuno.getNombre());
            tv_almuerzo.setText(almuerzo.getNombre());
            tv_cena.setText(cena.getNombre());



    }

    @Override
    public void validarUser(ValidarEntity body) {
        Toast.makeText(getContext(), String.valueOf(body.getEstado()), Toast.LENGTH_SHORT).show();

        //nextActivity(getActivity(), null, MapaActivity.class, false);
    }

    @Override
    public void error() {
        progressBar.setVisibility(View.GONE);
        error.setVisibility(View.VISIBLE);
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
                nextActivity(getActivity(),bundle, TipoActivity.class,false);

                break;

        }
    }
}
