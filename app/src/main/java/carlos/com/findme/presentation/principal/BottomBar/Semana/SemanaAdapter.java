package carlos.com.findme.presentation.principal.BottomBar.Semana;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import carlos.com.findme.R;
import carlos.com.findme.core.LoaderAdapter;
import carlos.com.findme.data.models.Semana_card;
import carlos.com.findme.utils.OnClickListListener;

public class SemanaAdapter extends LoaderAdapter<Semana_card> implements OnClickListListener{

    private Context context;
    private ItemSemana itemSemana;

    public SemanaAdapter(ArrayList<Semana_card> comidaEntities, Context context, ItemSemana itemSemana) {
        super(context);
        setItems(comidaEntities);
        this.context=context;
        this.itemSemana = itemSemana;
    }

    public ArrayList<Semana_card> getItems() {
        return (ArrayList<Semana_card>) getmItems();
    }


    @Override
    public long getYourItemId(int position) {
        return 1;
    }

    @Override
    public RecyclerView.ViewHolder getYourItemViewHolder(ViewGroup parent) {
        View root= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_semana,parent,false);

        return new SemanaAdapter.ViewHolder(root,this);
    }

    @Override
    public void bindYourViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Semana_card semana_card=getItems().get(position);

        ((ViewHolder) holder).tvDia.setText(semana_card.getDia());


        ((ViewHolder) holder).tv_desayuno.setText(semana_card.getDesayuno());
        ((ViewHolder) holder).tv_almuerzo.setText(semana_card.getAlmuerzo());
        ((ViewHolder) holder).tv_cena.setText(semana_card.getCena());

        if (position%4==0){
            Picasso.get().load(R.drawable.semana1).into(((ViewHolder) holder).imgComida);
        }else if (position%4==1){
            Picasso.get().load(R.drawable.semana2).into(((ViewHolder) holder).imgComida);
        }else if (position%4==2) {
            Picasso.get().load(R.drawable.semana3).into(((ViewHolder) holder).imgComida);
        }
        else  {
            Picasso.get().load(R.drawable.semana4).into(((ViewHolder) holder).imgComida);
        }



    }

    @Override
    public void onClick(int position) {
        Semana_card semana_card=getItems().get(position);
        itemSemana.clickItem(semana_card);
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.tv_dia)
        TextView tvDia;


        @BindView(R.id.tv_desayuno)
        TextView tv_desayuno;
        @BindView(R.id.tv_almuerzo)
        TextView tv_almuerzo;
        @BindView(R.id.tv_cena)
        TextView tv_cena;

        @BindView(R.id.img_comida)
        ImageView imgComida;



        private OnClickListListener onClickListListener;

        public ViewHolder(View itemView,OnClickListListener onClickListListener) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            this.onClickListListener = onClickListListener;
            this.itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            onClickListListener.onClick(getAdapterPosition());
        }
    }

}
