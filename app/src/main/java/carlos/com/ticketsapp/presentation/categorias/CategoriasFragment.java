package carlos.com.ticketsapp.presentation.categorias;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import butterknife.ButterKnife;
import butterknife.Unbinder;
import carlos.com.ticketsapp.R;
import carlos.com.ticketsapp.core.BaseFragment;

public class CategoriasFragment extends BaseFragment {
    Unbinder unbinder;

    public CategoriasFragment() {
    }
    public static CategoriasFragment newInstance() {
        CategoriasFragment fragment = new CategoriasFragment();

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

        View root = inflater.inflate(R.layout.fragment_categorias, container, false);
        unbinder = ButterKnife.bind(this, root);

        return root;
    }



}
