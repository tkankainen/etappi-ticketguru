# Päivitä käyttäjä

Päivitä olemassa oleva käyttäjä

**URL** : `/api/käyttäjät/{id}/`

**Metodi** : `PUT`

**Data rajoitukset**

```json

{
"etunimi": "[unicode 100 chars max]",
"sukunimi": "[unicode 100 chars max]",
"tunnus": "[unicode 100 chars max]",
"salasana": "[unicode 100 chars max]",
"rooli": "[unicode 100 chars max]",
}
```
**Esimerkki** Vain osa tiedoista on muutettu.

```json
{ 
    "etunimi": "User2",
    "sukunimi": "Snimi",
    "tunnus": "Koff",
    "salasana": "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6",
    "rooli": "USER"
}
```

## Onnistunut vastaus

**Ehto** Osa tai kaikki data muutettu

**Code** : `200 OK`

**Esimerkki** : "tunnus" kenttä on päivitetty ja lisätty kohteeseen `/api/kayttajat/2/`

```json
{
    "etunimi": "User2",
    "sukunimi": "Snimi",
    "tunnus": "Koff",
    "salasana": "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6",
    "rooli": "USER",
    "_links": {
        "self": {
            "href": "http://localhost:8080/api/kayttajat/5"
        },
        "kayttaja": {
            "href": "http://localhost:8080/api/kayttajat/5"
        },
        "myyntitapahtumat": {
            "href": "http://localhost:8080/api/kayttajat/5/myyntitapahtumat"
        }
    }
}
```
**Ehto** Käyttäjää ei ollut olemassa vielä kyseisellä ID:llä, joten sen ID:n alle luotiin uusi käyttäjä.

**Code** : `201 Created`

**Esimerkki syöte** :
```json
{ 
    "etunimi": "User3",
    "sukunimi": "Snimi",
    "tunnus": "Karjala",
    "salasana": "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6",
    "rooli": "USER"
}
```
**Sisältö** : 

```json
{
    "etunimi": "User3",
    "sukunimi": "Snimi",
    "tunnus": "Karjala",
    "salasana": "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6",
    "rooli": "USER",
    "_links": {
        "self": {
            "href": "http://localhost:8080/api/kayttajat/3"
        },
        "kayttaja": {
            "href": "http://localhost:8080/api/kayttajat/3"
        },
        "myyntitapahtumat": {
            "href": "http://localhost:8080/api/kayttajat/3/myyntitapahtumat"
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
    "sukunimi": "Snimi",
    "tunnus": "Karjala",
    "salasana": "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6",
    "rooli": ""
}
```
