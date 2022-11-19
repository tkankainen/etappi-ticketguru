# Näytä kaikki liput

Näyttää kaikki liput

**URL** : `/api/liput/`

**Metodi** : `GET`

# Onnistunut pyyntö

**Vaatimus** : Ei näytä yhtään lippua.

**Koodi** : `200 OK`

**Sisältö** :
```json
{
    "_embedded": {
        "lippus": []
    },
    "_links": {
        "self": {
            "href": "https://etappi-ticketguru.herokuapp.com/api/liput"
        },
        "profile": {
            "href": "https://etappi-ticketguru.herokuapp.com/api/profile/liput"
        },
        "search": {
            "href": "https://etappi-ticketguru.herokuapp.com/api/liput/search"
        }
    }
}       

```


### TAI

**Vaatimus** : Näyttää yhden tai useamman lipun

**Koodi** : `200 OK`

**Sisältö** : Esimerkiksi 2 lippua löytyi

```json
{
    "_embedded": {
        "lippus": [
            {
                "hinta": 25,
                "kaytetty" : null,
                "lippukoodi": "abc234",
                "_links": {
                    "self": {
                        "href": "https://etappi-ticketguru.herokuapp.com/api/liput/1"
                    },
                    "lippu": {
                        "href": "https://etappi-ticketguru.herokuapp.com/api/liput/1"
                    },
                    "myyntitapahtuma": {
                        "href": "https://etappi-ticketguru.herokuapp.com/api/liput/1/myyntitapahtuma"
                    },
                    "tapahtumalipputyyppi": {
                        "href": "https://etappi-ticketguru.herokuapp.com/api/liput/1/tapahtumalipputyyppi"
                    }
                }
            },
            {
                "hinta": 12,
                "kaytetty" : "11/14/2022, 07:38:40 PM",
                "lippukoodi": "iopp453f",
                "_links": {
                    "self": {
                        "href": "https://etappi-ticketguru.herokuapp.com/api/liput/2"
                    },
                    "lippu": {
                        "href": "https://etappi-ticketguru.herokuapp.com/api/liput/2"
                    },
                    "myyntitapahtuma": {
                        "href": "https://etappi-ticketguru.herokuapp.com/api/liput/2/myyntitapahtuma"
                    },
                    "tapahtumalipputyyppi": {
                        "href": "https://etappi-ticketguru.herokuapp.com/api/liput/2/tapahtumalipputyyppi"
                    }
                }
            }
        ]
    },
    "_links": {
        "self": {
            "href": "https://etappi-ticketguru.herokuapp.com/api/liput/"
        },
        "profile": {
            "href": "https://etappi-ticketguru.herokuapp.com/api/profile/liput"
        },
        "search": {
            "href": "https://etappi-ticketguru.herokuapp.com/api/liput/search"
        }
    }
}
```
# Näytä yksi lippu

Näyttää yhden lipun tiedot

**URL** : `api/liput/{id}`

**Metodi** : `GET`

# Onnistunut pyyntö

**Vaatimus** : Näyttää yhden lipun

**Koodi** : `200 OK`

**Sisältö** : Haettu yhden lipun (id=1) tiedot
```json
{
    "hinta": 25,
    "kaytetty" : "11/14/2022, 07:38:40 PM",
    "lippukoodi": "abc234",
    "_links": {
        "self": {
            "href": "https://etappi-ticketguru.herokuapp.com/api/liput/1"
        },
        "lippu": {
            "href": "https://etappi-ticketguru.herokuapp.com/api/liput/1"
        },
        "tapahtumalipputyyppi": {
            "href": "https://etappi-ticketguru.herokuapp.com/api/liput/1/tapahtumalipputyyppi"
        },
        "myyntitapahtuma": {
            "href": "https://etappi-ticketguru.herokuapp.com/api/liput/1/myyntitapahtuma"
        }

    }
}
```
## Epäonnistunut pyyntö

**Vaatimus** Lippua ei ole haetulla ID:llä

**Code** `404 NOT FOUND`

**Sisältö** : `{}`
