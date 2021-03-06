package carlos.com.findme.presentation.principal.BottomBar.Historial;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import carlos.com.findme.R;
import carlos.com.findme.core.LoaderAdapter;
import carlos.com.findme.data.models.FaltaEntity;

/**
 * Created by carlos on 12/06/2018.
 */

public class HistorialAdapter extends LoaderAdapter<FaltaEntity> {
    private Context context;


    public HistorialAdapter(ArrayList<FaltaEntity> faltaEntities, Context context) {
        super(context);
        setItems(faltaEntities);
        this.context=context;

    }

    public ArrayList<FaltaEntity> getItems() {
        return (ArrayList<FaltaEntity>) getmItems();
    }


    @Override
    public long getYourItemId(int position) {
        return 1;
    }

    @Override
    public RecyclerView.ViewHolder getYourItemViewHolder(ViewGroup parent) {
        View root= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_falta,parent,false);

        return new HistorialAdapter.ViewHolder(root);
    }

    @Override
    public void bindYourViewHolder(RecyclerView.ViewHolder holder, int position) {
        final FaltaEntity faltaEntity=getItems().get(position);

        ((HistorialAdapter.ViewHolder) holder).nombre.setText(faltaEntity.getNombreSancion());


        ((HistorialAdapter.ViewHolder) holder).fecha_fin.setText(faltaEntity.getFin());
        ((ViewHolder) holder).fecha_inicio.setText(faltaEntity.getInicio());


    }



    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.sancion)
        TextView nombre;


        @BindView(R.id.fecha_inicio)
        TextView fecha_inicio;
        @BindView(R.id.fecha_fin)
        TextView fecha_fin;






        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);


        }


    }
}

