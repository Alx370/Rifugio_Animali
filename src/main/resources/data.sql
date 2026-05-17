-- popolamento delle tabelle

INSERT INTO Utente (uuid, nome, cognome, email, password_hash, telefono, sesso, data_nascita, ruolo) VALUES
('utente-luca-rossi-000000000001', 'Luca',  'Rossi',   'luca.rossi@email.com',   '$2a$10$21QqnrmtgJYp4MqxD62AyuqdY2CulFKKM3tNH.xWrMnLaoOWJIT1K', '3331112222', 'M', '1990-05-15', 'ADMIN'),     -- luca
('utente-anna-bianchi-0000000002', 'Anna',  'Bianchi', 'anna.bianchi@email.com', '$2a$10$DYBbLRzdBogU4MWO0IHiwu0m8UxX3qAnE.xRDd4hH4EsA4/Dx8YI6', '3333334444', 'F', '1985-08-22', 'USER'),      -- anna
('utente-marco-verdi-00000000003', 'Marco', 'Verdi',   'marco.verdi@email.com',  '$2a$10$jo56at4LsykHIuNBeUzdaOrnmIZPuDqRmHyS14d.RtT03GEO7PZaG', NULL,          'M', '2000-01-10', 'USER'),     -- marco
('utente-sara-neri-000000000004',  'Sara',  'Neri',    'sara.neri@email.com',    '$2a$10$VQJZJFmPBt2KjviunU8ZZOiMehdndxUMeGmal/njc.aP2JpijiIMu', '3205551234', 'F', '1995-07-12', 'USER'),     -- sara
('utente-paolo-gallo-0000000005',  'Paolo', 'Gallo',   'paolo.gallo@email.com',  '$2a$10$Yani46jP5TJTsQZVmaZv1eBaEROWimojLiAuhYJmxx6Y2tU4x2sI2', '3396667777', 'M', '1988-11-30', 'USER'),     -- paolo
('utente-elisa-fontana-000000006', 'Elisa', 'Fontana', 'elisa.fontana@email.com','$2a$10$cRj2waC/H1F7m6/qiJppbOP7yi7xDmx3d//LWKneih.2RfrWQ4Cs6', NULL,          'F', '1992-03-03', 'USER');     -- elisa


INSERT INTO Ente (NOME, EMAIL, TELEFONO) VALUES
('Amici degli Animali Roma', 'roma@amicianimali.it', '0688776655'),
('Salviamo i Pelosetti', 'contatti@salvipelosetti.org', '0399876543'),
('Oasi Felina Torino', 'info@oasifelina.to', '0113344556'),
('Cuccioli in Famiglia', 'cuccioli@famiglia.it', '0557788990'),
('Amici a Quattro Zampe Napoli', 'napoli@a4zampe.it', '0814455667'),
('Vita da Cani', 'info@vitadacani.org', '0312233445'),
('Adozioni Felici', 'adozioni@felici.it', '0244667788'),
('Salute Animali Verona', 'verona@saluteanimali.it', '0457788990'),
('Protezione Pet Firenze', 'firenze@protezionepet.org', '0556677889'),
('Cuori Animali Bologna', 'bologna@cuorianimali.it', '0513344556');


INSERT INTO Dottore (NOME, COGNOME, EMAIL, TELEFONO, SESSO) VALUES
('Marta', 'Gallo', 'marta.gallo@vet.it', '3488877665', 'F'),
('Riccardo', 'Neri', 'riccardo.neri@vet.it', '3496677889', 'M'),
('Claudia', 'Fontana', 'claudia.fontana@vet.it', '3475566778', 'F'),
('Paolo', 'Ferrara', 'paolo.ferrara@vet.it', '3456667788', 'M'),
('Alessia', 'Bianchi', 'alessia.bianchi@vet.it', '3499988776', 'F'),
('Giovanni', 'Rossi', 'giovanni.rossi@vet.it', '3485544332', 'M'),
('Sofia', 'Marini', 'sofia.marini@vet.it', '3471122334', 'F'),
('Luca', 'Romano', 'luca.romano@vet.it', '3451122335', 'M'),
('Federica', 'Ricci', 'federica.ricci@vet.it', '3492233445', 'F'),
('Antonio', 'Morelli', 'antonio.morelli@vet.it', '3483344556', 'M');


