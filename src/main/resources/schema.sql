CREATE TABLE sneaker (
                         id UUID PRIMARY KEY,
                         price DECIMAL(10, 2) NOT NULL,
                         merk VARCHAR(255) NOT NULL,
                         schoennaam VARCHAR(255) NOT NULL,
                         schoenmaat VARCHAR(10),
                         beschrijving TEXT,
                         categorie VARCHAR(255),
                         color VARCHAR(50)
);
