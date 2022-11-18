# Luo tapahtuma

Luo uuden tapahtuman

**URL** : `/api/tapahtumat/`

**Metodi** : `POST`

**Datan rajoitukset**

Syötä tapahtuman tiedot

```json
{
"aika": "[unicode date]",
"nimi": "[unicode 100 chars max]",
"osoite": "[unicode 100 chars max]",
"kaupunki": "[unicode 100 chars max]",
"kpl": "[unicode numerical]",
"loppupvm": "[unicode 100 chars max]"
}
```
**Esimerkki** Kaikki kentät täytetty

```json
{
"aika" :"2022-10-10T15:00:00",
"nimi" :"Tapahtuma1",
"osoite" :"os1",
"kaupunki" :"HKI",
"kpl" :5,
"loppupvm": "12.10.2022",
}
```

## Onnistunut vastaus

**Ehto** Kaikki kentät sisältävät oikeaa dataa

**Code** : `201 CREATED`

```json

{
    "aika": "2023-12-21T18:00:00",
    "nimi": "Tapahtuma 4",
    "osoite": "os11",
    "kaupunki": "HKI",
    "kpl": 5,
    "loppupvm": "26.9.2022",
    "_links": {
        "self": {
            "href": "http://localhost:8080/api/tapahtumat/4"
        },
        "tapahtuma": {
            "href": "http://localhost:8080/api/tapahtumat/4"
        },
        "tapahtumalipputyypit": {
            "href": "http://localhost:8080/api/tapahtumat/4/tapahtumalipputyypit"
        }
    }
}
```

## Virhe vastauksia

**Ehto** : Osa kentistä on tyhjiä

**Code** : `206 Partial Content`

**Esimerkki**
 
 ```json
 {
    "aika": "2023-12-21T18:00:00",
    "nimi": "Tapahtuma 4",
    "osoite": "os11",
    "kaupunki": "",
    "kpl": 5,
    "loppupvm": ""
}
```
**Ehto** : Kenttä sisältää väärää dataa

**Code** : `400 Bad Request`

**Esimerkki** "kpl" kentässä on luvun sijasta sana

```json
 {
    "aika": "2023-12-21T18:00:00",
    "nimi": "Tapahtuma 4",
    "osoite": "os11",
    "kaupunki": "Helsinki",
    "kpl": "Moi",
    "loppupvm": ""
}
```
