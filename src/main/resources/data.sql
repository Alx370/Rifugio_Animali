-- popolamento delle tabelle

INSERT INTO Utente (NOME, COGNOME, EMAIL, PASSWORD, TELEFONO, SESSO, DATA_NASCITA) VALUES
('Luca', 'Rossi', 'luca.rossi@email.com', '$2a$10$wE/f50E7z1LeT/n90/rIaeUd82PNQ3jv4v59guUcOJMvOqzaYmn7S', '3331112222', 'M', '1990-05-15'),
('Anna', 'Bianchi', 'anna.bianchi@email.com', '$2a$10$wE/f50E7z1LeT/n90/rIaeUd82PNQ3jv4v59guUcOJMvOqzaYmn7S', '3333334444', 'F', '1985-08-22'),
('Marco', 'Verdi', 'marco.verdi@email.com', '$2a$10$wE/f50E7z1LeT/n90/rIaeUd82PNQ3jv4v59guUcOJMvOqzaYmn7S', NULL, 'M', '2000-01-10'),
('Sara', 'Neri', 'sara.neri@email.com', '$2a$10$wE/f50E7z1LeT/n90/rIaeUd82PNQ3jv4v59guUcOJMvOqzaYmn7S', '3205551234', 'F', '1995-07-12'),
('Paolo', 'Gallo', 'paolo.gallo@email.com', '$2a$10$wE/f50E7z1LeT/n90/rIaeUd82PNQ3jv4v59guUcOJMvOqzaYmn7S', '3396667777', 'M', '1988-11-30'),
('Elisa', 'Fontana', 'elisa.fontana@email.com', '$2a$10$wE/f50E7z1LeT/n90/rIaeUd82PNQ3jv4v59guUcOJMvOqzaYmn7S', NULL, 'F', '1992-03-03');


INSERT INTO Ente (NOME, EMAIL, TELEFONO) VALUES
('Associazione Animali Felici', 'contatti@aafelici.it', '055123456'),
('Protezione Animali Milano', 'info@pam-milano.org', '024567890'),
('Cuori a Quattro Zampe', 'info@cuorizampe.org', '0314445566');


INSERT INTO Dottore (NOME, COGNOME, EMAIL, TELEFONO, SESSO) VALUES
('Giulia', 'Conti', 'giulia.conti@vet.it', '3489988776', 'F'),
('Davide', 'Marini', 'davide.marini@vet.it', '3491234567', 'M'),
('Laura', 'Berti', 'laura.berti@vet.it', '3472223344', 'F'),
('Lorenzo', 'Ferri', 'lorenzo.ferri@vet.it', '3455556666', 'M');


INSERT INTO Animale (SPECIE, NOME, DATA_ARRIVO, DATA_ADOZIONE, RAZZA, SESSO, PESO, ETA, TAGLIA, COLORE, SEGNI_PARTICOLARI) VALUES
('Cane', '', '2024-01-10', '2024-03-05', 'Labrador', 'M', 25.50, 3, 'Grande', 'Marrone', 'Cicatrice sulla zampa posteriore'),
('Gatto', 'Zorro', '2024-02-14', NULL, 'Europeo', 'F', 4.30, 2, 'Piccola', 'Tigrato', 'Coda storta'),
('Cane', 'Luffy', '2024-03-01', '2024-04-10', 'Bulldog', 'F', 18.20, 5, 'Media', 'Bianco', ''),
('Gatto', 'Bob', '2024-03-20', NULL, 'Siamese', 'M', 3.90, 1, 'Piccola', 'Crema', 'Occhi azzurri'),
('Coniglio', 'Vera', '2024-04-01', NULL, 'Nano', 'F', 1.10, 2, 'Piccola', 'Bianco e nero', ''),
('Cane', 'Max', '2024-04-15', '2024-06-01', 'Meticcio', 'M', 20.00, 4, 'Media', 'Nero', 'Zampa anteriore più corta');


INSERT INTO Adozione (ID_ANIMALE, ID_UTENTE, DATA_ADOZIONE) VALUES
(1, 1, '2024-03-05'),
(3, 2, '2024-04-10'),
(6, 4, '2024-06-01');


INSERT INTO Visita (ID_ANIMALE, ID_DOTTORE, DATA_VISITA, DESCRIZIONE) VALUES
(1, 1, '2024-01-15', 'Controllo iniziale, vaccinato.'),
(2, 2, '2024-02-20', 'Controllo vaccini.'),
(3, 1, '2024-03-05', 'Problemi respiratori, terapia prescritta.'),
(4, 3, '2024-03-25', 'Controllo oculistico.'),
(5, 4, '2024-04-02', 'Visita generale, in ottima salute.'),
(6, 2, '2024-04-20', 'Cura zampa anteriore, miglioramento visibile.');


INSERT INTO Donazione (ID_UTENTE, ID_ENTE, NOME_DONATORE, EMAIL_DONATORE, DATA, SOMMA) VALUES
(2, 1, 'Anna Bianchi', 'anna.bianchi@email.com', '2024-04-10', 100.00),
(3, 2, 'Marco Verdi', 'marco.verdi@email.com', '2024-05-15', 50.00),
(1, 3, 'Luca Rossi', 'luca.rossi@email.com', '2024-06-01', 75.00),
(4, 2, 'Sara Neri', 'sara.neri@email.com', '2024-06-10', 120.00),
(5, 1, 'Paolo Gallo', 'paolo.gallo@email.com', '2024-05-30', 80.00),
(6, 3, 'Elisa Fontana', 'elisa.fontana@email.com', '2024-06-12', 60.00);


INSERT INTO admin_app (EMAIL, PASSWORD) VALUES
('admin@app.it', 'admin123'),
('root@app.it', 'rootpass');


INSERT INTO diario (Id_animale, storia_animale, stato_salute, stato_comportamentale, vaccinazioni, operazioni_effettuate) VALUES
(1, 'Recuperato da un canile abusivo, inizialmente molto diffidente. Adottato dopo un percorso di socializzazione.', 'Buona, vaccinato e in forma.', 'Tranquillo e socievole.', 'Vaccino trivalente, antirabbica', 'Sterilizzazione'),
(2, 'Trovata abbandonata vicino a un cassonetto. Ha ricevuto cure veterinarie e sta recuperando peso.', 'In recupero, sotto osservazione per anemia.', 'Tende a nascondersi, ma non aggressiva.', 'Vaccino trivalente', NULL),
(3, 'Consegnato da una famiglia che non poteva più tenerlo. Problemi respiratori al primo controllo.', 'Stabile, sotto controllo con terapia.', 'Affettuosa ma pigra.', 'Vaccino trivalente', 'Terapia respiratoria'),
(4, 'Trovato randagio in zona periferica. Condizioni iniziali buone.', 'Ottima salute.', 'Vivace, ama il contatto umano.', 'Vaccino trivalente, antirabbica', NULL),
(5, 'Donato da un allevatore. Abituato al contatto umano.', 'Molto buono, nessun problema riscontrato.', 'Docile e tranquillo.', NULL, NULL),
(6, 'Recuperato da una situazione di maltrattamento. Presentava una zampa anteriore più corta.', 'In miglioramento dopo cura.', 'Ha bisogno di attenzione, ma risponde bene agli stimoli.', 'Vaccino trivalente, antirabbica', 'Terapia alla zampa');