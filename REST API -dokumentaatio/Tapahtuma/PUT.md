# Päivitä tapahtuma

Päivitä olemassa oleva tapahtuma

**URL** : `/api/tapahtumat/{id}/`

**Metodi** : `PUT`

**Data rajoitukset**

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
**Esimerkki** Vain osa tiedoista on muutettu.

```json
{
    "aika": "aika120",
}
```

## Onnistunut vastaus

**Ehto** Osa tai kaikki data muutettu

**Code** : `200 OK`

**Esimerkki** : "aika" kenttä on päivitetty ja lisätty kohteeseen `/api/tapahtumat/1/`

```json
{
"id" :1,
"aika" :"aika120",
"nimi" :"Tapahtuma1",
"osoite" :"os1",
"kaupunki" :"HKI",
"kpl" :5,
"loppupvm": "15.9.2022"
}
```

## Virhe vastaus

**Ehto** : Tapahtumaa ei löydy.

**Code** ´404 NOT FOUND´

**Sisältö** : `{}`


  
