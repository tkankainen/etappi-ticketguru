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
        "kayttaja": "[kayttaja]",
        "timestamp": "[unicode 50 chars max]", HUOM, vaihda kun timestamp korjattu
    }
}
```
**Esimerkki** Kaikki kentät täytetty

```json
{
    "kayttaja": "http://localhost:8080/api/kayttajat/1",
    "timestamp": "1.1.2026"
    
}
```

## Onnistunut vastaus

**Ehto** Kaikki kentät sisältävät oikeaa dataa

**Code** : `201 CREATED`

**Sisältö** :
```json

{
    "timestamp": "1.1.2026",
    "_links": {
        "self": {
            "href": "http://localhost:8080/api/myyntitapahtumat/2"
        },
        "myyntitapahtuma": {
            "href": "http://localhost:8080/api/myyntitapahtumat/2"
        },
        "kayttaja": {
            "href": "http://localhost:8080/api/myyntitapahtumat/2/kayttaja"
        },
        "liput": {
            "href": "http://localhost:8080/api/myyntitapahtumat/2/liput"
        }
    }
}
```

## Virhevastauksia

**Ehto** : 

**Code** : `400 BAD REQUEST`

**Esimerkki**
 
 ```json
 
```