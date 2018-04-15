package carlos.com.ticketsapp.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.inthecheesefactory.thecheeselibrary.fragment.support.v4.app.StatedFragment;

/**
 * Created by kath on 26/02/18.
 */

public abstract class BaseMapFragment extends StatedFragment {

    private boolean loading = false;
    private static final int PLACE_AUTOCOMPLETE_REQUEST_CODE = 1;
    private static final String LOG_TAG = "PlaceSelectionListener";


    protected void nextActivity(Activity context, Bundle bundle, Class<?> activity, boolean destroy) {
        Intent intent = new Intent(context, activity);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        if (destroy) context.finish();
    }

    protected void newActivityClearPreview(Activity context, Bundle bundle, Class<?> activity) {
        Intent intent = new Intent(context, activity);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        context.finish();
    }

    protected void nextActivityNewTask(Activity context, Bundle bundle, Class<?> activity, boolean destroy) {
        Intent intent = new Intent(context, activity);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        if (destroy) context.finish();
    }


    public boolean isLoading() {
        return loading;
    }

    public void setLoading(boolean loading) {
        this.loading = loading;
    }



    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(getContext().INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
    }


    public boolean isOpenKeyboard() {
        InputMethodManager imm = (InputMethodManager) getActivity()
                .getSystemService(Context.INPUT_METHOD_SERVICE);

        if (imm.isAcceptingText()) {
            return true;
        } else {
            return false;
        }
    }



    public void visibleLayoutToogle(boolean active, View view) {
        if (active) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
        }

    }



 /*   @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (resultCode == Activity.RESULT_OK) {
                Place place = PlaceAutocomplete.getPlace(getContext(), data);
                onPlaceSelected(place);

            } else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
                Status status = PlaceAutocomplete.getStatus(getContext(), data);
                Toast.makeText(getContext(), "Error " + status, Toast.LENGTH_SHORT).show();

            } else if (resultCode == RESULT_CANCELED) {
                // The user canceled the operation.
            }
        }
        Toast.makeText(getActivity(), "Fragment Got it: " + requestCode + ", " + resultCode, Toast.LENGTH_SHORT).show();
    }
*/


    /*@Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100) {
            if (resultCode == Activity.RESULT_OK) {
                Place place = PlaceAutocomplete.getPlace(getContext(), data);
                onPlaceSelected(place);

            } else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
                Status status = PlaceAutocomplete.getStatus(getContext(), data);
                Toast.makeText(getContext(), "Error " + status, Toast.LENGTH_SHORT).show();

            } else if (resultCode == RESULT_CANCELED) {
                // The user canceled the operation.
            }
        }


    }*/

    /*  @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {

            Fragment fragment = getActivity().getSupportFragmentManager().findFragmentById(R.id.body);
            if (fragment != null) {
                fragment.onActivityResult(requestCode, resultCode, data);


            }


        }
    */
    public void openPlaceAutoCompleteView() {
        try {
            Intent intent =
                    new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN)
                            .build(getActivity());
           startActivityForResult(intent, 100);
        } catch (GooglePlayServicesRepairableException | GooglePlayServicesNotAvailableException e) {
            // TODO: Handle the error.
        }

    }

    protected abstract void onPlaceSelected(Place place);

    public void onError(Status status) {
        Log.e(LOG_TAG, "onError: Status = " + status.toString());
        Toast.makeText(getContext(), "Place selection failed: " + status.getStatusMessage(),
                Toast.LENGTH_SHORT).show();
    }
}
