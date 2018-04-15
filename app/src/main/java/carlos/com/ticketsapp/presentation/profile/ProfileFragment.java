package carlos.com.ticketsapp.presentation.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import butterknife.ButterKnife;
import butterknife.Unbinder;
import carlos.com.ticketsapp.R;
import carlos.com.ticketsapp.core.BaseFragment;
import carlos.com.ticketsapp.data.local.SessionManager;
import carlos.com.ticketsapp.data.models.UserEntity;

public class ProfileFragment extends BaseFragment {
    SessionManager mSessionManager;
    Unbinder unbinder;


    private UserEntity mUser;

    public ProfileFragment() {
    }
    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();

        return fragment;

    }
    @Override
    public void onResume() {
        super.onResume();

    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSessionManager = new SessionManager(getContext());
        mUser=mSessionManager.getUserEntity();
        //Se inicializan datos
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Se coloca el layout y este se administra

        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        unbinder = ButterKnife.bind(this, root);
        return root;
    }




}
