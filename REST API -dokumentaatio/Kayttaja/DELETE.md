# Poista käyttäjä

Poista valittu käyttäjä.

**URL** : `/api/käyttäjät/{id}/`

**URL Parametrit** :`{id}` on halutun käyttäjän tunnusluku tietokannassa.

**Metodi**: `DELETE`

**Data** : `{}`

## Onnistunut vastaus

**Ehto** Syötetyn tunnusluvun alta löytyy käyttäjä.

**Code** : `204 NO CONTENT`

**Content** : `{}`

## Virhe vastaukset

**Ehto** Syötetyn tunnusluvun alta ei löydy käyttäjää.

**Code** : `404 NOT FOUND`

**Content** : `{}`
