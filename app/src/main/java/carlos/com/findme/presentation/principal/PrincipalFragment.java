package carlos.com.findme.presentation.principal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import butterknife.ButterKnife;
import butterknife.Unbinder;
import carlos.com.findme.R;
import carlos.com.findme.core.BaseFragment;



/**
 * Created by kath on 09/04/18.
 */

public class PrincipalFragment extends BaseFragment {
    Unbinder unbinder;

    public static PrincipalFragment newInstance() {
        return new PrincipalFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_principal, container, false);
        unbinder = ButterKnife.bind(this, root);
        return root;
    }


    /*@OnClick({R.id.btn_categorias,R.id.btn_marcas,R.id.btn_recomendados})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.btn_categorias:
                nextActivity(getActivity(), null, CategoriasActivity.class, false);
                break;
            case R.id.btn_recomendados:
                nextActivity(getActivity(), null, RecomendadosActivity.class, false);
                break;
        }
    }*/
}
