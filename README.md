## 🎟️ Event Ticket Platform – Spring Boot (Intermediate Project)

### 💡 Project Overview

The **Event Ticket Platform** is a backend application built using **Spring Boot** that allows event organizers to create and manage events, while users can browse events and book tickets.
The system handles **ticket availability, bookings, and simulated payments**, similar to platforms like **BookMyShow** or **Paytm Insider**, but in a simplified backend-only form.

---

### 🔧 Key Features

* **User Management**

  * Users can register and view available events
  * Organizers can create and manage events

* **Event Management**

  * Create events with date, location, and ticket capacity
  * View upcoming and past events
  * Track available tickets in real time

* **Ticket Booking**

  * Users can book tickets for events
  * Automatically reduces available ticket count
  * Prevents overbooking

* **Payment Simulation**

  * Simulated payment flow for ticket booking
  * Booking is confirmed only after successful payment

* **Ticket Generation**

  * Generates booking confirmation/ticket after successful payment
  * Each ticket is linked to a user and an event

---

### 🛠️ Tech Stack

* **Backend:** Spring Boot, Spring Data JPA
* **Database:** MySQL
* **ORM:** Hibernate
* **Security (optional/extendable):** Spring Security, JWT
* **Build Tool:** Maven
* **API Testing:** Postman

---

### 📚 Learning Outcomes

* Implemented **RESTful APIs** using Spring Boot
* Gained hands-on experience with **JPA relationships** (`@OneToMany`, `@ManyToOne`)
* Used **service-repository architecture**
* Handled **business logic** like ticket availability and booking validation
* Designed a **real-world backend system**

