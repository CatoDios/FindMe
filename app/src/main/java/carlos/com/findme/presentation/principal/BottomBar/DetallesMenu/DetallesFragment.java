package carlos.com.findme.presentation.principal.BottomBar.DetallesMenu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import carlos.com.findme.R;
import carlos.com.findme.core.BaseFragment;

public class DetallesFragment extends BaseFragment{

    public DetallesFragment() {
    }

    public static DetallesFragment newInstance(){
        return new DetallesFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_detalles,container,false);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
