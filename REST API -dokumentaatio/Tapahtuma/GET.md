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
                "aika": "2022-12-21T18:00:00",
                "nimi": "Tapahtuma1",
                "osoite": "os1",
                "kaupunki": "HKI",
                "kpl": 5,
                "loppupvm": "15.9.2022",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/api/tapahtumat/1"
                    },
                    "tapahtuma": {
                        "href": "http://localhost:8080/api/tapahtumat/1"
                    },
                    "tapahtumalipputyypit": {
                        "href": "http://localhost:8080/api/tapahtumat/1/tapahtumalipputyypit"
                    }
                }
            },
            {
                "aika": "2022-10-08T20:00:00",
                "nimi": "Tapahtuma2",
                "osoite": "os1",
                "kaupunki": "HKI",
                "kpl": 5,
                "loppupvm": "15.9.2023",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/api/tapahtumat/2"
                    },
                    "tapahtuma": {
                        "href": "http://localhost:8080/api/tapahtumat/2"
                    },
                    "tapahtumalipputyypit": {
                        "href": "http://localhost:8080/api/tapahtumat/2/tapahtumalipputyypit"
                    }
                }
            },
            {
                "aika": "2022-10-22T21:25:36.474787",
                "nimi": "Tapahtuma3",
                "osoite": "Kulttuuritalo",
                "kaupunki": "Helsinki",
                "kpl": 500,
                "loppupvm": "31.12.2022",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/api/tapahtumat/3"
                    },
                    "tapahtuma": {
                        "href": "http://localhost:8080/api/tapahtumat/3"
                    },
                    "tapahtumalipputyypit": {
                        "href": "http://localhost:8080/api/tapahtumat/3/tapahtumalipputyypit"
                    }
                }
            }
        ]
    },
    "_links": {
        "self": {
            "href": "http://localhost:8080/api/tapahtumat/"
        },
        "profile": {
            "href": "http://localhost:8080/api/profile/tapahtumat"
        },
        "search": {
            "href": "http://localhost:8080/api/tapahtumat/search"
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
    "aika": "2022-12-21T18:00:00",
    "nimi": "Tapahtuma1",
    "osoite": "os1",
    "kaupunki": "HKI",
    "kpl": 5,
    "loppupvm": "15.9.2022",
    "_links": {
        "self": {
            "href": "http://localhost:8080/api/tapahtumat/1"
        },
        "tapahtuma": {
            "href": "http://localhost:8080/api/tapahtumat/1"
        },
        "tapahtumalipputyypit": {
            "href": "http://localhost:8080/api/tapahtumat/1/tapahtumalipputyypit"
        }
    }
}
```
## Epäonnistunut pyyntö

**Vaatimus** Tapahtumaa ei ole haetulla ID:llä

**Code** `404 NOT FOUND`

**Sisältö** : `{}`
