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
