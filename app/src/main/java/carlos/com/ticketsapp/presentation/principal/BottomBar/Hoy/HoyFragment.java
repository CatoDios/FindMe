package carlos.com.ticketsapp.presentation.principal.BottomBar.Hoy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import carlos.com.ticketsapp.R;
import carlos.com.ticketsapp.core.BaseActivity;
import carlos.com.ticketsapp.core.BaseFragment;
import carlos.com.ticketsapp.data.models.MenuEntity;
import carlos.com.ticketsapp.presentation.principal.PrincipalFragment;
import carlos.com.ticketsapp.utils.ProgressDialogCustom;

public class HoyFragment  extends BaseFragment implements HoyContract.View{
    Unbinder unbinder;
    private ProgressDialogCustom mProgressDialogCustom;

    public static PrincipalFragment newInstance() {
        return new PrincipalFragment();
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
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void getMenu(MenuEntity body) {

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
