package com.example.sqlserverprototipe02.sql

import android.util.Log
import java.sql.ResultSet
import java.sql.Statement

class SQLAcctions {

    val table = "usuario"

    fun crearUsuario(nombre: String, contrasena: String, esNutriologo: Boolean) : Boolean {

        try {
            val server = SQLConnection()
            val connection = server.obtenerConexion()

            if (connection != null) {
                val query = "INSERT INTO ${table} VALUES ('${nombre}', '${contrasena}', '${esNutriologo})"

                val st : Statement = connection.createStatement()
                val rs : Boolean = st.execute(query);
                return !rs
            }
        }
        catch (ex : Exception) {
            Log.e("Error", ex.message.toString())
            return false
        }

        return false

    }

    fun buscarUsuarioIniciarSesion(user: String, password: String)  : ResultSet? {
        try {
            val server = SQLConnection()
            val connection = server.obtenerConexion()

            if (connection != null) {
                val query = "SELECT * FROM ${table} WHERE usuario = '${user}' AND contrasena = '${password}'"

                val st : Statement = connection.createStatement()
                val rs : ResultSet = st.executeQuery(query)

                if (rs.next()) {
                    return rs
                }
                else {
                    return null
                }
            }
        }
        catch (ex : Exception) {
            Log.e("Error", ex.message.toString())
            return null
        }

        return null
    }
}