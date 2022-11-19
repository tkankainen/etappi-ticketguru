# Näytä kaikki tapahtumalipputyypit

Näyttää kaikki tapahtumalipputyypit

**URL** : `/api/tapahtumalipputyypit/`

**Metodi** : `GET`

# Onnistunut pyyntö

**Vaatimus** : Ei näytä yhtään tapahtumalipputyyppiä.

**Koodi** : `200 OK`

**Sisältö** : `{[]}`

### TAI

**Vaatimus** : Näyttää yhden tai useamman tapahtumalipputyypin

**Koodi** : `200 OK`

**Sisältö** : Esimerkiksi 3 tapahtumalipputyyppiä löytyi

```json
{
    "_embedded": {
        "tapahtumalipputyyppis": [
            {
      "hinta" : 40,
      "nimi" : "aikuinen",
      "_links" : {
        "self" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/tapahtumalipputyypit/1"
        },
        "tapahtumalipputyyppi" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/tapahtumalipputyypit/1"
        },
        "liput" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/tapahtumalipputyypit/1/liput"
        },
        "tapahtuma" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/tapahtumalipputyypit/1/tapahtuma"
        }
      }
    }, {
      "hinta" : 20,
      "nimi" : "lapsi",
      "_links" : {
        "self" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/tapahtumalipputyypit/2"
        },
        "tapahtumalipputyyppi" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/tapahtumalipputyypit/2"
        },
        "liput" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/tapahtumalipputyypit/2/liput"
        },
        "tapahtuma" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/tapahtumalipputyypit/2/tapahtuma"
        }
      }
    }, {
      "hinta" : 35,
      "nimi" : "aikuinen",
      "_links" : {
        "self" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/tapahtumalipputyypit/6"
        },
        "tapahtumalipputyyppi" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/tapahtumalipputyypit/6"
        },
        "liput" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/tapahtumalipputyypit/6/liput"
        },
        "tapahtuma" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/tapahtumalipputyypit/6/tapahtuma"
        }
      }
    }
```
# Näytä yksi tapahtuma

Näyttää yhden tapahtumalipputyypin tiedot

**URL** : `/api/tapahtumat/{id}`

**Metodi** : `GET`

**Vaatimus** : Näyttää yhden tapahtumalipputyypin

**Koodi** : `200 OK`

**Sisältö** : Haettu yhden tapahtumalipputyypin (id=1) tiedot
```json
{
  "hinta" : 40,
  "nimi" : "aikuinen",
  "_links" : {
    "self" : {
      "href" : "https://etappi-ticketguru.herokuapp.com/api/tapahtumalipputyypit/1"
    },
    "tapahtumalipputyyppi" : {
      "href" : "https://etappi-ticketguru.herokuapp.com/api/tapahtumalipputyypit/1"
    },
    "liput" : {
      "href" : "https://etappi-ticketguru.herokuapp.com/api/tapahtumalipputyypit/1/liput"
    },
    "tapahtuma" : {
      "href" : "https://etappi-ticketguru.herokuapp.com/api/tapahtumalipputyypit/1/tapahtuma"
    }
  }
}
```
## Epäonnistunut pyyntö

**Vaatimus** Tapahtumalipputyyppiä ei ole haetulla ID:llä

**Code** `404 NOT FOUND`

**Sisältö** : `{}`
