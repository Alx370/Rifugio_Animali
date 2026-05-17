package com.catarsi.Rifugio_Animali.sign_in;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import org.mindrot.jbcrypt.BCrypt;

public class RegistrazioneUtente {

    public static void registraUtente(String nome, String cognome, String email, String password, String telefono, String sesso,
                                      String dataNascita) {

        // Dati connessione al database
        String url = "jdbc:mysql://localhost:3306/rifugio_animali";
        String user = "catarsi";
        String pass = "portale123";

        String sql = "INSERT INTO utente (uuid, nome, cognome, email, password_hash, telefono, sesso, data_nascita) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Hash della password prima di salvarla
            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
            String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 30);

            // Imposto i valori ricevuti nel PreparedStatement
            stmt.setString(1, uuid);
            stmt.setString(2, nome);
            stmt.setString(3, cognome);
            stmt.setString(4, email);
            stmt.setString(5, hashedPassword); //  password hashata
            stmt.setString(6, telefono);
            stmt.setString(7, sesso);
            stmt.setDate(8, java.sql.Date.valueOf(dataNascita)); 

            int righeInserite = stmt.executeUpdate();

            if (righeInserite > 0) {
                System.out.println("Utente registrato con successo!");
            } else {
                System.out.println("Errore durante la registrazione.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
