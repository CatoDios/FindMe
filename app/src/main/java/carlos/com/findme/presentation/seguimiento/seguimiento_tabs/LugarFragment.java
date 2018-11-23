package carlos.com.findme.presentation.seguimiento.seguimiento_tabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import carlos.com.findme.R;
import carlos.com.findme.core.BaseFragment;

public class LugarFragment extends BaseFragment implements OnMapReadyCallback {
    GoogleMap mMap;
    Unbinder unbinder;
    LatLng latLng;
    SupportMapFragment mapFrag;
    public static LugarFragment newInstance() {

        Bundle args = new Bundle();

        LugarFragment fragment = new LugarFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_lugar, container, false);
        unbinder = ButterKnife.bind(this, root);


        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapFrag= (SupportMapFragment) this.getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFrag.getMapAsync(this);
        Bundle arg = getActivity().getIntent().getExtras();
        latLng=new LatLng(arg.getDouble("latitud"),arg.getDouble("longitud"));

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap=googleMap;
        mMap.addMarker(new MarkerOptions().position(latLng).title("Lugar"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 17));
    }
}
