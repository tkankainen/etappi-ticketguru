# Näytä kaikki liput

Näyttää kaikki liput

**URL** : `/api/liput/`

**Metodi** : `GET`

# Onnistunut pyyntö

**Vaatimus** : Ei näytä yhtään lippua.

**Koodi** : `200 OK`

**Sisältö** :
```json
[
[
   {
    "_embedded": {
        "lippus": []
    },
    "_links": {
        "self": {
            "href": "http://localhost:8080/api/liput"
        },
        "profile": {
            "href": "http://localhost:8080/api/profile/liput"
        },
        "search": {
            "href": "http://localhost:8080/api/liput/search"
        }
    }
}       
]
]
```


### TAI

**Vaatimus** : Näyttää yhden tai useamman lipun

**Koodi** : `200 OK`

**Sisältö** : Esimerkiksi 2 lippua löytyi

```json
[
  [
    {
    "_embedded": {
        "lippus": [
            {
                "lippukoodi": "abc234",
                "hinta": 25,
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/api/liput/1"
                    },
                    "lippu": {
                        "href": "http://localhost:8080/api/liput/1"
                    },
                    "tapahtumalipputyyppi": {
                        "href": "http://localhost:8080/api/liput/1/tapahtumalipputyyppi"
                    },
                    "tila": {
                        "href": "http://localhost:8080/api/liput/1/tila"
                    },
                    "myyntitapahtuma": {
                        "href": "http://localhost:8080/api/liput/1/myyntitapahtuma"
                    },
                    "tapahtuma": {
                        "href": "http://localhost:8080/api/liput/1/tapahtuma"
                    }
                }
            },
            {
                "lippukoodi": "iopp453f",
                "hinta": 12,
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/api/liput/2"
                    },
                    "lippu": {
                        "href": "http://localhost:8080/api/liput/2"
                    },
                    "tapahtumalipputyyppi": {
                        "href": "http://localhost:8080/api/liput/2/tapahtumalipputyyppi"
                    },
                    "tila": {
                        "href": "http://localhost:8080/api/liput/2/tila"
                    },
                    "myyntitapahtuma": {
                        "href": "http://localhost:8080/api/liput/2/myyntitapahtuma"
                    },
                    "tapahtuma": {
                        "href": "http://localhost:8080/api/liput/2/tapahtuma"
                    }
                }
            },
        ]
    },
    "_links": {
        "self": {
            "href": "http://localhost:8080/api/liput"
        },
        "profile": {
            "href": "http://localhost:8080/api/profile/liput"
        },
        "search": {
            "href": "http://localhost:8080/api/liput/search"
        }
    }
}
]
]
```
# Näytä kaikki liput

Näyttää yhden lipun tiedot

**URL** : `/liput/{id}`

**Metodi** : `GET`

# Onnistunut pyyntö

**Vaatimus** : Näyttää yhden lipun

**Koodi** : `200 OK`

**Sisältö** : Haettu yhden lipun (id=1) tiedot
```json
[
  [
   {
    "lippukoodi": "abc234",
    "hinta": 25,
    "_links": {
        "self": {
            "href": "http://localhost:8080/api/liput/1"
        },
        "lippu": {
            "href": "http://localhost:8080/api/liput/1"
        },
        "tapahtumalipputyyppi": {
            "href": "http://localhost:8080/api/liput/1/tapahtumalipputyyppi"
        },
        "tila": {
            "href": "http://localhost:8080/api/liput/1/tila"
        },
        "myyntitapahtuma": {
            "href": "http://localhost:8080/api/liput/1/myyntitapahtuma"
        },
        "tapahtuma": {
            "href": "http://localhost:8080/api/liput/1/tapahtuma"
        }
    }
} 
]
]
```

