package carlos.com.ticketsapp.data.models;

import java.io.Serializable;

public class MenuEntity implements Serializable{
    AlmuerzoEntity almuerzo;
    CenaEntity cena;

    public AlmuerzoEntity getAlmuerzo() {
        return almuerzo;
    }

    public void setAlmuerzo(AlmuerzoEntity almuerzo) {
        this.almuerzo = almuerzo;
    }

    public CenaEntity getCena() {
        return cena;
    }

    public void setCena(CenaEntity cena) {
        this.cena = cena;
    }
}
