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
                "hinta": 15,
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/api/tapahtumalipputyypit/1"
                    },
                    "tapahtumalipputyyppi": {
                        "href": "http://localhost:8080/api/tapahtumalipputyypit/1"
                    },
                    "lipputyyppi": {
                        "href": "http://localhost:8080/api/tapahtumalipputyypit/1/lipputyyppi"
                    },
                    "liput": {
                        "href": "http://localhost:8080/api/tapahtumalipputyypit/1/liput"
                    },
                    "tapahtuma": {
                        "href": "http://localhost:8080/api/tapahtumalipputyypit/1/tapahtuma"
                    }
                }
            },
            {
                "hinta": 20,
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/api/tapahtumalipputyypit/2"
                    },
                    "tapahtumalipputyyppi": {
                        "href": "http://localhost:8080/api/tapahtumalipputyypit/2"
                    },
                    "lipputyyppi": {
                        "href": "http://localhost:8080/api/tapahtumalipputyypit/2/lipputyyppi"
                    },
                    "liput": {
                        "href": "http://localhost:8080/api/tapahtumalipputyypit/2/liput"
                    },
                    "tapahtuma": {
                        "href": "http://localhost:8080/api/tapahtumalipputyypit/2/tapahtuma"
                    }
                }
            },
            {
                "hinta": 30,
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/api/tapahtumalipputyypit/3"
                    },
                    "tapahtumalipputyyppi": {
                        "href": "http://localhost:8080/api/tapahtumalipputyypit/3"
                    },
                    "lipputyyppi": {
                        "href": "http://localhost:8080/api/tapahtumalipputyypit/3/lipputyyppi"
                    },
                    "liput": {
                        "href": "http://localhost:8080/api/tapahtumalipputyypit/3/liput"
                    },
                    "tapahtuma": {
                        "href": "http://localhost:8080/api/tapahtumalipputyypit/3/tapahtuma"
                    }
                }
            }
        ]
    },
    "_links": {
        "self": {
            "href": "http://localhost:8080/api/tapahtumalipputyypit"
        },
        "profile": {
            "href": "http://localhost:8080/api/profile/tapahtumalipputyypit"
        },
        "search": {
            "href": "http://localhost:8080/api/tapahtumalipputyypit/search"
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
    "hinta": 15,
    "_links": {
        "self": {
            "href": "http://localhost:8080/api/tapahtumalipputyypit/1"
        },
        "tapahtumalipputyyppi": {
            "href": "http://localhost:8080/api/tapahtumalipputyypit/1"
        },
        "lipputyyppi": {
            "href": "http://localhost:8080/api/tapahtumalipputyypit/1/lipputyyppi"
        },
        "liput": {
            "href": "http://localhost:8080/api/tapahtumalipputyypit/1/liput"
        },
        "tapahtuma": {
            "href": "http://localhost:8080/api/tapahtumalipputyypit/1/tapahtuma"
        }
    }
}
```
## Epäonnistunut pyyntö

**Vaatimus** Tapahtumalipputyyppiä ei ole haetulla ID:llä

**Code** `404 NOT FOUND`

**Sisältö** : `{}`
