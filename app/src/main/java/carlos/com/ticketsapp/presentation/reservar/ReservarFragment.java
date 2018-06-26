package carlos.com.ticketsapp.presentation.reservar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import carlos.com.ticketsapp.R;
import carlos.com.ticketsapp.core.BaseFragment;
import carlos.com.ticketsapp.data.local.SessionManager;
import carlos.com.ticketsapp.data.models.RespuestaNT;
import carlos.com.ticketsapp.data.models.RetornoEntity;
import carlos.com.ticketsapp.presentation.principal.PrincipalActivity;
import carlos.com.ticketsapp.presentation.reservacion_nivel.NivelFragment;

/**
 * Created by carlos on 12/06/2018.
 */

public class ReservarFragment extends BaseFragment implements ReservarContract.View{
    @BindView(R.id.confirmar)
    Button confirmar;
    @BindView(R.id.nombre)
    TextView nombre;
    @BindView(R.id.comida)
    TextView comida;
    @BindView(R.id.turno)
    TextView turno;
    @BindView(R.id.nivel)
    TextView nivel;

    @BindView(R.id.hora_inicio)
    TextView hora_inicio;
    @BindView(R.id.hora_fin)
    TextView hora_fin;
    Unbinder unbinder;
    SessionManager mSessionManager;
    ReservarContract.Presenter mPresenter;

    public static ReservarFragment newInstance(){
        return new ReservarFragment();
    }

    @Override
    public void onResume() {
        super.onResume();

        mPresenter.finalizar();
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

    @OnClick(R.id.confirmar)
    public void onclick(View view){
        nextActivity(getActivity(),null, PrincipalActivity.class,true);
    }
}
