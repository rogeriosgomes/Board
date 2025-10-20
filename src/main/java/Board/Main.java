package Board;

import Board.persistence.migration.MigrationStrategy;
import Board.ui.MainMenu;

import java.sql.SQLException;

import static Board.persistence.config.ConnectionConfig.getConnection;


public class Main {

    public static void main(String[] args) throws SQLException {
        try(var connection = getConnection()){
            new MigrationStrategy(connection).executeMigration();
        }

        new MainMenu().execute();

    }

}
