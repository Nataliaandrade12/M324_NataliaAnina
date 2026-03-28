# Kurzanleitung für die Installation der Entwicklungsumgebung zum Basisprojekt im Modul 324

## TLDR
Projektgruppe: Anina und Natalia
Dieses Projekt ist eine einfache ToDo-Webanwendung mit:
Frontend: React
Backend: Spring Boot
Die Anwendung ermöglicht das Erstellen und Löschen von Tasks.
Weitere Details zur Funktionsweise befinden sich im Code, insbesondere in der App.js.

## Projektstruktur / Relevante Dateien

Frontend (React – VS Code, npm)
App.js → Hauptlogik der Anwendung

Backend (Spring Boot – Eclipse oder VS Code)
DemoApplication.java → Startpunkt der Anwendung
Task.java → Datenmodell für Tasks
pom.xml → Maven-Konfiguration (inkl. Plugins & Build)

## Inbetriebnahme

Repository klonen oder forken
Backend starten
	In VS Code mit Java Extension Pack öffnen
	Anwendung starten
Backend läuft auf: http://localhost:8080
Hinweis: Keine Persistenz → Daten gehen nach Neustart verloren

Frontend starten
	Terminal im frontend-Ordner öffnen
	Abhängigkeiten installieren:
		npm install
	Frontend starten:
		npm run dev

## Benutzung

Frontend öffnen:
	http://localhost:5173
Funktionen:
	Tasks hinzufügen
	Tasks werden sofort in der Liste angezeigt
	Mit "Done" können Tasks gelöscht werden
Wichtig:
	Task-Namen müssen eindeutig sein


## CI Pipeline – GitHub Actions
Beschreibung:
Für dieses Projekt wurde eine GitHub Actions Pipeline erstellt, die automatisch bei jedem Pull Request ausgeführt wird.
Ziel der Pipeline ist es, sicherzustellen, dass sowohl das Frontend als auch das Backend erfolgreich gebaut werden können.

## Trigger
Die Pipeline wird automatisch ausgelöst bei:
	Pull Requests auf den Branch `main`
Dies stellt sicher, dass Änderungen vor dem Mergen überprüft werden.

## Ablauf der Pipeline
Die Pipeline besteht aus zwei Jobs:
### Frontend Build
	Node.js wird installiert
	Abhängigkeiten werden mit `npm install` installiert
	Das Projekt wird mit `npm run build` gebaut
Ergebnis: HTML, CSS und JavaScript Dateien werden generiert

### Backend Build
	Java 17 wird installiert
	Maven Wrapper (`mvnw`) wird verwendet
	Der Build wird mit `./mvnw clean package` ausgeführt
Ergebnis: Es wird eine `.war` Datei erstellt

## Verwendete Technologien
	React (Frontend)
	Spring Boot (Backend)
	Maven (Build-Tool)
	GitHub Actions (CI/CD Pipeline)

## Nutzen der Pipeline
Die Pipeline bringt folgende Vorteile:
	Fehler werden früh erkannt
	Sicherstellung, dass der Code buildbar ist
	Automatische Überprüfung bei jeder Änderung
	Verbesserte Codequalität
	Unterstützung der Teamarbeit

## Test der Pipeline
Die Pipeline wurde getestet durch:
1. Erstellen eines neuen Branches
2. Durchführung von Änderungen
3. Erstellen eines Pull Requests auf `main`
4. Automatisches Starten der Pipeline
Die Builds für Frontend und Backend wurden erfolgreich ausgeführt.

## Hinweis
Die Ausführung der Pipeline kann im Tab "Actions" auf GitHub eingesehen werden.
