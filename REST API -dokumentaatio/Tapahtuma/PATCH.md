# Päivitä tapahtuman tietoa

Päivitä tapahtuman yksittäistä tietoa

**URL** : `/api/tapahtumat/{id}/`

**Metodi** : `PATCH`

**Data rajoitukset**

```json

{
"aika": "[unicode 100 chars max]",
}
```
**Esimerkki** Muutetaan "aika" kenttää.

```json
{
"aika": "aika120"
}
```

## Onnistunut vastaus

**Ehto** : Osa tapahtuman dataa muutettu

**Code** : `200 OK`

**Esimerkki** : "aika" kenttä on päivitetty kohteeseen `/api/tapahtumat/1/`

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

**Code** `404 NOT FOUND`

**Sisältö** : `{}`
