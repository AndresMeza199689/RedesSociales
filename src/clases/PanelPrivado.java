package clases;

import java.util.HashSet;
import java.util.Set;

public class PanelPrivado extends Panel {

    private Set<String> palabrasClave;
    private Set<Mensaje> mensajesSeguimiento;

    public PanelPrivado(Perfil propietario) {
        super(propietario);
        palabrasClave = new HashSet<String>();
        mensajesSeguimiento = new HashSet<Mensaje>();
    }

    public void setPalabrasClave(String... palabras) {
        for (String p : palabras) {
            palabrasClave.add(p);
        }
        mensajesSeguimiento.clear();
        for (Mensaje m : mensajes) {
            for (String p : palabrasClave) {
                if (m.getTexto().contains(p)) {
                    mensajesSeguimiento.add(m);
                }
            }
        }
    }

    @Override
    protected boolean publicable(Perfil autor, Mensaje mensaje) {
        if (mensaje == null) {
            if (autor == propietario) {
                return true;
            }
        } else {
            for (Mensaje m : mensajes) {
                if (mensaje.equals(m)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Mensaje publicarMensaje(String texto, Perfil autor, Mensaje mensaje) {
        Mensaje m = super.publicarMensaje(texto, autor, mensaje);
        if (m != null) {
            for (String p : palabrasClave) {
                if (texto.contains(p)) {
                    mensajesSeguimiento.add(m);
                }
            }
        }
        return m;
    }

    @Override
    public Mensaje publicarMensaje(String texto) {
        Mensaje m = super.publicarMensaje(texto);
        for (String p : palabrasClave) {
            if (texto.contains(p)) {
                mensajesSeguimiento.add(m);

            }
        }
        return m;
    }

    @Override
    public boolean borrarMensaje(Mensaje mensaje) {
        if (consultarRespuestas(mensaje).size() == 0 && !mensajesSeguimiento.contains(mensaje)) {
            mensajes.remove(mensaje);
            return true;
        }
        return false;
    }

}
