# Näytä kaikki käyttäjät

Näyttää kaikki käyttäjät

**URL** : `/api/kayttajat/`

**Metodi** : `GET`

# Onnistunut pyyntö

**Vaatimus** : Ei näytä yhtään käyttäjää.

**Koodi** : `200 OK`

**Sisältö** :
```json
{
    "_embedded": {
        "kayttajas": []
    },
  "_links" : {
    "self" : {
      "href" : "https://etappi-ticketguru.herokuapp.com/api/kayttajat"
    },
    "profile" : {
      "href" : "https://etappi-ticketguru.herokuapp.com/api/profile/kayttajat"
    },
    "search" : {
      "href" : "https://etappi-ticketguru.herokuapp.com/api/kayttajat/search"
    }
  }
}    

```


### TAI

**Vaatimus** : Näyttää yhden tai useamman käyttajan

**Koodi** : `200 OK`

**Sisältö** : Esimerkiksi 2 käyttäjää löytyi

```json
{
    "_embedded": {
        "kayttajas": [
            {
      "etunimi" : "Esimerkki",
      "sukunimi" : "Kayttaja",
      "tunnus" : "user",
      "salasana" : "$2a$10$UmKkO8p.15R057r8PiSpKemW6uhrcvyD2nFWnXEPZ68r5Y3GuukZW",
      "rooli" : "user",
      "_links" : {
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
    }, {
      "etunimi" : "User1",
      "sukunimi" : "Snimi",
      "tunnus" : "u1",
      "salasana" : "$2a$10$UmKkO8p.15R057r8PiSpKemW6uhrcvyD2nFWnXEPZ68r5Y3GuukZW",
      "rooli" : "USER",
      "_links" : {
        "self" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/kayttajat/2"
        },
        "kayttaja" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/kayttajat/2"
        },
        "myyntitapahtumat" : {
          "href" : "https://etappi-ticketguru.herokuapp.com/api/kayttajat/2/myyntitapahtumat"
        }
      }
    }
        ]
    },
  "_links" : {
    "self" : {
      "href" : "https://etappi-ticketguru.herokuapp.com/api/kayttajat"
    },
    "profile" : {
      "href" : "https://etappi-ticketguru.herokuapp.com/api/profile/kayttajat"
    },
    "search" : {
      "href" : "https://etappi-ticketguru.herokuapp.com/api/kayttajat/search"
    }
  }
}
```
# Näytä yksi käyttäjä

Näyttää yhden käyttäjän tiedot

**URL** : `api/käyttäjät/{id}`

**Metodi** : `GET`

# Onnistunut pyyntö

**Vaatimus** : Näyttää yhden käyttäjän

**Koodi** : `200 OK`

**Sisältö** : Haettu yhden käyttäjän (id=1) tiedot
```json
{
  "etunimi" : "Esimerkki",
  "sukunimi" : "Kayttaja",
  "tunnus" : "user",
  "salasana" : "$2a$10$UmKkO8p.15R057r8PiSpKemW6uhrcvyD2nFWnXEPZ68r5Y3GuukZW",
  "rooli" : "user",
  "_links" : {
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
## Epäonnistunut pyyntö


**Vaatimus** Käyttäjää ei ole haetulla ID:llä

**Code** `404 NOT FOUND`

**Sisältö** : `{}`
