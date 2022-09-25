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
        "aika" :"2022-10-10T15:00:00",
        "nimi" :"Tapahtuma1",
        "osoite" :"os1",
        "kaupunki" :"HKI",
        "kpl" :5,
        "loppupvm": "12.10.2022",
        },
    "tapahtuma": {
        "id" :2,
        "aika" :"2022-10-20T18:00:00",
        "nimi" :"Tapahtuma2",
        "osoite" :"os1",
        "kaupunki" :"HKI",
        "kpl" :5,
        "loppupvm": "22.10.2023",
        }
      }
]
```
