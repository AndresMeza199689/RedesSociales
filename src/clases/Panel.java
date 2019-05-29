package clases;

import java.util.ArrayList;

public abstract class Panel {

    protected final Perfil propietario;
    protected ArrayList<Mensaje> mensajes;

    public Panel(Perfil propietario) {
        this.propietario = propietario;
        mensajes = new ArrayList<Mensaje>();
    }

    public ArrayList<Mensaje> consultarRespuestas(Mensaje mensaje) {
        ArrayList<Mensaje> respuestas = new ArrayList<Mensaje>();
        for (Mensaje m : mensajes) {
            if (!m.isIndependiente() && m.getMensaje().equals(mensaje)) {
                respuestas.add(m);
            }
        }
        return respuestas;
    }

    public boolean borrarMensaje(Mensaje mensaje) {
        if (consultarRespuestas(mensaje).size() == 0) {
            mensajes.remove(mensaje);
            return true;
        }
        return false;
    }

    public Mensaje publicarMensaje(String texto, Perfil autor, Mensaje mensaje) {
        if (publicable(autor, mensaje)) {
            if (mensaje == null) {
                publicarMensaje(texto);
            } else {
                Mensaje m = new Mensaje(texto, autor, mensaje);
                mensajes.add(m);
                return m;
            }
        }
        return null;
    }

    public Mensaje publicarMensaje(String texto) {
        Mensaje m = new Mensaje(texto, propietario);
        mensajes.add(m);
        return m;

    }

    public Perfil getPropietario() {
        return propietario;
    }

    @Override
    public String toString() {
        return "Panel{" +this.getClass().getSimpleName()+ " propietario = " + propietario + '}';
    }

   

    public ArrayList<Mensaje> getMensajes() {
        return mensajes;
    }

    
    
    protected abstract boolean publicable(Perfil autor, Mensaje mensaje);
}
