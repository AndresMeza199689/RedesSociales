package clases;

import java.util.HashMap;
import java.util.Map;

public class Perfil {

    private final String identificador;
    private PanelPrivado panel;
    private Map<String, PanelSuscripcion> temasInteres;

    public Perfil(String identificador) {
        this.identificador = identificador;
        panel = new PanelPrivado(this);
        temasInteres = new HashMap<String, PanelSuscripcion>();
    }

    public void anadirTemainteres(String tema){
        temasInteres.put(tema,new PanelSuscripcion(this));
    }
    
    public PanelSuscripcion getPanelSuscripcion(String tema){
        return temasInteres.get(tema);
    }

    @Override
    public String toString() {
        return "Perfil{" + "identificador = " + identificador + '}';
    }

    public PanelPrivado getPanel() {
        return panel;
    }

    public String getIdentificador() {
        return identificador;
    }
    
    
}
