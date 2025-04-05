package co.edu.konradlorenz.model;

import java.util.ArrayList;
import java.util.List;


public class SeguridadBancaria {
    private List<Valor> listaValoresCustodiados;
    private List<Objeto> listaObjetos;

    public SeguridadBancaria() {
        this.listaValoresCustodiados = new ArrayList<>();
        this.listaObjetos = new ArrayList<>();
    }

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

    public void agregarValor(Valor valor) {
        if (valor != null) {
            listaValoresCustodiados.add(valor);
        }
    }

    public void retirarValor(int idValor) {
        listaValoresCustodiados.removeIf(valor -> valor.getId() == idValor);
    }

    public Valor buscarValor(int idValor) {
        for (Valor valor : listaValoresCustodiados) {
            if (valor.getId() == idValor) {
                return valor;
            }
        }
        return null;
    }

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