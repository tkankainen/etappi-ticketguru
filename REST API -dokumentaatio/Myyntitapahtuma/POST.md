# Luo myyntitapahtuma

Luo uuden myyntitapahtuman

**URL** : `api/myyntitapahtumat/`

**Metodi** : `POST`

**Datan rajoitukset**

Pyynnössä on linkki käyttäjään.
Syötä käyttäjän tiedot

```json
{
    {
        "kayttaja": "[kayttaja]"
    }
}
```
**Esimerkki** Kaikki kentät täytetty

```json
{
    "kayttaja": "http://localhost:8080/api/kayttajat/1",
    
}
```

## Onnistunut vastaus

**Ehto** Kaikki kentät sisältävät oikeaa dataa

**Code** : `201 CREATED`

**Sisältö** :
```json

{
    "timestamp": "2022-10-22T22:17:42.7237358",
    "toteutunut": "0",
    "_links": {
        "self": {
            "href": "http://localhost:8080/api/myyntitapahtumat/4"
        },
        "myyntitapahtuma": {
            "href": "http://localhost:8080/api/myyntitapahtumat/4"
        },
        "liput": {
            "href": "http://localhost:8080/api/myyntitapahtumat/4/liput"
        },
        "kayttaja": {
            "href": "http://localhost:8080/api/myyntitapahtumat/4/kayttaja"
        }
    }
}
```

## Virhevastauksia

**Ehto** : 

**Code** : `400 BAD REQUEST`

**Esimerkki** Käyttäjä nimen sijasta on numero
 
 ```json
 
```
