import controller.DatabaseControl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> generos = new ArrayList();

        generos.add(6);
        var db = new DatabaseControl();
        db.insertMovie("The Social Network", "2010", 1, generos);
    }
}