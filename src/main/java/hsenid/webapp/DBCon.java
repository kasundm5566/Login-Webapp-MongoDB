package hsenid.webapp;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import java.sql.Connection;
import java.sql.DatabaseMetaData;

/**
 * Created by hsenid.
 *
 * @author hsenid
 */
public class DBCon {

    private static Connection connection;

    /**
     * @param host Host of the MongoDB database
     * @param port MongoDB port
     */
    static DB database;
    public static DB CreateConnection(String host, String port) {
        try {
            MongoClient mongo = new MongoClient(host, Integer.parseInt(port));
            database = mongo.getDB("userdata");
        } catch (Exception ex) {
            Login.error="Something bad happened. Try again later.";
        }
        return database;
    }

    /**
     * @return returns Connection object
     */
    public static DB getConnection() {
        return database;
    }
}
