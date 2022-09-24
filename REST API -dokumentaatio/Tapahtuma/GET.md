# Näytä kaikki tapahtumat

Näyttää kaikki tapahtumat

**URL** : `/api/tapahtumat/`

**Metodi** : `GET`

# Onnistunut pyyntö

**Vaatimus** : Ei näytä yhtään tapahtumaa.

**Koodi** : `200 OK`

**Sisältö** : `{[]}`

### TAI

**Vaatimus** : Näyttää yhden tai useamman tapahtuman

**Koodi** : `200 OK`

**Sisältö** : Esimerkiksi 2 tapahtumaa löytyi

```json
[
  {
    "tapahtuma": {
        "id" :1,
        "aika" :"aika1",
        "nimi" :"Tapahtuma1",
        "osoite" :"os1",
        "kaupunki" :"HKI",
        "kpl" :5,
        "loppupvm": "15.9.2022",
        },
    "tapahtuma": {
        "id" :2,
        "aika" :"aika2",
        "nimi" :"Tapahtuma2",
        "osoite" :"os1",
        "kaupunki" :"HKI",
        "kpl" :5,
        "loppupvm": "15.9.2023",
        }
      }
]
```
