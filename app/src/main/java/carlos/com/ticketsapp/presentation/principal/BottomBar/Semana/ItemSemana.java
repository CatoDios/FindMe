package carlos.com.ticketsapp.presentation.principal.BottomBar.Semana;

import carlos.com.ticketsapp.data.models.ComidaEntity;

public interface ItemSemana {

    void clickItem(ComidaEntity comidaEntity);
    void deleteItem(ComidaEntity comidaEntity, int position);


}
