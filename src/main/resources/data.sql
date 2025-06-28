-- popolamento delle tabelle

INSERT INTO Utente (nome, cognome, email, password, telefono, sesso, data_nascita) VALUES
('Luca', 'Rossi', 'luca.rossi@email.com', 'pwd123', '3331112222', 'M', '1990-05-15'),
('Anna', 'Bianchi', 'anna.bianchi@email.com', 'pwd456', '3333334444', 'F', '1985-08-22'),
('Marco', 'Verdi', 'marco.verdi@email.com', 'pwd789', NULL, 'M', '2000-01-10'),
('Sara', 'Neri', 'sara.neri@email.com', 'pwd111', '3205551234', 'F', '1995-07-12'),
('Paolo', 'Gallo', 'paolo.gallo@email.com', 'pwd222', '3396667777', 'M', '1988-11-30'),
('Elisa', 'Fontana', 'elisa.fontana@email.com', 'pwd333', NULL, 'F', '1992-03-03'),
('Giovanni', 'Ferrari', 'giovanni.ferrari@email.com', 'pwd777', '3477778888', 'M', '1991-06-18'),
('Martina', 'Russo', 'martina.russo@email.com', 'pwd888', '3491122334', 'F', '1987-12-09'),
('Andrea', 'Esposito', 'andrea.esposito@email.com', 'pwd999', '3661234567', 'M', '1994-04-21'),
('Chiara', 'Romano', 'chiara.romano@email.com', 'pwd000', NULL, 'F', '1993-09-05'),
('Stefano', 'Greco', 'stefano.greco@email.com', 'pwdabc', '3359988776', 'M', '1990-02-02'),
('Valentina', 'Gatti', 'valentina.gatti@email.com', 'pwdfgh', '3287654321', 'F', '1989-10-17'),
('Davide', 'Colombo', 'davide.colombo@email.com', 'pwdjkl', NULL, 'M', '1986-08-01'),
('Federica', 'Marchetti', 'federica.marchetti@email.com', 'pwdmno', '3401234567', 'F', '1996-07-23'),
('Roberto', 'Barone', 'roberto.barone@email.com', 'pwdpqr', '3387766554', 'M', '1983-05-30');


INSERT INTO Ente (nome, email, telefono) VALUES
('Associazione Animali Felici', 'contatti@aafelici.it', '055123456'),
('Protezione Animali Milano', 'info@pam-milano.org', '024567890'),
('Cuori a Quattro Zampe', 'info@cuorizampe.org', '0314445566'),
('Amici di Pelo', 'info@pelosi.org', '0511239876'),
('Animal Life Roma', 'contact@animalliferoma.it', '0666667777'),
('Oasi Canina Firenze', 'info@oasicanina.it', '0574123456'),
('Zampe Amiche', 'info@zampeamiche.it', '0331222333'),
('Cuccioli per Sempre', 'info@cucciolix.it', '0344555666'),
('Animal Rescue Napoli', 'napoli@animalrescue.it', '0811122334'),
('SOS Gatti Torino', 'sosgatti@torino.it', '0114455667'),
('SalvaZampe', 'help@salvazampe.org', '0777888999'),
('Amici Randagi', 'info@randagi.org', '0353322110'),
('PetHelp', 'info@pethelp.it', '0366789900'),
('Fido e Micio', 'info@fidomicio.it', '0371234567'),
('Care Pets', 'care@pets.it', '0388112233');


INSERT INTO Admin_app (email, password) VALUES
('admin2@app.it', 'admin234'),
('admin3@app.it', 'admin345'),
('admin4@app.it', 'admin456'),


INSERT INTO Animale (specie, nome, data_arrivo, data_adozione, razza, sesso, peso, eta, taglia, colore, segni_particolari) VALUES
('Gatto', 'Milo', '2024-05-10', NULL, 'Persiano', 'M', 3.20, 3, 'Piccola', 'Grigio', ''),
('Cane', 'Nina', '2024-05-15', NULL, 'Beagle', 'F', 12.00, 2, 'Media', 'Tricolore', ''),
('Cane', 'Rocky', '2024-05-20', NULL, 'Boxer', 'M', 28.00, 6, 'Grande', 'Fulvo', 'Orecchio tagliato'),
('Gatto', 'Luna', '2024-05-25', NULL, 'Europeo', 'F', 3.80, 1, 'Piccola', 'Nero', ''),
('Cane', 'Thor', '2024-06-01', NULL, 'Pastore Tedesco', 'M', 30.00, 5, 'Grande', 'Nero e focato', ''),
('Gatto', 'Stella', '2024-06-02', NULL, 'Ragdoll', 'F', 4.50, 2, 'Piccola', 'Bianco e grigio', ''),
('Cane', 'Bunny', '2024-06-03', NULL, 'Maltese', 'M', 1.20, 1, 'Piccola', 'Bianco', ''),
('Cane', 'Chicco', '2024-06-04', NULL, 'Meticcio', 'M', 15.00, 4, 'Media', 'Marrone chiaro', ''),
('Gatto', 'Mimì', '2024-06-05', NULL, 'Europeo', 'F', 3.70, 3, 'Piccola', 'Tigrato grigio', '');



