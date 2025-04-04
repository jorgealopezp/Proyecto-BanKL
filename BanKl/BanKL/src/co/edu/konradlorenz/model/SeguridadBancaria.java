package co.edu.konradlorenz.model;

import java.util.ArrayList;
import java.util.List;


public class SeguridadBancaria {

    private List<Valor> listaValoresCustodiados;

    public SeguridadBancaria() {
        this.listaValoresCustodiados = new ArrayList<>();
    }

    public SeguridadBancaria(List<Valor> listaValoresCustodiados) {
        this.listaValoresCustodiados = listaValoresCustodiados;
    }

    public List<Valor> getListaValoresCustodiados() {
        return listaValoresCustodiados;
    } 

    public void setListaValoresCustodiados(List<Valor> listaValoresCustodiados) {
        this.listaValoresCustodiados = listaValoresCustodiados;
    }

    public void agregarValor(Valor valor) {
        if (valor != null) {
            listaValoresCustodiados.add(valor);
        }
    }

    public void retirarValor(int idValor) {
        listaValoresCustodiados.removeIf(valor -> valor.getId() == idValor);
    }

    public List<Valor> listarValores() {
        return new ArrayList<>(listaValoresCustodiados);
    }
    public Valor buscarValor(int idValor) {
    for (Valor valor : listaValoresCustodiados) {
        if (valor.getId() == idValor) {
            return valor;
        }
    }
    return null;
}

public boolean existeValor(int idValor) {
    return listaValoresCustodiados.stream().anyMatch(valor -> valor.getId() == idValor);
}

}
