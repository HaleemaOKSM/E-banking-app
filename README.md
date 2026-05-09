# Digital Banking Application

> **Projet JEE : Spring Boot · Angular 18 · Spring Security JWT · AI Chatbot RAG + Telegram**  
> ENSET Mohammedia — Université Hassan II de Casablanca  
> Module : Java EE & Frameworks Web  
> Encadrant : **Pr. Mohamed Youssfi**

---

## Réalisé par

 Halima ID OUAKSIM | BDCC2 

---

## 📌 Description du Projet

**Digital Banking** est une application web full-stack de gestion bancaire permettant de gérer des clients, des comptes bancaires (courants et épargnes) ainsi que leurs opérations (dépôt, retrait, virement). L'application intègre un système de sécurité basé sur **Spring Security + JWT** et un **chatbot intelligent basé sur RAG (Retrieval Augmented Generation)** avec Mistral AI, accessible depuis l'interface web **et via Telegram (@BankinAIBot)**.

---

## 🗂️ Structure du Projet

```
E-banking-app/
├── bankingApp-backend/       # Spring Boot 3.3 — API REST + Sécurité JWT
├── e-banking-frontend/       # Angular 18 — Interface utilisateur
└── Chat-bot/                 # Spring AI + Mistral — Chatbot RAG + Telegram
```

---

## 🧱 Architecture Globale

```
┌──────────────────────────────────────────────────────────┐
│                     CLIENT BROWSER                        │
│              Angular 18 · Bootstrap 5                     │
│  Dashboard │ Clients │ Comptes │ Opérations │ BankBot     │
└─────────────────────┬────────────────────────────────────┘
                      │ HTTP/JSON + JWT Bearer Token
       ┌──────────────┴──────────────┐
       │                             │
       ▼                             ▼
┌──────────────┐            ┌─────────────────┐    ┌─────────────┐
│ Spring Boot  │            │  Spring AI      │◄───│  Telegram   │
│ Backend      │            │  Chatbot RAG    │    │ @BankinAIBot│
│ Port: 8085   │            │  Port: 8087     │    └─────────────┘
│              │            │                 │
│ REST API     │            │ Mistral AI LLM  │
│ Spring Sec.  │            │ Vector Store    │
│ JWT HS512    │            │ HTTP Streaming  │
│ JPA/Hibernate│            │ RAG Pipeline    │
└──────┬───────┘            └─────────────────┘
       ▼
┌──────────────┐
│ H2 / MySQL   │
│ Database     │
└──────────────┘
```

---

## ⚙️ Technologies Utilisées

### Backend
| Technologie | Version | Rôle |
|---|---|---|
| Java | 17 | Langage principal |
| Spring Boot | 3.3.0 | Framework backend |
| Spring Security + OAuth2 | 6.x | JWT HS512, protection des endpoints |
| Spring Data JPA / Hibernate | 6.x | Persistance ORM |
| H2 Database | — | Base de données embarquée (dev) |
| Lombok | 1.18.36 | Réduction du boilerplate |
| SpringDoc OpenAPI | 2.5.0 | Documentation Swagger UI |

### Frontend
| Technologie | Version | Rôle |
|---|---|---|
| Angular | 18 | Framework SPA standalone components |
| TypeScript | 5.4 | Typage statique |
| Bootstrap | 5.3 | Mise en page responsive |
| Chart.js | 4.x | Graphiques dashboard |
| ngx-markdown | — | Rendu Markdown des réponses IA |
| RxJS | 7.8 | HTTP Streaming réactif |

### Chatbot IA
| Technologie | Rôle |
|---|---|
| Spring AI 1.0.0-M6 | Framework IA intégré à Spring Boot |
| Mistral AI (mistral-small-latest) | Modèle LLM génération de réponses |
| Mistral Embed (mistral-embed) | Embeddings vectoriels RAG |
| SimpleVectorStore | Base vectorielle en mémoire |
| HTTP Streaming | Réponses token par token (SSE) |
| TelegramBots API | Client Telegram (TelegramLongPollingBot) |

---

## 🚀 Démarrage du Projet

### Prérequis
- Java 17+ · Node.js 20+ · Maven 3.9+ · Angular CLI 18
- Clé API Mistral : https://console.mistral.ai
- Token Bot Telegram : via @BotFather

### 1. Lancer le Backend
```bash
cd bankingApp-backend/demo
./mvnw spring-boot:run
```
- API : http://localhost:8085
- Swagger : http://localhost:8085/swagger-ui/index.html
- H2 : http://localhost:8085/h2-console

### 2. Lancer le Frontend
```bash
cd e-banking-frontend
npm install && ng serve
```
Application : http://localhost:4200

### 3. Lancer le Chatbot
```bash
cd Chat-bot
./mvnw spring-boot:run
```
API Chatbot : http://localhost:8087

