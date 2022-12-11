## Testaus

Tässä käsitellään tehtyjä testejä sovellukseen.

# Yksikkötestit

Tässä testataan koodin yksittäisia ominaisuuksia, luokkia ja metodeja.

### TicketGuruApplicationTests

Tässä testataan yhteyttä tietokantaan ja katsotaan, että jokaisesta taulusta löytyy sisältöä.

#### EiTyhjälippu()

Tarkistaa, että "Liput" taulusta löytyy lippu ID 0:n alta. Testi OK

#### EiTyhjälipputyyppi()

Tarkistaa, että "Tapahtumalipputyyppi" taulusta läytyy tapapahtumalipputyyppi ID 0:n alta. Testi OK

#### EiTyhjäkayttaja()

Tarkistaa, että "Kayttaja" taulusta löytyy käyttäjä ID 0:n alta. Testi OK

#### EiTyhjäMT()

Tarkistaa, että "Myyntitapahtuma" taulusta löytyy myyntitapahtuma ID 0:n alta. Testi OK

#### EiTyhjäLipputyyppi()

Tarkistaa, että "Lipputyyppi" taulusta löytyy lipputyyppi ID 0:n alta. Testi OK

### LippuTests

Tässä testataan lipun luontia ja muista taulusta tuotuja arvoja.

#### LuoLippu()

Testissä luodaan lippu ja sitä varten määritellään Tapahtuma, Tapahtumalipputyyppi, Käyttäjä, Myyntitapahtuma. Lopuksi varmistetaan, että kyseisen lipun ominaisuudet löytyvät luonnin jälkeen. Testi OK



# Integraatiotestit

Tässä testataan ohjelmiston komponenttien toimintaa rajapinnan kanssa.

### TapahtumaControllerTest

Testaamme, että käyttäjät pystyvät luomaan tapahtuman tietokantaan. Samalla testataan autentikoinnin toimivuus.


#### testiTapahtuma()

Tässä luodaan testattava tapahtuma, mitä pyritään lisäämään tietokantaan.

#### testLuo()

Käyttäjä pyrkii lisäämään tapahtuman tietokantaan. Autentikoinnin avulla tämä on sallittua toimintaa. Testi OK


# end-to-end

Testaamme koko sovelluksen toimintaa vaihe vaiheelta.

### Testi 1

Käyttöliittymän testausta. Luodaan myyntitapahtuma.

-Valitaan tapahtuma

-Valitaan lipputyyppi

-Valitaan lippujen määrä

-Haetaan myyntitapahtuma listasta

-Näytetään myyntitapahtuman liput tapahtumaan

Lippujen lukumäärät ja lipputyyppi oikeaan tapahtumaan ovat oikeita. Testi OK

### Testi 2

Luodaan Tapahtuma

-Lisätään uusi tapahtuma

-Luodaan lipputyyppi

-Myydään lippuja tapahtumaan

-Muokataan tapahtumaa

-Poistetaan tapahtuma


Uusi tapahtuma luotiin onnistuneesti, siihen luotiin oma lipputyyppi, lippujen myynti tapahtumaan onnistui, tapahtuman muokkaaminen päivitti tietoja ja tapahtuma poistui listalta onnistuneesti. Testi OK






