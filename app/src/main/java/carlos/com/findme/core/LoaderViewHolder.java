package carlos.com.findme.core;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;



import butterknife.BindView;
import butterknife.ButterKnife;
import carlos.com.findme.R;


/**
 * Created by elanicdroid on 14/09/15.
 */
public class LoaderViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.progressbar)
    ProgressBar mProgressBar;

    public LoaderViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}