### Identifiants de test
| Rôle | Username | Mot de passe |
|------|----------|--------------|
| Administrateur | `admin` | `12345` |
| Utilisateur | `user1` | `12345` |

---

## 🖥️ Captures d'écran

---

### 1 Dashboard

<img width="1912" height="944" alt="Screenshot 2026-05-08 012206" src="https://github.com/user-attachments/assets/a162463a-4d1d-4c56-8d21-d0db228d3022" />

Vue d'ensemble temps réel : **3 clients · 6 comptes · 60 opérations · 2.5M MAD** de solde total. Graphique barres des opérations mensuelles, flux financiers (Crédits 5.4M MAD / Débits 890K MAD), répartition 3 comptes courants + 3 épargnes, et actions rapides.

---

### 2  Gestion des Clients (vue Administrateur)
<img width="1907" height="941" alt="Screenshot 2026-05-08 012216" src="https://github.com/user-attachments/assets/74a59d8c-451c-4a18-a01d-6fabfa1effed" />

Liste complète avec boutons **Modifier** ✏️ et **Supprimer** 🗑️ visibles uniquement pour l'administrateur. Barre de recherche en temps réel par nom ou email.

---

### 3  Gestion des Clients (vue Utilisateur)
<img width="1899" height="926" alt="Screenshot 2026-05-08 012405" src="https://github.com/user-attachments/assets/441868da-a65e-4f09-af77-a1dea379d17d" />

Vue en lecture seule pour l'utilisateur standard : les boutons d'action sont masqués, démontrant le contrôle d'accès par rôle.

---

### 4 Création d'un Nouveau Client
<img width="1916" height="937" alt="Screenshot 2026-05-08 012240" src="https://github.com/user-attachments/assets/a51029c4-ad7d-4ea5-ba22-aa4ac031e7c0" />

Modal avec validation réactive Angular : nom (min. 2 caractères) et email obligatoires, messages d'erreur inline affichés instantanément.

---

### 5  Confirmation de Suppression
<img width="1919" height="948" alt="Screenshot 2026-05-08 012252" src="https://github.com/user-attachments/assets/d82d3f0d-21ca-4e54-8974-699a9b0cef56" />

Confirmation inline dans la ligne du tableau avant suppression définitive, évitant les suppressions accidentelles.

---

### 6  Gestion des Comptes — Grille

<img width="1890" height="949" alt="Screenshot 2026-05-08 012304" src="https://github.com/user-attachments/assets/17087971-1d7a-4339-a4e2-e5f024d02988" />

