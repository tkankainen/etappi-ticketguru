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

Testaamme, että eri käyttäjä tyypit pystyvät tai eivät pysty luomaan, hakemaan ja poistamaan tapahtumaa tietokannasta. Samalla testataan autentikoinnin toimivuus.


#### testiTapahtuma()

Tässä luodaan testattava tapahtuma, mitä eri käyttäjät pyrkivät lisäämään tietokantaan.

#### testLuoJaPoista()

Ylläpitäjän oikeudet omaava käyttäjä pyrkii luomaan, hakemaan ja poistamaan tapahtuman tietokannasta. Autentikoinnin avulla tämä on sallittua toimintaa. Testi OK

#### testLuoUserina()

Tässä perus käyttäjä ilman ylläpitäjän oikeuksia pyrkii luomaan tapahtuman tietokantaan. Autentikointi tulisi estää tämän toiminnan. Testi OK.


# end-to-end

(JATKUU)



