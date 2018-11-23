package carlos.com.findme.presentation.seguimientos;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import carlos.com.findme.R;
import carlos.com.findme.core.LoaderAdapter;
import carlos.com.findme.data.models.desaparicion.Desaparecido;
import de.hdodenhof.circleimageview.CircleImageView;

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

        if (position%4==0){
            Picasso.get().load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRq6CwrVLiolN2jDJ49P1_9tbQQ4_utezOdUwpTipGn2ukBmYNs").into(((ViewHolder) holder).tvFoto);
        }else if(position%4==1){
            Picasso.get().load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS40JtwvAon2bBAW87bTNBTToHTSyvwO4ayb1tBj_73T65Wcl5tyw").into(((ViewHolder) holder).tvFoto);

        }else if(position%4==2){
            Picasso.get().load("https://e00-elmundo.uecdn.es/elmundosalud/imagenes/2013/07/09/noticias/1373393588_0.jpg").into(((ViewHolder) holder).tvFoto);

        }else if(position%4==3){
            Picasso.get().load("https://i.ytimg.com/vi/hfVVWtnoESg/maxresdefault.jpg").into(((ViewHolder) holder).tvFoto);

        }

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
        @BindView(R.id.foto)
        CircleImageView tvFoto;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
