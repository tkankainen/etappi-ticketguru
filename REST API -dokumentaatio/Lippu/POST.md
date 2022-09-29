# Luo lippu

Luo uuden lipun tapahtumaan

**URL** : `api/liput/`

**Metodi** : `POST`

**Datan rajoitukset**

Pyynnössä on linkit tapahtumaan, tapahtumalipputyyppiin, tilaan ja myyntitapahtumaan.
Syötä tapahtuman tiedot

```json
{
    {
        "tapahtuma": "[tapahtuma]",
        "tapahtumalipputyyppi": "[tapahtumalipputyyppi]",
        "tila": "[tila]",
        "myyntitapahtuma": "[myyntitapahtuma]",
        "lippukoodi": "[unicode 50 chars max]",
        "hinta": "[unicode numerical]",
    }
}
```
**Esimerkki** Kaikki kentät täytetty

```json
{
    "tapahtuma": "http://localhost:8080/api/tapahtumat/3",
    "tapahtumalipputyyppi": "http://localhost:8080/api/tapahtumalipputyypit/2",
    "tila": "http://localhost:8080/api/tilat/1",
    "myyntitapahtuma": "http://localhost:8080/api/myyntitapahtumat/1",
    "lippukoodi": "234ty5tg6",
    "hinta": 37
}
```

## Onnistunut vastaus

**Ehto** Kaikki kentät sisältävät oikeaa dataa

**Code** : `201 CREATED`

**Sisältö** :
```json

{
    "lippukoodi": "234ty5tg6",
    "hinta": 37,
    "_links": {
        "self": {
            "href": "http://localhost:8080/api/liput/4"
        },
        "lippu": {
            "href": "http://localhost:8080/api/liput/4"
        },
        "tapahtumalipputyyppi": {
            "href": "http://localhost:8080/api/liput/4/tapahtumalipputyyppi"
        },
        "tila": {
            "href": "http://localhost:8080/api/liput/4/tila"
        },
        "myyntitapahtuma": {
            "href": "http://localhost:8080/api/liput/4/myyntitapahtuma"
        },
        "tapahtuma": {
            "href": "http://localhost:8080/api/liput/4/tapahtuma"
        }
    }
}

```

## Virhevastauksia

**Ehto** : 

**Code** : `400 BAD REQUEST`

**Esimerkki**
 
 ```json
 
```