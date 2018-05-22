package carlos.com.ticketsapp.presentation.principal.BottomBar.Semana;

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
import carlos.com.ticketsapp.R;
import carlos.com.ticketsapp.core.LoaderAdapter;
import carlos.com.ticketsapp.data.models.Comida;
import carlos.com.ticketsapp.data.models.ComidaEntity;
import carlos.com.ticketsapp.utils.OnClickListListener;

public class SemanaAdapter extends LoaderAdapter<ComidaEntity> implements OnClickListListener{

    private Context context;
    private ItemSemana itemSemana;

    public SemanaAdapter(ArrayList<ComidaEntity> comidaEntities,Context context,ItemSemana itemSemana) {
        super(context);
        setItems(comidaEntities);
        this.context=context;
        this.itemSemana = itemSemana;
    }

    public ArrayList<ComidaEntity> getItems() {
        return (ArrayList<ComidaEntity>) getmItems();
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
        final ComidaEntity comidaEntity=getItems().get(position);

        ((ViewHolder) holder).tvDia.setText(comidaEntity.getDia());

        ((ViewHolder) holder).tvTipo.setText(comidaEntity.getComidaTipo());
        ((ViewHolder) holder).tvAlm2.setText(comidaEntity.getNombre());
        ((ViewHolder) holder).tvAlm3.setText(String.valueOf(comidaEntity.getNumRaciones()));
        ((ViewHolder) holder).tvAlm1.setText(comidaEntity.getDescripcion());

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
        ComidaEntity comidaEntity=getItems().get(position);
        itemSemana.clickItem(comidaEntity);
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.tv_dia)
        TextView tvDia;
        @BindView(R.id.tipo)
        TextView tvTipo;

        @BindView(R.id.tv_alm_1)
        TextView tvAlm1;
        @BindView(R.id.tv_alm_2)
        TextView tvAlm2;
        @BindView(R.id.tv_alm_3)
        TextView tvAlm3;

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