6 comptes affichés en grille de cartes : **Courants** (bordure bleue, découvert) et **Épargnes** (bordure verte, taux d'intérêt). Chaque carte affiche solde, client, date de création et lien vers les opérations.

---

### 7 Création d'un Compte Courant

<img width="1875" height="945" alt="Screenshot 2026-05-08 012316" src="https://github.com/user-attachments/assets/11e05206-516d-4b32-bd21-0bfcec25aa5d" />

Formulaire : sélection du client, solde initial, devise (MAD/EUR/USD), plafond de découvert autorisé.

---

### 8  Sélection du Client dans le Formulaire

<img width="1889" height="940" alt="Screenshot 2026-05-08 012324" src="https://github.com/user-attachments/assets/1657bbd8-4651-4eac-9aa2-6517f751e778" />

Dropdown présentant nom et email de chaque client pour faciliter l'identification.

---

### 9  Création d'un Compte Épargne

<img width="1897" height="948" alt="Screenshot 2026-05-08 012334" src="https://github.com/user-attachments/assets/1ed2909d-eb70-4799-8981-d9d808fa0a4a" />

Formulaire adapté : le champ **Taux d'intérêt (%)** remplace le plafond de découvert, avec valeur par défaut à 3.5%.

---

### 10  BankBot : Chatbot IA Web (Streaming)

<img width="1899" height="954" alt="Screenshot 2026-05-08 012147" src="https://github.com/user-attachments/assets/59c69cda-6441-4ccb-bae3-883016a0afac" />

Le chatbot **BankBot** est intégré directement dans la sidebar sous "Assistant IA". Il s'ouvre en panneau flottant et répond en **streaming temps réel** avec rendu Markdown. Démonstration : la question "c'est quoi le solde de Hassan ?" reçoit une réponse précise de **15 000,00 MAD** grâce au pipeline RAG.

---

### 11  @BankinAIBot : Intégration Telegram

<img width="1406" height="848" alt="image" src="https://github.com/user-attachments/assets/c2efe1f5-fe1b-4018-b2f6-38a6b77c46b6" />

Le même chatbot IA est accessible sur **Telegram** via **@BankinAIBot**. Il interroge la base de données bancaire en temps réel et répond en langage naturel (français et anglais) :

- `"what is the balance of Hassan ?"` → **15 000,00 MAD**, compte **ACTIVE**
- `"and what about other clients ?"` → tableau complet Hassan (25 000), Mohamed (7 800 — SUSPENDED), Imane (54 000)

---

## Chatbot IA : RAG + Telegram

### Deux canaux d'accès

```
┌──────────────┐          ┌──────────────┐
│ Interface    │          │   Telegram   │
│ Web Angular  │          │ @BankinAIBot │
│ HTTP Stream  │          │ Long Polling │
└──────┬───────┘          └──────┬───────┘
       └──────────┬──────────────┘
                  ▼
         ┌─────────────────┐
         │ Spring AI       │
         │ Chatbot (8087)  │
         └────────┬────────┘
                  │
      ┌───────────┴────────────┐
      ▼                        ▼
┌──────────────┐     ┌──────────────────┐
│ mistral-embed│     │ mistral-small    │
│ (embeddings) │     │ (génération LLM) │
└──────┬───────┘     └────────┬─────────┘
       ▼                      ▼
┌──────────────┐     ┌──────────────────┐
│ Vector Store │────►│ Réponse enrichie │
│ (docs indexés│     │ par le contexte  │
└──────────────┘     └──────────────────┘
```

### Pipeline RAG en 6 étapes

```
1. Question utilisateur (web ou Telegram)
2. Embedding vectoriel (mistral-embed)
3. Recherche top-4 chunks similaires dans le Vector Store
4. Injection du contexte dans le prompt système
5. Génération par Mistral AI (mistral-small-latest)
6. Réponse → Web : streaming SSE · Telegram : message complet
```

### Fonctionnalités

| Fonctionnalité | Web | Telegram |
|---|:---:|:---:|
| Réponses en langage naturel | ✅ | ✅ |
| Streaming temps réel | ✅ | — |
| Rendu Markdown | ✅ | ✅ |
| Historique multi-tours | ✅ | ✅ |
| Réinitialisation | ✅ | ✅ `/clear` |
| Multilingue FR/EN | ✅ | ✅ |
| Intégré sidebar | ✅ | — |
| Commandes slash | — | ✅ |


---

## 🔐 Sécurité

```
POST /auth/login { username, password }
        ↓
Vérification InMemoryUserDetailsManager
        ↓
JWT HS512 généré (validité 10 min)
        ↓
Angular stocke dans localStorage
        ↓
Intercepteur JWT → Authorization: Bearer <token>
        ↓
NimbusJwtDecoder valide chaque requête
```

**Endpoints publics :** `/auth/login` · `/h2-console/**` · `/swagger-ui/**` · `/chat`

---

## API REST

```http
# Auth
POST /auth/login

# Clients
GET    /customers              GET    /customers/search?keyword=
GET    /customers/{id}         POST   /customers
PUT    /customers/{id}         DELETE /customers/{id}

# Comptes
GET  /accounts                 GET  /accounts/{id}
GET  /accounts/{id}/pageOperations?page=0&size=5
POST /accounts/current         POST /accounts/saving

# Opérations
POST /accounts/debit           POST /accounts/credit
POST /accounts/transfer

# Chatbot
GET  /chat?query=votre question
```

---

## Modèle de Données

```
Customer(id, name, email)
    └──(1..*)──► BankAccount(id UUID, balance, status, currency, createdAt)
                    ├── CurrentAccount(overDraft)      TYPE discriminator: "CA"
                    ├── SavingAccount(interestRate)    TYPE discriminator: "SA"
                    └──(1..*)──► AccountOperation(id, date, amount, type, description)

AccountStatus  : CREATED | ACTIVATED | SUSPENDED
OperationType  : DEBIT | CREDIT
```

---

## 🔗 Liens

| Ressource | URL |
|-----------|-----|
| 📁 GitHub | https://github.com/HaleemaOKSM/E-banking-app |
| 🌐 Frontend | http://localhost:4200 |
| ⚙️ Backend | http://localhost:8085 |
| 📖 Swagger | http://localhost:8085/swagger-ui/index.html |
| 🤖 Chatbot | http://localhost:8087 |
| 💬 Telegram | @BankinAIBot |

---

## 📚 Références

- Spring Boot 3.3 · Spring Security OAuth2 · Spring AI 1.0.0-M6
- Angular 18 Standalone Components · ngx-markdown · Chart.js
- Mistral AI API · TelegramBots Java Library
- Cours JEE — Pr. Mohamed Youssfi, ENSET Mohammedia

---

<div align="center">

**Digital Banking Application** : Projet JEE 2024/2025  
ENSET Mohammedia · Université Hassan II de Casablanca  
Développé par **Haleema OKSM** 🎓

</div>