INSERT INTO Animale (SPECIE, NOME, DATA_ARRIVO, DATA_NASCITA, DATA_ADOZIONE, RAZZA, SESSO, PESO, TAGLIA, COLORE, SEGNI_PARTICOLARI) VALUES
('Cane', 'Javier', '2024-01-10', '2021-01-10', '2024-03-05', 'Labrador', 'M', 25.50, 'Grande', 'Marrone', 'Cicatrice sulla zampa posteriore'),
('Gatto', 'Zorro', '2024-02-14', '2022-02-14', NULL, 'Europeo', 'F', 4.30, 'Piccola', 'Tigrato', 'Coda storta'),
('Cane', 'Luffy', '2024-03-01', '2019-03-01', '2024-04-10', 'Bulldog', 'F', 18.20, 'Media', 'Bianco', ''),
('Gatto', 'Bob', '2024-03-20', '2023-03-20', NULL, 'Siamese', 'M', 3.90, 'Piccola', 'Crema', 'Occhi azzurri'),
('Coniglio', 'Vera', '2024-04-01', '2022-04-01', NULL, 'Nano', 'F', 1.10, 'Piccola', 'Bianco e nero', ''),
('Cane', 'Rex', '2024-05-10', '2020-05-10', NULL, 'Pastore Tedesco', 'M', 30.0, 'Grande', 'Nero e marrone', ''),
('Gatto', 'Mia', '2024-06-01', '2021-06-01', NULL, 'Persiano', 'F', 4.5, 'Piccola', 'Grigia', 'Occhi verdi'),
('Cane', 'Bruno', '2024-05-15', '2019-05-15', NULL, 'Golden Retriever', 'M', 28.0, 'Grande', 'Dorato', ''),
('Gatto', 'Luna', '2024-05-20', '2022-05-20', '2024-06-20', 'Siberiano', 'F', 5.0, 'Media', 'Bianco e nero', ''),
('Coniglio', 'Pippo', '2024-04-22', '2023-04-22', NULL, 'Nano', 'M', 1.2, 'Piccola', 'Bianco', ''),
('Cane', 'Max', '2024-04-15', '2020-04-15', '2024-06-01', 'Meticcio', 'M', 20.00, 'Media', 'Nero', 'Zampa anteriore piu corta');


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


INSERT INTO Donazione (ID_UTENTE, ID_ENTE, DATA, SOMMA) VALUES
(2, 1, '2024-04-10', 100.00),
(3, 2, '2024-05-15', 50.00),
(1, 3, '2024-06-01', 75.00),
(4, 2, '2024-06-10', 120.00),
(5, 1, '2024-05-30', 80.00),
(6, 3, '2024-06-12', 60.00);


INSERT INTO diary (Id_animale, storia_animale, stato_salute, stato_comportamentale, vaccinazioni, operazioni_effettuate) VALUES
(1, 'Recuperato da un canile abusivo, inizialmente molto diffidente. Adottato dopo un percorso di socializzazione.', 'Buona, vaccinato e in forma.', 'Tranquillo e socievole.', 'Vaccino trivalente, antirabbica', 'Sterilizzazione'),
(2, 'Trovata abbandonata vicino a un cassonetto. Ha ricevuto cure veterinarie e sta recuperando peso.', 'In recupero, sotto osservazione per anemia.', 'Tende a nascondersi, ma non aggressiva.', 'Vaccino trivalente', NULL),
(3, 'Consegnato da una famiglia che non poteva più tenerlo. Problemi respiratori al primo controllo.', 'Stabile, sotto controllo con terapia.', 'Affettuosa ma pigra.', 'Vaccino trivalente', 'Terapia respiratoria'),
(4, 'Trovato randagio in zona periferica. Condizioni iniziali buone.', 'Ottima salute.', 'Vivace, ama il contatto umano.', 'Vaccino trivalente, antirabbica', NULL),
(5, 'Donato da un allevatore. Abituato al contatto umano.', 'Molto buono, nessun problema riscontrato.', 'Docile e tranquillo.', NULL, NULL),
(6, 'Recuperato da una situazione di maltrattamento. Presentava una zampa anteriore più corta.', 'In miglioramento dopo cura.', 'Ha bisogno di attenzione, ma risponde bene agli stimoli.', 'Vaccino trivalente, antirabbica', 'Terapia alla zampa');
