package carlos.com.ticketsapp.presentation.reservacion_nivel;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import carlos.com.ticketsapp.R;
import carlos.com.ticketsapp.core.BaseActivity;
import carlos.com.ticketsapp.core.BaseFragment;
import carlos.com.ticketsapp.data.local.SessionManager;
import carlos.com.ticketsapp.data.models.RespuestaNT;
import carlos.com.ticketsapp.data.models.ValidarEntity;
import carlos.com.ticketsapp.presentation.escanear.scanerActivity;
import carlos.com.ticketsapp.presentation.reservacion.ReservacionFragment;
import carlos.com.ticketsapp.presentation.reservar.ReservarActivity;

/**
 * Created by carlos on 12/06/2018.
 */

public class NivelFragment extends BaseFragment implements NivelContract.View{
    @BindView(R.id.barcode_result)
    TextView barCodeResult;
    @BindView(R.id.nivel2)
    RelativeLayout nivel2;
    SessionManager mSessionManager;
    Unbinder unbinder;
    NivelContract.Presenter mPresenter;
    public static NivelFragment newInstance(){
        return new NivelFragment();
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSessionManager=new SessionManager(getContext());
        mPresenter=new NivelPresenter(getContext(),this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_nivel,container,false);
        unbinder= ButterKnife.bind(this,root);
        if(mSessionManager.getTipo().equals("cena")){
            nivel2.setVisibility(View.GONE);
        }
        return  root;
    }

    @OnClick({R.id.nivel1,R.id.nivel2})
    public void onclicked(View view){
        String turno=mSessionManager.getIdNivelturno();
        switch (view.getId()){
            case R.id.nivel1:
                    mSessionManager.setNivel("1");
                    mPresenter.getNT();

                    scanBarCode(view);
                break;
            case R.id.nivel2:
                    mSessionManager.setNivel("2");
                mPresenter.getNT();

                    scanBarCode(view);
                break;
        }
    }
    private void scanBarCode(View view) {
        Intent intent=new Intent(getActivity(),scanerActivity.class);
        startActivityForResult(intent,0);
    }
    @Override
    public void setPresenter(NivelContract.Presenter presenter) {
            this.mPresenter=presenter;
    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public void showMessage(String message) {
        ((BaseActivity) getActivity()).showMessage(message);
    }

    @Override
    public void showErrorMessage(String message) {
        ((BaseActivity) getActivity()).showMessageError(message);
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void validarCantidad(ValidarEntity body) {

        if (body.getEstado()==0){
            Toast.makeText(getContext(), body.getMensaje(), Toast.LENGTH_SHORT).show();

        }else{
            //nextActivity(getActivity(),null, ReservarActivity.class,false);

        }

    }

    @Override
    public void ponerNT(RespuestaNT body) {
        mSessionManager.setIdNivelTurno(String.valueOf(body.getEstado()));

        mPresenter.validarCantidad();
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==0){
            if (resultCode== CommonStatusCodes.SUCCESS){
                if(data!=null){
                    Barcode barcode=data.getParcelableExtra("barcode");
                    barCodeResult.setText(barcode.displayValue);
                    //aqui en lugar de mostrar el dato del codigo de barras, debe pasar a buscar con ese dato a otra actividad
                }else{
                    barCodeResult.setText("No barcode found");
                }
            }
        }else{

        }
        //super.onActivityResult(requestCode, resultCode, data);
    }


}
