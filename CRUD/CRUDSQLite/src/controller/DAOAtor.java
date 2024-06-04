package controller;

import model.Ator;

import java.sql.*;
import java.util.ArrayList;

public class DAOAtor {
    private static final String path = "jdbc:sqlite:moviesDB.db";
    private Connection conn = null;

    public ArrayList<Ator> fetchAll(){
        var atorList = new ArrayList<Ator>();
        try(Connection conn = DriverManager.getConnection(path);
            Statement stmt = conn.createStatement()) {

            String fetchAllSQL = "SELECT * FROM Ator;";
            ResultSet rs = stmt.executeQuery(fetchAllSQL);
            while(rs.next()){
                Ator ator = new Ator(rs.getString("nome"), rs.getString("data_nascimento"));
                atorList.add(ator);
                System.out.println("O ator: "+ ator.toString() + " foi adicionado na lista.");
            }
            return atorList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Ator fetch(String nomeAtor){
        try(Connection conn = DriverManager.getConnection(path);
            Statement stmt = conn.createStatement()){
            ArrayList<String> papeis = new ArrayList<>();

            String fetch = String.format("""
                    SELECT elenco.papel, ator.nome, ator.data_nascimento 
                    FROM Ator ator 
                    JOIN Elenco elenco 
                    ON ator.id = elenco.ator_id 
                    WHERE ator.nome = '%s';
                    """, nomeAtor);
            ResultSet rs = stmt.executeQuery(fetch);
            var ator = new Ator(rs.getString("nome"), rs.getString("data_nascimento"));
            while(rs.next()){
                papeis.add(rs.getString("papel"));
            }
            ator.setPapeis(papeis);
            return ator;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Ator insertAtor(Ator ator){
        String insertSQL = " INSERT INTO Ator (nome, data_nascimento) values (?,?);";
        try(Connection conn = DriverManager.getConnection(path);
            PreparedStatement pstmt = conn.prepareStatement(insertSQL)){

            pstmt.setString(1, ator.getNome());
            pstmt.setString(2, ator.getData_nascimento());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
