package main;

import clases.Mensaje;
import clases.Panel;
import clases.PanelPrivado;
import clases.PanelSuscripcion;
import clases.Perfil;
import java.util.ArrayList;

public class Programa {

    public static void main(String[] args) {

        Perfil p = new Perfil("Juan");
        p.anadirTemainteres("Java vs. C++");

        Perfil p1 = new Perfil("Pedro");
        p1.anadirTemainteres("El nuevo estadio del Real Madrid");

        Perfil p2 = new Perfil("Enrique");

        ArrayList<Perfil> perfiles = new ArrayList<Perfil>(3);
        perfiles.add(p);
        perfiles.add(p1);
        perfiles.add(p2);

        ArrayList<Panel> paneles = new ArrayList<Panel>();
        for (Perfil perfil : perfiles) {
            p.getPanel().publicarMensaje("Hola soy " + perfil.getIdentificador() + " ¡Bienvenidos!");
            paneles.add(perfil.getPanel());
            if (perfil.getIdentificador().equals("Juan")) {
                paneles.add(perfil.getPanelSuscripcion("Java vs. C++"));
            }
            if(perfil.getIdentificador().equals("Pedro")){
                paneles.add(perfil.getPanelSuscripcion("El nuevo estadio del Real Madrid"));
            }
        }

        for (Panel panel : paneles) {

                if (panel.getClass().getSimpleName().equals("PanelPrivado")) {
                    PanelPrivado pP = (PanelPrivado) panel;
                    pP.setPalabrasClave("Hola", "Real Madrid", "Futbol");
                }

        }

        for (Perfil perfil : perfiles) {
            for (Panel panel : paneles) {

                    if (panel.getClass().getSimpleName().equals("PanelSuscripcion") && !panel.getPropietario().equals(perfil)) {
                        PanelSuscripcion pS = (PanelSuscripcion) panel;
                        pS.anadirColaborador(perfil);
                        pS.publicarMensaje("Muy Interesante");
                    }
               
            }
        }

        for (Panel panel : paneles) {

                System.out.println(panel.toString() + "#Mensajes=" + panel.getMensajes().size());

                if (panel.getClass().getSimpleName().equals("PanelSuscripcion")) {
                    for (Mensaje mensaje : panel.getMensajes()) {
                        System.out.println(mensaje.toString());
                    }
              }
            }
        }
    }


