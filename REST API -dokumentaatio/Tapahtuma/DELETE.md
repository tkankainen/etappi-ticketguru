# Poista tapahtuma

Poista valittu tapahtuma.

**URL** : `/api/tapahtumat/{id}/`

**URL Parametrit** :`{id}` on halutun tapahtuman tunnusluku tietokannassa.

**Metodi**: `DELETE`

**Data** : `{}`

## Onnistunut vastaus

**Ehto** Syötetyn tunnusluvun alta löytyy tapahtuma.

**Code** : `204 NO CONTENT`

**Content** : `{}`

## Virhe vastaukset

**Ehto** Syötetyn tunnusluvun alta ei löydy tapahtumaa.

**Code** : `404 NOT FOUND`

**Content** : `{}`
