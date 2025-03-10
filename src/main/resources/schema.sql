-- H2 Database Script with Test Data

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

CREATE SCHEMA IF NOT EXISTS mydb;
SET SCHEMA mydb;


-- -----------------------------------------------------
-- Table `Movie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Movie (
                                     id IDENTITY PRIMARY KEY,
                                     duration TIME NOT NULL,
                                     releaseYear INT NOT NULL,
                                     ageRestriction INT NOT NULL,
                                     genre INT NOT NULL,
                                     director VARCHAR(100) NOT NULL
    );

INSERT INTO Movie (duration, releaseYear, ageRestriction, genre, director) VALUES
                                                                        ('02:00:00', 2023, 13, 1, 'Director A'),
                                                                        ('01:45:00', 2022, 18, 2, 'Director B');

-- -----------------------------------------------------
-- Table `Theatre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Theatre (
                                       id IDENTITY PRIMARY KEY,
                                       seats INT NOT NULL
);

INSERT INTO Theatre (seats) VALUES
                                (100),
                                (150);

-- -----------------------------------------------------
-- Table `Showing`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Showing (
                                       id IDENTITY PRIMARY KEY,
                                       time TIME NOT NULL,
                                       date DATE NOT NULL,
                                       movieId INT NOT NULL,
                                       theatreId INT NOT NULL,
                                       FOREIGN KEY (movieId) REFERENCES Movie(id),
    FOREIGN KEY (theatreId) REFERENCES Theatre(id)
    );

INSERT INTO Showing (time, date, movieId, theatreId) VALUES
                                                         ('18:00:00', '2023-10-01', 1, 1),
                                                         ('20:00:00', '2023-10-02', 2, 2);

-- -----------------------------------------------------
-- Table `Ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Ticket (
                                      id IDENTITY PRIMARY KEY,
                                      phoneNumber BIGINT NOT NULL,
                                      showingId INT NOT NULL,
                                      FOREIGN KEY (showingId) REFERENCES Showing(id)
    );

INSERT INTO Ticket (phoneNumber, showingId) VALUES
                                                (1234567890, 1),
                                                (9876543210, 2);

-- -----------------------------------------------------
-- Table `Actor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Actor (
                                     id IDENTITY PRIMARY KEY,
                                     name VARCHAR(45) NOT NULL
    );

INSERT INTO Actor (name) VALUES
                             ('Actor One'),
                             ('Actor Two');

-- -----------------------------------------------------
-- Table `ActorMovie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS ActorMovie (
                                          id IDENTITY PRIMARY KEY,
                                          actorId INT NOT NULL,
                                          movieId INT NOT NULL,
                                          FOREIGN KEY (actorId) REFERENCES Actor(id),
    FOREIGN KEY (movieId) REFERENCES Movie(id)
    );

INSERT INTO ActorMovie (actorId, movieId) VALUES
                                              (1, 1),
                                              (2, 2);
