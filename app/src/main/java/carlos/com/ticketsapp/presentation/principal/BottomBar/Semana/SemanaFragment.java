package carlos.com.ticketsapp.presentation.principal.BottomBar.Semana;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import carlos.com.ticketsapp.R;
import carlos.com.ticketsapp.core.BaseActivity;
import carlos.com.ticketsapp.core.BaseFragment;
import carlos.com.ticketsapp.data.models.ComidaEntity;
import carlos.com.ticketsapp.presentation.principal.BottomBar.DetallesMenu.DetallesActivity;
import carlos.com.ticketsapp.presentation.principal.PrincipalFragment;
import carlos.com.ticketsapp.utils.ProgressDialogCustom;

public class SemanaFragment extends BaseFragment implements SemanaContract.View{

    @BindView(R.id.rv_list)
    RecyclerView rvList;

    private LinearLayoutManager mLayoutManager;

    Unbinder unbinder;
    private SemanaContract.Presenter mPresenter;
    private SemanaAdapter mAdapter;
    private ProgressDialogCustom mProgressDialogCustom;

    public static PrincipalFragment newInstance() {
        return new PrincipalFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter=new SemanaPresenter(this,getContext());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mProgressDialogCustom = new ProgressDialogCustom(getContext(), "Obteniendo datos...");
        mLayoutManager = new LinearLayoutManager(getContext());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mAdapter = new SemanaAdapter(new ArrayList<ComidaEntity>(), getContext(),(ItemSemana) mPresenter);
        rvList.setLayoutManager(mLayoutManager);
        rvList.setAdapter(mAdapter);
    }

    @Override
    public void onResume() {

        super.onResume();
        mPresenter.getMenu();


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_semana, container, false);
        unbinder = ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void setPresenter(SemanaContract.Presenter presenter) {

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

    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void getMenuSemana(ArrayList<ComidaEntity> body) {
        mAdapter.setItems(body);


    }

    @Override
    public void clickItemCategorias(ComidaEntity comidaEntity) {
        nextActivity(getActivity(),null, DetallesActivity.class,false);
    }
}
