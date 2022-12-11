# Luo tapahtumalipputyyppi

Luo uuden tapahtumalipputyypin

**URL** : `api/myyntitapahtumat/`

**Metodi** : `POST`

**Datan rajoitukset**

Syötä hinta ja linkit lipputyyppiin sekä tapahtumaan

```json
{
    "hinta":30,
   "lipputyyppi": "https://etappi-ticketguru.herokuapp.com/api/tapahtumalipputyypit/1",
   "tapahtuma": "https://etappi-ticketguru.herokuapp.com/api/tapahtumat/3"
	
}
```
**Esimerkki** Kaikki kentät täytetty

```json
{
    "hinta":30,
	"lipputyyppi": "https://etappi-ticketguru.herokuapp.com/api/tapahtumalipputyypit/1",
  	 "tapahtuma": "https://etappi-ticketguru.herokuapp.com/api/tapahtumat/3"
	
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
   "lipputyyppi": "https://etappi-ticketguru.herokuapp.com/api/tapahtumalipputyypit/2/liput",
   "tapahtuma": "https://etappi-ticketguru.herokuapp.com/api/tapahtumalipputyypit/2/tapahtuma"
	
}
 
```
