# Luo tapahtumalipputyyppi

Luo uuden tapahtumalipputyypin

**URL** : `api/myyntitapahtumat/`

**Metodi** : `POST`

**Datan rajoitukset**

Syötä hinta ja linkit lipputyyppiin sekä tapahtumaan

```json
{
    "hinta":30,
   "lipputyyppi": "http://localhost:8080/api/lipputyypit/1",
   "tapahtuma": "http://localhost:8080/api/tapahtumat/3"
	
}
```
**Esimerkki** Kaikki kentät täytetty

```json
{
    "hinta":30,
   "lipputyyppi": "http://localhost:8080/api/lipputyypit/1",
   "tapahtuma": "http://localhost:8080/api/tapahtumat/3"
	
}
```

## Onnistunut vastaus

**Ehto** Kaikki kentät sisältävät oikeaa dataa

**Code** : `201 CREATED`

**Sisältö** :
```json

{
  "hinta" : 20,
  "nimi" : "lapsi",
  "_links" : {
    "self" : {
      "href" : "https://etappi-ticketguru.herokuapp.com/api/tapahtumalipputyypit/2"
    },
    "tapahtumalipputyyppi" : {
      "href" : "https://etappi-ticketguru.herokuapp.com/api/tapahtumalipputyypit/2"
    },
    "liput" : {
      "href" : "https://etappi-ticketguru.herokuapp.com/api/tapahtumalipputyypit/2/liput"
    },
    "tapahtuma" : {
      "href" : "https://etappi-ticketguru.herokuapp.com/api/tapahtumalipputyypit/2/tapahtuma"
    }
  }
}
```

## Virhevastauksia

**Ehto** : Virheellistä dataa kentässä

**Code** : `400 BAD REQUEST`

**Esimerkki** Hinnan numeron sijasta on kirjaimia
 
 ```json
 
 {
    "hinta":"moi",
   "lipputyyppi": "[http://localhost:8080/api/lipputyypit/1](https://etappi-ticketguru.herokuapp.com/api/tapahtumalipputyypit/2/liput)",
   "tapahtuma": "[http://localhost:8080/api/tapahtumat/3](https://etappi-ticketguru.herokuapp.com/api/tapahtumalipputyypit/2/tapahtuma)"
	
}
 
```
