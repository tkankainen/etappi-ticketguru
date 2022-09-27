# Näytä kaikki liput

Näyttää kaikki liput

**URL** : `/liput/`

**Metodi** : `GET`

# Onnistunut pyyntö

**Vaatimus** : Ei näytä yhtään lippua.

**Koodi** : `200 OK`

**Sisältö** : `{[]}`

### TAI

**Vaatimus** : Näyttää yhden tai useamman lipun

**Koodi** : `200 OK`

**Sisältö** : Esimerkiksi 2 lippua löytyi

```json
[
  [
    {
        "lippuid": 1,
        "tapahtuma": {
            "tapahtumaid": 1,
            "aika": "2022-12-21T18:00:00",
            "nimi": "Tapahtuma1",
            "osoite": "os1",
            "kaupunki": "HKI",
            "kpl": 5,
            "loppupvm": "15.9.2022"
        },
        "tapahtumalipputyyppi": null,
        "tila": {
            "tilaid": 1,
            "nimi": "vapaa"
        },
        "myyntitapahtuma": null,
        "lippukoodi": "abc234",
        "hinta": 25
    },
    {
        "lippuid": 2,
        "tapahtuma": {
            "tapahtumaid": 3,
            "aika": "2022-09-27T14:17:45.279002",
            "nimi": "Tapahtuma3",
            "osoite": "Kulttuuritalo",
            "kaupunki": "Helsinki",
            "kpl": 500,
            "loppupvm": "31.12.2022"
        },
        "tapahtumalipputyyppi": null,
        "tila": {
            "tilaid": 2,
            "nimi": "käytetty"
        },
        "myyntitapahtuma": null,
        "lippukoodi": "iopp453f",
        "hinta": 12
    }
]
]
```
# Näytä kaikki liput

Näyttää yhden lipun tiedot

**URL** : `/liput/{id}`

**Metodi** : `GET`

# Onnistunut pyyntö

**Vaatimus** : Näyttää yhden lipun

**Koodi** : `200 OK`

**Sisältö** : Haettu yhden lipun (id=x) tiedot
