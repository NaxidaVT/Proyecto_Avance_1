-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS VillaGastronomica;

-- Usar la base de datos
USE VillaGastronomica;

-- Tabla de Usuarios
CREATE TABLE Usuarios (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(100) NOT NULL,
	Apellidos VARCHAR(100) NOT NULL,
    Correo VARCHAR(100) UNIQUE NOT NULL,
    Contraseña VARCHAR(100) NOT NULL,
    Tarjeta VARCHAR(16) NOT NULL,
    Ubicacion VARCHAR(100) NOT NULL
);

-- Tabla de Restaurantes
CREATE TABLE Restaurantes (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(100) NOT NULL,
    Descripcion TEXT
);

-- Tabla de Comidas (platillos)
CREATE TABLE Comidas (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(100) NOT NULL,
    Descripcion TEXT,
    Precio DECIMAL(10, 2) NOT NULL,
    RestauranteID INT NOT NULL,
    FOREIGN KEY (RestauranteID) REFERENCES Restaurantes(ID)
);

-- Tabla de Favoritos (para los usuarios registrados que deseen guardar restaurantes)
CREATE TABLE Favoritos (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    UsuarioID INT NOT NULL,
    RestauranteID INT NOT NULL,
    Comentario TEXT,
    FOREIGN KEY (UsuarioID) REFERENCES Usuarios(ID),
    FOREIGN KEY (RestauranteID) REFERENCES Restaurantes(ID)
);

-- Tabla de Ofertas y Promociones
CREATE TABLE Ofertas (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    RestauranteID INT NOT NULL,
    Descripcion TEXT NOT NULL,
    FechaInicio DATE NOT NULL,
    FechaFin DATE NOT NULL,
    FOREIGN KEY (RestauranteID) REFERENCES Restaurantes(ID)
);