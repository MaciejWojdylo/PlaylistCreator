# Spotify Playlist Maker

Spotify Playlist Maker is a web application that allows users to create, edit, and save their own playlists. Each playlist is made up of entered words, which can represent songs. The application also provides functionality to review playlist history and will eventually integrate with the Spotify API.

Spotify Playlist Maker to aplikacja internetowa, która umożliwia użytkownikom tworzenie, edytowanie i zapisywanie własnych playlist. Każda playlista składa się z wprowadzonych słów, które mogą reprezentować utwory. Aplikacja oferuje również możliwość przeglądania historii playlist, a w przyszłości zostanie zintegrowana z API Spotify.

---

## Features / Funkcjonalności

### 1. Playlist Creation / Tworzenie playlisty
- Users can input any text, and each word forms an individual card in the playlist.
- Each card can be edited or deleted using intuitive icons available upon hovering over the card.

- Użytkownik może wpisać dowolny tekst, a każde słowo tworzy osobny kafelek w playliście.
- Każdy kafelek można edytować lub usunąć za pomocą intuicyjnych ikon dostępnych po najechaniu kursorem na kafelek.

### 2. Playlist Confirmation / Zatwierdzenie playlisty
- Users can confirm their playlist, which is saved to the database as part of their history.

- Użytkownik może zatwierdzić playlistę, która zostanie zapisana w bazie danych jako część jego historii.

### 3. Playlist History / Historia playlist
- Each logged-in user has access to their playlist history. They can review playlists that are linked to their account.

- Każdy zalogowany użytkownik ma dostęp do swojej historii playlist. Może przeglądać zapisane playlisty, które są powiązane z jego kontem.

### 4. Return to Menu / Powrót do menu głównego
- After confirming the playlist, the application automatically redirects the user to the main menu.

- Po zatwierdzeniu playlisty aplikacja automatycznie przekierowuje użytkownika do menu głównego.

---

## Technology / Technologia

The project was developed using:
Projekt został stworzony przy użyciu:
- **Java 21**
- **Spring Boot**:
  - Spring Web
  - Spring Data JPA
  - Spring Security
- **Thymeleaf** for dynamic view rendering / do dynamicznego generowania widoków.
- **H2 / PostgreSQLE** (database / baza danych).
- **HTML, CSS, JavaScript** for a visually appealing frontend / do atrakcyjnego frontend'u.

---

## Project Structure / Struktura projektu

### 1. `templates` Folder / Folder `templates`
Contains HTML templates rendered dynamically by Thymeleaf:
Zawiera szablony generowane dynamicznie przez Thymeleaf:
- `index.html`: Homepage / Strona główna.
- `playlist-maker.html`: Playlist creation page / Strona do tworzenia playlist.
- `login.html`: Login page / Strona logowania.
- `register.html`: Registration / Rejestracja.
- `history.html`: User History / Historię użytkownika .

---

## Installation and Running / Instalacja i uruchomienie

### 1. Environment Setup / Skonfiguruj środowisko
- Install Java 17 / Zainstaluj Java 17.
- Install Maven / Zainstaluj Maven.

### 2. Database Setup / Konfiguracja bazy danych
- Configure the database connection in the `application.properties` file (in the `resources` folder):
- Skonfiguruj połączenie z bazą danych w pliku `application.properties` (w folderze `resources`):
  ```properties
  spring.datasource.url=jdbc:mysql://localhost:3306/spotifyapp
  spring.datasource.username=root
  spring.datasource.password=haslo
  spring.jpa.hibernate.ddl-auto=update


## 3. Run the Application / Uruchom aplikację
Clone the project / Skopiuj projekt.

In the terminal, execute / W terminalu wykonaj:
mvn spring-boot:run

The application will be available at / Aplikacja będzie dostępna pod adresem:
http://localhost:8080

## Future Features / Przyszłe funkcjonalności
Spotify API Integration: Automatically fetch songs, images, and metadata.
Integracja z API Spotify: Automatyczne pobieranie utworów, obrazków i metadanych.

Customization: Add custom images or descriptions to playlists.
Personalizacja: Możliwość dodawania własnych grafik lub opisów do playlist.

Playlist Sharing: Allow users to share playlists with others.
Udostępnianie playlist: Umożliwienie użytkownikom dzielenia się playlistami.



