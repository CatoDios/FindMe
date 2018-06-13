package carlos.com.ticketsapp.presentation.reservacion;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import carlos.com.ticketsapp.R;
import carlos.com.ticketsapp.core.BaseFragment;
import carlos.com.ticketsapp.data.local.SessionManager;
import carlos.com.ticketsapp.presentation.reservacion_nivel.NivelActivity;

/**
 * Created by carlos on 12/06/2018.
 */

public class ReservacionFragment extends BaseFragment {

    SessionManager mSessionManager;
    Unbinder unbinder;
    public static ReservacionFragment newInstance(){
        return new ReservacionFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSessionManager=new SessionManager(getContext());

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_turno,container,false);
        unbinder=ButterKnife.bind(this,root);
        return  root;
    }

    @OnClick({R.id.turno1,R.id.turno2,R.id.turno3,R.id.turno4,R.id.turno5})
    public void onclicked(View view){
        switch (view.getId()){
            case R.id.turno1:
                mSessionManager.setIdNivelTurno("1");
                nextActivity(getActivity(),null, NivelActivity.class,false);
                break;
            case R.id.turno2:
                mSessionManager.setIdNivelTurno("2");
                nextActivity(getActivity(),null, NivelActivity.class,false);
                break;
            case R.id.turno3:
                mSessionManager.setIdNivelTurno("3");
                nextActivity(getActivity(),null, NivelActivity.class,false);
                break;
            case R.id.turno4:
                mSessionManager.setIdNivelTurno("4");
                nextActivity(getActivity(),null, NivelActivity.class,false);
                break;
            case R.id.turno5:
                mSessionManager.setIdNivelTurno("5");
                nextActivity(getActivity(),null, NivelActivity.class,false);
                break;
        }
    }
}
