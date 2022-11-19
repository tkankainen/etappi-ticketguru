# Päivitä käyttäjän tietoa

Päivitä käyttäjän yksittäistä tietoa

**URL** : `/api/käyttäjät/{id}/`

**Metodi** : `PATCH`

**Data rajoitukset**

```json

{
"etunimi": "[unicode 100 chars max]",
}
```
**Esimerkki** Muutetaan "etunimi" kenttää.

```json
{
"etunimi": "Teppo"
}
```

## Onnistunut vastaus

**Ehto** : Osa tapahtuman dataa muutettu

**Code** : `200 OK`

**Esimerkki** : "etunimi" kenttä on päivitetty kohteeseen `/api/käyttäjät/1/`

```json
{
    "etunimi": "Teppo",
    "sukunimi": "Snimi",
    "tunnus": "u1",
    "salasana": "$2a$10$UmKkO8p.15R057r8PiSpKemW6uhrcvyD2nFWnXEPZ68r5Y3GuukZW",
    "rooli": "USER",
    "_links": {
    "self" : {
      "href" : "https://etappi-ticketguru.herokuapp.com/api/kayttajat/1"
    },
    "kayttaja" : {
      "href" : "https://etappi-ticketguru.herokuapp.com/api/kayttajat/1"
    },
    "myyntitapahtumat" : {
      "href" : "https://etappi-ticketguru.herokuapp.com/api/kayttajat/1/myyntitapahtumat"
    }
  }
}
```

## Virhe vastaus

**Ehto** : Käyttäjää ei löydy.

**Code** `404 NOT FOUND`

**Sisältö** : `{}`
