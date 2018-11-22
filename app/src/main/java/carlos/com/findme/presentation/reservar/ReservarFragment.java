package carlos.com.findme.presentation.reservar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import carlos.com.findme.R;
import carlos.com.findme.core.BaseFragment;
import carlos.com.findme.data.local.SessionManager;
import carlos.com.findme.data.models.RespuestaNT;
import carlos.com.findme.data.models.RetornoEntity;
import carlos.com.findme.presentation.principal.PrincipalActivity;

/**
 * Created by carlos on 12/06/2018.
 */

public class ReservarFragment extends BaseFragment implements ReservarContract.View{
    @BindView(R.id.confirmar)
    Button confirmar;
    @BindView(R.id.cola)
    TextView cola;
    @BindView(R.id.nombre)
    TextView nombre;
    @BindView(R.id.comida)
    TextView comida;
    @BindView(R.id.turno)
    TextView turno;
    @BindView(R.id.nivel)
    TextView nivel;
    @BindView(R.id.cuerpo)
    RelativeLayout cuerpo;

    @BindView(R.id.hora_inicio)
    TextView hora_inicio;
    @BindView(R.id.hora_fin)
    TextView hora_fin;
    Unbinder unbinder;
    SessionManager mSessionManager;
    ReservarContract.Presenter mPresenter;
    ProgressBar progressBar;
    public static ReservarFragment newInstance(){
        return new ReservarFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
        if(mSessionManager.getEstadoCola()==0){
            mPresenter.finalizarCola();
        }
        else{
            mPresenter.finalizar();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSessionManager=new SessionManager(getContext());
        mPresenter=new ReservarPresenter(getContext(),this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_reservar,container,false);
        unbinder= ButterKnife.bind(this,root);
        return  root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressBar = new ProgressBar(getContext(),null,android.R.attr.progressBarStyleLarge);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(100,100);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);
        RelativeLayout layout = getActivity().findViewById(R.id.root);
        layout.addView(progressBar,params);
        progressBar.setVisibility(View.VISIBLE);  //To show ProgressBar
        cuerpo.setVisibility(View.GONE);
        /*nombre.setText(mSessionManager.getUserEntity().getNombres()+" "+mSessionManager.getUserEntity().getApePat());
        comida.setText(mSessionManager.getIdComida());
        turno.setText(mSessionManager.getIdNivelturno());*/



    }

    @Override
    public void setPresenter(ReservarContract.Presenter presenter) {
            this.mPresenter=presenter;
    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showErrorMessage(String message) {

    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void reservado(RetornoEntity body) {
        progressBar.setVisibility(View.GONE);
        cuerpo.setVisibility(View.VISIBLE);
        nombre.setText(mSessionManager.getUserEntity().getNombres()+" "+mSessionManager.getUserEntity().getApePat()+" "+mSessionManager.getUserEntity().getApeMat());
        comida.setText(body.getNombre());
        nivel.setText(String.valueOf(body.getNivel()));
        turno.setText(String.valueOf(body.getTurno()));
        hora_fin.setText(body.getHoraFin());
        hora_inicio.setText(body.getHoraInicio());


        mSessionManager.setIdNivelTurno("");


    }

    @Override
    public void ponerNT(RespuestaNT body) {
        mSessionManager.setIdNivelTurno(String.valueOf(body.getEstado()));
    }

    @Override
    public void reservadoCola(RetornoEntity body) {
        cola.setText("(En la cola "+body.getEstado()+")");
        progressBar.setVisibility(View.GONE);
        cuerpo.setVisibility(View.VISIBLE);
        nombre.setText(mSessionManager.getUserEntity().getNombres()+" "+mSessionManager.getUserEntity().getApePat()+" "+mSessionManager.getUserEntity().getApeMat());
        comida.setText(body.getNombre());
        nivel.setText(String.valueOf(body.getNivel()));
        turno.setText(String.valueOf(body.getTurno()));
        hora_fin.setText(body.getHoraFin());
        hora_inicio.setText(body.getHoraInicio());


        mSessionManager.setIdNivelTurno("");

    }

    @OnClick(R.id.confirmar)
    public void onclick(View view){
        nextActivity(getActivity(),null, PrincipalActivity.class,true);
    }
}
