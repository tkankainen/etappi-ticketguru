# Luo lippu

Luo uuden lipun tapahtumaan

**URL** : `/liput/`

**Metodi** : `POST`

**Datan rajoitukset**

Pyynnössä on tapahtuman, tapahtumalipputyypin, tilan ja myyntitapahtuman yksilöivä tunniste.
Syötä tapahtuman tiedot

```json
{
{
    "tapahtuma": {
        "tapahtumaid": {tapahtumaid}
    },
    "tapahtumalipputyyppi": {
        "lipputyyppiid": {lipputyyppiid}
    },
    "tila": {
        "tilaid": {tilaid}
    },
    "myyntitapahtuma": {
        "myyntiid": {myyntiid}
    },
    "lippukoodi": "[unicode 50 chars max]",
    "hinta": "[unicode numerical]",
}
}
```
**Esimerkki** Kaikki kentät täytetty

```json
{
    "tapahtuma": {
        "tapahtumaid": 1
    },
    "tapahtumalipputyyppi": {
        "lipputyyppiid": 1
    },
    "tila": {
        "tilaid": 1
    },
    "myyntitapahtuma": {
        "myyntiid": 1
    },
    "lippukoodi": "234ty5tg6",
    "hinta": 37
}
```

## Onnistunut vastaus

**Ehto** Kaikki kentät sisältävät oikeaa dataa

**Code** : `201 CREATED`
