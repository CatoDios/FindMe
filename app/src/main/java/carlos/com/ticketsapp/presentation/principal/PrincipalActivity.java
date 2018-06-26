package carlos.com.ticketsapp.presentation.principal;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import carlos.com.ticketsapp.R;
import carlos.com.ticketsapp.core.BaseActivity;
import carlos.com.ticketsapp.data.local.SessionManager;
import carlos.com.ticketsapp.data.models.UserEntity;
import carlos.com.ticketsapp.presentation.auth.LoginActivity;
import carlos.com.ticketsapp.presentation.ayuda.ayuda1;
import carlos.com.ticketsapp.presentation.estado.EstadoActivity;
import carlos.com.ticketsapp.presentation.estado.EstadoFragment;
import carlos.com.ticketsapp.presentation.principal.BottomBar.Historial.HistorialFragment;
import carlos.com.ticketsapp.presentation.principal.BottomBar.Hoy.HoyFragment;
import carlos.com.ticketsapp.presentation.principal.BottomBar.Semana.SemanaFragment;
import carlos.com.ticketsapp.presentation.profile.ProfileActivity;
import carlos.com.ticketsapp.presentation.splash.InicioActivity;

/**
 * Created by kath on 09/04/18.
 */

public class PrincipalActivity extends BaseActivity {
    DrawerLayout mDrawer;
    NavigationView navigationView;
    SessionManager mSessionManager;



    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private ActionBarDrawerToggle mDrawerToggle;
    public TextView tv_username;
    public TextView tv_codigo;
    public TextView tv_placa;
    public TextView tvEmail;
    public UserEntity mUser;
    public ImageView imageView;
    private PrincipalFragment fragment;

    private static ArrayList<Activity> activities=new ArrayList<Activity>();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mSessionManager = new SessionManager(this);
        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_hoy) {
                    HoyFragment hoyFragment=new HoyFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.body,hoyFragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(null).commit();
                }
                if (tabId == R.id.tab_semana) {
                    SemanaFragment semanaFragment=new SemanaFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.body,semanaFragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(null).commit();
                }
                if (tabId == R.id.tab_historial) {
                    HistorialFragment historialFragment=new HistorialFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.body,historialFragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(null).commit();
                }
            }
        });

        /**
         *Setup the DrawerLayout and NavigationView
         */
        mDrawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        navigationView = (NavigationView) findViewById(R.id.navigation);


        /**
         * Setup click events on the Navigation View Items.
         */


        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowHomeEnabled(true);

        setupDrawerContent(navigationView);

        mDrawerToggle = new ActionBarDrawerToggle(
                this,                    /* host Activity */
                mDrawer,                    /* DrawerLayout object */
                toolbar,
                R.string.app_name,  /* "open drawer" description for accessibility */
                R.string.app_name  /* "close drawer" description for accessibility */
        );
        mDrawerToggle.syncState();
        mDrawer.setDrawerListener(mDrawerToggle);

        mDrawerToggle.syncState();
        View header = navigationView.getHeaderView(0);

        tv_codigo=(TextView) header.findViewById(R.id.tv_codigo);
        tv_username = (TextView) header.findViewById(R.id.tv_name);
        imageView = (ImageView) header.findViewById(R.id.imgCliente);


        initHeader();
        //findViewById(R.id.appbar).bringToFront();
        //getSupportActionBar().setDisplayShowTitleEnabled(false);


        //findViewById(R.id.appbar).setOutlineProvider(null);

        fragment = (PrincipalFragment) getSupportFragmentManager()
                .findFragmentById(R.id.body);


        //ACTIVA VALIDACIÓN DE SERVICIOS
       /* if(!mSessionManager.getUserEntity().isIdValidaServicio()){
            navigationView.getMenu().findItem(R.id.ac_validar).setVisible(false);
        }*/


       /* if (fragment == null) {
            fragment = PrincipalFragment.newInstance();

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    fragment, R.id.body);
        }*/
        //Fabric.with(this, new Crashlytics());

    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {

                        menuItem.setChecked(false);
                        menuItem.setCheckable(false);

                        switch (menuItem.getItemId()) {

                            case R.id.ac_cerrar_sesion:
                                CloseSession();
                                break;

                            case R.id.ac_Pedido:
                                nextActivity(PrincipalActivity.this,null, EstadoActivity.class,false);
                                break;
                            case R.id.ac_ayuda:
                                nextActivity(PrincipalActivity.this,null, ayuda1.class,false);

                                //Intent intent = new Intent(TicketsActivity.this , ProfileActivity.class);
                                //startActivityForResult(intent, 7);
                                break;

                            /*
                            case R.id.ac_validar:
                                next(PrincipalActivity.this, null, ValidacionActivity.class, false);
                                break;

                            case R.id.ac_metodos_de_pago:
                                break;

                            case R.id.ac_promociones:
                                //next(TicketsActivity.this, null, SlideActivity.class, false);
                                break;

                            case R.id.ac_compartir:
                                //Intent intent = new Intent(TicketsActivity.this , ProfileActivity.class);
                                //startActivityForResult(intent, 7);
                                break;



                            case R.id.ac_salir:
                                CloseSession();
                                break;

                            case R.id.ac_termino:
                                break;

                            case R.id.ac_politicas:
                                break;
*/
                            default:
                                break;
                        }
                        menuItem.setChecked(false);
                        //  mDrawer.closeDrawers();
                        return true;
                    }
                });
    }

    private void CloseSession() {
        mSessionManager.closeSession();
        //AccessToken.setCurrentAccessToken(null);
        newActivityClearPreview(this, null, InicioActivity.class);
    }


    public void initHeader() {

        mUser = mSessionManager.getUserEntity();

        if (mUser != null) {
            tv_username.setText(mUser.getNombres()+" "+mUser.getApePat());
            tv_codigo.setText(mUser.getCodigo());

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    next(PrincipalActivity.this, null, ProfileActivity.class, false);
                }
            });

            //tvEmail.setText(mUser.getEmail());

            /*
            Picasso.with(getApplicationContext()).load("https://maps.googleapis.com/maps/api/staticmap?center=Albany,+NY&zoom=13&scale=1&size=600x300&maptype=roadmap&format=png&visual_refresh=true").into(imageView);
*/
        }
        else{
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    next(PrincipalActivity.this, null, LoginActivity.class, false);
                }
            });
        }


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.body);
        fragment.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case 200:

                    break;
                case 7:
                    break;
            }
        }

    }

    @Override
    public void onBackPressed() {
        if (this.mDrawer.isDrawerOpen(GravityCompat.START)) {
            this.mDrawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void salirapp() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Deseas cerrar sesion?")
                .setTitle("Cerrar Sesion")
                //.setIcon(R.drawable.btnadvertencia)
                .setCancelable(false)
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        /*SendEstado sendEstado = new SendEstado(mSessionManager.getUserEntity().getAsociado().getIdasociado(),3, 0);
                        mPresenter.sendEstado(sendEstado);
                        CloseSession();*/
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // some code if you want
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
