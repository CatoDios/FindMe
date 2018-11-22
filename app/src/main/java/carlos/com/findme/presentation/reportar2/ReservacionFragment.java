package carlos.com.findme.presentation.reportar2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import carlos.com.findme.R;
import carlos.com.findme.core.BaseFragment;
import carlos.com.findme.data.local.SessionManager;

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


}
