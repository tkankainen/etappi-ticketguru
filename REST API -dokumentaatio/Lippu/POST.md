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
    "tapahtumalipputyyppi": null,
    "tila": {
        "tilaid": 1
    },
    "myyntitapahtuma": null,
    "lippukoodi": "xcvg567s",
    "hinta": 40
}
```

## Onnistunut vastaus

**Ehto** Kaikki kentät sisältävät oikeaa dataa

**Code** : `201 CREATED`

```json
{
"id" :1,
"aika" :"2022-10-10T15:00:00",
"nimi" :"Tapahtuma1",
"osoite" :"os1",
"kaupunki" :"HKI",
"kpl" :5,
"loppupvm": "12.10.2022",
}
```

## Virhe vastauksia

**Ehto** : Kenttä on tyhjä, puutteeliinen tai sisältää väärä dataa.

**Code** : `400 BAD REQUEST`

**Esimerkki**
 
 ```json
 
 {
 "aika": ["Vaadittu kenttä"]
 }
```
