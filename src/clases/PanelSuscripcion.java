
package clases;

import java.util.HashSet;
import java.util.Set;


public class PanelSuscripcion extends Panel{
    private Set<Perfil> colaboradores;
    
    public PanelSuscripcion(Perfil propietario) {
        super(propietario);
        colaboradores=new HashSet<Perfil>();
    }
    
    public void anadirColaborador(Perfil p){
        colaboradores.add(p);
    }
    
    public void eliminarColaborador(Perfil p){
        colaboradores.remove(p);
    }

    @Override
    protected boolean publicable(Perfil autor, Mensaje mensaje) {
       if(autor.equals(propietario) || colaboradores.contains(autor)){
           return true;
       }
       return false;
    }

   

   }
