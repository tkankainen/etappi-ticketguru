# Päivitä tapahtuma

Päivitä olemassa oleva tapahtuma

**URL** : `/api/tapahtumat/{id}/`

**Metodi** : `PUT`

**Data rajoitukset**

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
**Esimerkki** Vain osa tiedoista on muutettu.

```json
{
"aika" :"2022-10-10T15:00:00",
"nimi" :"VehnäRock",
"osoite" :"os1",
"kaupunki" :"HKI",
"kpl" :5,
"loppupvm": "12.10.2022"
}
```

## Onnistunut vastaus

**Ehto** Osa tai kaikki data muutettu

**Code** : `200 OK`

**Esimerkki** : "aika" kenttä on päivitetty ja lisätty kohteeseen `/api/tapahtumat/1/`

```json
{
"id" :1,
"aika" :"2022-10-10T15:00:00",
"nimi" :"VehnäRock",
"osoite" :"os1",
"kaupunki" :"HKI",
"kpl" :5,
"loppupvm": "12.12.2022"
}
```

## Virhe vastaus

**Ehto** : Tapahtumaa ei löydy.

**Code** `404 NOT FOUND`

**Sisältö** : `{}`


  
