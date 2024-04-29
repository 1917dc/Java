package model;

import java.util.List;

public interface InterfaceVeiculo {
    List<Veiculo> fetchAll();
    void save(Veiculo veiculo);
    void update(Veiculo veiculo);
    void delete(Veiculo veiculo);
}
