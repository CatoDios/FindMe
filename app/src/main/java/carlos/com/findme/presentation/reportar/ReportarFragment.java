package carlos.com.findme.presentation.reportar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import carlos.com.findme.R;
import carlos.com.findme.core.BaseFragment;
import carlos.com.findme.presentation.mapa.MapaActivity;

/**
 * Created by kath on 06/04/18.
 */

public class ReportarFragment extends BaseFragment {

    Unbinder unbinder;


    public static ReportarFragment newInstance() {
        return new ReportarFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_registro, container, false);
        unbinder = ButterKnife.bind(this, root);
        return root;
    }


    @OnClick(R.id.btn_seguir)
    public void onClick(View view){
        nextActivity(getActivity(),null,MapaActivity.class,false);
    }
}
