package carlos.com.ticketsapp.presentation.principal.BottomBar.Semana;

import carlos.com.ticketsapp.data.models.ComidaEntity;
import carlos.com.ticketsapp.data.models.Semana_card;

public interface ItemSemana {

    void clickItem(Semana_card comidaEntity);
    void deleteItem(Semana_card comidaEntity, int position);


}
