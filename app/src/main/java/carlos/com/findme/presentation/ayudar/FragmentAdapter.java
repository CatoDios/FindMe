package carlos.com.findme.presentation.ayudar;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import carlos.com.findme.presentation.seguimiento.seguimiento_tabs.ComentariosFragment;
import carlos.com.findme.presentation.seguimiento.seguimiento_tabs.DatosFragment;
import carlos.com.findme.presentation.seguimiento.seguimiento_tabs.FechaFragment;
import carlos.com.findme.presentation.seguimiento.seguimiento_tabs.LugarFragment;

public class FragmentAdapter extends FragmentPagerAdapter {
    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment baseFragment=ReporteFragment.newInstance();
        switch (position){
            case 0:baseFragment=ReporteFragment.newInstance();
                break;
            case 1:baseFragment=DetalleFragment.newInstance();
                break;
        }
        return baseFragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        CharSequence a="";
        switch (position){
            case 0:a="REPORTE";
                break;
            case 1:a="DETALLE";
                break;
        }
        return a;
    }
}
