package carlos.com.findme.data.models.desaparicion;

import java.util.ArrayList;
import java.util.Random;

import io.realm.Realm;
import io.realm.RealmResults;

public class ServicioDesaparecido {
    private Realm realm;

    public ServicioDesaparecido(Realm realm) {
        this.realm = realm;
    }

    public void newDesaparecido(  int pk,

             String nombres,
             String apellidos,
             int edad,
             float talla,
             String color_cabello,
             String color_piel,
             String otros,
                                  String fecha,
                                  String hora
    ){
        realm.beginTransaction();
        Random aleatorio=new Random(System.currentTimeMillis());
        int intAleatorio=aleatorio.nextInt(1000000000);
        Desaparecido desaparecido=realm.createObject(Desaparecido.class,intAleatorio);
        desaparecido.setNombres(nombres);
        desaparecido.setApellidos(apellidos);
        desaparecido.setEdad(edad);
        desaparecido.setTalla(talla);
        desaparecido.setColor_cabello(color_cabello);
        desaparecido.setColor_piel(color_piel);
        desaparecido.setOtros(otros);
        desaparecido.setFecha(fecha);
        desaparecido.setHora(hora);
        realm.commitTransaction();

    }
    public ArrayList<Desaparecido> getDesaparecidos(){
        ArrayList<Desaparecido> respuesta=new ArrayList<>();
        RealmResults<Desaparecido>results= realm.where(Desaparecido.class).findAll();
        respuesta.addAll(realm.copyFromRealm(results));
        return respuesta;
    }
}
