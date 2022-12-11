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
        "myyntitapahtumas": [
        "timestamp": "2022-10-26T20:42:31.16203",
        "toteutunut": "0",
    }],
    "_links": {
        "self": {
            "href": "https://etappi-ticketguru.herokuapp.com/api/myyntitapahtumat"
        },
        "profile": {
            "href": "https://etappi-ticketguru.herokuapp.com/api/profile/myyntitapahtumat"
        },
        "search": {
            "href": "https://etappi-ticketguru.herokuapp.com/api/myyntitapahtumat/search"
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
                "timestamp": "2022-10-26T20:42:31.16203",
                "toteutunut" : "0",
                "_links": {
                    "self": {
                        "href": "https://etappi-ticketguru.herokuapp.com/api/myyntitapahtumat/1"
                    },
                    "myyntitapahtuma": {
                        "href": "https://etappi-ticketguru.herokuapp.com/api/myyntitapahtumat/1"
                    },
                    "kayttaja": {
                        "href": "https://etappi-ticketguru.herokuapp.com/api/myyntitapahtumat/1/kayttaja"
                    },
                    "liput": {
                        "href": "https://etappi-ticketguru.herokuapp.com/api1/liput"
                    }
                }
            }
        ]
    },
    "_links": {
        "self": {
            "href": "https://etappi-ticketguru.herokuapp.com/api/myyntitapahtumat"
        },
        "profile": {
            "href": "https://etappi-ticketguru.herokuapp.com/api/profile/myyntitapahtumat"
        },
        "search": {
            "href": "https://etappi-ticketguru.herokuapp.com/api/myyntitapahtumat/search"
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
      "timestamp" : "2022-10-26T20:42:31.16203",
      "toteutunut" : "0",
      "_links" : {
        "self" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/myyntitapahtumat/1"
        },
        "myyntitapahtuma" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/myyntitapahtumat/1"
        },
        "kayttaja" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/myyntitapahtumat/1/kayttaja"
        },
        "liput" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/myyntitapahtumat/1/liput"
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
            "href": "https://etappi-ticketguru.herokuapp.com/api/myyntitapahtumat/3/liput"
        }
    }
}
```
# Onnistunut pyyntö
**Vaatimus** : Näyttää yhden myyntitapahtuman kaikki liput

**Koodi** : `200 OK`

**Sisältö** : Esimerkiksi 1 myyntitapahtumalla löytyi lippuja

```json
{
    "_embedded": {
        "lippus": [
            {
      "hinta" : 10,
      "kaytetty" : "11/15/2022, 08:26:35 PM",
      "lippukoodi" : "9c676ce0-cce3-49a3-9a87-989ea1611095",
      "_links" : {
        "self" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/liput/1"
        },
        "lippu" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/liput/1"
        },
        "myyntitapahtuma" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/liput/1/myyntitapahtuma"
        },
        "tapahtumalipputyyppi" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/liput/1/tapahtumalipputyyppi"
        }
      }
    }, {
      "hinta" : 30,
      "kaytetty" : "2022-10-27T14:16:33.063874",
      "lippukoodi" : "03db2892-4838-456e-8df0-98599cc9faf0",
      "_links" : {
        "self" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/liput/4"
        },
        "lippu" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/liput/4"
        },
        "myyntitapahtuma" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/liput/4/myyntitapahtuma"
        },
        "tapahtumalipputyyppi" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/liput/4/tapahtumalipputyyppi"
        }
      }
    }
          
        ]
    },
    "_links": {
        "self": {
            "[href": "http://localhost:8080/api](https://etappi-ticketguru.herokuapp.com/api)/myyntitapahtumat/1/liput"
        }
    }
}
```
## Epäonnistunut pyyntö

**Vaatimus** Myyntitapahtumaa ei ole haetulla ID:llä

**Code** `404 NOT FOUND`

**Sisältö** : `{}`
