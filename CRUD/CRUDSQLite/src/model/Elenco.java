package model;

import java.util.ArrayList;

public class Elenco {
    private Integer filme_id;
    private ArrayList<Ator> ator;

    public Elenco(Integer filme_id, ArrayList<Ator> ator) {
        this.filme_id = filme_id;
        this.ator = ator;
    }

    public Integer getFilme_id() {
        return filme_id;
    }

    public void setFilme_id(Integer filme_id) {
        this.filme_id = filme_id;
    }

    public ArrayList<Ator> getAtor() {
        return ator;
    }

    public void setAtor(ArrayList<Ator> ator) {
        this.ator = ator;
    }
}
