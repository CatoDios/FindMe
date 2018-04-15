package carlos.com.ticketsapp.presentation.recomendados;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import butterknife.ButterKnife;
import butterknife.Unbinder;
import carlos.com.ticketsapp.R;
import carlos.com.ticketsapp.core.BaseFragment;

public class RecomendadosFragment extends BaseFragment {

    Unbinder unbinder;

    public RecomendadosFragment() {
    }
    public static RecomendadosFragment newInstance() {
        RecomendadosFragment fragment = new RecomendadosFragment();

        return fragment;

    }
    @Override
    public void onResume() {
        super.onResume();

    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Se inicializan datos
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Se coloca el layout y este se administra

        View root = inflater.inflate(R.layout.fragment_recomendados, container, false);
        unbinder = ButterKnife.bind(this, root);

        return root;
    }

}
