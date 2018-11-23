package carlos.com.findme.presentation.seguimientos;

import android.content.Context;
import android.support.v7.widget.CardView;
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
import carlos.com.findme.data.models.desaparicion.Desaparecido;

public class SeguimientosAdapter extends LoaderAdapter<Desaparecido> {


    private Context context;
    private ItemSeguimientos itemCarrito;

    public ArrayList<Desaparecido> getItems() {
        return (ArrayList<Desaparecido>) getmItems();
    }

    public SeguimientosAdapter(ArrayList<Desaparecido> producto_bds, Context context, ItemSeguimientos itemCarrito) {
        super(context);
        setItems(producto_bds);
        this.context = context;
        this.itemCarrito = itemCarrito;
    }

    @Override
    public long getYourItemId(int position) {
        return 1;
    }

    @Override
    public RecyclerView.ViewHolder getYourItemViewHolder(ViewGroup parent) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_seguimiento, parent, false);
        return new ViewHolder(root);
    }

    @Override
    public void bindYourViewHolder(RecyclerView.ViewHolder holder, int position) {
        final int posicion = position;
        final Desaparecido desaparecido = getItems().get(position);
        ((ViewHolder) holder).tvNombres.setText(desaparecido.getNombres());

        //Picasso.get().load(producto_bd.getImage()).into(((ViewHolder) holder).imagen);
        ((ViewHolder) holder).card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemCarrito.clickItem(desaparecido);
            }
        });


    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.card)
        CardView card;
        @BindView(R.id.tv_nombres)
        TextView tvNombres;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
