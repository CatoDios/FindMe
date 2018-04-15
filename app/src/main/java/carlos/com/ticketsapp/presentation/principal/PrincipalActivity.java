package carlos.com.ticketsapp.presentation.principal;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
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



import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import carlos.com.ticketsapp.R;
import carlos.com.ticketsapp.core.BaseActivity;
import carlos.com.ticketsapp.data.local.SessionManager;
import carlos.com.ticketsapp.data.models.UserEntity;
import carlos.com.ticketsapp.presentation.auth.LoginActivity;
import carlos.com.ticketsapp.presentation.profile.ProfileActivity;
import carlos.com.ticketsapp.presentation.splash.InicioActivity;
import carlos.com.ticketsapp.utils.ActivityUtils;

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


        tv_username = (TextView) header.findViewById(R.id.tv_name);
        imageView = (ImageView) header.findViewById(R.id.imgCliente);
        tvEmail = (TextView) header.findViewById(R.id.tv_email);

        initHeader();
        //findViewById(R.id.appbar).bringToFront();
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        //findViewById(R.id.appbar).setOutlineProvider(null);

        fragment = (PrincipalFragment) getSupportFragmentManager()
                .findFragmentById(R.id.body);


        //ACTIVA VALIDACIÓN DE SERVICIOS
       /* if(!mSessionManager.getUserEntity().isIdValidaServicio()){
            navigationView.getMenu().findItem(R.id.ac_validar).setVisible(false);
        }*/


        if (fragment == null) {
            fragment = PrincipalFragment.newInstance();

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    fragment, R.id.body);
        }
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
                            case R.id.ac_pedidos:
                                next(PrincipalActivity.this, null, InicioActivity.class, false);
                                break;

                            case R.id.ac_cerrar_sesion:
                                CloseSession();
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

                            case R.id.ac_ayuda:
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
            tv_username.setText(mUser.getCorreo());
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
