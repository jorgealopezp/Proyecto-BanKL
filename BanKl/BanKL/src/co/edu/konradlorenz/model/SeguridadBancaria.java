package co.edu.konradlorenz.model;

import java.util.ArrayList;
import java.util.List;


public class SeguridadBancaria {
    private List<Valor> listaValoresCustodiados;
    private List<Objeto> listaObjetos;
    //CONSTRUCTOR
    public SeguridadBancaria() {
        this.listaValoresCustodiados = new ArrayList<>();
        this.listaObjetos = new ArrayList<>();
    }
    //GETTERS Y SETTERS
    public List<Valor> getListaValoresCustodiados() {
        return listaValoresCustodiados;
    }

    public void setListaValoresCustodiados(List<Valor> listaValoresCustodiados) {
        this.listaValoresCustodiados = listaValoresCustodiados;
    }

    public List<Objeto> getListaObjetos() {
        return listaObjetos;
    }

    public void setListaObjetos(List<Objeto> listaObjetos) {
        this.listaObjetos = listaObjetos;
    }
    /// Métodos para agregar valores a la lista
    public void agregarValor(Valor valor) {
        if (valor != null) {
            listaValoresCustodiados.add(valor);
        }
    }
    /// Método para retirar un valor de la lista
    public void retirarValor(int idValor) {
        listaValoresCustodiados.removeIf(valor -> valor.getId() == idValor);
    }
    /// Método para buscar un valor en la lista
    public Valor buscarValor(int idValor) {
        for (Valor valor : listaValoresCustodiados) {
            if (valor.getId() == idValor) {
                return valor;
            }
        }
        return null;
    }
    // Método para agregar un objeto a la lista
    public void agregarObjeto(Objeto objeto) {
        if (objeto != null) {
            listaObjetos.add(objeto);
        }
    }

    public void retirarObjeto(int idObjeto) {
        listaObjetos.removeIf(objeto -> objeto.getId() == idObjeto);
    }

    public Objeto buscarObjeto(int idObjeto) {
        for (Objeto objeto : listaObjetos) {
            if (objeto.getId() == idObjeto) {
                return objeto;
            }
        }
        return null;
    }
}