# Luo lippu

Luo uuden lipun tapahtumaan

**URL** : `api/liput/`

**Metodi** : `POST`

**Datan rajoitukset**

Pyynnössä on linkit tapahtumalipputyyppiin ja myyntitapahtumaan.
Syötä tapahtuman tiedot

```json
{
    "tapahtumalipputyyppi": "[tapahtumalipputyyppi]",
    "myyntitapahtuma": "[myyntitapahtuma]",
    "lippukoodi": "[unicode 50 chars max]",
    "hinta": "[unicode numerical]",
    "kaytetty": "[unicode 50 chars max]"
}
```
**Esimerkki** Kaikki kentät täytetty

```json
{
    "tapahtumalipputyyppi": "https://etappi-ticketguru.herokuapp.com/api/tapahtumalipputyypit/2",
    "myyntitapahtuma": "https://etappi-ticketguru.herokuapp.com/api/myyntitapahtumat/1",
    "lippukoodi": "234ty5tg6",
    "hinta": 37,
    "kaytetty": "null"
}
```

## Onnistunut vastaus

**Ehto** Kaikki kentät sisältävät oikeaa dataa

**Code** : `201 CREATED`

**Sisältö** :
```json

{
    "hinta": 37,
    "kaytetty": "null",
    "lippukoodi": "234ty5tg6",
    "_links": {
        "self": {
            "href": "https://etappi-ticketguru.herokuapp.com/api/liput/4"
        },
        "lippu": {
            "href": "https://etappi-ticketguru.herokuapp.com/api/liput/4"
        },
        "tapahtumalipputyyppi": {
            "href": "https://etappi-ticketguru.herokuapp.com/api/liput/4/tapahtumalipputyyppi"
        },
        "myyntitapahtuma": {
            "href": "https://etappi-ticketguru.herokuapp.com/api/liput/4/myyntitapahtuma"
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
