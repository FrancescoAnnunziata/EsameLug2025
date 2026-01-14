# Bro-menu

**Bro-menu** è un’applicazione grafica per la gestione delle ricompense che un utente ottiene per i propri *Bros*.

Il progetto è pensato come esercizio di **Programmazione 2** e richiede particolare attenzione ai principi di **Object-Oriented Programming**, alla gestione delle collezioni in JavaFX e alla pulizia del codice.

---

## 👤 Utente

Un utente è caratterizzato da:
- **Livello Elo**
- **Numero totale di trofei**

Questi dati sono mostrati nella prima riga dell’interfaccia grafica.

---

## 🤝 Bros

Un **Bro** possiede le seguenti caratteristiche:
- Nome
- Valore in **crediti** necessario per ottenerlo
- Livello *(inizializzato a 1)*
- Numero di trofei ottenuti *(inizializzato a 0)*

### Bros iniziali

All’avvio dell’applicazione, i Bros disponibili (tutti inizialmente **non posseduti**) sono:

| Nome    | Crediti |
|--------|---------|
| Beretta | 10 |
| ZME     | 40 |
| Drago   | 100 |
| Topo    | 150 |
| Treno  | 200 |

---

## 🎮 Visualizzazione dei Bros

- I Bros sono rappresentati come **cerchi di raggio 40px**
- **Bro non posseduto**
  - Colore: `OLIVE`
  - Mostra: nome + valore in crediti
- **Bro posseduto**
  - Colore: `GREEN`
  - Mostra: nome + livello + numero di trofei

### Interazioni

- Click su Bro **non posseduto**  
  → Alert **ERROR**:  
  `Bro non sbloccato`

- Click su Bro **posseduto**
  - Decrementa:
    - Powerups di 10
    - Monete di 10
  - Incrementa:
    - Livello del Bro di 1

Se le ricompense non sono sufficienti:
- Alert **ERROR**:  
  `Mancano X ricompense di tipo Y per livellare`
- Se mancano entrambe, viene mostrato **un solo alert** con **due messaggi**

---

## 📋 Ordinamento Bros

La lista dei Bros è divisa in:
- **Bros posseduti**
- **Bros non posseduti**

### Bros posseduti
Ordinabili per:
- Nome (ordinamento naturale)
- Livello
- Numero di trofei  

In caso di conflitto → ordinamento naturale

### Bros non posseduti
- **Non ordinabili**
- Sempre mostrati in ordine crescente di valore in crediti  
- Evidenziano il **prossimo Bro sbloccabile**

---

## 🎁 Ricompense

Le ricompense sono visualizzate come **rettangoli 100x30 px** con:
- Colore associato al tipo
- Bordo nero da 5px
- Testo: tipo + totale corrente

### Tipi di ricompensa

| Tipo      | Colore   | Incremento | Massimo |
|----------|----------|------------|---------|
| Powerups | PURPLE   | +10        | 30 |
| Monete   | GOLD     | +100       | 200 |
| Crediti | CYAN     | +30        | — |
| Elo      | GRAY     | +70        | — |
| Trofei   | MAROON   | +8         | — |

Tutte le ricompense sono inizializzate a **0** all’avvio dell’applicazione.

### Interazioni

- Click su una ricompensa:
  - Incrementa il totale della quantità prevista
  - Se viene superato il massimo:
    - Alert **ERROR**:  
      `Massimo raggiunto`

- **Trofei**:
  - Incrementano anche i trofei del **primo Bro posseduto** nella lista

---

## 🖥️ Interfaccia Grafica

- Dimensioni finestra: **600 x 150 px**
- Layout:
  1. Riga dati utente
  2. Riga Bros (con pulsanti di ordinamento)
  3. Riga ricompense

La disposizione grafica deve rispecchiare il layout richiesto, ma la **funzionalità è prioritaria** rispetto all’aspetto estetico.
