package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Държи една отворена връзка към базата данни.
 *
 * Обектът се създава веднъж, при стартиране на приложението (виж main()),
 * и се подава на всички repository класове. Класът НЕ съдържа SQL заявки —
 * заявките се пишат в repository класовете.
 *
 * Ако връзката не може да се отвори, конструкторът хвърля SQLException.
 * Това означава, че щом обект от Connect съществува, връзката е валидна —
 * няма как да получим null връзка по-късно.
 */
public class Connect implements AutoCloseable {

    /**
     * Относителен път! Файлът chinook.db се търси в папката, от която е
     * стартирано приложението (папката на проекта). Никога НЕ пишете пълен
     * път от вида D:/Desktop/chinook.db — на друга машина няма да работи.
     */
    private static final String DEFAULT_URL = "jdbc:sqlite:chinook.db";

    private final Connection conn;

    /**
     * Отваря връзка към chinook.db в папката на проекта.
     *
     * @throws SQLException ако няма драйвер за SQLite или връзката не може да се отвори
     */
    public Connect() throws SQLException {
        this(DEFAULT_URL);
    }

    /**
     * Отваря връзка по подаден connection string.
     * Полезно е за курсовите проекти, където базата се казва различно.
     *
     * @param url connection string, например "jdbc:sqlite:moqbaza.db"
     * @throws SQLException ако връзката не може да се осъществи
     */
    public Connect(String url) throws SQLException {
        this.conn = DriverManager.getConnection(url);
    }

    /**
     * @return отворената връзка; никога не е null
     */
    public Connection getConnection() {
        return conn;
    }

    /**
     * Затваря връзката. Извиква се веднъж, при спиране на приложението,
     * а не при затваряне на всяка отделна форма.
     */
    @Override
    public void close() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.err.println("Грешка при затваряне на връзката: " + ex.getMessage());
        }
    }
}