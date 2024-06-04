package controller;

import java.sql.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class DatabaseControl {
    private static final String path = "jdbc:sqlite:moviesDB.db";
    private Connection conn = null;

    public void selectAllMovies() {
        String tableName = "Filme";
        try {
            conn = DriverManager.getConnection(path);
            Statement stmt = conn.createStatement();
            String selectAllSQL = MessageFormat.format("SELECT * FROM {0}", tableName);
            ResultSet rsFilme = stmt.executeQuery(selectAllSQL);


            while (rsFilme.next()) {
                String selectDiretoresSQL = MessageFormat.format("""
                        SELECT diretor.nome FROM Filme filme 
                        JOIN Diretor diretor 
                        ON filme.diretor_id = diretor.id
                        WHERE filme.id = {0};
                        """, rsFilme.getRow());

                Statement stmtDiretor = conn.createStatement();
                ResultSet rsDiretor = stmtDiretor.executeQuery(selectDiretoresSQL);

                System.out.println("------------------------------------------");
                System.out.println("Filme: " + rsFilme.getString("titulo"));
                System.out.println("Ano: " + rsFilme.getString("ano"));
                System.out.println("Diretor: " + rsDiretor.getString("nome"));
                System.out.println("-----------------------------------------");


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection(conn);
        }
    }

    public void insertMovie(String titulo, String ano, String nomeDiretor, List<Integer> generos) {
        try {
            String insertMovieSQL = "INSERT INTO Filme(titulo, ano, diretor_id) VALUES(?,?,?)";
            conn = DriverManager.getConnection(path);

            Statement stmtDiretor = conn.createStatement();
            String selectDiretorSQL = String.format("SELECT id FROM Diretor WHERE nome = '%s';", nomeDiretor);
            ResultSet rsDiretor = stmtDiretor.executeQuery(selectDiretorSQL);
            int diretor_id = rsDiretor.getInt("id");

            PreparedStatement pstmtFilme = conn.prepareStatement(insertMovieSQL);
            pstmtFilme.setString(1, titulo);
            pstmtFilme.setString(2, ano);
            pstmtFilme.setInt(3, diretor_id);
            pstmtFilme.executeUpdate();

            Statement stmt = conn.createStatement();
            String selectFilmeSQL = String.format("SELECT id FROM Filme WHERE titulo = '%s';", titulo);

            String insertFilmeGenero = "INSERT INTO Filme_Genero(genero_id, filme_id) VALUES(?,?)";
            PreparedStatement pstmtGeneroFilme = conn.prepareStatement(insertFilmeGenero);
            for (Integer generosInsert : generos) {
                ResultSet rs = stmt.executeQuery(selectFilmeSQL);
                pstmtGeneroFilme.setInt(1, generosInsert);
                pstmtGeneroFilme.setInt(2, rs.getInt("id"));
                pstmtGeneroFilme.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection(conn);
        }
    }

    private void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
