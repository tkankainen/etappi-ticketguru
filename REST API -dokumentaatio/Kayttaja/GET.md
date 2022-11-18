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
    "_links": {
        "self": {
            "href": "http://localhost:8080/api/kayttajat"
        },
        "profile": {
            "href": "http://localhost:8080/api/profile/kayttajat"
        },
        "search": {
            "href": "http://localhost:8080/api/kayttajat/search"
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
                "etunimi": "User1",
                "sukunimi": "Snimi",
                "tunnus": "u1",
                "salasana": "$2a$10$UmKkO8p.15R057r8PiSpKemW6uhrcvyD2nFWnXEPZ68r5Y3GuukZW",
                "rooli": "USER",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/api/kayttajat/1"
                    },
                    "kayttaja": {
                        "href": "http://localhost:8080/api/kayttajat/1"
                    },
                    "myyntitapahtumat": {
                        "href": "http://localhost:8080/api/kayttajat/1/myyntitapahtumat"
                    }
                }
            },
            {
                "etunimi": "User2",
                "sukunimi": "Snimi",
                "tunnus": "a2",
                "salasana": "$2a$10$gfVAlVfQoENWFqEJDCN6Au/1.HRhkVa/g6KSw0wXHsg6DWpKiK8Um",
                "rooli": "ADMIN",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/api/kayttajat/2"
                    },
                    "kayttaja": {
                        "href": "http://localhost:8080/api/kayttajat/2"
                    },
                    "myyntitapahtumat": {
                        "href": "http://localhost:8080/api/kayttajat/2/myyntitapahtumat"
                    }
                }
            }
        ]
    },
    "_links": {
        "self": {
            "href": "http://localhost:8080/api/kayttajat"
        },
        "profile": {
            "href": "http://localhost:8080/api/profile/kayttajat"
        },
        "search": {
            "href": "http://localhost:8080/api/kayttajat/search"
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
    "etunimi": "User1",
    "sukunimi": "Snimi",
    "tunnus": "u1",
    "salasana": "$2a$10$UmKkO8p.15R057r8PiSpKemW6uhrcvyD2nFWnXEPZ68r5Y3GuukZW",
    "rooli": "USER",
    "_links": {
        "self": {
            "href": "http://localhost:8080/api/kayttajat/1"
        },
        "kayttaja": {
            "href": "http://localhost:8080/api/kayttajat/1"
        },
        "myyntitapahtumat": {
            "href": "http://localhost:8080/api/kayttajat/1/myyntitapahtumat"
        }
    }
}
```
## Epäonnistunut pyyntö

**Vaatimus** Käyttäjää ei ole haetulla ID:llä

**Code** `404 NOT FOUND`

**Sisältö** : `{}`
