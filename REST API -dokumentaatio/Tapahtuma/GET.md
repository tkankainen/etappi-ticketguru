# Näytä kaikki tapahtumat

Näyttää kaikki tapahtumat

**URL** : `/api/tapahtumat/`

**Metodi** : `GET`

# Onnistunut pyyntö

**Vaatimus** : Ei näytä yhtään tapahtumaa.

**Koodi** : `200 OK`

**Sisältö** : `{[]}`

### TAI

**Vaatimus** : Näyttää yhden tai useamman tapahtuman

**Koodi** : `200 OK`

**Sisältö** : Esimerkiksi 3 tapahtumaa löytyi

```json
{
    "_embedded": {
        "tapahtumas": [
            {
      "aika" : "2022-12-21T18:00:00",
      "nimi" : "Joutsenlampi",
      "osoite" : "Ooppera",
      "kaupunki" : "Helsinki",
      "kpl" : 800,
      "loppupvm" : "20.12.2022",
      "_links" : {
        "self" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/tapahtumat/4"
        },
        "tapahtuma" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/tapahtumat/4"
        },
        "tapahtumalipputyypit" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/tapahtumat/4/tapahtumalipputyypit"
        }
      }
    }, {
      "aika" : "2022-12-21T00:00:00",
      "nimi" : "TAPAHTUMA1",
      "osoite" : "TAVASTIA",
      "kaupunki" : "HELSINKI",
      "kpl" : 40,
      "loppupvm" : "15.9.2022",
      "_links" : {
        "self" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/tapahtumat/1"
        },
        "tapahtuma" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/tapahtumat/1"
        },
        "tapahtumalipputyypit" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/tapahtumat/1/tapahtumalipputyypit"
        }
      }
    }, {
      "aika" : "2022-12-21T00:00:00",
      "nimi" : "TAPAHTUMA2",
      "osoite" : "TAVASTIA",
      "kaupunki" : "HELSINKI",
      "kpl" : 40,
      "loppupvm" : "15.9.2022",
      "_links" : {
        "self" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/tapahtumat/2"
        },
        "tapahtuma" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/tapahtumat/2"
        },
        "tapahtumalipputyypit" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/tapahtumat/2/tapahtumalipputyypit"
        }
      }
    }
        ]
    },
    "_links": {
        "self": {
      "href" : "https://etappi-ticketguru.herokuapp.com/api/tapahtumat"
    },
    "profile" : {
      "href" : "https://etappi-ticketguru.herokuapp.com/api/profile/tapahtumat"
    },
    "search" : {
      "href" : "https://etappi-ticketguru.herokuapp.com/api/tapahtumat/search"
    }
  }
}
```
# Näytä yksi tapahtuma

Näyttää yhden tapahtuman tiedot

**URL** : `/api/tapahtumat/{id}`

**Metodi** : `GET`

**Vaatimus** : Näyttää yhden tapahtuman

**Koodi** : `200 OK`

**Sisältö** : Haettu yhden tapahtuman (id=1) tiedot
```json
{
      "aika" : "2022-12-21T18:00:00",
      "nimi" : "Joutsenlampi",
      "osoite" : "Ooppera",
      "kaupunki" : "Helsinki",
      "kpl" : 800,
      "loppupvm" : "20.12.2022",
      "_links" : {
        "self" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/tapahtumat/4"
        },
        "tapahtuma" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/tapahtumat/4"
        },
        "tapahtumalipputyypit" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/tapahtumat/4/tapahtumalipputyypit"
        }
      }
    }
```
## Epäonnistunut pyyntö

**Vaatimus** Tapahtumaa ei ole haetulla ID:llä

**Code** `404 NOT FOUND`

**Sisältö** : `{}`
