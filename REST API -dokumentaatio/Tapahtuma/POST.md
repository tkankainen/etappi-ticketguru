# Luo tapahtuma

Luo uuden tapahtuman

**URL** : `/api/tapahtumat/`

**Metodi** : `POST`

**Datan rajoitukset**

Syötä tapahtuman tiedot

```json
{
"aika": "[unicode 100 chars max]",
"nimi": "[unicode 100 chars max]",
"osoite": "[unicode 100 chars max]",
"kaupunki": "[unicode 100 chars max]",
"kpl": "[unicode numerical]",
"loppupvm": "[unicode date]"
}
```
**Esimerkki** Kaikki kentät täytetty

```json
{
"aika" :"aika1",
"nimi" :"Tapahtuma1",
"osoite" :"os1",
"kaupunki" :"HKI",
"kpl" :5,
"loppupvm": "15.9.2022",
}
```

## Onnistunut vastaus

**Ehto** Kaikki kentät sisältävät oikeaa dataa

**Code** : `201 CREATED`

```json
{
"id" :1,
"aika" :"aika1",
"nimi" :"Tapahtuma1",
"osoite" :"os1",
"kaupunki" :"HKI",
"kpl" :5,
"loppupvm": "15.9.2022"
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
