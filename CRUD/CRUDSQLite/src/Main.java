import controller.DAOAtor;
import controller.DatabaseControl;
import model.Ator;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        var atorDAO = new DAOAtor();

        var ator = new Ator("Tom Cruise", "1962-06-03");
        var ator2 = new Ator("Jung Hae-In", "1988-04-01");

        atorDAO.insertAtor(ator);
        atorDAO.insertAtor(ator2);
    }
}