package com.example.sqlserverprototipe02.sql

import android.os.StrictMode
import android.util.Log
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class SQLConnection {
    private val ip = "192.168.1.8" // localhost sql server IP @Fabian_PC
    private val port = "1433" // default port in SQL Server (Verify this)
    private val dataBase = "KiloKappDB" // database name
    private val userDb = "sa"; // system administrator user
    private val password = "sa1922342"


    fun obtenerConexion() : Connection? {

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        var connection : Connection? = null
        val connectionString : String

        try {
            // Instancia del controlador de conexion
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance()
            // declaramos la cadena que apunta a la base de datos.
            connectionString = "jdbc:jtds:sqlserver://" + ip + ":" + port + ";databasename=" + dataBase + ";User=" + userDb + ";password=" + password + ";"
            connection = DriverManager.getConnection(connectionString)

        } catch (ex : SQLException) {
            Log.e("Error", ex.message.toString())
        }
        catch (ex : ClassNotFoundException) {
            Log.e("Error", ex.message.toString())
        }
        catch (ex : Exception) {
            Log.e("Error", ex.message.toString())
        }

        return connection
    }
}