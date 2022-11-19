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
"nimi": "Tapahtuma12",
"osoite": "os11",
"kaupunki": "TAMPERE",
"kpl": 5,
"loppupvm": "26.9.2022"
}
```

## Onnistunut vastaus

**Ehto** Osa tai kaikki data muutettu

**Code** : `200 OK`

**Esimerkki** : Kenttiä on päivitetty ja lisätty kohteeseen `/api/tapahtumat/1/`

```json
{

                "nimi": "Tapahtuma12",
                "osoite": "Porvoo",
                "kaupunki": "TAMPERE",
                "kpl": 5,
                "loppupvm": "26.9.2022"

}
```

```json
{
    "aika": null,
    "nimi": "Tapahtuma12",
    "osoite": "moikku",
    "kaupunki": "TAMPERE",
    "kpl": 5,
    "loppupvm": "26.9.2022",
    "_links": {
    "self" : {
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
**Ehto** Tapahtumaa ei ollut olemassa vielä kyseisellä ID:llä, joten sen ID:n alle luotiin uusi käyttäjä.

**Code** : `201 Created`

**Esimerkki syöte** :
```json
            {
               
                "nimi": "Tapahtuma12",
                "osoite": "moikku",
                "kaupunki": "TAMPERE",
                "kpl": 5,
                "loppupvm": "26.9.2022"
             
            }
```
**Sisältö** : 

```json
{
    "aika": null,
    "nimi": "Tapahtuma12",
    "osoite": "moikku",
    "kaupunki": "TAMPERE",
    "kpl": 5,
    "loppupvm": "26.9.2022",
    "_links": {
    "self" : {
      "href" : "https://etappi-ticketguru.herokuapp.com/api/tapahtumat/7"
    },
    "tapahtuma" : {
      "href" : "https://etappi-ticketguru.herokuapp.com/api/tapahtumat/7"
    },
    "tapahtumalipputyypit" : {
      "href" : "https://etappi-ticketguru.herokuapp.com/api/tapahtumat/7/tapahtumalipputyypit"
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
"nimi": "Tapahtuma12",
"osoite": "",
"kaupunki": "TAMPERE",
"kpl": 5,
"loppupvm": "26.9.2022"
}
```
**Ehto** : Kenttä sisältää väärää dataa

**Code** : `400 Bad Request`

**Esimerkki** "kpl" kentässä on luvun sijasta sana

```json
 {
                "nimi": "Tapahtuma12",
                "osoite": "moikku",
                "kaupunki": "TAMPERE",
                "kpl": "Testi",
                "loppupvm": "26.9.2022"
}
```

  
