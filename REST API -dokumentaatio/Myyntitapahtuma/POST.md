# Luo myyntitapahtuma

Luo uuden myyntitapahtuman

**URL** : `api/myyntitapahtumat/`

**Metodi** : `POST`

**Datan rajoitukset**

Pyynnössä on linkki käyttäjään.
Syötä käyttäjän tiedot

```json

    {
        "kayttaja": "[kayttaja]"
    }

```
**Esimerkki** Kaikki kentät täytetty

```json
{
    "https://etappi-ticketguru.herokuapp.com/api/kayttajat/1",
    
}
```

## Onnistunut vastaus

**Ehto** Kaikki kentät sisältävät oikeaa dataa

**Code** : `201 CREATED`

**Sisältö** :
```json

{
      "hinta" : 10,
      "kaytetty" : "11/15/2022, 08:26:35 PM",
      "lippukoodi" : "9c676ce0-cce3-49a3-9a87-989ea1611095",
      "_links" : {
        "self" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/liput/1"
        },
        "lippu" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/liput/1"
        },
        "myyntitapahtuma" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/liput/1/myyntitapahtuma"
        },
        "tapahtumalipputyyppi" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/liput/1/tapahtumalipputyyppi
```

## Virhevastauksia

**Ehto** : 

**Code** : `400 BAD REQUEST`

**Esimerkki** Käyttäjä nimen sijasta on numero
 
 ```json
 {
    "kayttaja": 2
}
```
