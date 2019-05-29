
package clases;

    
public class Mensaje {
    private final String texto;
    private final Perfil autor;
    private Mensaje mensaje;
    private boolean independiente;
    

    public Mensaje(String texto, Perfil autor) {
        this.texto = texto;
        this.autor = autor;
        mensaje=null;
        independiente=true;
    }
    
    public Mensaje(String texto, Perfil autor, Mensaje mensaje){
        this.texto=texto;
        this.autor=autor;
        this.mensaje=mensaje;
        independiente=false;
    }

    public String getTexto() {
        return texto;
    }

    public Perfil getAutor() {
        return autor;
    }

    public Mensaje getMensaje() {
        return mensaje;
    }

    public boolean isIndependiente() {
        return independiente;
    }

    @Override
    public String toString() {
        return "Mensaje{" + "texto=" + texto + ", autor = " + autor + ", independiente = " + independiente + '}';
    }
    
    
}
