package controller;

import model.InterfaceVeiculo;
import model.Veiculo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO implements InterfaceVeiculo {
    @Override
    public List<Veiculo> fetchAll() {
        List<Veiculo> veiculos = new ArrayList<>();
        var path = getPath();
        if(Files.exists(path)){
            try(var fis = Files.newInputStream(path);
                var ois = new ObjectInputStream(fis)){
                while(fis.available() > 0){
                    Veiculo veiculo = (Veiculo) ois.readObject();
                    veiculos.add(veiculo);
                }
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return veiculos;
    }

    @Override
    public void save(Veiculo veiculo) {
        var path = getPath();
        List<Veiculo> veiculos = new ArrayList<>();
        if(!Files.exists(path)){
            try {
                Files.createFile(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else{
            veiculos = fetchAll();
        }
        veiculos.add(veiculo);
        try {
            var fos = Files.newOutputStream(path);
            var oos = new ObjectOutputStream(fos);
            for(Veiculo veiculoWrite : veiculos) {
                oos.writeObject(veiculoWrite);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(Veiculo veiculo) {
        var path = getPath();
        List<Veiculo> veiculos = fetchAll();
        if(Files.exists(path)){
            for(Veiculo veiculoEditOut : veiculos){
                try {
                    var fos = Files.newOutputStream(path);
                    var oos = new ObjectOutputStream(fos);
                    if(veiculoEditOut.equals(veiculo)){
                        oos.writeObject(veiculoEditOut);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public void delete(Veiculo veiculo) {

    }
    public static Path getPath(){
        Path path = Paths.get("veiculos.txt");
        return path;
    }
}