INSERT INTO Adozione (id_animale, id_utente, data_adozione) VALUES
(1, 1, '2024-03-05'),
(3, 2, '2024-04-10'),
(6, 4, '2024-06-01');


INSERT INTO Visita (id_animale, id_dottore, data_visita, descrizione) VALUES
(7, 3, '2024-05-12', 'Pulizia occhi, in corso trattamento.'),
(8, 4, '2024-05-18', 'Controllo udito, tutto regolare.'),
(9, 5, '2024-05-21', 'Rimozione zecche.'),
(10, 6, '2024-05-26', 'Leggero raffreddore, somministrato antibiotico.'),
(11, 7, '2024-06-01', 'Controllo generale prima di adozione.'),
(12, 8, '2024-06-02', 'Problema digestivo, dieta specifica.'),
(13, 9, '2024-06-03', 'Controllo zampette posteriori.'),
(14, 10, '2024-06-04', 'Vaccinazioni di base.'),
(15, 11, '2024-06-05', 'Sverminazione effettuata.');


INSERT INTO Donazione (id_utente, id_ente, nome_donatore, email_donatore, data, somma) VALUES
(7, 4, 'Giovanni Ferrari', 'giovanni.ferrari@email.com', '2024-06-13', 90.00),
(8, 5, 'Martina Russo', 'martina.russo@email.com', '2024-06-14', 110.00),
(9, 6, 'Andrea Esposito', 'andrea.esposito@email.com', '2024-06-15', 70.00),
(10, 7, 'Chiara Romano', 'chiara.romano@email.com', '2024-06-16', 85.00),
(11, 8, 'Stefano Greco', 'stefano.greco@email.com', '2024-06-17', 60.00),
(12, 9, 'Valentina Gatti', 'valentina.gatti@email.com', '2024-06-18', 95.00),
(13, 10, 'Davide Colombo', 'davide.colombo@email.com', '2024-06-19', 105.00),
(14, 11, 'Federica Marchetti', 'federica.marchetti@email.com', '2024-06-20', 40.00),
(15, 12, 'Roberto Barone', 'roberto.barone@email.com', '2024-06-21', 55.00);


INSERT INTO Dottore (nome, cognome, email, telefono, sesso) VALUES
('Maria', 'Leone', 'maria.leone@vet.it', '3471112223', 'F'),
('Alessandro', 'Riva', 'alessandro.riva@vet.it', '3483334455', 'M'),
('Beatrice', 'Gori', 'beatrice.gori@vet.it', '3499988771', 'F'),
('Matteo', 'Sarti', 'matteo.sarti@vet.it', '3462233445', 'M'),
('Francesca', 'Lodi', 'francesca.lodi@vet.it', '3405566771', 'F'),
('Fabio', 'Moretti', 'fabio.moretti@vet.it', '3419988776', 'M'),
('Elena', 'Pagani', 'elena.pagani@vet.it', '3493214567', 'F');

INSERT INTO diario (id_animale, storia_animale, stato_salute, stato_comportamentale, vaccinazioni, operazioni_effettuate) VALUES
(7, 'Affidato da privato per problemi economici.', 'In salute.', 'Molto docile.', 'Trivalente', NULL),
(8, 'Recuperata per strada, aveva pulci.', 'Buona dopo trattamento antiparassitario.', 'Vivace e socievole.', 'Antiparassitario, trivalente', NULL),
(9, 'Cane da guardia in disuso.', 'Stressato, in recupero.', 'Protettivo, ma in miglioramento.', 'Antirabbica', NULL),
(10, 'Gattina trovata in un giardino condominiale.', 'Buona salute.', 'Tranquilla, si affeziona.', 'Trivalente', NULL),
(11, 'Ceduto da famiglia anziana.', 'Ottima salute.', 'Obbediente e affettuoso.', 'Tutti i vaccini base', NULL),
(12, 'Donata dopo svezzamento.', 'Ottima forma.', 'Curiosa e attiva.', 'Vaccini base', NULL),
(13, 'Acquistato da privati e abbandonato.', 'Buona salute.', 'Tende a rosicchiare.', 'Trivalente', NULL),
(14, 'Trovato nei pressi di una tangenziale.', 'In lieve sovrappeso.', 'Mite e sereno.', 'Trivalente + antirabbica', NULL),
(15, 'Gattina recuperata da tettoia.', 'In forma.', 'Molto affettuosa.', 'Vaccinazioni in regola', NULL);