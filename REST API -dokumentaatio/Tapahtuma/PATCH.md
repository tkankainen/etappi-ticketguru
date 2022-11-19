# Päivitä tapahtuman tietoa

Päivitä tapahtuman yksittäistä tietoa

**URL** : `/api/tapahtumat/{id}/`

**Metodi** : `PATCH`

**Data rajoitukset**

```json

{
"nimi": "[unicode 100 chars max]",
}
```
**Esimerkki** Muutetaan "nimi" kenttää.

```json
{
"nimi": "VehnäRock"
}
```

## Onnistunut vastaus

**Ehto** : Osa tapahtuman dataa muutettu

**Code** : `200 OK`

**Esimerkki** : "nimi" kenttä on päivitetty kohteeseen `/api/tapahtumat/1/`

```json
{
"id" :1,
"aika" :"2022-10-10T15:00:00",
"nimi" :"VehnäRock",
"osoite" :"os1",
"kaupunki" :"HKI",
"kpl" :5,
"loppupvm": "12.10.2022"
"_links": {
        "self": {
      "href" : "https://etappi-ticketguru.herokuapp.com/api/tapahtumat/1"
    },
    "tapahtuma" : {
      "href" : "https://etappi-ticketguru.herokuapp.com/api/tapahtumat/1"
    },
    "tapahtumalipputyypit" : {
      "href" : "https://etappi-ticketguru.herokuapp.com/api/tapahtumat/1/tapahtumalipputyypit"
    }
  }
}
```

## Virhe vastaus

**Ehto** : Tapahtumaa ei löydy.

**Code** `404 NOT FOUND`

**Sisältö** : `{}`
