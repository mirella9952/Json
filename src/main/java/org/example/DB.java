package org.example;

import oracle.jdbc.pool.OracleDataSource;

import java.sql.*;

public class DB {
    private String user;
    private String passwd;
    private String host;
    private String port;
    private String service;
    private String ConnectionString;
    Connection con;

    public DB(String user, String passwd, String host, String port, String service) {
        this.user = user;
        this.passwd = passwd;
        this.host = host;
        this.port = port;
        this.service = service;
        this.ConnectionString="jdbc:oracle:thin:@(DESCRIPTION="
                + "(ADDRESS=(PROTOCOL=tcp)(HOST=" + host + ")(PORT=" + port + "))"
                + "(CONNECT_DATA=(SERVICE_NAME=" + service + ")))";
        con = null;
    }

    public void connect(){
        try {
            OracleDataSource dataSource = new OracleDataSource();
            dataSource.setURL(ConnectionString);
            dataSource.setUser(user);
            dataSource.setPassword(passwd);
            con = dataSource.getConnection();
            System.out.println("Verbindung steht");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public String getListe(String sql){
        String ausgabe="";
        try { Statement befehl = con.createStatement();

            ResultSet ergebnisse =  befehl.executeQuery(sql);

            while(ergebnisse.next()){
                String name = ergebnisse.getString("name");
                String vorname = ergebnisse.getString("vorname");
                int pnr= ergebnisse.getInt("personal_nr");
                Date geb = ergebnisse.getDate("geburtstag");

                ausgabe +="" + name + ", " + vorname + " , " + geb +"\n";

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ausgabe;
    }

    public void insertData(String name, String vorname) {
        Statement befehl = null;
        try {
            befehl = con.createStatement();

            befehl.execute("Insert INTO Test VALUES ('" + name + "','" + vorname + "')");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void close(){
        try{
            con.close();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
