# Women Safety System

Women Safety System is a desktop-based safety application designed to provide women with quick access to emergency support, safety resources, and police assistance. The application is built using Java Swing with MySQL for persistent data storage and provides an easy-to-use interface for emergency alerts and safety features.

## Features

* User registration and secure login
* Emergency SOS alert system
* Emergency contacts management
* Instant siren/alarm activation
* Police Control Room dashboard
* SOS alert history and status tracking
* Nearby Police and Hospital information
* Women Safety Laws and awareness resources
* Self-defense tips and safety guidelines
* Emergency helpline numbers
* Location information using latitude and longitude
* MySQL-based persistent data storage
* User-friendly Java Swing interface

## Tech Stack

**Frontend/UI:** Java Swing, Java AWT
**Backend:** Java
**Database:** MySQL
**Database Tool:** MySQL Workbench
**Architecture:** Desktop Application
**IDE:** Eclipse
**Version Control:** Git, GitHub

## Getting Started

### Prerequisites

* Java JDK 8 or higher
* Eclipse IDE
* MySQL Server
* MySQL Workbench
* Git

### Installation

1. Clone the repository:

```bash
git clone https://github.com/srikanthpandi/WomenSafetySystem.git
cd WomenSafetySystem
```

2. Open the project in Eclipse.

3. Configure the MySQL database.

Create a database named:

```sql
CREATE DATABASE womensafety;
```

4. Create the required tables for users, emergency contacts, SOS alerts, and SOS history.

5. Update the database connection settings in the Java database configuration file with your MySQL username and password.

6. Add the required project dependencies and resources, including application icons and alarm sound files.

7. Run the application from Eclipse.

## Application Modules

### User Module

Users can:

* Register an account
* Log in securely
* Add and manage emergency contacts
* Save location information
* Access safety resources
* Send emergency SOS alerts

### SOS Alert

The SOS feature allows users to quickly send an emergency alert when they are in danger.

The alert can contain:

* Username
* Emergency message
* Latitude
* Longitude
* Alert time
* Alert status

SOS alerts are stored in the MySQL database and can be viewed through the Police Control Room.

### Siren Alarm

The application provides an emergency siren that can be activated when the user is in trouble. The alarm provides an immediate audio warning to attract attention.

### Police Control Room

The Police Control Room provides an administrative dashboard where emergency alerts can be monitored.

Police can view:

* Alert ID
* Username
* Emergency message
* Latitude
* Longitude
* Alert time
* Alert status

Police can also refresh the alert list and update the status of emergency requests.

### Safety Resources

The application provides useful safety information, including:

* Nearby Police Stations
* Nearby Hospitals
* Women Safety Laws
* Self-Defense Guidelines
* Emergency Helpline Numbers

## Database

The application uses **MySQL** for persistent data storage.

Main database components include:

* User information
* Emergency contacts
* SOS alerts
* SOS alert history
* Location information

Architecture ::
                ┌─────────────────────┐
                │       USER          │
                │  Mobile / Web App   │
                └──────────┬──────────┘
                           │
                           ↓
                ┌─────────────────────┐
                │   PRESENTATION      │
                │       LAYER         │
                │ Login, SOS, Maps,   │
                │ Emergency Contacts  │
                └──────────┬──────────┘
                           │
                           ↓
                ┌─────────────────────┐
                │    APPLICATION /    │
                │    BACKEND LAYER    │
                │                     │
                │ • Authentication    │
                │ • SOS Processing    │
                │ • Location Handling │
                │ • Alert Management  │
                └──────┬───────┬──────┘
                       │       │
              ┌────────┘       └─────────┐
              ↓                          ↓
      ┌───────────────┐          ┌──────────────┐
      │   DATABASE    │          │ External APIs │
      │               │          │              │
      │ Users         │          │ GPS/Maps     │
      │ Contacts      │          │ SMS/Email    │
      │ SOS Alerts    │          │ Notifications │
      │ Locations     │          └──────────────┘
      └───────────────┘
Example database:

```text
womensafety
├── users
├── emergency_contacts
├── sos_alerts
└── sos_history
```

## Project Structure

```text
WomenSafetySystem
│
├── src
│   └── com.womensafety
│       ├── Database
│       ├── Login
│       ├── Register
│       ├── Dashboard
│       ├── EmergencyContacts
│       ├── SOSAlert
│       ├── Siren
│       ├── PoliceDashboard
│       ├── SidebarPanel
│       ├── FeatureCard
│       ├── HeaderPanel
│       ├── IconUtil
│       └── Theme
│
├── sounds
│   └── siren.wav
│
├── icons
│   ├── shield.png
│   ├── contacts.png
│   ├── alarm.png
│   ├── history.png
│   ├── police.png
│   ├── hospital.png
│   ├── law.png
│   ├── karate.png
│   └── phone.png
│
└── README.md
```

## Usage

1. Launch the Women Safety System.
2. Register as a new user.
3. Log in using your credentials.
4. Add emergency contacts and location details.
5. Use the dashboard to access safety features.
6. In an emergency, activate the **SOS Alert**.
7. The alert is stored in the database and displayed on the **Police Control Room** dashboard.
8. Use the siren and other safety resources when required.

## Future Enhancements

* Real-time GPS location tracking
* SMS and email emergency notifications
* Automatic location sharing with emergency contacts
* Mobile application support
* AI-based emergency message analysis
* Integration with Google Maps
* Real-time police response tracking
* Cloud-based deployment
* Voice-activated SOS functionality

## Contributing

Contributions, issues, and feature requests are welcome. Feel free to open an issue or submit a pull request.

## License

This project is open source and available for use under the MIT License.
