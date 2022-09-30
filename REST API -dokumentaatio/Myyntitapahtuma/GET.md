# Näytä kaikki myyntitapahtumat

Näyttää kaikki Myyntitapahtumat

**URL** : `/api/myyntitapahtumat/`

**Metodi** : `GET`

# Onnistunut pyyntö

**Vaatimus** : Ei näytä yhtään myyntitapahtumaa.

**Koodi** : `200 OK`

**Sisältö** :
```json
{
    "_embedded": {
        "myyntitapahtumas": []
    },
    "_links": {
        "self": {
            "href": "http://localhost:8080/api/myyntitapahtumat"
        },
        "profile": {
            "href": "http://localhost:8080/api/profile/myyntitapahtumat"
        },
        "search": {
            "href": "http://localhost:8080/api/myyntitapahtumat/search"
        }
    }
}

```


### TAI

**Vaatimus** : Näyttää yhden tai useamman myyntitapahtuman

**Koodi** : `200 OK`

**Sisältö** : Esimerkiksi 1 myyntitapahtuma löytyi

```json
{
    "_embedded": {
        "myyntitapahtumas": [
            {
                "timestamp": "31.12.2022",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/api/myyntitapahtumat/1"
                    },
                    "myyntitapahtuma": {
                        "href": "http://localhost:8080/api/myyntitapahtumat/1"
                    },
                    "kayttaja": {
                        "href": "http://localhost:8080/api/myyntitapahtumat/1/kayttaja"
                    },
                    "liput": {
                        "href": "http://localhost:8080/api/myyntitapahtumat/1/liput"
                    }
                }
            }
        ]
    },
    "_links": {
        "self": {
            "href": "http://localhost:8080/api/myyntitapahtumat"
        },
        "profile": {
            "href": "http://localhost:8080/api/profile/myyntitapahtumat"
        },
        "search": {
            "href": "http://localhost:8080/api/myyntitapahtumat/search"
        }
    }
}
```
# Näytä yksi myyntitapahtuma

Näyttää yhden myyntitaphtuman tiedot

**URL** : `api/myyntitapahtumat/{id}`

**Metodi** : `GET`

# Onnistunut pyyntö

**Vaatimus** : Näyttää yhden myyntitapahtuman

**Koodi** : `200 OK`

**Sisältö** : Haettu yhden myyntitapahtuman (id=1) tiedot
```json
{
    "timestamp": "31.12.2022",
    "_links": {
        "self": {
            "href": "http://localhost:8080/api/myyntitapahtumat/1"
        },
        "myyntitapahtuma": {
            "href": "http://localhost:8080/api/myyntitapahtumat/1"
        },
        "kayttaja": {
            "href": "http://localhost:8080/api/myyntitapahtumat/1/kayttaja"
        },
        "liput": {
            "href": "http://localhost:8080/api/myyntitapahtumat/1/liput"
        }
    }
}
```
### Näyttää yhden myyntitapahtuman liput

Näyttää tiettyyn myyntitapahtumaan liittyvät liput

**URL** : `http://localhost:8080/api/myyntitapahtumat/{id}/liput`

**Metodi** : `GET`

# Onnistunut pyyntö

**Vaatimus** : Ei näytä yhtään lippua myyntitapahtumalle.

**Koodi** : `200 OK`

**Sisältö** :
```json
{
    "_embedded": {
        "lippus": []
    },
    "_links": {
        "self": {
            "href": "http://localhost:8080/api/myyntitapahtumat/3/liput"
        }
    }
}

# Onnistunut pyyntö
**Vaatimus** : Näyttää yhden myyntitapahtuman kaikki liput

**Koodi** : `200 OK`

**Sisältö** : Esimerkiksi 1 myyntitapahtumalla löytyi lippuja

```json
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
                    "tila": {
                        "href": "http://localhost:8080/api/liput/1/tila"
                    },
                    "tapahtumalipputyyppi": {
                        "href": "http://localhost:8080/api/liput/1/tapahtumalipputyyppi"
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
                    "tila": {
                        "href": "http://localhost:8080/api/liput/2/tila"
                    },
                    "tapahtumalipputyyppi": {
                        "href": "http://localhost:8080/api/liput/2/tapahtumalipputyyppi"
                    },
                    "myyntitapahtuma": {
                        "href": "http://localhost:8080/api/liput/2/myyntitapahtuma"
                    },
                    "tapahtuma": {
                        "href": "http://localhost:8080/api/liput/2/tapahtuma"
                    }
                }
            }
          
        ]
    },
    "_links": {
        "self": {
            "href": "http://localhost:8080/api/myyntitapahtumat/1/liput"
        }
    }
}
```
