# Spotify Playlist Maker

Spotify Playlist Maker is a web application that allows users to create, edit, and save their own playlists. Each playlist is made up of entered words, which can represent songs. The application also provides functionality to review playlist history and will eventually integrate with the Spotify API.

---

## Features / Funkcjonalności

### 1. Playlist Creation
- Users can input any text, and each word forms an individual card in the playlist.
- Each card can be edited or deleted using intuitive icons available upon hovering over the card.

### 2. Playlist Confirmation
- Users can confirm their playlist, which is saved to the database as part of their history.


### 3. Playlist History
- Each logged-in user has access to their playlist history. They can review playlists that are linked to their account.

### 4. Return to Menu / Powrót do menu głównego
- After confirming the playlist, the application automatically redirects the user to the main menu.

---

## Technology

The project was developed using:
- **Java 21**
- **Spring Boot**:
  - Spring Web
  - Spring Data JPA
  - Spring Security
- **Thymeleaf** for dynamic view rendering
- **PostgreSQLE** (database).
- **HTML, CSS, JavaScript** frontend

---

## Project Structure

### 1. `templates` Folder 
Contains HTML templates rendered dynamically by Thymeleaf:
- `index.html`: Homepage
- `playlist-maker.html`: Playlist creation page 
- `login.html`: Login page
- `register.html`: Registration
- `history.html`: User History

---

## Installation and Running

### 1. Environment Setup / Skonfiguruj środowisko
- Install Java 21
- Install Maven

### 2. Database Setup
- Configure the database connection in the `application.properties` file (in the `resources` folder):
  ```properties
  spring.datasource.url=jdbc:mysql://localhost:3306/spotifyapp
  spring.datasource.username=root
  spring.datasource.password=haslo
  spring.jpa.hibernate.ddl-auto=update


## 3. Run the Application
Clone the project.

In the terminal, execute:
mvn spring-boot:run

The application will be available at:
http://localhost:8080

## Future Features
Spotify API Integration: Automatically fetch songs, images, and metadata.

Customization: Add custom images or descriptions to playlists.

Playlist Sharing: Allow users to share playlists with others.



