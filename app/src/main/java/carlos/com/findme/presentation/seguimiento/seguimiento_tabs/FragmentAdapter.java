package carlos.com.findme.presentation.seguimiento.seguimiento_tabs;


import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragmentAdapter extends FragmentPagerAdapter {
    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment baseFragment=DatosFragment.newInstance();
        switch (position){
            case 0:baseFragment=DatosFragment.newInstance();
                break;
            case 1:baseFragment=LugarFragment.newInstance();
                break;
            case 2:baseFragment=FechaFragment.newInstance();
                break;
            case 3:baseFragment=ComentariosFragment.newInstance();
                break;
        }
        return baseFragment;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        CharSequence a="";
        switch (position){
            case 0:a="DATOS";
                break;
            case 1:a="LUGAR";
                break;
            case 2:a="FECHA";
                break;
            case 3:a="COMENTARIOS";
                break;
        }
        return a;
    }

}
