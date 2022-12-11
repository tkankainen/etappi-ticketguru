# Luo Käyttäjä

Luo uuden käyttäjän

**URL** : `/api/kayttajat/`

**Metodi** : `POST`

Syötä käyttäjän tiedot

```json
{
    "etunimi": "[etunimi]",
    "sukunimi": "[sukunimi]",
    "tunnus": "[tunnus]",
    "salasana": "[salasana]",
    "rooli": "[rooli]",
}
```
**Esimerkki** Kaikki kentät täytetty

```json
{
    "etunimi": "User3",
    "sukunimi": "Snimi",
    "tunnus": "u3",
    "salasana": "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6",
    "rooli": "USER",
}
```

## Onnistunut vastaus

**Ehto** Kaikki kentät sisältävät oikeaa dataa

**Code** : `201 CREATED`

**Sisältö** :
```json
{
    "etunimi": "User3",
    "sukunimi": "Snimi",
    "tunnus": "u3",
    "salasana": "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6",
    "rooli": "USER",
    "_links": {
    "self" : {
      "href" : "https://etappi-ticketguru.herokuapp.com/api/kayttajat/3"
    },
    "kayttaja" : {
      "href" : "https://etappi-ticketguru.herokuapp.com/api/kayttajat/3"
    },
    "myyntitapahtumat" : {
      "href" : "https://etappi-ticketguru.herokuapp.com/api/kayttajat/3/myyntitapahtumat"
    }
  }
}
```

## Virhe vastaus

**Ehto** Kentät ovat osittain tai täysin puutteellisia

**Code** : `206 PARTIAL CONTENT`

**Sisältö** :
```json
{ 
    "etunimi": "User3",
    "sukunimi": "",
    "tunnus": "u3",
    "salasana": "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6",
    "rooli": "USER"
}
```
