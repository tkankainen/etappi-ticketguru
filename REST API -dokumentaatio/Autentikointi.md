## JSON Web Token autentikointi

Endpoint ilman autentikointia:

Login https://etappi-ticketguru.herokuapp.com/login

jossa annetaan bodyssä JSON muotoisena arvot: 

```json
{
    "tunnus":"user", 
    "salasana":"user"
} 
```
tai 
```json
{
    "tunnus":"a2", 
    "salasana":"admin"
} 
```

Onnistuneen pyynnön jälkeen palvelin palauttaa Authorization headerissa Bearer Tokenin. 

### Käyttöliittymässä

https://etappi-ticketguru-client.herokuapp.com/

annetaan rajapintaan tunnistetiedot, palvelu tarkistaa ne ja palauttaa Bearer tokenin. 

#### tunnus: a2   salasana: admin
tai
#### tunnus: user   salasana: user

Onnistuneen kirjautumisen jälkeen, client tallentaa tokenin ja liittää sen jokaisen pyynnön headeriin. 
Tokenin käyttöaika on 1 pv. Token tuhotaan clientista, kun käyttöaika loppuu, tai käyttäjä kirjautuu ulos.
